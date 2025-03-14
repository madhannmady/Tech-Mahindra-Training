import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:firebase_core/firebase_core.dart'; // Import firebase_core
import 'firebase_options.dart'; // Import the generated firebase_options
import 'screens/home_screen.dart';
import 'localization/localization.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized(); // Ensure Flutter is initialized
  await Firebase.initializeApp(
    options:
        DefaultFirebaseOptions.currentPlatform, // Use the generated options
  );
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  Locale _locale = const Locale('en'); // Default locale

  void _setLocale(Locale locale) {
    setState(() {
      _locale = locale;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      locale: _locale, // Dynamically update locale
      supportedLocales: const [
        Locale('en', ''), // English
        Locale('ta', ''), // Tamil
      ],
      localizationsDelegates: const [
        AppLocalizations.delegate,
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        GlobalCupertinoLocalizations.delegate,
      ],
      home:
          HomeScreen(onLocaleChange: _setLocale), // Pass locale change callback
    );
  }
}
