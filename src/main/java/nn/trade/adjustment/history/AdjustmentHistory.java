package nn.trade.adjustment.history;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import nn.trade.BaseEntity;
import nn.trade.adjustment.Adjustment;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_adjustment_history")
public class AdjustmentHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "history_seq")
    @SequenceGenerator(name = "history_seq",sequenceName = "history_id_seq",allocationSize = 1)
    private Long historyId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adjustment_id")
    private Adjustment adjustment;

    private Long amount;



}
