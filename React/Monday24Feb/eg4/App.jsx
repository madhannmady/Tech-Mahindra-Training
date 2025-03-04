import React from "react";
import Animal from "./Animal";

function App() {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100">
      <h1 className="text-2xl font-bold text-gray-700 mb-4">
        React Animal Component
      </h1>
      <Animal />
    </div>
  );
}

export default App;
