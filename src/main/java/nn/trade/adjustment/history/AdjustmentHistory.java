package nn.trade.adjustment.history;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_adjustment")
public class AdjustmentHistory {
    @Id
    private Long adjustmentId;
}
