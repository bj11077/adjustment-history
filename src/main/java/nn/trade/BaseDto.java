package nn.trade;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public abstract class BaseDto {

    protected Timestamp createDate;


    @NotBlank
    protected String createUser;

    public BaseDto(BaseEntity entity){
        this.createDate = entity.getCreateDate();
        this.createUser = entity.getCreateUser();
    }

    public abstract BaseEntity toEntity();



}
