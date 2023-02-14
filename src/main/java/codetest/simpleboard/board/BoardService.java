package codetest.simpleboard.board;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import codetest.simpleboard.board.boarddto.BoardListDto;
import codetest.simpleboard.board.boarddto.CreateBoardDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BoardService {
    
    private final BoardRepository repository;

    public List<BoardListDto> findAll(){
        List<Board> boards = repository.findAll();
        List<BoardListDto> result = boards.stream().map(board->new BoardListDto(board)).collect(Collectors.toList());
        return result;
    }

    @Transactional
    public Long save(CreateBoardDto dto){
        Board board = Board.createBoard(dto.getTitle(), dto.getContent(), dto.getRegName());
        return repository.save(board).getNo();
    }
}
