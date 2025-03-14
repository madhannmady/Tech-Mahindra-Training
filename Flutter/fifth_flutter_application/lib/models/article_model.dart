import 'package:cloud_firestore/cloud_firestore.dart';

class Article {
  final String id;
  final String title;
  final String description;
  final String content;
  final String imageUrl;
  final int likes;
  final Timestamp createdAt;

  Article({
    required this.id,
    required this.title,
    required this.description,
    required this.content,
    required this.imageUrl,
    required this.likes,
    required this.createdAt,
  });

  factory Article.fromMap(Map<String, dynamic> map, String id) {
    return Article(
      id: id,
      title: map['title'],
      description: map['description'],
      content: map['content'],
      imageUrl: map['imageUrl'],
      likes: map['likes'],
      createdAt: map['createdAt'] ?? Timestamp.now(),
    );
  }
}
