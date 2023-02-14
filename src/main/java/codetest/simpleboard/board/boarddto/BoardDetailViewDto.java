package codetest.simpleboard.board.boarddto;

import java.util.Date;

import codetest.simpleboard.board.Board;
import lombok.Getter;

@Getter
public class BoardDetailViewDto {

    private Long no;
    private String title;
    private String content;
    private Long hits;
    private String regName;
    private Date regDttm;

    public BoardDetailViewDto(Board board){

        this.no = board.getNo();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.hits = board.getHits();
        this.regName = board.getRegName();
        this.regDttm = board.getRegDttm();
    }

}
