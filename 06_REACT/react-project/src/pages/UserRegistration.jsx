import { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { useUser } from '../components/UserContext';

const UserRegistration = () => {
  const navigate = useNavigate();

  const { users, addUser } = useUser();

  const [name, setName] = useState("");
  const [age, setAge] = useState("");
  const [isOnline, setIsOnline] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!name.trim()) {
      alert("이름을 입력해주세요.");
      return;
    }

    if (!age || isNaN(age) || Number(age) <= 0) {
      alert("나이를 올바르게 입력해주세요.");
      return;
    }

    const newUser = {
      id: users.length + 1,
      name,
      age: Number(age),
      isOnline
    };

    addUser(newUser);

    alert("유저 등록 완료!");
    navigate("/");
  };

  const handleCancel = () => {
    navigate("/");
  };

  return (
    <div>
      <h2>유저 등록</h2>

      <form onSubmit={handleSubmit}>

        <div>
          <label>이름 : </label>
          <input 
            type="text" 
            placeholder="이름 입력" 
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>

        <div>
          <label>나이 : </label>
          <input 
            type="number" 
            placeholder="나이 입력"
            value={age}
            onChange={(e) => setAge(e.target.value)}
          />
        </div>

        <div>
          <label>온라인 여부 : </label>
          <input
            type="checkbox"
            checked={isOnline}
            onChange={(e) => setIsOnline(e.target.checked)}
          />
          {isOnline ? " 온라인" : " 오프라인"}
        </div>

        <button type="submit">등록</button>
        <button type="button" onClick={handleCancel}>취소</button>

      </form>
    </div>
  )
}

export default UserRegistration