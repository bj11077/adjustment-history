package nn.trade.exception;

import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<ErrorResponse> validException(
            MethodArgumentNotValidException ex) {

        List<String> rejected = new ArrayList<>();

        /**
         * @TODO
         * List값이 오면 dtoList[0].createUser는 공백일 수 없습니다 로 나옴 내부요소 보임
         */

        ex.getBindingResult().getFieldErrors().forEach(e->{
            log.error("field: {}",e.getField());
            log.error("rejectValue: {}",e.getRejectedValue());
            log.error("default: {}",e.getDefaultMessage());
            log.error("code: {}",e.getCode());
            rejected.add(String.join("는 ",e.getField(),e.getDefaultMessage()));
        });

        ErrorResponse response = new ErrorResponse();
        response.setErrorList(rejected);
        response.setErrorCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // 2
    }
}
