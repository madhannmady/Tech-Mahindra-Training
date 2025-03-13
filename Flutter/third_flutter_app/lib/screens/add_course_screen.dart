import 'package:flutter/material.dart';
import '../database_helper.dart';
import '../models/course.dart';

class AddCourseScreen extends StatefulWidget {
  const AddCourseScreen({super.key});

  @override
  State<AddCourseScreen> createState() => _AddCourseScreenState();
}

class _AddCourseScreenState extends State<AddCourseScreen> {
  final _formKey = GlobalKey<FormState>();
  final _nameController = TextEditingController();
  final _descriptionController = TextEditingController();
  final _thumbnailController = TextEditingController();
  final _costController = TextEditingController();
  final _hoursController = TextEditingController();

  String? _validateUrl(String? value) {
    if (value == null || value.isEmpty) {
      return 'Required';
    }
    final uri = Uri.tryParse(value);
    if (uri == null || !uri.hasScheme || !uri.hasAuthority) {
      return 'Invalid URL';
    }
    return null;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Add New Course')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: SingleChildScrollView(
            child: Column(
              children: [
                TextFormField(
                  controller: _nameController,
                  decoration: const InputDecoration(labelText: 'Course Name'),
                  validator: (value) => value!.isEmpty ? 'Required' : null,
                ),
                TextFormField(
                  controller: _descriptionController,
                  decoration: const InputDecoration(labelText: 'Description'),
                  validator: (value) => value!.isEmpty ? 'Required' : null,
                ),
                TextFormField(
                  controller: _thumbnailController,
                  decoration: const InputDecoration(labelText: 'Thumbnail URL'),
                  validator: _validateUrl,
                  onChanged: (_) => setState(() {}),
                ),
                const SizedBox(height: 10),
                _thumbnailController.text.isNotEmpty &&
                        _validateUrl(_thumbnailController.text) == null
                    ? Image.network(
                      _thumbnailController.text,
                      height: 150,
                      width: 150,
                      fit: BoxFit.cover,
                      errorBuilder:
                          (context, error, stackTrace) => const Icon(
                            Icons.broken_image,
                            size: 100,
                            color: Colors.grey,
                          ),
                    )
                    : const SizedBox.shrink(),
                TextFormField(
                  controller: _costController,
                  decoration: const InputDecoration(labelText: 'Cost'),
                  keyboardType: TextInputType.number,
                  validator: (value) => value!.isEmpty ? 'Required' : null,
                ),
                TextFormField(
                  controller: _hoursController,
                  decoration: const InputDecoration(labelText: 'Hours'),
                  keyboardType: TextInputType.number,
                  validator: (value) => value!.isEmpty ? 'Required' : null,
                ),
                const SizedBox(height: 20),
                ElevatedButton(
                  onPressed: () async {
                    if (_formKey.currentState!.validate()) {
                      final course = Course(
                        name: _nameController.text,
                        description: _descriptionController.text,
                        thumbnailUrl: _thumbnailController.text,
                        cost: double.parse(_costController.text),
                        hours: int.parse(_hoursController.text),
                      );
                      await DatabaseHelper.instance.create(course);
                      Navigator.pop(context);
                    }
                  },
                  child: const Text('Submit'),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  @override
  void dispose() {
    _nameController.dispose();
    _descriptionController.dispose();
    _thumbnailController.dispose();
    _costController.dispose();
    _hoursController.dispose();
    super.dispose();
  }
}
