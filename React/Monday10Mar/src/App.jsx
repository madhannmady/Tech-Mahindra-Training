import { Routes, Route } from "react-router-dom";
import Header from "./components/Header/Header";
import CourseList from "./components/CourseList/CourseList";
import BestSelling from "./components/BestSelling/BestSelling";
import AboutUs from "./components/AboutUs/AboutUs";
import PlansPricing from "./components/PlansPricing/PlansPricing";
import Feedback from "./components/Feedback/Feedback";
import "./App.css";

function App() {
  return (
    <div className="App">
      <Header />
      <div className="main-content">
        <Routes>
          <Route path="/" element={<CourseList />} />
          <Route path="/best-selling" element={<BestSelling />} />
          <Route path="/about-us" element={<AboutUs />} />
          <Route path="/plans-pricing" element={<PlansPricing />} />
          <Route path="/feedback" element={<Feedback />} />
          <Route path="/courses" element={<CourseList />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
