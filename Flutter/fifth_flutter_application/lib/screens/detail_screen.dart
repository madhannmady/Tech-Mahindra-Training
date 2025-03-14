import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import '../services/firebase_service.dart';
import '../localization/localization.dart';

class DetailScreen extends StatefulWidget {
  final String articleId;

  const DetailScreen({required this.articleId});

  @override
  _DetailScreenState createState() => _DetailScreenState();
}

class _DetailScreenState extends State<DetailScreen> {
  final FirebaseService _firebaseService = FirebaseService();

  @override
  Widget build(BuildContext context) {
    final localizations = AppLocalizations.of(context);
    return Scaffold(
      appBar: AppBar(
        title: Text(localizations.translate('article_detail')),
        backgroundColor: Colors.purple[100],
      ),
      body: FutureBuilder<Map<String, dynamic>>(
        future: _firebaseService.getArticleDetail(widget.articleId),
        builder: (context, snapshot) {
          if (!snapshot.hasData) {
            return const Center(child: CircularProgressIndicator());
          }
          var article = snapshot.data!;
          return Padding(
            padding: const EdgeInsets.all(16.0),
            child: Card(
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(12.0),
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Image.network(
                    article['imageUrl'] ?? '',
                    height: 250,
                    width: double.infinity,
                    fit: BoxFit.cover,
                    errorBuilder: (context, error, stackTrace) => Container(
                      height: 250,
                      color: Colors.grey[300],
                      child: const Center(child: Text('Image not available')),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(16.0),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          article['title'] ?? 'No title',
                          style: const TextStyle(
                            fontSize: 24.0,
                            fontWeight: FontWeight.bold,
                            color: Colors.black87,
                          ),
                        ),
                        const SizedBox(height: 8.0),
                        Text(
                          '${localizations.translate('date')}: ${(article['createdAt'] as Timestamp).toDate().toLocal().toString().split(' ')[0]}',
                          style: TextStyle(
                            fontSize: 14.0,
                            color: Colors.grey[600],
                          ),
                        ),
                        const SizedBox(height: 8.0),
                        Text(
                          '${localizations.translate('description')}: ${article['description'] ?? 'No description'}',
                          style: TextStyle(
                            fontSize: 16.0,
                            color: Colors.black54,
                          ),
                        ),
                        const SizedBox(height: 8.0),
                        Text(
                          '${localizations.translate('content')}: ${article['content'] ?? 'No content'}',
                          style: TextStyle(
                            fontSize: 16.0,
                            color: Colors.black87,
                          ),
                        ),
                        const SizedBox(height: 16.0),
                        Container(
                          padding: const EdgeInsets.symmetric(
                            horizontal: 12.0,
                            vertical: 6.0,
                          ),
                          decoration: BoxDecoration(
                            color: Colors.purple[300],
                            borderRadius: BorderRadius.circular(8.0),
                          ),
                          child: Text(
                            '${localizations.translate('category')}: ${article['category'] ?? 'Uncategorized'}',
                            style: const TextStyle(
                              fontSize: 14.0,
                              fontWeight: FontWeight.w500,
                              color: Colors.white,
                            ),
                          ),
                        ),
                      ],
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.only(
                        left: 16.0, right: 16.0, bottom: 8.0),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.end,
                      children: [
                        FutureBuilder<bool>(
                          future:
                              _firebaseService.isArticleLiked(widget.articleId),
                          builder: (context, snapshot) {
                            if (!snapshot.hasData) return SizedBox.shrink();
                            bool isLiked = snapshot.data!;
                            return IconButton(
                              icon: Icon(
                                isLiked
                                    ? Icons.favorite
                                    : Icons.favorite_border,
                                color: isLiked ? Colors.red : null,
                              ),
                              onPressed: () async {
                                await _firebaseService
                                    .toggleLike(widget.articleId);
                                setState(() {});
                              },
                            );
                          },
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          );
        },
      ),
    );
  }
}
