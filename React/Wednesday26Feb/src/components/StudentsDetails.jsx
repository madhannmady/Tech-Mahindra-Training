import React from "react";

const StudentDetails = ({ students }) => {
  return (
    <div>
      <h2>Student List</h2>
      <ul>
        {students.map((student, index) => (
          <li key={index}>
            {student.name} - {student.department}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default StudentDetails;
