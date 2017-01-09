package com.erickrim.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by krime on 1/5/17.
 */
@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    // the point cut is saying
    // all the methods that return void and start with set and take argument (for any number of argument use (..) )
    // and reside anywhere in the com.erickrim package
    @Before("execution(void com.erickrim..*.set*(*))")
    public void callSetters(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String argument = joinPoint.getArgs()[0].toString();
        logger.info("called " + method + " with args " + argument + " on " + joinPoint.getTarget());
    }

//    @Around("execution(String playGame())")
//    public Object checkForRain(ProceedingJoinPoint pjp) throws Throwable {
//        boolean rain = Math.random() < 0.5;
//        Object result = null;
//
//        if (rain) {
//            logger.info(pjp.getTarget() + " rained out");
//        } else {
//            result = pjp.proceed();
//            logger.info(result.toString());
//        }
//        return result;
//    }
}
