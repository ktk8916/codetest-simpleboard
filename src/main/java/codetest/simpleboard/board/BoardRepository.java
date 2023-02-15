package codetest.simpleboard.board;

import java.util.List;

public interface BoardRepository {
    List<Board> findAll();
    Board save(Board board);
    Board findByNo(Long id);
    void delete(Board board);
}
