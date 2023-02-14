package codetest.simpleboard.board;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import codetest.simpleboard.board.boarddto.BoardDetailViewDto;
import codetest.simpleboard.board.boarddto.BoardListDto;
import codetest.simpleboard.board.boarddto.CreateBoardDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardController{

    private final BoardService boardService;

    @GetMapping("/board")
    public List<BoardListDto> findAllBoard(){
        return boardService.findAll();
    }

    @GetMapping("/board/{id}")
    public BoardDetailViewDto findBoardById(@PathVariable("id") Long id){
        return boardService.findOne(id);
    }

    @PostMapping("/board")
    public Long save(@RequestBody CreateBoardDto dto){
        return boardService.save(dto);
    }

}