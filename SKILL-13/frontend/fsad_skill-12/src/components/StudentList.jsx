import React, { useEffect, useState } from "react";
import axios from "axios";

function StudentList({ editStudent, refresh }) {
  const [students, setStudents] = useState([]);

  const fetchData = () => {
    axios.get("http://localhost:2026/students")
      .then(res => setStudents(res.data));
  };

  useEffect(() => {
    fetchData();
  }, [refresh]); // 🔥 THIS LINE IS IMPORTANT

  const deleteStudent = (id) => {
    if (window.confirm("Are you sure?")) {
      axios.delete(`http://localhost:2026/students/${id}`)
        .then(() => fetchData());
    }
  };

  return (
    <div className="card">
      <h2>Student List</h2>

      {students.map(s => (
        <div className="student-item" key={s.id}>
          
          <div className="student-info">
            <strong>{s.name}</strong><br />
            {s.email}<br />
            {s.course}
          </div>

          <div className="actions">
            <button className="edit-btn" onClick={() => editStudent(s)}>
              Edit
            </button>

            <button className="delete-btn" onClick={() => deleteStudent(s.id)}>
              Delete
            </button>
          </div>

        </div>
      ))}
    </div>
  );
}

export default StudentList;