import React from 'react'
import { useParams, useNavigate } from 'react-router-dom';
import { useUser } from '../components/UserContext';
import { PageContainer } from '../components/styled/LayoutStyled';
import { Button } from '../components/styled/ButtonStyled';

const UserDetail = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const { users, deleteUser } = useUser();

  const user = users.find(u => u.id === Number(id));

  if (!user) {
    return <h2>유저 정보를 찾을 수 없습니다.</h2>;
  }

  const handleDelete = () => {
    deleteUser(user.id);
    navigate("/");
  };

  return (
    <PageContainer>
      <h2>{user.name} 상세 정보</h2>

      <p>나이: {user.age}</p>
      <p>상태: {user.isOnline ? "🟢 온라인" : "🔴 오프라인"}</p>

      <Button onClick={() => navigate("/")}>뒤로 가기</Button>
      <Button onClick={handleDelete}>유저 삭제</Button>
    </PageContainer>
  )
}

export default UserDetail