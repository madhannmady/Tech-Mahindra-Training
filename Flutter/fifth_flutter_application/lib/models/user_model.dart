class User {
  final String name;
  final List<String> likedArticles;

  User({required this.name, required this.likedArticles});

  factory User.fromMap(Map<String, dynamic> map) {
    return User(
      name: map['name'],
      likedArticles: List<String>.from(map['likedArticles'] ?? []),
    );
  }
}
