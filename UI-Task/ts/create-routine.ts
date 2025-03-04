interface Exercise {
  name: string;
  duration: number;
  rest: number;
}

interface Routine {
  name: string;
  exercises: Exercise[];
}

class RoutineManager {
  private form: HTMLFormElement;
  private exerciseList: HTMLDivElement;
  private addExerciseBtn: HTMLButtonElement;
  private workouts: Routine[] = [];

  constructor() {
    this.form = document.getElementById("routineForm") as HTMLFormElement;
    this.exerciseList = document.getElementById(
      "exerciseList"
    ) as HTMLDivElement;
    this.addExerciseBtn = document.getElementById(
      "addExerciseBtn"
    ) as HTMLButtonElement;
    this.loadWorkouts();
    this.setupEventListeners();
  }

  private loadWorkouts(): void {
    const saved = localStorage.getItem("workouts");
    if (saved) this.workouts = JSON.parse(saved);
  }

  private saveWorkouts(): void {
    localStorage.setItem("workouts", JSON.stringify(this.workouts));
  }

  private setupEventListeners(): void {
    this.addExerciseBtn.addEventListener("click", () => this.addExercise());
    this.form.addEventListener("submit", (e) => this.saveRoutine(e));
  }

  private addExercise(): void {
    const exerciseItem = document.createElement("div");
    exerciseItem.className = "exercise-item";
    exerciseItem.innerHTML = `
            <input type="text" placeholder="Exercise Name" required>
            <input type="number" placeholder="Duration (sec)" min="1" required>
            <input type="number" placeholder="Rest (sec)" min="0" required>
            <button type="button" class="remove-exercise">Remove</button>
        `;
    this.exerciseList.appendChild(exerciseItem);
    exerciseItem
      .querySelector(".remove-exercise")
      ?.addEventListener("click", () => exerciseItem.remove());
  }

  private saveRoutine(e: Event): void {
    e.preventDefault();
    const routineName = (
      document.getElementById("routineName") as HTMLInputElement
    ).value;
    const exerciseItems = this.exerciseList.querySelectorAll(".exercise-item");
    const exercises: Exercise[] = Array.from(exerciseItems).map((item) => ({
      name: (item.querySelector("input:nth-child(1)") as HTMLInputElement)
        .value,
      duration: parseInt(
        (item.querySelector("input:nth-child(2)") as HTMLInputElement).value
      ),
      rest: parseInt(
        (item.querySelector("input:nth-child(3)") as HTMLInputElement).value
      ),
    }));

    const routine: Routine = { name: routineName, exercises };
    this.workouts.push(routine);
    this.saveWorkouts();
    alert("Routine saved!");
    this.form.reset();
    this.exerciseList.innerHTML = "";
    window.location.href = "my-routines.html";
  }
}

document.addEventListener("DOMContentLoaded", () => new RoutineManager());
