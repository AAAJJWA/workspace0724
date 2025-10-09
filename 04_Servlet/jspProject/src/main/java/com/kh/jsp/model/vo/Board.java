package com.kh.jsp.model.vo;

import java.sql.Date;

public class Board {
    
    private int boardNo;         // 게시글 번호
    private int boardType;       // 게시판 타입 (1: 일반, 2: 사진)
    private int categoryNo;      // 카테고리 번호 (CATEGORY 테이블 참조)
    private String boardTitle;   // 게시글 제목
    private String boardContent; // 게시글 내용
    private int boardWriter;     // 작성자 회원번호 (MEMBER 참조)
    private int count;           // 조회수
    private Date createDate;     // 작성일
    private String status;       // 상태값 (Y/N)

    // --------------------------------
    // 기본 생성자
    // --------------------------------
    public Board() {}

    // --------------------------------
    // 전체 필드 생성자
    // --------------------------------
    public Board(int boardNo, int boardType, int categoryNo, String boardTitle, String boardContent,
                 int boardWriter, int count, Date createDate, String status) {
        super();
        this.boardNo = boardNo;
        this.boardType = boardType;
        this.categoryNo = categoryNo;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardWriter = boardWriter;
        this.count = count;
        this.createDate = createDate;
        this.status = status;
    }

    // --------------------------------
    // Getter & Setter
    // --------------------------------
    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public int getBoardType() {
        return boardType;
    }

    public void setBoardType(int boardType) {
        this.boardType = boardType;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public int getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(int boardWriter) {
        this.boardWriter = boardWriter;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // --------------------------------
    // toString() - 디버깅용
    // --------------------------------
    @Override
    public String toString() {
        return "Board [boardNo=" + boardNo 
                + ", boardType=" + boardType 
                + ", categoryNo=" + categoryNo 
                + ", boardTitle=" + boardTitle 
                + ", boardContent=" + boardContent 
                + ", boardWriter=" + boardWriter 
                + ", count=" + count 
                + ", createDate=" + createDate 
                + ", status=" + status + "]";
    }
}
