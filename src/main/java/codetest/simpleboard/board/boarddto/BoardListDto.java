package codetest.simpleboard.board.boarddto;

import java.util.Date;

import codetest.simpleboard.board.Board;
import lombok.Getter;

@Getter
public class BoardListDto {

    private Long no;
    private String title;
    private Long hits;
    private String regName;
    private Date regDttm;

    public BoardListDto(Board board){
        this.no = board.getNo();
        this.title = board.getTitle();
        this.hits = board.getHits();
        this.regName = board.getRegName();
        this.regDttm = board.getRegDttm();
    }
}
