function getAddress() {
  let userAddress = prompt("Please enter your address:");
  if (userAddress) {
    alert("Your address is: " + userAddress);
  } else {
    alert("No address entered!");
  }
}

// Call the function to execute when the script runs
getAddress();
