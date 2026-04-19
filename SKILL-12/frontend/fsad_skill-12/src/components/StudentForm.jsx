import React, { useState, useEffect } from "react";
import axios from "axios";

function StudentForm({ selected, clearSelection }) {
  const [form, setForm] = useState({
    name: "",
    email: "",
    course: ""
  });

  useEffect(() => {
    if (selected) {
      setForm(selected);
    }
  }, [selected]);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = () => {
    if (form.id) {
      axios.put(`http://localhost:2026/students/${form.id}`, form)
        .then(() => {
          alert("Student Updated");
          clearSelection();
          window.location.reload();
        });
    } else {
      axios.post("http://localhost:2026/students", form)
        .then(() => {
          alert("Student Added");
          window.location.reload();
        });
    }
  };

  return (
    <div className="card">
      <h2>{form.id ? "Update Student" : "Add Student"}</h2>

      <div className="form-group">
        <label>Name</label>
        <input
          name="name"
          value={form.name}
          onChange={handleChange}
          placeholder="Enter name"
        />
      </div>

      <div className="form-group">
        <label>Email</label>
        <input
          name="email"
          value={form.email}
          onChange={handleChange}
          placeholder="Enter email"
        />
      </div>

      <div className="form-group">
        <label>Course</label>
        <input
          name="course"
          value={form.course}
          onChange={handleChange}
          placeholder="Enter course"
        />
      </div>

      <button onClick={handleSubmit}>
        {form.id ? "Update" : "Add"}
      </button>
    </div>
  );
}

export default StudentForm;