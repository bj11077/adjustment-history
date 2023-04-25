package nn.trade.exception;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import nn.trade.ResponseDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalValidExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseDto validException(
            MethodArgumentNotValidException ex) {

        List<String> rejected = new ArrayList<>();

        /**
         * @TODO
         * List값이 오면 dtoList[0].createUser는 공백일 수 없습니다 로 나옴 내부요소 보임
         */
        ex.getBindingResult().getFieldErrors().forEach(e->{
            log.error("{} Field error Message: {}",e.getField(),e.getDefaultMessage());
            rejected.add(String.join(" 필드는 ",e.getField(),e.getDefaultMessage()));
        });
        String message = StringUtils.join(rejected,", ");
        return ResponseDto.error(HttpStatus.BAD_REQUEST.value(),message);
    }

}
