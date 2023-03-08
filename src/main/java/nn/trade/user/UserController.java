package nn.trade.user;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    /**
     * @TODO
     * 1. 로그인 - 권한분배 필요
     * 2. 시큐리티적용
     */

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto){
        return ResponseEntity.ok(service.save(dto));
    }




}
