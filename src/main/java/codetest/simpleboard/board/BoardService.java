package codetest.simpleboard.board;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import codetest.simpleboard.board.boarddto.BoardDetailViewDto;
import codetest.simpleboard.board.boarddto.BoardListDto;
import codetest.simpleboard.board.boarddto.UpdateBoardDto;
import codetest.simpleboard.board.boarddto.WriteBoardDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BoardService {
    
    private final BoardRepository repository;

    //게시글 목록 조회
    public List<BoardListDto> findAll(){
        List<Board> boards = repository.findAll();
        List<BoardListDto> result = boards.stream().map(board->new BoardListDto(board)).collect(Collectors.toList());
        return result;
    }

    //게시글 제목, 내용으로 조회
    public List<BoardListDto> findBySearch(String keyword1, String keyword2){
        List<Board> boards = repository.findByTitleContainsOrContentContains(keyword1, keyword2);
        List<BoardListDto> result = boards.stream().map(board->new BoardListDto(board)).collect(Collectors.toList());
        return result;
    }

    //게시글 조회
    public Board findOne(Long no){
        Board board = repository.findByNo(no);
        if(board==null){
            throw new IllegalArgumentException(no + "번 게시글이 존재하지 않습니다.");
        }
        return board;
    }

    //게시글 작성
    @Transactional
    public Long writeBoard(WriteBoardDto dto){
        Board board = Board.createBoard(dto.getTitle(), dto.getContent(), dto.getRegName());
        return repository.save(board).getNo();
    }

    //게시글 상세보기
    @Transactional
    public BoardDetailViewDto detailViewBoard(Long no){
        Board board = findOne(no);
        board.increaseHits();
        return new BoardDetailViewDto(board);
    }

    //게시글 수정
    @Transactional
    public Long updateBoard(Long no, UpdateBoardDto dto){
        Board board = findOne(no);
        Board.changeBoard(board, dto.getTitle(), dto.getContent());

        return board.getNo();
    }

    //게시글 삭제
    @Transactional
    public void deleteBoard(Long no){
        Board board = findOne(no);
        repository.delete(board);
    }
}
