interface Exercise {
  name: string;
  duration: number;
  rest: number;
}

interface Routine {
  name: string;
  exercises: Exercise[];
  completed?: boolean;
}

class RoutineDisplay {
  private routineGrid: HTMLDivElement;
  private workouts: Routine[] = [];

  constructor() {
    this.routineGrid = document.getElementById("routineGrid") as HTMLDivElement;
    this.loadWorkouts();
    this.displayRoutines();
  }

  private loadWorkouts(): void {
    const saved = localStorage.getItem("workouts");
    if (saved) {
      this.workouts = JSON.parse(saved);
    }
  }

  private saveWorkouts(): void {
    localStorage.setItem("workouts", JSON.stringify(this.workouts));
  }

  private saveProgress(routine: Routine): void {
    const progress = localStorage.getItem("progress");
    const progressData: { date: string; routine: Routine }[] = progress
      ? JSON.parse(progress)
      : [];
    progressData.push({ date: new Date().toISOString(), routine });
    localStorage.setItem("progress", JSON.stringify(progressData));
  }

  private displayRoutines(): void {
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
                    .map(
                      (ex) =>
                        `<li>${ex.name} - ${ex.duration}s (Rest: ${ex.rest}s)</li>`
                    )
                    .join("")}</ul>
                  <button class="btn btn-primary mt-2 complete-workout" data-index="${index}" ${
        routine.completed ? "disabled" : ""
      }>
                      ${routine.completed ? "Completed" : "Complete"}
                  </button>
              </div>
          `;
      this.routineGrid.appendChild(card);

      // Add event listener directly to the button
      const completeBtn = card.querySelector(
        ".complete-workout"
      ) as HTMLButtonElement;
      if (!routine.completed) {
        completeBtn.addEventListener("click", () =>
          this.completeWorkout(index)
        );
      }
    });
  }

  private completeWorkout(index: number): void {
    // Mark the routine as completed
    this.workouts[index].completed = true;
    this.saveWorkouts();
    this.saveProgress(this.workouts[index]);
    alert("Workout completed!");
    this.displayRoutines(); // Re-render the UI
  }
}

document.addEventListener("DOMContentLoaded", () => new RoutineDisplay());
