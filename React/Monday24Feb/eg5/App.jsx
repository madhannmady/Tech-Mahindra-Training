import React from "react";
import Game from "./Game";

function App() {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100">
      <h1 className="text-2xl font-bold text-gray-700 mb-4">
        React Game Component
      </h1>
      <Game />
    </div>
  );
}

export default App;
