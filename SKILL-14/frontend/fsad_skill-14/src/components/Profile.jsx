import { useEffect, useState } from "react";
import axios from "axios";

const Profile = () => {
  const [user, setUser] = useState({});

  useEffect(() => {
    const id = localStorage.getItem("userId");

    axios.get(`http://localhost:8080/user/${id}`)
      .then(res => setUser(res.data));
  }, []);

  return (
    <div>
      <h2>Profile</h2>
      <p>Username: {user.username}</p>
    </div>
  );
};

export default Profile;