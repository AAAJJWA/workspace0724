import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const CardList = () => {
  const [cards, setCards] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetch("/api/cards")
      .then(res => res.json())
      .then(data => setCards(data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div style={{ maxWidth: "900px", margin: "40px auto" }}>
      <h2>카드 목록</h2>

      {cards.map(card => (
        <div
          key={card.id}
          style={{
            border: "1px solid #ddd",
            padding: "12px",
            marginBottom: "12px",
            cursor: "pointer"
          }}
          onClick={() => navigate(`/cards/${card.id}`)}
        >
          <h3>{card.name}</h3>
          <p>작성자: {card.memberNickname}</p>
          <p>{card.cardType} | ATK {card.attack} / DEF {card.defense}</p>
        </div>
      ))}
    </div>
  );
};

export default CardList;
