package codetest.simpleboard.board.boarddto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateBoardDto {
    
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private Date regDttm;
}
