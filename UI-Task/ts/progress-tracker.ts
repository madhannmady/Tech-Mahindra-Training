interface Exercise {
  name: string;
  duration: number;
  rest: number;
}

interface Routine {
  name: string;
  exercises: Exercise[];
}

interface ProgressEntry {
  date: string;
  routine: Routine;
}

declare const Chart: any;

class ProgressTracker {
  private progressHistory: HTMLDivElement;
  private progressData: ProgressEntry[] = [];

  constructor() {
    this.progressHistory = document.getElementById(
      "progressHistory"
    ) as HTMLDivElement;
    this.loadProgress();
    this.displayProgress();
    this.displayChart();
  }

  private loadProgress(): void {
    const saved = localStorage.getItem("progress");
    if (saved) this.progressData = JSON.parse(saved);
  }

  private displayProgress(): void {
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

  private displayChart(): void {
    const ctx = (
      document.getElementById("progressChart") as HTMLCanvasElement
    ).getContext("2d")!;
    new Chart(ctx, {
      type: "line",
      data: {
        labels: this.progressData.map((entry) =>
          new Date(entry.date).toLocaleDateString()
        ),
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
