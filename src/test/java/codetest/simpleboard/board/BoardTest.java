package codetest.simpleboard.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    @DisplayName("새로 생성된 board의 조회수는 0이고, 생성일자는 null이 아니어야 한다")
    void testCreateBoard() {
        Board board = Board.createBoard("title", "content", "name");

        assertEquals(board.getHits(), 0);
        assertNotEquals(board.getRegDttm(), null);
    }

    @Test
    @DisplayName("조회수 증가")
    void testIncreaseHits() {
        Board board = Board.createBoard("title", "content", "name");
        
        Long hits = board.increaseHits();
        
        assertEquals(hits, 1);
    }


    
}
