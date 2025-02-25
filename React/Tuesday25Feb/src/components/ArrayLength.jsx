// import React from "react";

const ArrayLengthCheck = (props) => {
  const isMultipleOfThree = props.numbers.length % 3 === 0;

  return (
    <div>
      <p>
        --------------------------------------------------------------------------
      </p>
      <p>Array: [{props.numbers.join(", ")}]</p>
      <p>
        The number of elements ({props.numbers.length})
        {isMultipleOfThree ? "is" : "is not"} a multiple of 3
      </p>
    </div>
  );
};

export default ArrayLengthCheck;
