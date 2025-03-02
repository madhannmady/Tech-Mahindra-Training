interface Course {
    id: number;
    title: string;
    category: string;
    description: string;
    instructor: string;
    image: string;
    prerequisites: string;
    rating: number;
}

interface Enrollment {
    fullName: string;
    email: string;
    courseId: number;
}

class EnrollmentManager {
    private form: HTMLFormElement;
    private courseSelect: HTMLSelectElement;

    constructor() {
        this.form = document.getElementById('enrollmentForm') as HTMLFormElement;
        this.courseSelect = document.getElementById('courseSelect') as HTMLSelectElement;
        this.loadCourses();
        this.setupForm();
    }

    private async loadCourses(): Promise<void> {
        try {
            const response = await fetch('assets/data/courses.json');
            const courses: Course[] = await response.json();
            courses.forEach(course => {
                const option = document.createElement('option');
                option.value = course.id.toString();
                option.textContent = course.title;
                this.courseSelect.appendChild(option);
            });
        } catch (error) {
            console.error('Error loading courses:', error);
        }
    }

    private setupForm(): void {
        this.form.addEventListener('submit', (e: Event) => {
            e.preventDefault();
            const enrollment: Enrollment = {
                fullName: (document.getElementById('fullName') as HTMLInputElement).value,
                email: (document.getElementById('email') as HTMLInputElement).value,
                courseId: parseInt(this.courseSelect.value)
            };

            if (this.validateEnrollment(enrollment)) {
                console.log('Enrollment submitted:', enrollment);
                alert('Enrollment successful! Check your email for confirmation.');
                this.form.reset();
            }
        });
    }

    private validateEnrollment(enrollment: Enrollment): boolean {
        if (!enrollment.fullName || !enrollment.email || !enrollment.courseId) {
            alert('Please fill all fields');
            return false;
        }
        if (!enrollment.email.includes('@')) {
            alert('Please enter a valid email');
            return false;
        }
        return true;
    }
}

document.addEventListener('DOMContentLoaded', () => {
    new EnrollmentManager();
});