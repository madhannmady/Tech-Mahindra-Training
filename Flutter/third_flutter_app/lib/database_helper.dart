import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';
import 'models/course.dart';

class DatabaseHelper {
  static final DatabaseHelper instance = DatabaseHelper._init();
  static Database? _database;

  DatabaseHelper._init();

  Future<Database> get database async {
    if (_database != null) return _database!;
    _database = await _initDB('courses.db');
    return _database!;
  }

  Future<Database> _initDB(String filePath) async {
    final dbPath = await getDatabasesPath();
    final path = join(dbPath, filePath);

    return await openDatabase(path, version: 1, onCreate: _createDB);
  }

  Future _createDB(Database db, int version) async {
    await db.execute('''
    CREATE TABLE courses (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      name TEXT NOT NULL,
      description TEXT NOT NULL,
      thumbnailUrl TEXT NOT NULL,
      cost REAL NOT NULL,
      hours INTEGER NOT NULL
    )
    ''');
  }

  Future<Course> create(Course course) async {
    final db = await database;
    final id = await db.insert('courses', course.toMap());
    return course.copyWith(id: id);
  }

  Future<List<Course>> readAllCourses() async {
    final db = await database;
    final result = await db.query('courses');
    return result.map((json) => Course.fromMap(json)).toList();
  }
}

extension on Course {
  Course copyWith({int? id}) {
    return Course(
      id: id ?? this.id,
      name: name,
      description: description,
      thumbnailUrl: thumbnailUrl,
      cost: cost,
      hours: hours,
    );
  }
}
