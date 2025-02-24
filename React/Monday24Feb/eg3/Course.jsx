import React, { Component } from "react";

class Course extends Component {
  render() {
    return (
      <div className="p-4 border rounded-md shadow-md bg-blue-100 text-center">
        <h2 className="text-xl font-bold text-blue-600">
          Course Name: {this.props.name}
        </h2>
      </div>
    );
  }
}

export default Course;
