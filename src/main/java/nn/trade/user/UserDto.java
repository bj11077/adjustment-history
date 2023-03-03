package nn.trade.user;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import nn.trade.BaseDto;
import nn.trade.adjustment.Adjustment;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto {

    private Long userId;

    private String username;

    private String email;

    private String password;

    private String role;


    public UserDto(User entity){
        this.userId = entity.getUserId();
        this.username = entity.getUsername();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.role = entity.getRole().name();
        this.createDate = entity.getCreateDate();
        this.createUser = entity.getCreateUser();
    }

    @Override
    public User toEntity(){
        return User.builder()
                .userId(userId)
                .username(username)
                .email(email)
                .password(password)
                .role(Role.valueOf(role))
                .createUser(createUser)
                .createDate(createDate)
                .build();
    }


}
