package nn.trade;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import nn.trade.adjustment.Adjustment;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@Getter
public class BaseEntity {

    @CreationTimestamp
    private Timestamp createDate;
    private String createUser;




}
