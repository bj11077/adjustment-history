package nn.trade.user.auth;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDto {

    private String email;
    private String password;
}
