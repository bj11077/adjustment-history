package nn.trade.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import nn.trade.ResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;

@Component
@Slf4j
public class JwtExceptionFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request,response);
        }catch (ExpiredJwtException e){
            log.error("expiredJwt Exception");
            log.error(e.getMessage());
            setErrorResponse(request,response,e.getMessage());
        }catch (JwtException e){
            log.error("Jwt Exception");
            log.error(e.getMessage());
            setErrorResponse(request,response,e.getMessage());
        }
    }

    private void setErrorResponse(HttpServletRequest request, HttpServletResponse response, String ex) throws IOException {
        response.setContentType("application/json; charset=UTF-8");
        ResponseDto error = ResponseDto.error(HttpServletResponse.SC_UNAUTHORIZED, ex);
        ObjectMapper mapper =new ObjectMapper();
        Map<String,Object> map = mapper.convertValue(error, Map.class);
        mapper.writeValue(response.getOutputStream(), map);
    }


}
