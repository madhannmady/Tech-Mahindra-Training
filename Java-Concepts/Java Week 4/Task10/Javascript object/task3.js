
/*
Create an object called student in Javascript with 3 properties and 1 method and access them with the object. Then add a nested object and 2 more functions to it. Access all the properties and functions.
Remove a normal property and a function and then display the details of the object
*/

// Creating the student object
let student = {
    name: "John",
    age: 21,
    course: "Computer Science",
    getDetails: function () {
        return `Name: ${this.name}, Age: ${this.age}, Course: ${this.course}`;
    }
};

// Accessing properties and method
console.log(student.getDetails());

// Adding a nested object and new methods
student.address = {
    city: "New York",
    country: "USA"
};

student.setAge = function (newAge) {
    this.age = newAge;
};

student.getAddress = function () {
    return `City: ${this.address.city}, Country: ${this.address.country}`;
};

// Accessing new properties and methods
console.log(student.getAddress());
student.setAge(22);
console.log(student.getDetails());

// Removing a property and a function
delete student.course;
delete student.setAge;

console.log(student);
