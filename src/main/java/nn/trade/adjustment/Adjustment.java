package nn.trade.adjustment;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import nn.trade.BaseEntity;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@SuperBuilder
@Table(name = "tb_adjustment")
public class Adjustment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "item_seq")
    @SequenceGenerator(name = "item_seq",sequenceName = "item_id_seq",allocationSize = 1)
    private Long adjustmentId;

    private String title;


    public Adjustment() {
        super();
    }
}
