package nn.trade.adjustment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nn.trade.BaseEntity;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_adjustment")
public class Adjustment extends BaseEntity {
    @Id
    private Long adjustmentId;

    private String title;



}
