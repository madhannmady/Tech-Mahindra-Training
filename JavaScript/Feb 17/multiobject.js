const person = {
    firstName: "John",
    lastName: "Doe",
    age: 50,
    eyeColor: "blue"
  };
  console.log(person)
  // Create an Object
  //const person = {};
  
  // Add Properties
  person.firstName = "John";
  person.lastName = "Doe";
  person.age = 50;
  person.eyeColor = "blue";
    console.log(person)

    
    let age = person["age"];
    console.log(person["firstName"] + " is " + person["age"] + " years old.");
    
    
    let x = "firstName";
    let y = "age";
    console.log(person[x] + " is " + person[y] + " years old.");

//add a new property to the object
person.nationality = "English";
console.log(person);

//delete a property from the object
delete person.age;
console.log(person);

//nested object
const person = {
    firstName: "John",
    lastName: "Doe",
    id: 5566,
    fullName: function() {
      return this.firstName + " " + this.lastName;
    }
  };
  
  //name = person.fullName();
  //console.log("Full name: "+person.fullName())
  console.log("fullName function definition: "+person.fullName);