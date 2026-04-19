import React, { useState, useEffect } from "react";
import axios from "axios";

function AddStudent({ selected, refresh }) {
  const [student, setStudent] = useState({
    name: "",
    email: "",
    course: ""
  });

  useEffect(() => {
    if (selected) {
      setStudent(selected);
    }
  }, [selected]);

  const handleChange = (e) => {
    setStudent({
      ...student,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = () => {
    if (student.id) {
      axios.put(`http://localhost:2026/students/${student.id}`, student)
        .then(() => refresh());
    } else {
      axios.post("http://localhost:2026/students", student)
        .then(() => refresh());
    }

    setStudent({ name: "", email: "", course: "" });
  };

  return (
    <div className="card">
      <h2>{student.id ? "Update Student" : "Add Student"}</h2>

      <div className="form-group">
        <label>Name</label>
        <input
          type="text"
          name="name"
          value={student.name}
          onChange={handleChange}
          placeholder="Enter name"
        />
      </div>

      <div className="form-group">
        <label>Email</label>
        <input
          type="email"
          name="email"
          value={student.email}
          onChange={handleChange}
          placeholder="Enter email"
        />
      </div>

      <div className="form-group">
        <label>Course</label>
        <input
          type="text"
          name="course"
          value={student.course}
          onChange={handleChange}
          placeholder="Enter course"
        />
      </div>

      <button onClick={handleSubmit}>
        {student.id ? "Update" : "Add"}
      </button>
    </div>
  );
}

export default AddStudent;