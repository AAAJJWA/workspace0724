import React from 'react'
import { 
  HomeContainer, 
  ContentBox,
  Title, 
  StatsWrapper, 
  StatCard, 
  StatNumber, 
  StatLabel,
  CategoryWrapper,
  CategoryTitle,
  CategoryList,
  CategoryItem,
  CategoryName,
  CategoryCount
} from './Home.styled'

const Home = () => {
  return (
    <HomeContainer>
      <ContentBox>

        <Title>Dashboard</Title>

        {/* 상단 통계 카드 */}
        <StatsWrapper>
          <StatCard>
            <StatNumber>7</StatNumber>
            <StatLabel>전체 할일</StatLabel>
          </StatCard>

          <StatCard>
            <StatNumber>5</StatNumber>
            <StatLabel>미완료</StatLabel>
          </StatCard>

          <StatCard>
            <StatNumber>2</StatNumber>
            <StatLabel>완료</StatLabel>
          </StatCard>
        </StatsWrapper>

        {/* 카테고리 박스 */}
        <CategoryWrapper>
          <CategoryTitle>카테고리별 할일</CategoryTitle>

          <CategoryList>
            <CategoryItem>
              <CategoryName>업무</CategoryName>
              <CategoryCount>1</CategoryCount>
            </CategoryItem>

            <CategoryItem>
              <CategoryName>개인</CategoryName>
              <CategoryCount>5</CategoryCount>
            </CategoryItem>

            <CategoryItem>
              <CategoryName>학습</CategoryName>
              <CategoryCount>1</CategoryCount>
            </CategoryItem>
          </CategoryList>
        </CategoryWrapper>

      </ContentBox>
    </HomeContainer>
  )
}

export default Home
