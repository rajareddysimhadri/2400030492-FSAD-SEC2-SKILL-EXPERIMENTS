import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const [user, setUser] = useState({
    username: "",
    password: ""
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const res = await axios.post("http://localhost:8080/login", user);

      if (res.data) {
        localStorage.setItem("userId", res.data.id);
        navigate("/");
      } else {
        alert("Invalid credentials");
      }
    } catch (error) {
      alert("Server error");
      console.error(error);
    }
  };

  return (
    <form onSubmit={handleLogin}>
      <h2>Login</h2>

      <input
        type="text"
        name="username"
        placeholder="Username"
        onChange={handleChange}
      />

      <input
        type="password"
        name="password"
        placeholder="Password"
        onChange={handleChange}
      />

      <button type="submit">Login</button>
    </form>
  );
};

export default Login;