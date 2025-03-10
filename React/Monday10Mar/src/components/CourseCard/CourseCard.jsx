import "./CourseCard.css";

function CourseCard({ course }) {
  return (
    <div className="card">
      <h3>{course.title}</h3>
      <p>{course.description}</p>
      <p>
        <strong>Category:</strong> {course.category}
      </p>
      <p>
        <strong>Price:</strong> ${course.price}
      </p>
      <p>
        <strong>Rating:</strong> {course.rating}/5
      </p>
      <p>
        <strong>Duration:</strong> {course.duration}
      </p>
      <p>
        <strong>Instructor:</strong> {course.instructor}
      </p>
      <button className="enroll-btn">Enroll Now</button>
    </div>
  );
}

export default CourseCard;
