package uz.pdp;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ServiceLoggingAspect {

    @Around("within(@org.springframework.stereotype.Service *)")
    public Object logService( ProceedingJoinPoint joinPoint ) throws Throwable {
        try {
            log.info( "Before {}", joinPoint.getSignature() );
            log.info( "Before (second log) {}", joinPoint.getSignature() );

            Object result = joinPoint.proceed();

            log.info( "After {}", joinPoint.getSignature() );
            log.info( "After (second log) {}", joinPoint.getSignature() );
            return result;
        } catch ( Exception ex ) {
            log.error( "Exception in {}", joinPoint.getSignature(), ex );
            throw ex;
        }
    }
}
