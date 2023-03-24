package nn.trade.adjustment;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;
import nn.trade.BaseDto;
import nn.trade.BaseEntity;
import nn.trade.adjustment.Adjustment;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdjustmentDto extends BaseDto {

    private Long adjustmentId;

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
