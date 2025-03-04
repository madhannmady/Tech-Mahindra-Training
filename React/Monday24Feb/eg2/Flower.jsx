import React from "react";

function Flower({ name }) {
  return (
    <div className="p-4 border rounded-md shadow-md bg-pink-100 text-center">
      <h2 className="text-xl font-bold text-pink-600">Flower Name: {name}</h2>
    </div>
  );
}

export default Flower;
