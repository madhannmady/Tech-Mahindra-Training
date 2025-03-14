import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'detail_screen.dart';
import 'profile_screen.dart';
import '../widgets/article_card.dart';
import '../services/firebase_service.dart';
import '../localization/localization.dart';

class HomeScreen extends StatefulWidget {
  final void Function(Locale) onLocaleChange; // Callback to update locale

  const HomeScreen({required this.onLocaleChange});

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final FirebaseService _firebaseService = FirebaseService();
  String _selectedCategory = '';
  List<String> _categories = [''];

  @override
  void initState() {
    super.initState();
    _fetchCategories();
  }

  Future<void> _fetchCategories() async {
    final categories = await _firebaseService.getCategories();
    setState(() {
      _categories = [''];
      _categories.addAll(categories);
    });
    print('Fetched categories: $_categories');
  }

  void _toggleLanguage() {
    final currentLocale = AppLocalizations.of(context).locale;
    final newLocale = currentLocale.languageCode == 'en'
        ? const Locale('ta')
        : const Locale('en');
    widget.onLocaleChange(newLocale); // Update locale at app level
  }

  void _addNewArticle() async {
    TextEditingController titleController = TextEditingController();
    TextEditingController descController = TextEditingController();
    TextEditingController contentController = TextEditingController();
    TextEditingController imageUrlController = TextEditingController();
    TextEditingController categoryController = TextEditingController();

    showDialog(
      context: context,
      builder: (context) {
        final localizations =
            AppLocalizations.of(context); // Use context for localization
        return AlertDialog(
          title: Text(localizations.translate('add_article')),
          content: SingleChildScrollView(
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                TextField(
                  controller: titleController,
                  decoration: InputDecoration(
                    labelText: localizations.translate('title'),
                    border: OutlineInputBorder(),
                  ),
                ),
                SizedBox(height: 10),
                TextField(
                  controller: descController,
                  decoration: InputDecoration(
                    labelText: localizations.translate('description'),
                    border: OutlineInputBorder(),
                  ),
                ),
                SizedBox(height: 10),
                TextField(
                  controller: contentController,
                  decoration: InputDecoration(
                    labelText: localizations.translate('content'),
                    border: OutlineInputBorder(),
                  ),
                ),
                SizedBox(height: 10),
                TextField(
                  controller: imageUrlController,
                  decoration: InputDecoration(
                    labelText: localizations.translate('image_url'),
                    border: OutlineInputBorder(),
                  ),
                ),
                SizedBox(height: 10),
                TextField(
                  controller: categoryController,
                  decoration: InputDecoration(
                    labelText: localizations.translate('category'),
                    border: OutlineInputBorder(),
                  ),
                ),
              ],
            ),
          ),
          actions: [
            TextButton(
              onPressed: () async {
                if (categoryController.text.isNotEmpty) {
                  await _firebaseService.addArticle(
                    titleController.text,
                    descController.text,
                    contentController.text,
                    imageUrlController.text,
                    categoryController.text,
                  );
                  print(
                      'Added article with category: ${categoryController.text}');
                  await _fetchCategories();
                  Navigator.pop(context);
                } else {
                  print('Category cannot be empty');
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(
                        content:
                            Text(localizations.translate('category_empty'))),
                  );
                }
              },
              child: Text(localizations.translate('submit')),
            ),
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          AppLocalizations.of(context).translate('app_title'),
          style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
        ),
        backgroundColor: Colors.purple[100],
        elevation: 4.0,
        actions: [
          IconButton(
            icon: CircleAvatar(
              backgroundColor: Colors.purple[300],
              child: Icon(Icons.person, color: Colors.white),
            ),
            onPressed: () => Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => ProfileScreen(),
              ),
            ),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _addNewArticle,
        backgroundColor: Colors.purple[300],
        child: Icon(Icons.add, size: 30),
      ),
      body: Container(
        color: Colors.grey[100],
        child: Column(
          children: [
            Container(
              color: Colors.white,
              padding: EdgeInsets.symmetric(horizontal: 16.0, vertical: 8.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  IconButton(
                    icon: Icon(Icons.language,
                        color: Colors.purple[300], size: 30),
                    onPressed: _toggleLanguage,
                  ),
                  DropdownButton<String>(
                    value: _selectedCategory.isEmpty ? null : _selectedCategory,
                    hint: Text(AppLocalizations.of(context)
                        .translate('filter_by_category')),
                    items: _categories.map((String category) {
                      return DropdownMenuItem<String>(
                        value: category,
                        child: Text(category.isEmpty
                            ? AppLocalizations.of(context).translate('all')
                            : category),
                      );
                    }).toList(),
                    onChanged: (String? newValue) {
                      setState(() {
                        _selectedCategory = newValue ?? '';
                        print(
                            'Selected category changed to: $_selectedCategory');
                      });
                    },
                  ),
                ],
              ),
            ),
            Expanded(
              child: StreamBuilder(
                stream: _firebaseService.getArticles(
                    category:
                        _selectedCategory.isEmpty ? null : _selectedCategory),
                builder: (context, AsyncSnapshot<QuerySnapshot> snapshot) {
                  if (snapshot.hasError) {
                    print('StreamBuilder error: ${snapshot.error}');
                    return Center(child: Text('Error: ${snapshot.error}'));
                  }
                  if (snapshot.connectionState == ConnectionState.waiting) {
                    print(
                        'StreamBuilder waiting for data with category: $_selectedCategory');
                    return Center(child: CircularProgressIndicator());
                  }
                  if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
                    print('No articles found for category: $_selectedCategory');
                    return Center(
                      child: Text(
                        AppLocalizations.of(context).translate('no_articles'),
                        style: TextStyle(fontSize: 18, color: Colors.grey),
                      ),
                    );
                  }
                  var articles = snapshot.data!.docs;
                  print(
                      'Number of articles fetched: ${articles.length} for category: $_selectedCategory');
                  return ListView.builder(
                    padding: EdgeInsets.all(16.0),
                    itemCount: articles.length,
                    itemBuilder: (context, index) {
                      var article =
                          articles[index].data() as Map<String, dynamic>;
                      return FutureBuilder<bool>(
                        future:
                            _firebaseService.isArticleLiked(articles[index].id),
                        builder: (context, snapshot) {
                          if (!snapshot.hasData) return SizedBox.shrink();
                          bool isLiked = snapshot.data!;
                          return ArticleCard(
                            title: article['title'] ?? 'No title',
                            thumbnailUrl: article['imageUrl'] ?? '',
                            category: article['category']?.toString(),
                            onTap: () => Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder: (context) =>
                                    DetailScreen(articleId: articles[index].id),
                              ),
                            ),
                            onLike: () async {
                              await _firebaseService
                                  .toggleLike(articles[index].id);
                              setState(() {});
                            },
                            createdAt: article['createdAt'] as Timestamp,
                            liked: isLiked,
                          );
                        },
                      );
                    },
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
