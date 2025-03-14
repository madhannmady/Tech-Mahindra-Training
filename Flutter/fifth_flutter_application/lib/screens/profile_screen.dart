import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'detail_screen.dart';
import '../services/firebase_service.dart';
import '../localization/localization.dart';

class ProfileScreen extends StatelessWidget {
  final FirebaseService _firebaseService = FirebaseService();

  @override
  Widget build(BuildContext context) {
    final localizations = AppLocalizations.of(context);
    return Scaffold(
      appBar: AppBar(
        title: Text(localizations.translate('profile')),
        backgroundColor: Colors.purple[100],
      ),
      body: FutureBuilder<DocumentSnapshot>(
        future: _firebaseService.getUserData(),
        builder: (context, snapshot) {
          if (!snapshot.hasData) {
            return const Center(child: CircularProgressIndicator());
          }
          var userData = snapshot.data!.data() as Map<String, dynamic>;
          return Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  '${localizations.translate('name')}: ${userData['name'] ?? 'Unknown'}',
                  style: TextStyle(fontSize: 18),
                ),
                const SizedBox(height: 16),
                Text(
                  localizations.translate('liked_articles'),
                  style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                ),
                Expanded(
                  child: StreamBuilder<QuerySnapshot>(
                    stream: _firebaseService.getLikedArticles(),
                    builder: (context, AsyncSnapshot<QuerySnapshot> snapshot) {
                      if (!snapshot.hasData) {
                        return const Center(child: CircularProgressIndicator());
                      }
                      var articles = snapshot.data!.docs;
                      if (articles.isEmpty) {
                        return Center(
                          child: Text(localizations.translate('no_articles')),
                        );
                      }
                      return ListView.builder(
                        itemCount: articles.length,
                        itemBuilder: (context, index) {
                          var article =
                              articles[index].data() as Map<String, dynamic>;
                          return ListTile(
                            title: Text(article['title'] ?? 'No title'),
                            subtitle: Text(
                              '${localizations.translate('date')}: ${(article['createdAt'] as Timestamp).toDate().toLocal().toString().split(' ')[0]}',
                            ),
                            onTap: () => Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder: (context) =>
                                    DetailScreen(articleId: articles[index].id),
                              ),
                            ),
                          );
                        },
                      );
                    },
                  ),
                ),
              ],
            ),
          );
        },
      ),
    );
  }
}
