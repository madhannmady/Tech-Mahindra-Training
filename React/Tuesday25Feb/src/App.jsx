import "./App.css";

import DivisibleNum from "./components/DivisibleNum";
import StringLength from "./components/StringLength";
import VowelsCounter from "./components/VowelsCounter";
import FlowerChecker from "./components/FlowerChecker";
import ArrayLengthCheck from "./components/ArrayLength";

function App() {
  return (
    <>
      <h1>Hello</h1>
      <DivisibleNum num={13} />
      <StringLength name={"Test"} />
      <VowelsCounter text={"Madhan"} />
      <ArrayLengthCheck numbers={[9, 4, 24]} />
      <FlowerChecker input="tomato" />
    </>
  );
}

export default App;
