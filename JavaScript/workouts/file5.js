function showConfirmation() {
  let result = confirm("Are you sure you want to proceed?");
  if (result) {
    alert("You clicked OK!");
  } else {
    alert("You clicked Cancel!");
  }
}

showConfirmation();
