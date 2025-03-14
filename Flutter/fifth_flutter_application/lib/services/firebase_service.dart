import 'package:cloud_firestore/cloud_firestore.dart';

class FirebaseService {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  // Add a new article to Firestore
  Future<void> addArticle(
    String title,
    String description,
    String content,
    String imageUrl,
    String category,
  ) async {
    try {
      String normalizedCategory =
          category[0].toUpperCase() + category.substring(1).toLowerCase();
      await _firestore.collection('articles').add({
        'title': title,
        'description': description,
        'content': content,
        'imageUrl': imageUrl,
        'category': normalizedCategory,
        'createdAt': Timestamp.now(),
      });
      await _firestore
          .collection('categories')
          .doc(normalizedCategory)
          .set({}, SetOptions(merge: true));
    } catch (e) {
      print('Error adding article: $e');
      rethrow;
    }
  }

  // Get articles, optionally filtered by category
  Stream<QuerySnapshot> getArticles({String? category}) {
    try {
      if (category != null) {
        return _firestore
            .collection('articles')
            .where('category', isEqualTo: category)
            .snapshots();
      }
      return _firestore.collection('articles').snapshots();
    } catch (e) {
      print('Error getting articles: $e');
      rethrow;
    }
  }

  // Get all categories
  Future<List<String>> getCategories() async {
    try {
      QuerySnapshot snapshot = await _firestore.collection('categories').get();
      return snapshot.docs.map((doc) => doc.id).toList();
    } catch (e) {
      print('Error getting categories: $e');
      rethrow;
    }
  }

  // Get article details by ID
  Future<Map<String, dynamic>> getArticleDetail(String articleId) async {
    try {
      DocumentSnapshot doc =
          await _firestore.collection('articles').doc(articleId).get();
      return doc.data() as Map<String, dynamic>;
    } catch (e) {
      print('Error getting article detail: $e');
      rethrow;
    }
  }

  // Check if an article is liked
  Future<bool> isArticleLiked(String articleId) async {
    try {
      DocumentSnapshot userDoc =
          await _firestore.collection('users').doc('current_user').get();
      List<dynamic> likedArticles =
          (userDoc.data() as Map<String, dynamic>)['likedArticles'] ?? [];
      return likedArticles.contains(articleId);
    } catch (e) {
      print('Error checking if article is liked: $e');
      return false;
    }
  }

  // Toggle like status for an article
  Future<void> toggleLike(String articleId) async {
    try {
      DocumentReference userDoc =
          _firestore.collection('users').doc('current_user');
      DocumentSnapshot snapshot = await userDoc.get();
      Map<String, dynamic> userData = snapshot.data() as Map<String, dynamic>;
      List<dynamic> likedArticles = userData['likedArticles'] ?? [];

      if (likedArticles.contains(articleId)) {
        likedArticles.remove(articleId);
      } else {
        likedArticles.add(articleId);
      }

      await userDoc.set({
        'likedArticles': likedArticles,
      }, SetOptions(merge: true));
    } catch (e) {
      print('Error toggling like: $e');
      rethrow;
    }
  }

  // Get user data
  Future<DocumentSnapshot> getUserData() async {
    try {
      return await _firestore.collection('users').doc('current_user').get();
    } catch (e) {
      print('Error getting user data: $e');
      rethrow;
    }
  }

  // Get liked articles
  Stream<QuerySnapshot> getLikedArticles() {
    try {
      return _firestore
          .collection('users')
          .doc('current_user')
          .snapshots()
          .asyncMap((userDoc) async {
        Map<String, dynamic>? userData =
            userDoc.data() as Map<String, dynamic>?;
        List<dynamic> likedArticleIds = userData?['likedArticles'] ?? [];
        if (likedArticleIds.isEmpty) {
          // Return an empty stream for no liked articles
          return await _firestore
              .collection('articles')
              .where('title', isEqualTo: '') // Dummy query to get empty result
              .limit(0)
              .get();
        }
        return await _firestore
            .collection('articles')
            .where(FieldPath.documentId, whereIn: likedArticleIds)
            .get();
      }).map((snapshot) =>
              snapshot); // Convert Future<QuerySnapshot> to QuerySnapshot
    } catch (e) {
      print('Error getting liked articles: $e');
      rethrow;
    }
  }
}
