// import React from "react";
import StudentDetails from "./components/StudentsDetails";
import Garage from "./components/Garage";
import UserCardCheck from "./components/UserCardCheck";
const App = () => {
  const user = { hasAadhar: true, hadPan: false };
  const students = [
    { name: "Alice", department: "Computer Science" },
    { name: "Bob", department: "Mechanical Engineering" },
    { name: "Charlie", department: "Electrical Engineering" },
  ];

  return (
    <div>
      <h1>Welcome</h1>
      <Garage />
      <UserCardCheck user={user} />
      <StudentDetails students={students} />
    </div>
  );
};

export default App;
