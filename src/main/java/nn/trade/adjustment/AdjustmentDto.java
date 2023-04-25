package nn.trade.adjustment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import nn.trade.BaseDto;

@Schema(description = "정산 DTO")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdjustmentDto extends BaseDto {

    @Schema(description = "정산ID", example = "1")
    private Long adjustmentId;

    @Schema(description = "제목",example = "제목1")
    @NotBlank
    private String title;


    public AdjustmentDto(Adjustment entity){
        this.adjustmentId = entity.getAdjustmentId();
        this.title = entity.getTitle();
        this.createDate = entity.getCreateDate();
        this.createUser = entity.getCreateUser();
    }

    @Override
    public Adjustment toEntity(){
        return Adjustment.builder()
                .adjustmentId(adjustmentId)
                .title(title)
                .createUser(createUser)
                .createDate(createDate)
                .build();
    }


}
