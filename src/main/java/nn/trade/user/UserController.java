package nn.trade.user;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {



    private final UserService service;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto){
        return ResponseEntity.ok(service.save(dto));
    }




}
