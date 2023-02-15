package codetest.simpleboard.board;

import java.util.List;

public interface BoardRepository {

    List<Board> findAll();
    List<Board> findByTitleContainsOrContentContains(String keyword1, String keyword2);
    Board save(Board board);
    Board findByNo(Long id);
    void delete(Board board);
}
