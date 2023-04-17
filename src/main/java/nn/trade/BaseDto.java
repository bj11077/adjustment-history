package nn.trade;


import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "등록일자",nullable = true)
    protected Timestamp createDate;


    @NotBlank
    @Schema(description = "등록유저",example = "유저1")
    protected String createUser;

    public BaseDto(BaseEntity entity){
        this.createDate = entity.getCreateDate();
        this.createUser = entity.getCreateUser();
    }

    public abstract BaseEntity toEntity();



}
