// If Statement
// *************
const num1 = 5;

if (num1 > 0) {
  console.log("The number is positive.");
}

// If-Else Statement
// *****************
let num2 = -10;

if (num2 > 0) {
  console.log("The number is positive.");
} else {
  console.log("The number is negative.");
}

// Nested If-Else Statement
// *************************
let weather = "sunny";
let temperature = 25;

if (weather === "sunny") {
  if (temperature > 30) {
    console.log("It's a hot day!");
  } else if (temperature > 20) {
    console.log("It's a warm day.");
  } else {
    console.log("It's a bit cool today.");
  }
} else if (weather === "rainy") {
  console.log("Don't forget your umbrella!");
} else {
  console.log("Check the weather forecast!");
}
