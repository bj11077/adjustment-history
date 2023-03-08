package nn.trade.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService  {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserDto save(UserDto dto)  {
        dto.setPassword(encoder.encode(dto.getPassword()));
        User saveUser = repository.save(dto.toEntity());
        return new UserDto(saveUser);
    }
}
