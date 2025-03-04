"use strict";
class RoutineDisplay {
    routineGrid;
    workouts = [];
    constructor() {
        this.routineGrid = document.getElementById("routineGrid");
        this.loadWorkouts();
        this.displayRoutines();
    }
    loadWorkouts() {
        const saved = localStorage.getItem("workouts");
        if (saved) {
            this.workouts = JSON.parse(saved);
        }
    }
    saveWorkouts() {
        localStorage.setItem("workouts", JSON.stringify(this.workouts));
    }
    saveProgress(routine) {
        const progress = localStorage.getItem("progress");
        const progressData = progress
            ? JSON.parse(progress)
            : [];
        progressData.push({ date: new Date().toISOString(), routine });
        localStorage.setItem("progress", JSON.stringify(progressData));
    }
    displayRoutines() {
        // Clear the grid and remove any existing event listeners
        this.routineGrid.innerHTML =
            this.workouts.length === 0
                ? '<p style="text-align: center; color: #666;">No routines found.</p>'
                : "";
        this.workouts.forEach((routine, index) => {
            const card = document.createElement("div");
            card.className = `routine-card ${routine.completed ? "completed" : ""}`;
            card.innerHTML = `
              <div class="routine-card-content">
                  <h3>${routine.name}</h3>
                  <ul>${routine.exercises
                .map((ex) => `<li>${ex.name} - ${ex.duration}s (Rest: ${ex.rest}s)</li>`)
                .join("")}</ul>
                  <button class="btn btn-primary mt-2 complete-workout" data-index="${index}" ${routine.completed ? "disabled" : ""}>
                      ${routine.completed ? "Completed" : "Complete"}
                  </button>
              </div>
          `;
            this.routineGrid.appendChild(card);
            // Add event listener directly to the button
            const completeBtn = card.querySelector(".complete-workout");
            if (!routine.completed) {
                completeBtn.addEventListener("click", () => this.completeWorkout(index));
            }
        });
    }
    completeWorkout(index) {
        // Mark the routine as completed
        this.workouts[index].completed = true;
        this.saveWorkouts();
        this.saveProgress(this.workouts[index]);
        alert("Workout completed!");
        this.displayRoutines(); // Re-render the UI
    }
}
document.addEventListener("DOMContentLoaded", () => new RoutineDisplay());
