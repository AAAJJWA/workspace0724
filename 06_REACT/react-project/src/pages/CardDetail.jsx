import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";

const CardDetail = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const logged = JSON.parse(localStorage.getItem("loggedInUser") || "null");

  const [card, setCard] = useState(null);

  useEffect(() => {
    fetch(`/api/cards/${id}`)
      .then(res => res.json())
      .then(data => setCard(data))
      .catch(() => alert("카드를 찾을 수 없습니다."));
  }, [id]);

  if (!card) return <div style={{ padding: 40 }}>로딩 중...</div>;

  const isAuthor = logged && logged.id === card.memberId;

  const deleteCard = async () => {
    if (!window.confirm("정말 삭제하시겠습니까?")) return;

    await fetch(`/api/cards/${id}`, { method: "DELETE" });
    alert("삭제되었습니다.");
    navigate("/");
  };

  return (
    <div style={{ maxWidth: "900px", margin: "40px auto", textAlign: "center" }}>
      <h2>{card.name}</h2>
      <p>작성자: {card.memberNickname}</p>

      <img
        src={card.artwork}
        alt="card"
        style={{ width: "350px", borderRadius: "12px" }}
      />

      <div style={{ marginTop: "20px" }}>
        {isAuthor && (
          <button onClick={deleteCard}>삭제하기</button>
        )}
        <button onClick={() => navigate("/")}>목록으로</button>
      </div>
    </div>
  );
};

export default CardDetail;
