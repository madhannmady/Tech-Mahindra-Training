const person = {firstName:"John", lastName:"Doe", age:50, eyeColor:"blue"};
console.log(person)

let age = person.age;
console.log(person.firstName + " is " + person.age + " years //old.");

//adding function to the object
person.name1 = function () {
    return this.firstName + " " + this.lastName;
  };
  
  person.name2 = function () {
    return (this.firstName + " " + this.lastName).toUpperCase();
  };
  
  console.log("name1 function definition: "+person.name1);
  console.log("name2 function definition: "+person.name2);

  //delete a function from the object
  delete person.name1;