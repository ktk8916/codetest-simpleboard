package codetest.simpleboard.board;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import codetest.simpleboard.board.boarddto.BoardDetailViewDto;
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

    //단건 조회에 조회수 증가를 위해서 @Transactional을 붙이는게 맞나 ?
    @Transactional
    public BoardDetailViewDto findOne(Long id){
        Board board = repository.findByNo(id);
        if(board==null){
            throw new IllegalArgumentException(id + "번 게시글이 존재하지 않습니다.");
        }
        board.increaseHits();
        return new BoardDetailViewDto(board);
    }
}
