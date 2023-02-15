package codetest.simpleboard.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBoardRepository extends BoardRepository, JpaRepository<Board, Long>{

    List<Board> findAll();
    List<Board> findByTitleContainsOrContentContains(String keyword1, String keyword2);
    Board save(Board board);
    Board findByNo(Long no);
    void delete(Board board);
    
}
