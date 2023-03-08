package nn.trade.user.auth;


import lombok.RequiredArgsConstructor;
import nn.trade.config.JwtUtils;
import nn.trade.user.User;
import nn.trade.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserDetailsService service;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDto authenticate(AuthRequestDto dto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );
        UserDetails userDetails = service.loadUserByUsername(dto.getEmail());
        String token = jwtUtils.generateToken(userDetails);
        return new AuthResponseDto(token);

    }


}
