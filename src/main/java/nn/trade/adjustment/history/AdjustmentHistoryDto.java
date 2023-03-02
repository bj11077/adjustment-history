package nn.trade.adjustment.history;

import jakarta.persistence.Id;
import lombok.*;
import nn.trade.BaseDto;
import nn.trade.adjustment.Adjustment;
import nn.trade.adjustment.AdjustmentDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdjustmentHistoryDto extends BaseDto {

    private Long historyId;

    private AdjustmentDto adjustment;
    private Long amount;

    public AdjustmentHistoryDto(AdjustmentHistory entity){
        this.historyId = entity.getHistoryId();
        this.adjustment = new AdjustmentDto(entity.getAdjustment());
        this.amount = entity.getAmount();
        this.createDate = entity.getCreateDate();
        this.createUser = entity.getCreateUser();
    }

    @Override
    public AdjustmentHistory toEntity(){
        return AdjustmentHistory.builder()
                .historyId(historyId)
                .adjustment(adjustment.toEntity())
                .amount(amount)
                .createUser(createUser)
                .createDate(createDate)
                .build();
    }


}
