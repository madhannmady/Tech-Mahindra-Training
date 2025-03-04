function checkLeapYearAndMonth(year, month) {
  let isLeap = (year % 4 === 0 && year % 100 !== 0) || year % 400 === 0;

  if (isLeap) {
    if (month === 2) {
      console.log(
        "The year is a leap year and the month is February with 29 days."
      );
    } else {
      console.log("The year is a leap year and the month is not February.");
    }
  } else {
    console.log("The given year is not a leap year.");
  }
}

checkLeapYearAndMonth(2024, 2);
checkLeapYearAndMonth(2024, 5);
checkLeapYearAndMonth(2023, 2);
