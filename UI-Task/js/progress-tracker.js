"use strict";
class ProgressTracker {
    progressHistory;
    progressData = [];
    constructor() {
        this.progressHistory = document.getElementById("progressHistory");
        this.loadProgress();
        this.displayProgress();
        this.displayChart();
    }
    loadProgress() {
        const saved = localStorage.getItem("progress");
        if (saved)
            this.progressData = JSON.parse(saved);
    }
    displayProgress() {
        this.progressHistory.innerHTML = "";
        this.progressData.forEach((entry) => {
            const div = document.createElement("div");
            div.className = "progress-entry";
            div.innerHTML = `
                <h4>${new Date(entry.date).toLocaleString()}</h4>
                <p>Routine: ${entry.routine.name}</p>
                <p>Exercises: ${entry.routine.exercises
                .map((ex) => `${ex.name} (${ex.duration}s)`)
                .join(", ")}</p>
            `;
            this.progressHistory.appendChild(div);
        });
    }
    displayChart() {
        const ctx = document.getElementById("progressChart").getContext("2d");
        new Chart(ctx, {
            type: "line",
            data: {
                labels: this.progressData.map((entry) => new Date(entry.date).toLocaleDateString()),
                datasets: [
                    {
                        label: "Workouts Completed",
                        data: this.progressData.map((_, i) => i + 1),
                        borderColor: "#0a66c2",
                        backgroundColor: "rgba(10, 102, 194, 0.2)",
                        fill: true,
                    },
                ],
            },
            options: {
                responsive: true,
                scales: {
                    y: { beginAtZero: true, title: { display: true, text: "Workouts" } },
                    x: { title: { display: true, text: "Date" } },
                },
            },
        });
    }
}
document.addEventListener("DOMContentLoaded", () => new ProgressTracker());
