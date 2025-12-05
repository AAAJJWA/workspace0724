import React from "react";
import { useParams, useNavigate } from "react-router-dom";

const CardDetail = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  const logged = JSON.parse(localStorage.getItem("loggedInUser") || "null");
  const cards = JSON.parse(localStorage.getItem("cardList") || "[]");

  const card = cards.find((c) => c.id === Number(id));

  if (!card) return <div style={{ padding: 40 }}>카드를 찾을 수 없습니다.</div>;

  /* ===== 카드 다운로드 ===== */
  const downloadImage = () => {
    const link = document.createElement("a");
    link.href = card.thumbnail; // 저장된 캔버스 이미지
    link.download = `${card.name}.png`;
    link.click();
  };

  /* ===== 카드 삭제 (작성자만 가능) ===== */
  const deleteCard = () => {
    if (!window.confirm("정말 삭제하시겠습니까?")) return;

    const newCards = cards.filter((c) => c.id !== Number(id));
    localStorage.setItem("cardList", JSON.stringify(newCards));

    alert("삭제되었습니다.");
    navigate("/");
  };

  const isAuthor = logged && logged.nickname === card.author;

  return (
    <div style={{ width: "100%", maxWidth: "900px", margin: "40px auto", textAlign: "center" }}>

      <h2>{card.name}</h2>
      <p>작성자: {card.author}</p>

      {/* 카드 전체 이미지 */}
      <img
        src={card.thumbnail}
        alt="card full"
        style={{
          width: "350px",
          borderRadius: "12px",
          boxShadow: "0 6px 20px rgba(0,0,0,0.2)",
          marginBottom: "20px",
        }}
      />

      {/* 버튼 영역 */}
      <div style={{ display: "flex", gap: "12px", justifyContent: "center" }}>

        <button
          onClick={downloadImage}
          style={{
            padding: "10px 16px",
            background: "#4b7fff",
            color: "#fff",
            borderRadius: "8px",
            cursor: "pointer",
            border: "none"
          }}
        >
          이미지 다운로드
        </button>

        {isAuthor && (
          <button
            onClick={deleteCard}
            style={{
              padding: "10px 16px",
              background: "#ff4d4d",
              color: "#fff",
              borderRadius: "8px",
              cursor: "pointer",
              border: "none"
            }}
          >
            삭제하기
          </button>
        )}

        <button
          onClick={() => navigate("/")}
          style={{
            padding: "10px 16px",
            background: "#ddd",
            borderRadius: "8px",
            cursor: "pointer",
            border: "none"
          }}
        >
          목록으로
        </button>

      </div>
    </div>
  );
};

export default CardDetail;
