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
  const logged = JSON.parse(localStorage.getItem("loggedInUser") || "null");

  const [showMyCards, setShowMyCards] = useState(false);
  const [savedCards, setSavedCards] = useState([]);

  useEffect(() => {
    const cards = JSON.parse(localStorage.getItem("cardList") || "[]");
    setSavedCards(cards);
  }, []);

  const filteredCards = showMyCards
    ? savedCards.filter((c) => c.author === logged?.nickname)
    : savedCards;

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
          {filteredCards.map((card) => (
            <CardItem key={card.id} onClick={() => navigate(`/detail/${card.id}`)}>
              <CardThumb src={card.thumbnail} alt="card thumbnail" />
              <CardInfo>
                <h3>{card.name}</h3>
                <p>작성자: {card.author}</p>
              </CardInfo>
            </CardItem>
          ))}

          {filteredCards.length === 0 && (
            <p style={{ padding: "20px", color: "#666" }}>
              {showMyCards ? "만든 카드가 없습니다." : "등록된 카드가 없습니다."}
            </p>
          )}
        </CardGrid>
      </Container>
    </PageWrapper>
  );
};

export default BoardList;
