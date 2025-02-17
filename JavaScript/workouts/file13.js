function displayMultiples(firstNum, secondNum) {
  let thirdNum = secondNum + 40;
  let current = Math.ceil(secondNum / firstNum) * firstNum;

  while (current <= thirdNum) {
    console.log(current);
    current += firstNum;
  }
}

displayMultiples(7, 20);
