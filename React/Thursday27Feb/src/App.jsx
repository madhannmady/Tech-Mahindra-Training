import { useState } from "react";
import "./App.css";
import NestedComponents from "./components/React";
import ABComponent2 from "./components/ABComponent2";
import Nested1 from "./components/Nested1";
import Nested2 from "./components/Nested2";
import Nested3 from "./components/Nested3";
import Nested4 from "./components/Nested4";

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <NestedComponents />
      <ABComponent2 />
      <Nested1 />
      <Nested2 />
      <Nested3 />
      <Nested4 />
    </>
  );
}

export default App;
