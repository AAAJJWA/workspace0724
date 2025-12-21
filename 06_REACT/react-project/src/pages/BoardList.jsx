import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import {
  PageWrapper,
  Container,
  SectionTitleRow,
  SectionTitle,
  ToggleButton,
  CardGrid,
  CardItem,
  CardThumb,
  CardInfo,
} from "./BoardList.styled";

const BoardList = () => {
  const navigate = useNavigate();
  const [logged, setLogged] = useState(() =>
    JSON.parse(localStorage.getItem("loggedInUser") || "null")
  );

  const [showMyCards, setShowMyCards] = useState(false);
  const [savedCards, setSavedCards] = useState([]);

  useEffect(() => {
    const fetchCards = async () => {
      try {
        const url =
          showMyCards && logged
            ? `/api/cards/my?loginId=${logged.loginId}`
            : "/api/cards";

        const res = await fetch(url);
        const data = await res.json();

        setSavedCards(data);
      } catch (e) {
        console.error(e);
      }
    };

    fetchCards();
  }, [showMyCards, logged]);

  return (
    <PageWrapper>
      <Container>
        <SectionTitleRow>
          <SectionTitle>
            {showMyCards ? "내가 만든 카드" : "최신 카드 목록"}
          </SectionTitle>

          {logged && (
            <ToggleButton
              active={showMyCards}
              onClick={() => setShowMyCards((prev) => !prev)}
            >
              {showMyCards ? "전체 보기" : "내 카드 보기"}
            </ToggleButton>
          )}
        </SectionTitleRow>

        <CardGrid>
          {savedCards.map((card) => (
            <CardItem
              key={card.id}
              onClick={() => navigate(`/cards/${card.id}`)}
            >
              <CardThumb src={card.artwork} alt="card thumbnail" />
              <CardInfo>
                <h3>{card.name}</h3>
                <p>작성자: {card.memberNickname}</p>
              </CardInfo>
            </CardItem>
          ))}

          {savedCards.length === 0 && (
            <p style={{ padding: "20px", color: "#666" }}>
              {showMyCards
                ? "만든 카드가 없습니다."
                : "등록된 카드가 없습니다."}
            </p>
          )}
        </CardGrid>
      </Container>
    </PageWrapper>
  );
};

export default BoardList;
