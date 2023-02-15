package codetest.simpleboard.board;

import codetest.simpleboard.board.boarddto.BoardDetailViewDto;
import codetest.simpleboard.board.boarddto.WriteBoardDto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired BoardService boardService;

    @BeforeEach
    public void init(){
        for(int i=0;i<50;i++){
            boardService.writeBoard(new WriteBoardDto("title" + i, "content"+ i, "name"+ i));
        }
    }
    
    @Test
    @DisplayName("게시글 조회 기능은 조회수를 증가시켜야 한다.")
    public void t1(){
        Long beforeHits = boardService.findOne(1L).getHits();

        BoardDetailViewDto viewBoard = boardService.detailViewBoard( 1L );

        assertEquals(beforeHits+ 1, viewBoard.getHits());
    }

    @Test
    @DisplayName("게시글이 존재하지 않으면 예외를 발생시켜야 한다.")
    public void t2(){
        assertThrows(IllegalArgumentException.class,()-> boardService.findOne(100L)) ;
    }
}