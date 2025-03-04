import React from "react";

const FlowerChecker = (props) => {
  const flowers = ["Rose", "Jasmine", "Lotus"];
  const isFlower = flowers.includes(props.input);

  return (
    <div>
      <p>----------------------------------------</p>
      <p>Input: "{props.input}"</p>
      <p>{isFlower ? "It's a flower" : "It's not a flower"}</p>
    </div>
  );
};

export default FlowerChecker;
