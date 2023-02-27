package nn.trade.adjustment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import nn.trade.BaseDto;
import nn.trade.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_adjustment")
public class AdjustmentDto extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adjustmentId;

    private String title;


    public AdjustmentDto(Adjustment entity){
        this.adjustmentId = entity.getAdjustmentId();
        this.title = entity.getTitle();
        this.createDate = entity.getCreateDate();
        this.createUser = entity.getCreateUser();
    }

}
