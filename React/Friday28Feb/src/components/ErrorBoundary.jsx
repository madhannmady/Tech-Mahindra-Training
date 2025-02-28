import React, { Component } from "react";

export default class ErrorBoundary extends Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false };
  }

  componentDidCatch(error, errorInfo) {
    console.error("Error:", error);
    console.error("Error info:", errorInfo);

    this.setState({ hasError: true }); // Fix: Correct state update
  }

  render() {
    if (this.state.hasError) {
      return (
        <div>
          <h2>Something went wrong!!!!</h2>
        </div>
      );
    }
    return this.props.children;
  }
}
