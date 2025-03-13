import 'package:flutter/material.dart';
import 'package:third_flutter_app/screens/add_course_screen.dart';
import 'package:third_flutter_app/screens/course_detail_screen.dart';
import 'package:third_flutter_app/database_helper.dart';
import 'package:third_flutter_app/models/course.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  late Future<List<Course>> courses;

  @override
  void initState() {
    super.initState();
    _refreshCourses();
  }

  void _refreshCourses() {
    setState(() {
      courses = DatabaseHelper.instance.readAllCourses();
    });
  }

  Future<void> _deleteCourse(int id) async {
    try {
      final db = await DatabaseHelper.instance.database;
      await db.delete('courses', where: 'id = ?', whereArgs: [id]);
      _refreshCourses(); // Refresh the list after deletion
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Course deleted successfully')),
      );
    } catch (e) {
      ScaffoldMessenger.of(
        context,
      ).showSnackBar(SnackBar(content: Text('Error deleting course: $e')));
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Available Courses')),
      body: FutureBuilder<List<Course>>(
        future: courses,
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          }
          if (!snapshot.hasData || snapshot.data!.isEmpty) {
            return const Center(child: Text('No courses available'));
          }
          return GridView.builder(
            padding: const EdgeInsets.all(16),
            gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
              crossAxisCount: 2,
              childAspectRatio: 0.75,
              crossAxisSpacing: 16,
              mainAxisSpacing: 16,
            ),
            itemCount: snapshot.data!.length,
            itemBuilder: (context, index) {
              final course = snapshot.data![index];
              return CourseCard(
                course: course,
                onRefresh: _refreshCourses,
                onDelete: () => _deleteCourse(course.id!),
              );
            },
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () async {
          await Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => const AddCourseScreen()),
          );
          _refreshCourses();
        },
        child: const Icon(Icons.add),
      ),
    );
  }
}

class CourseCard extends StatelessWidget {
  final Course course;
  final VoidCallback onRefresh;
  final VoidCallback onDelete;

  const CourseCard({
    super.key,
    required this.course,
    required this.onRefresh,
    required this.onDelete,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Container(
        height: 200, // Fixed height to prevent overflow
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Expanded(
              child: Image.network(
                course.thumbnailUrl,
                width: double.infinity,
                fit: BoxFit.cover,
                cacheWidth: 200,
                cacheHeight: 100,
                errorBuilder: (context, error, stackTrace) {
                  print(
                    'Image loading failed for ${course.thumbnailUrl}: $error',
                  ); // Debug log
                  return Container(
                    color: Colors.grey[300],
                    child: const Center(
                      child: Icon(Icons.error, color: Colors.red),
                    ),
                  );
                },
                loadingBuilder: (context, child, loadingProgress) {
                  if (loadingProgress == null) return child;
                  return Container(
                    color: Colors.grey[200],
                    child: const Center(child: CircularProgressIndicator()),
                  );
                },
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    course.name,
                    style: Theme.of(context).textTheme.bodyMedium,
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                  ),
                  Text(
                    '\$${course.cost}',
                    style: TextStyle(
                      color: Theme.of(context).colorScheme.secondary,
                    ),
                  ),
                  const SizedBox(height: 8),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.end,
                    children: [
                      ElevatedButton(
                        onPressed: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder:
                                  (context) =>
                                      CourseDetailScreen(course: course),
                            ),
                          );
                        },
                        child: const Text('Check'),
                      ),
                    ],
                  ),
                  const SizedBox(height: 4),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.end,
                    children: [
                      TextButton(
                        onPressed: onDelete,
                        style: TextButton.styleFrom(
                          foregroundColor: Colors.red,
                          textStyle: const TextStyle(
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                        child: const Text('Delete'),
                      ),
                    ],
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
