import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import '../localization/localization.dart';

class ArticleCard extends StatelessWidget {
  final String title;
  final String thumbnailUrl;
  final String? category;
  final VoidCallback onTap;
  final VoidCallback onLike;
  final Timestamp createdAt;
  final bool liked;

  const ArticleCard({
    required this.title,
    required this.thumbnailUrl,
    this.category,
    required this.onTap,
    required this.onLike,
    required this.createdAt,
    required this.liked,
  });

  @override
  Widget build(BuildContext context) {
    final localizations = AppLocalizations.of(context);
    return Card(
      margin: const EdgeInsets.only(bottom: 16.0),
      clipBehavior: Clip.antiAlias,
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(12.0),
      ),
      child: InkWell(
        onTap: onTap,
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Image.network(
              thumbnailUrl,
              height: 200,
              width: double.infinity,
              fit: BoxFit.cover,
              errorBuilder: (context, error, stackTrace) => Container(
                height: 200,
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
                    title,
                    style: const TextStyle(
                      fontSize: 20.0,
                      fontWeight: FontWeight.bold,
                      color: Colors.black87,
                    ),
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                  ),
                  const SizedBox(height: 8.0),
                  Text(
                    '${localizations.translate('date')}: ${createdAt.toDate().toLocal().toString().split(' ')[0]}',
                    style: TextStyle(
                      fontSize: 14.0,
                      color: Colors.grey[600],
                    ),
                  ),
                  const SizedBox(height: 4.0),
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
                      '${localizations.translate('category')}: ${category ?? 'Uncategorized'}',
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
              padding:
                  const EdgeInsets.only(left: 16.0, right: 16.0, bottom: 8.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.end,
                children: [
                  IconButton(
                    icon: Icon(
                      liked ? Icons.favorite : Icons.favorite_border,
                      color: liked ? Colors.red : null,
                    ),
                    onPressed: onLike,
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
