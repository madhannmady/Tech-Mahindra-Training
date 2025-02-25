const DivisibleNum = (props) => {
  if (props.num % 13 == 0) {
    return <p>The number {props.num} is Divisible by 13</p>;
  } else {
    return <p>The number {props.num} is not divisible by 13</p>;
  }
};

export default DivisibleNum;
