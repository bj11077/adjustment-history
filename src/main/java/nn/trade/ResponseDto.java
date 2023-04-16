package nn.trade;

import org.springframework.http.HttpStatus;

public record ResponseDto<T>(boolean status, int code, String message, T data) {

    public static <T> ResponseDto<T> ok(T data){
        return new ResponseDto<>(true,HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(),data);
    }

    public static <T> ResponseDto<T> error(int code, String message){
        return new ResponseDto<>(false,code,message,null);
    }

}
