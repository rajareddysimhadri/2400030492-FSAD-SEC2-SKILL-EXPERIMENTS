import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const Home = () => {
  const navigate = useNavigate();

  useEffect(() => {
    const user = localStorage.getItem("userId");
    if (!user) {
      navigate("/login");
    }
  }, []);

  return <h1>Welcome to Home Page</h1>;
};

export default Home;