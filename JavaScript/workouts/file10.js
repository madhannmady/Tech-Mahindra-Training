let mark = 888;

if (mark === 100) {
  console.log("Phenomenal");
} else if (mark >= 85 && mark < 100) {
  console.log("Excellent ");
} else if (mark <= 85 && mark >= 71) {
  console.log("Good Work");
} else if (mark <= 70 && mark >= 51) {
  console.log("Practice Well");
} else if (mark < 51 && mark >= 0) {
  console.log("Hard Work is needed");
} else {
  console.log("Enter a mark below 100");
}
