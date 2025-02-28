import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import ErrorBoundary from "./components/ErrorBoundary";
import ABComponentForError from "./components/ABComponentForError";

const rootElement = document.getElementById("root");

if (rootElement) {
  ReactDOM.createRoot(rootElement).render(
    <React.StrictMode>
      <ErrorBoundary>
        <ABComponentForError />
      </ErrorBoundary>
      <App />
    </React.StrictMode>
  );
} else {
  console.error("Root element not found!");
}
