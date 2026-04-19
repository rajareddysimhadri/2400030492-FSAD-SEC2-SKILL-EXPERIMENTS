import React, { useState } from "react";
import AddStudent from "./components/AddStudent";
import StudentList from "./components/StudentList";
import "./App.css";

function App() {
  const [selectedStudent, setSelectedStudent] = useState(null);
  const [refresh, setRefresh] = useState(false);

  const refreshData = () => {
    setRefresh(!refresh);
    setSelectedStudent(null);
  };

  return (
    <div className="app">
      <h1>Student Management System</h1>

      <AddStudent
        selected={selectedStudent}
        refresh={refreshData}
      />

      <StudentList
        editStudent={setSelectedStudent}
        refresh={refresh}
      />
    </div>
  );
}

export default App;