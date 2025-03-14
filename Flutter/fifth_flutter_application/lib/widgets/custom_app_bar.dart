import 'package:flutter/material.dart';

class CustomAppBar extends StatelessWidget implements PreferredSizeWidget {
  final String title;
  final Widget action;

  CustomAppBar({required this.title, required this.action});

  @override
  Widget build(BuildContext context) {
    return AppBar(
      title: Text(title),
      actions: [action],
    );
  }

  @override
  Size get preferredSize => Size.fromHeight(kToolbarHeight);
}
