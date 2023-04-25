package nn.trade.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
@Aspect
public class LogAspect {

    /**
     * @TODO
     * OPENAPI 적용후 고장난거확인
     * */

    @Around("execution(* nn.trade..*Service.*(..) )")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[AOP] Signature : {}",joinPoint.getSignature());
        log.info("[AOP] Target : {}",joinPoint.getTarget());
//        log.info("[AOP] Class : {}",joinPoint.getClass());
//        log.info("[AOP] This : {}",joinPoint.getThis());
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("[AOP] total elapsed time : {} ms", end-start);
        return result;
    }

}
