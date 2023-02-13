package codetest.simpleboard.board;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import codetest.simpleboard.board.boarddto.BoardListDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
    
    private final BoardRepository repository;

    public List<BoardListDto> findAll(){
        List<Board> boards = repository.findAll();
        List<BoardListDto> result = boards.stream().map(board->new BoardListDto(board)).collect(Collectors.toList());
        return result;
    }
}
