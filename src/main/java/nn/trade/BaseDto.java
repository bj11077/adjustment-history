package nn.trade;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class BaseDto {

    protected Timestamp createDate;
    protected String createUser;

    public BaseDto(BaseEntity entity){
        this.createDate = entity.getCreateDate();
        this.createUser = entity.getCreateUser();
    }





}
