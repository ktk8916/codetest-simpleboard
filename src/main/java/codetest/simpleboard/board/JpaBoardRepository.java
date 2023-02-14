package codetest.simpleboard.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBoardRepository extends BoardRepository, JpaRepository<Board, Long>{

    List<Board> findAll();
    Board save(Board board);
    
}
