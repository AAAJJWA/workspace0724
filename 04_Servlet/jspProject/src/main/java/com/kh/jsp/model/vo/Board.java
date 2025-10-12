package com.kh.jsp.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    
    private int boardNo;
    private int boardType;
    private int categoryNo;
    private String boardTitle;
    private String boardContent;
    private int boardWriter;
    private int count;
    private Date createDate;
    private String status;
    private String categoryName;
    private String writerId;
    
    private int fileNo;
    private String originName;
    private String changeName;
    private String filePath;
    private Date uploadDate;
    private int fileLevel;
    private String fileStatus;

    public static Board createInsertBoard(int categoryNo, String title, String content, int writerNo) {
        Board b = new Board();
        b.setBoardType(1);
        b.setCategoryNo(categoryNo);
        b.setBoardTitle(title);
        b.setBoardContent(content);
        b.setBoardWriter(writerNo);
        
        return b;
    }
    
    public static Board createUpdateBoard(int boardNo, int categoryNo, String title, String content) {
        Board b = new Board();
        b.setBoardNo(boardNo);       
        b.setCategoryNo(categoryNo); 
        b.setBoardTitle(title);      
        b.setBoardContent(content); 
        
        return b;
    }

}
