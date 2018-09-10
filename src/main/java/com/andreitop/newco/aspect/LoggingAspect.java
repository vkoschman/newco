package com.andreitop.newco.aspect;


import com.andreitop.newco.dto.TripDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect

@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);
    private static long deleteById = 0;

    @Before("com.andreitop.newco.aspect.PointcutContainer.repositoryFind()")
    public void beforeRepoFind(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Method " + className + "." + methodName + " is about to be called");
    }

    @After("com.andreitop.newco.aspect.PointcutContainer.repositoryDelete()")
    public void afterRepoDelete(JoinPoint joinPoint) {
        ++deleteById;
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Method " + className + "." + methodName + " was called " + deleteById + " times");
    }

    @Around("com.andreitop.newco.aspect.PointcutContainer.repositoryUpdate()")
    public Object afterRepoUpdate(ProceedingJoinPoint joinPoint) throws Throwable{
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Intercepting call of: " + className + methodName);
        long t1 = System.currentTimeMillis();
        try{
            Thread.sleep(1000L);
            return joinPoint.proceed();
        }finally{
            long t2=System.currentTimeMillis();
            logger.info(" ---> Execution of: " + className + methodName + " took: " + (t2-t1)/1000 + " ms.");
        }
    }

    @AfterReturning(value="com.andreitop.newco.aspect.PointcutContainer.serviceFindById()", returning = "result")
    public void afterServiceFindById(JoinPoint joinPoint, TripDto result) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        if (result != null){
            logger.info(" ---> Method " + className + "." + methodName + " returned a trip by id ");
        }
    }
}
