import 'package:flutter/material.dart';
import 'package:third_flutter_app/screens/home_screen.dart';
import 'package:third_flutter_app/theme.dart';

void main() {
  runApp(const CourseApp());
}

class CourseApp extends StatelessWidget {
  const CourseApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Course Registration',
      theme: appTheme,
      home: const HomeScreen(),
    );
  }
}
