package codetest.simpleboard.board;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;

@Entity @Getter
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

}
