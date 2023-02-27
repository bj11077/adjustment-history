package nn.trade.adjustment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adjustmentId;

    private String title;


    public Adjustment() {
        super();
    }
}
