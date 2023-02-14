package codetest.simpleboard.board;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    
    @Id @GeneratedValue
    @Column(name = "board_no")
    private Long no;

    private String title;
    
    private String content;
    
    private Long hits;
    
    @Column(name = "reg_name")
    private String regName;
    
    @Column(name = "reg_dttm")
    private Date regDttm;

    public static Board createBoard(String title, String content, String regName){
        Board board = new Board();
        board.title = title;
        board.content = content;
        board.hits = 0L;
        board.regName = regName;
        board.regDttm = new Date();
        return board;
    }
}
