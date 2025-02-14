function isPrime(num) {
  if (num <= 1) return false;
  for (let i = 2; i <= Math.sqrt(num); i++) {
    if (num % i === 0) return false;
  }
  return true;
}
const a = 10;
const b = 2;
const c = 123;
console.log(isPrime(a));
console.log(isPrime(b));
console.log(isPrime(c));
