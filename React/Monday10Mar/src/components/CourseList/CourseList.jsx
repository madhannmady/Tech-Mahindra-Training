import { useState, useEffect } from "react";
import api from "../../services/api";
import CourseCard from "../CourseCard/CourseCard";
import "./CourseList.css";

function CourseList() {
  const [courses, setCourses] = useState([]);
  const [filter, setFilter] = useState({
    category: "",
    minPrice: 0,
    maxPrice: 1000,
    searchTerm: "",
  });

  useEffect(() => {
    api.getCourses().then((data) => {
      console.log("Total courses fetched:", data.length);
      const nonBestSellers = data.filter((course) => !course.bestseller);
      console.log("Non-bestseller courses:", nonBestSellers.length);
      setCourses(nonBestSellers);
    });
  }, []);

  const categories = ["Game Design", "Programming", "Art", "Sound Design"];

  const handleFilterChange = (e) => {
    setFilter({ ...filter, [e.target.name]: e.target.value });
  };

  const filteredCourses = courses.filter((course) => {
    const matchesCategory = filter.category
      ? course.category === filter.category
      : true;
    const matchesPrice =
      course.price >= filter.minPrice && course.price <= filter.maxPrice;
    const matchesSearch = filter.searchTerm
      ? course.title.toLowerCase().includes(filter.searchTerm.toLowerCase()) ||
        course.description
          .toLowerCase()
          .includes(filter.searchTerm.toLowerCase())
      : true;
    return matchesCategory && matchesPrice && matchesSearch;
  });

  return (
    <div className="container course-list">
      <h1>Welcome to Course-Win</h1>
      <p>
        Unleash your game development potential with industry-leading courses
        designed by experts.
      </p>
      <hr className="divider" />
      <h2>Explore Our Courses</h2>
      <form className="filter-form">
        <select
          name="category"
          value={filter.category}
          onChange={handleFilterChange}
        >
          <option value="">All Categories</option>
          {categories.map((category) => (
            <option key={category} value={category}>
              {category}
            </option>
          ))}
        </select>
        <input
          type="number"
          name="minPrice"
          value={filter.minPrice}
          onChange={handleFilterChange}
          placeholder="Min Price"
        />
        <input
          type="number"
          name="maxPrice"
          value={filter.maxPrice}
          onChange={handleFilterChange}
          placeholder="Max Price"
        />
        <input
          type="text"
          name="searchTerm"
          value={filter.searchTerm}
          onChange={handleFilterChange}
          placeholder="Search courses..."
        />
      </form>
      <div className="course-grid">
        {filteredCourses.map((course) => (
          <CourseCard key={course.id} course={course} />
        ))}
      </div>
    </div>
  );
}

export default CourseList;
