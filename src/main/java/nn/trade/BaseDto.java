package nn.trade;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
public class BaseDto {

    protected Timestamp createDate;
    protected String createUser;

    public BaseDto(BaseEntity entity){
        this.createDate = entity.getCreateDate();
        this.createUser = entity.getCreateUser();
    }





}
