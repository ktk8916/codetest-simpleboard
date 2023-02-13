package codetest.simpleboard.board;

import java.util.List;

public interface BoardRepository {
    List<Board> findAll();
    List<Board> findByNameOrLikcContenBoards();
    Long save(Board board);
}
