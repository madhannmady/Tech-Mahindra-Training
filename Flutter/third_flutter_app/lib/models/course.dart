class Course {
  final int? id;
  final String name;
  final String description;
  final String thumbnailUrl;
  final double cost;
  final int hours;

  Course({
    this.id,
    required this.name,
    required this.description,
    required this.thumbnailUrl,
    required this.cost,
    required this.hours,
  });

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'name': name,
      'description': description,
      'thumbnailUrl': thumbnailUrl,
      'cost': cost,
      'hours': hours,
    };
  }

  factory Course.fromMap(Map<String, dynamic> map) {
    return Course(
      id: map['id'],
      name: map['name'],
      description: map['description'],
      thumbnailUrl: map['thumbnailUrl'],
      cost: map['cost'],
      hours: map['hours'],
    );
  }
}
