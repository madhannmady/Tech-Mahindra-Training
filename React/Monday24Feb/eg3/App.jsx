import React from "react";
import Course from "./Course";

function App() {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100">
      <h1 className="text-2xl font-bold text-gray-700 mb-4">
        React Course Component
      </h1>
      <Course name="Information Technology" />
    </div>
  );
}

export default App;
