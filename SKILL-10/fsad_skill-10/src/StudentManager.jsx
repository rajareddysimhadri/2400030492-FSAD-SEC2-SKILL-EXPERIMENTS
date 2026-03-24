import React, { useState } from "react";
import "./StudentManager.css";

const StudentManager = () => {
  // Initial students list
  const [students, setStudents] = useState([
    { id: 1, name: "Sudheer", course: "Python",department:"CSE-1" },
    { id: 2, name: "Ravi", course: "Java" ,department:"ECE"},
    { id: 3, name: "Anjali", course: "C" , department:"IT"},
    { id: 4, name: "Kiran", course: "C#" ,department:"EEE"},
    { id: 5, name: "Meena", course: "React" ,department:"CIVIL"}
  ]);

  // New student state
  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: "",
    department:""
  });

  // Handle input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewStudent({
      ...newStudent,
      [name]: value
    });
  };

  // Add student
  const addStudent = () => {
    if (!newStudent.id || !newStudent.name || !newStudent.course) {
      alert("Please fill all fields");
      return;
    }

    // Add new student
    setStudents([...students, newStudent]);

    // Clear inputs
    setNewStudent({
      id: "",
      name: "",
      course: "",
      department: ""
    });
  };

  // Delete student
  const deleteStudent = (id) => {
    const updatedStudents = students.filter(
      (student) => student.id !== id
    );
    setStudents(updatedStudents);
  };

  return (
    <div className="container">
      <h2>Student Manager</h2>

      {/* Input Fields */}
      <div className="form">
        <input
          type="number"
          name="id"
          placeholder="Enter ID"
          value={newStudent.id}
          onChange={handleChange}
        />

        <input
          type="text"
          name="name"
          placeholder="Enter Name"
          value={newStudent.name}
          onChange={handleChange}
        />

        <input
          type="text"
          name="course"
          placeholder="Enter Course"
          value={newStudent.course}
          onChange={handleChange}
        />
        <input
          type="text"
          name="department"
          placeholder="Enter Department"
          value={newStudent.department}
          onChange={handleChange}
        />

        <button onClick={addStudent}>Add Student</button>
      </div>

      {/* Display Students */}
      {students.length === 0 ? (
        <p className="empty">No students available</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Department</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.course}</td>
                <td>{student.department}</td>
                <td>
                  <button
                    className="delete-btn"
                    onClick={() => deleteStudent(student.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default StudentManager;