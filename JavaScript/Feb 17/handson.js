//task 1

let num = 8; 
let limit = 10;

function displayMultiplicationTable() {
    for (let i = 1; i <= limit; i++) {
        console.log(`${num} x ${i} = ${num * i}`);
    }
}

displayMultiplicationTable();


//task 2

function displayFactors(number) {
    console.log(`Factors of ${number}:`);
    for (let i = 1; i <= number; i++) {
        if (number % i === 0) {
            console.log(i);
        }
    }
}

displayFactors(16);


//task 3

function isSumOfDigitsEvenOrOdd(number) {
    let sum = 0;
    let num = number;

    while (num > 0) {
        sum += num % 10;
        num = Math.floor(num / 10);
    }

    if (sum % 2 === 0) {
        console.log(`The sum of the digits of ${number} is ${sum}, which is an even number.`);
    } else {
        console.log(`The sum of the digits of ${number} is ${sum}, which is an odd number.`);
    }
}

isSumOfDigitsEvenOrOdd(1234);

//task 4

const chooseOperation = () => {
    const operation = 'add';
    const a = 20;
    const b = 5;  

    const add = (x, y) => x + y;
    const subtract = (x, y) => x - y;
    const multiply = (x, y) => x * y;
    const divide = (x, y) => {
        if (y === 0) {
            return 'Cannot divide by zero';
        } else {
            return {
                quotient: Math.floor(x / y),
                remainder: x % y
            };
        }
    };

    switch (operation) {
        case 'add':
            console.log(`Sum: ${add(a, b)}`);
            break;
        case 'subtract':
            console.log(`Difference: ${subtract(a, b)}`);
            break;
        case 'multiply':
            console.log(`Product: ${multiply(a, b)}`);
            break;
        case 'divide':
            const result = divide(a, b);
            if (typeof result === 'string') {
                console.log(result);
            } else {
                console.log(`Quotient: ${result.quotient}, Remainder: ${result.remainder}`);
            }
            break;
        default:
            console.log('Invalid operation');
    }
};

chooseOperation();


//task 5


const student = {
    id: 101,
    name: 'John Doe',
    department: 'Computer Science',
    college: 'ABC University',
    email: 'johndoe@example.com'
};
function displayStudentDetails() {
    console.log(`ID: ${student.id}`);
    console.log(`Name: ${student.name}`);
    console.log(`Department: ${student.department}`);
    console.log(`College: ${student.college}`);
    console.log(`Email: ${student.email}`);
}
displayStudentDetails();

function displayStudentBasicDetails() {
    console.log(`ID: ${student.id}`);
    console.log(`Name: ${student.name}`);
    console.log(`Email: ${student.email}`);
}
displayStudentBasicDetails();
student.address = {
    doorNo: '123',
    street: 'Main Street',
    area: 'Downtown',
    pincode: '123456'
};
function displayStudentDetailsWithAddress() {
    displayStudentDetails();
    console.log(`Address: ${student.address.doorNo}, ${student.address.street}, ${student.address.area}, ${student.address.pincode}`);
}
displayStudentDetailsWithAddress();
delete student.email;
delete displayStudentBasicDetails;
displayStudentDetailsWithAddress();
