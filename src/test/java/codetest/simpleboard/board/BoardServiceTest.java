package codetest.simpleboard.board;

import codetest.simpleboard.board.boarddto.BoardDetailViewDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BoardServiceTest {

    @Autowired BoardService boardService;
    
    @Test
    @DisplayName("조회된 게시글은 조회수가 증가해야 한다")
    public void t1(){
        Board board = Board.createBoard("title", "content", "name");

        BoardDetailViewDto viewBoard = boardService.detailViewBoard( ??? ); //조회를 어떻게 하지 ??

        assertEquals(viewBoard.getHits(), 1);
    }
}