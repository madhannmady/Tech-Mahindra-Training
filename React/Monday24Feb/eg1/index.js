import React from "react";
import ReactDOM from "react-dom/client";

// Creating elements
const heading = React.createElement(
  "div",
  {},
  React.createElement("h2", {}, "This is an H2 Heading")
);

const subHeading = React.createElement(
  "div",
  {},
  React.createElement("h4", {}, "This is an H4 Subheading")
);

const paragraph = React.createElement(
  "div",
  {},
  React.createElement("p", {}, "This is a paragraph inside a div.")
);

// Rendering to the root div
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  React.createElement(React.Fragment, {}, heading, subHeading, paragraph)
);
