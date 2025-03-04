const StringLength = (props) => {
  if (props.name.length % 2 == 0) {
    return <p>{props.name} is having even length</p>;
  } else {
    return <p>{props.name} is having odd length</p>;
  }
};

export default StringLength;
