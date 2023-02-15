package codetest.simpleboard.board.boarddto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WriteBoardDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String regName;
}
