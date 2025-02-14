function checkDayOfWeek(day) {
  switch (day.toLowerCase()) {
    case "monday":
      console.log("Start of the week!");
      break;
    case "tuesday":
    case "wednesday":
    case "thursday":
      console.log("Mid of the week!");
      break;
    case "friday":
      console.log("Last working day of the week!");
      break;
    case "saturday":
      console.log("WeekEnd - Saturday!");
      break;
    case "sunday":
      console.log("WeekEnd - Sunday!");
      break;
    default:
      console.log("Invalid input!");
  }
}

checkDayOfWeek("Monday");
checkDayOfWeek("Wednesday");
checkDayOfWeek("Friday");
checkDayOfWeek("Saturday");
checkDayOfWeek("Sunday");
checkDayOfWeek("Holiday");
