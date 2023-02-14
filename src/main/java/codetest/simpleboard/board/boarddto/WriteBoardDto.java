package codetest.simpleboard.board.boarddto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class WriteBoardDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String regName;
}
