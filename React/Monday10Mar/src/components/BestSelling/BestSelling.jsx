import { useState, useEffect } from "react";
import api from "../../services/api";
import CourseCard from "../CourseCard/CourseCard";
import "./BestSelling.css";

function BestSelling() {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    api.getCourses().then((data) => {
      console.log("Total courses fetched:", data.length);
      const bestSellers = data.filter((course) => course.bestseller);
      console.log("Bestseller courses:", bestSellers.length);
      setCourses(bestSellers);
    });
  }, []);

  return (
    <div className="container best-selling">
      <h1>Best Selling Courses</h1>
      <div className="course-grid">
        {courses.map((course) => (
          <CourseCard key={course.id} course={course} />
        ))}
      </div>
    </div>
  );
}

export default BestSelling;
