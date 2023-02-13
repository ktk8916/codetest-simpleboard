package codetest.simpleboard.board;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import codetest.simpleboard.board.boarddto.BoardListDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardController{

    private final BoardService boardService;

    @GetMapping("/boards")
    public List<BoardListDto> findAllBoard(){
        return boardService.findAll();
    }

}