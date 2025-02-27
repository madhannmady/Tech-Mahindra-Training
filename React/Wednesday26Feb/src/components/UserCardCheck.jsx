// import React from "react";

const UserCardCheck = ({ user }) => {
  const { hasAadhar, hasPAN } = user;

  return (
    <div>
      <h2>User Card Availability</h2>
      {hasAadhar || hasPAN ? (
        <ul>
          {hasAadhar && <li>Aadhaar Card Available</li>}
          {hasPAN && <li>PAN Card Available</li>}
        </ul>
      ) : (
        <p>No Aadhaar or PAN Card available.</p>
      )}
    </div>
  );
};

export default UserCardCheck;
