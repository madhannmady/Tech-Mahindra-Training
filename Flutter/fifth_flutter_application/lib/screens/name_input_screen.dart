import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'home_screen.dart';
import '../localization/localization.dart';

class NameInputScreen extends StatefulWidget {
  @override
  _NameInputScreenState createState() => _NameInputScreenState();
}

class _NameInputScreenState extends State<NameInputScreen> {
  final TextEditingController _nameController = TextEditingController();
  final _formKey = GlobalKey<FormState>();

  void _saveNameAndProceed() async {
    if (_formKey.currentState!.validate()) {
      // Save the name to Firestore
      await FirebaseFirestore.instance
          .collection('users')
          .doc('current_user')
          .set({
        'name': _nameController.text,
        'likedArticles': [], // Initialize liked articles
      }, SetOptions(merge: true));
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(
            builder: (context) => HomeScreen(onLocaleChange: (locale) {
                  // Handle locale change here
                })),
      );
    }
  }

  @override
  void dispose() {
    _nameController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final localizations = AppLocalizations.of(context);
    return Scaffold(
      backgroundColor:
          Colors.grey[100], // Match HomeScreen and DetailScreen background
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 24.0, vertical: 40.0),
          child: Form(
            key: _formKey,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                // Article Feed Title: Centered and Bold
                const Text(
                  'Article Feed',
                  style: TextStyle(
                    fontSize: 32.0,
                    fontWeight: FontWeight.bold,
                    color: Colors.black87,
                  ),
                ),
                const SizedBox(height: 40.0), // Spacing between title and input
                // Enter Your Name TextField: Medium thickness border
                TextFormField(
                  controller: _nameController,
                  decoration: InputDecoration(
                    labelText: localizations
                        .translate('name'), // Localized "Enter your name"
                    labelStyle: TextStyle(
                      color: Colors.grey[600],
                      fontSize: 16.0,
                    ),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(8.0),
                      borderSide: const BorderSide(
                        width: 2.0, // Medium thickness
                        color: Colors.black54,
                      ),
                    ),
                    enabledBorder: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(8.0),
                      borderSide: const BorderSide(
                        width: 2.0, // Medium thickness
                        color: Colors.black54,
                      ),
                    ),
                    focusedBorder: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(8.0),
                      borderSide: const BorderSide(
                        width: 2.0, // Medium thickness
                        color: Colors.purple, // Match theme color
                      ),
                    ),
                    contentPadding: const EdgeInsets.symmetric(
                      vertical: 16.0,
                      horizontal: 16.0,
                    ),
                  ),
                  validator: (value) {
                    if (value == null || value.trim().isEmpty) {
                      return 'Please enter your name'; // You can localize this too
                    }
                    return null;
                  },
                ),
                const SizedBox(
                    height: 40.0), // Spacing between input and button
                // Get Started Button: Centered with border
                ElevatedButton(
                  onPressed: _saveNameAndProceed,
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.purple[300], // Match theme color
                    foregroundColor: Colors.white,
                    padding: const EdgeInsets.symmetric(
                      horizontal: 32.0,
                      vertical: 16.0,
                    ),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(8.0),
                      side: const BorderSide(
                        color: Colors.black54,
                        width: 2.0, // Medium thickness border
                      ),
                    ),
                    elevation: 4.0, // Slight shadow for depth
                  ),
                  child: Text(
                    localizations
                        .translate('get_started'), // Localized "Get Started"
                    style: const TextStyle(
                      fontSize: 16.0,
                      fontWeight: FontWeight.w600,
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
