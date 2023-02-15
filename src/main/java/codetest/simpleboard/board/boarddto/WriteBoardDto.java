package codetest.simpleboard.board.boarddto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WriteBoardDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String regName;
}
