package nn.trade;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@MappedSuperclass
@Getter
public class BaseEntity {

    @CreationTimestamp
    private Timestamp createDate;
    private String createUser;


}
