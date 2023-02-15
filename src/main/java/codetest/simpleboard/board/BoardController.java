package codetest.simpleboard.board;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import codetest.simpleboard.board.boarddto.BoardDetailViewDto;
import codetest.simpleboard.board.boarddto.BoardListDto;
import codetest.simpleboard.board.boarddto.UpdateBoardDto;
import codetest.simpleboard.board.boarddto.WriteBoardDto;
import lombok.RequiredArgsConstructor;

@Validated
@RequiredArgsConstructor
@RestController
public class BoardController{

    private final BoardService boardService;

    @GetMapping("/board")
    public List<BoardListDto> findAllBoard(){
        return boardService.findAll();
    }

    @GetMapping("/board/{no}")
    public BoardDetailViewDto findBoardById(@PathVariable("no") Long no){
        return boardService.detailViewBoard(no);
    }

    @PostMapping("/board")
    public Long WriteBoard(@RequestBody WriteBoardDto dto){
        return boardService.writeBoard(dto);
    }

    @PutMapping("/board/{no}")
    public Long save(@PathVariable("no") Long no, @RequestBody UpdateBoardDto dto){
        return boardService.updateBoard(no, dto);
    }

    @DeleteMapping("/board/{no}")
    public void deleteBoard(@PathVariable("no") Long no){
        boardService.deleteBoard(no);
    }

}