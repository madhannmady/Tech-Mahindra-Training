import { useState } from "react";
import "./Feedback.css";

function Feedback() {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    rating: 5,
    comments: "",
  });
  const [submitted, setSubmitted] = useState(false);
  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const validateForm = () => {
    const newErrors = {};
    if (!formData.name || formData.name.length < 2) {
      newErrors.name = "Name is required and must be at least 2 characters.";
    }
    if (!formData.email || !/\S+@\S+\.\S+/.test(formData.email)) {
      newErrors.email = "Please enter a valid email address.";
    }
    if (!formData.rating || formData.rating < 1 || formData.rating > 5) {
      newErrors.rating = "Rating must be between 1 and 5.";
    }
    if (!formData.comments || formData.comments.length < 10) {
      newErrors.comments =
        "Comments are required and must be at least 10 characters.";
    }
    return newErrors;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const validationErrors = validateForm();
    if (Object.keys(validationErrors).length > 0) {
      setErrors(validationErrors);
      return;
    }

    const feedback = {
      id: Date.now(),
      ...formData,
      date: new Date().toISOString(),
    };

    const existingFeedback =
      JSON.parse(localStorage.getItem("courseWinFeedback")) || [];
    localStorage.setItem(
      "courseWinFeedback",
      JSON.stringify([...existingFeedback, feedback])
    );

    setSubmitted(true);
    setFormData({ name: "", email: "", rating: 5, comments: "" });
    setErrors({});
    setTimeout(() => setSubmitted(false), 3000);
  };

  return (
    <div className="feedback-container">
      <h1>Share Your Feedback</h1>
      <p>We value your feedback to improve our courses and services.</p>
      {submitted && (
        <div className="success-message">Thank you for your feedback!</div>
      )}
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="name">Name</label>
          <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            placeholder="Your Name"
          />
          {errors.name && <div className="error">{errors.name}</div>}
        </div>
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Your Email"
          />
          {errors.email && <div className="error">{errors.email}</div>}
        </div>
        <div className="form-group">
          <label htmlFor="rating">Rating (1-5)</label>
          <input
            type="number"
            id="rating"
            name="rating"
            value={formData.rating}
            onChange={handleChange}
            min="1"
            max="5"
          />
          {errors.rating && <div className="error">{errors.rating}</div>}
        </div>
        <div className="form-group">
          <label htmlFor="comments">Comments</label>
          <textarea
            id="comments"
            name="comments"
            value={formData.comments}
            onChange={handleChange}
            placeholder="Your feedback..."
          ></textarea>
          {errors.comments && <div className="error">{errors.comments}</div>}
        </div>
        <button type="submit">Submit Feedback</button>
      </form>
    </div>
  );
}

export default Feedback;
