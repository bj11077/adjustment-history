package nn.trade.adjustment.mapping;

import lombok.*;
import nn.trade.BaseDto;
import nn.trade.adjustment.AdjustmentDto;
import nn.trade.adjustment.history.AdjustmentHistory;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdjustmentMappingDto extends BaseDto {

    private Long historyId;

    private AdjustmentDto adjustment;
    private Long amount;

    public AdjustmentMappingDto(AdjustmentHistory entity){
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
