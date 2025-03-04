"use strict";
class RoutineManager {
    form;
    exerciseList;
    addExerciseBtn;
    workouts = [];
    constructor() {
        this.form = document.getElementById("routineForm");
        this.exerciseList = document.getElementById("exerciseList");
        this.addExerciseBtn = document.getElementById("addExerciseBtn");
        this.loadWorkouts();
        this.setupEventListeners();
    }
    loadWorkouts() {
        const saved = localStorage.getItem("workouts");
        if (saved)
            this.workouts = JSON.parse(saved);
    }
    saveWorkouts() {
        localStorage.setItem("workouts", JSON.stringify(this.workouts));
    }
    setupEventListeners() {
        this.addExerciseBtn.addEventListener("click", () => this.addExercise());
        this.form.addEventListener("submit", (e) => this.saveRoutine(e));
    }
    addExercise() {
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
    saveRoutine(e) {
        e.preventDefault();
        const routineName = document.getElementById("routineName").value;
        const exerciseItems = this.exerciseList.querySelectorAll(".exercise-item");
        const exercises = Array.from(exerciseItems).map((item) => ({
            name: item.querySelector("input:nth-child(1)")
                .value,
            duration: parseInt(item.querySelector("input:nth-child(2)").value),
            rest: parseInt(item.querySelector("input:nth-child(3)").value),
        }));
        const routine = { name: routineName, exercises };
        this.workouts.push(routine);
        this.saveWorkouts();
        alert("Routine saved!");
        this.form.reset();
        this.exerciseList.innerHTML = "";
        window.location.href = "my-routines.html";
    }
}
document.addEventListener("DOMContentLoaded", () => new RoutineManager());
