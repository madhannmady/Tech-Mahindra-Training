interface Workout {
  name: string;
  category: string;
  description: string;
  image: string;
}

document.addEventListener("DOMContentLoaded", () => {
  const featuredWorkouts = document.getElementById(
    "featuredWorkouts"
  ) as HTMLDivElement;
  let workouts: Workout[] = [];

  fetch("assets/data/routines.json")
    .then((response) => response.json())
    .then((data) => {
      workouts = data;
      displayFeaturedWorkouts();
    })
    .catch((error) => console.error("Error fetching routines:", error));

  function displayFeaturedWorkouts() {
    if (!featuredWorkouts) return;

    featuredWorkouts.innerHTML = "";
    const cardio = workouts.find((w) => w.category === "cardio");
    const strength = workouts.find((w) => w.category === "strength");

    [cardio, strength].forEach((workout) => {
      if (workout) {
        const card = document.createElement("div");
        card.className = "featured-card";
        card.innerHTML = `
                    <img src="${workout.image}" alt="${workout.name}">
                    <div class="featured-card-content">
                        <h3>${workout.name}</h3>
                        <p>${workout.description}</p>
                    </div>
                `;
        featuredWorkouts.appendChild(card);
      }
    });
  }
});
