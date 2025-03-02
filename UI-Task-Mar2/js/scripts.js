document.addEventListener("DOMContentLoaded", () => {
  const courseGrid = document.getElementById("courseGrid");
  const featuredCourses = document.getElementById("featuredCourses");
  const searchInput = document.getElementById("searchInput");
  const tabButtons = document.querySelectorAll(".tab-btn");
  const allCoursesGrid = document.getElementById("allCoursesGrid");
  const instructorGrid = document.getElementById("instructorGrid");
  let courses = [];

  const instructorImages = {
    Ramesh: "assets/images/instructor1.jpg",
    Suresh: "assets/images/instructor2.jpg",
    Dinesh: "assets/images/instructor3.jpg",
    Sarah: "assets/images/instructor4.jpg",
    Emily: "assets/images/instructor5.jpg",
  };

  fetch("assets/data/courses.json")
    .then((response) => response.json())
    .then((data) => {
      courses = data;
      displayFeaturedCourses();
      displayCourses(courses, courseGrid);
      if (allCoursesGrid) displayCourses(courses, allCoursesGrid);
      if (instructorGrid) displayInstructors();
    });

  function displayFeaturedCourses() {
    if (!featuredCourses) return;

    const techCourse = courses.find((course) => course.category === "tech");
    const businessCourse = courses.find(
      (course) => course.category === "business"
    );

    featuredCourses.innerHTML = "";

    if (techCourse) {
      const techCard = document.createElement("div");
      techCard.className = "featured-card";
      techCard.innerHTML = `
              <img src="${techCourse.image}" alt="${techCourse.title}">
              <div class="featured-card-content">
                  <h3>${techCourse.title}</h3>
                  <p>${techCourse.description}</p>
                  <p class="rating">★ ${techCourse.rating}</p>
              </div>
          `;
      featuredCourses.appendChild(techCard);
    }

    if (businessCourse) {
      const businessCard = document.createElement("div");
      businessCard.className = "featured-card";
      businessCard.innerHTML = `
              <img src="${businessCourse.image}" alt="${businessCourse.title}">
              <div class="featured-card-content">
                  <h3>${businessCourse.title}</h3>
                  <p>${businessCourse.description}</p>
                  <p class="rating">★ ${businessCourse.rating}</p>
              </div>
          `;
      featuredCourses.appendChild(businessCard);
    }
  }

  function displayCourses(courseList, grid) {
    if (!grid) return;
    grid.innerHTML = "";
    courseList.forEach((course) => {
      const card = document.createElement("div");
      card.className = "course-card";
      card.innerHTML = `
              <img src="${course.image}" alt="${course.title}">
              <div class="course-card-content">
                  <h3>${course.title}</h3>
                  <p>${course.description}</p>
                  <p>Instructor: ${course.instructor}</p>
                  <p class="rating">★ ${course.rating}</p>
              </div>
          `;
      grid.appendChild(card);
    });
  }

  function displayInstructors() {
    const instructors = [...new Set(courses.map((c) => c.instructor))];
    instructors.forEach((instructor) => {
      const card = document.createElement("div");
      card.className = "instructor-card";
      card.innerHTML = `
              <img src="${instructorImages[instructor]}" alt="${instructor}">
              <div class="instructor-card-content">
                  <h3>${instructor}</h3>
                  <p>Expert in ${
                    courses.find((c) => c.instructor === instructor).category
                  }</p>
                  <p class="rating">★ ${
                    courses.find((c) => c.instructor === instructor).rating
                  }</p>
              </div>
          `;
      instructorGrid.appendChild(card);
    });
  }

  tabButtons.forEach((button) => {
    button.addEventListener("click", () => {
      tabButtons.forEach((btn) => btn.classList.remove("active"));
      button.classList.add("active");
      const category = button.dataset.category;
      const filtered =
        category === "all"
          ? courses
          : courses.filter((course) => course.category === category);
      displayCourses(filtered, courseGrid);
    });
  });

  if (searchInput) {
    searchInput.addEventListener("input", () => {
      const term = searchInput.value.toLowerCase();
      const filtered = courses.filter(
        (course) =>
          course.title.toLowerCase().includes(term) ||
          course.instructor.toLowerCase().includes(term)
      );
      displayCourses(filtered, courseGrid);
    });
  }
});
