function displayMultiples(firstNum, secondNum) {
  let thirdNum = secondNum + 40;
  let current = secondNum;

  while (current <= thirdNum) {
    if (current % firstNum === 0) {
      console.log(current);
    }
    current++;
  }
}

displayMultiples(7, 20);
