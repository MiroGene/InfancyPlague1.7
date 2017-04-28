package com.test.base.aspect;

import com.test.base.annotation.InvokeLog;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.test.base.aspect.LogUtils.log;

/**
 * Created by Gene on 2017/4/24.
 */
@Aspect
public class InvokeLogAdvice {
    @Pointcut("execution(public * com.test..*.*(..))&&@annotation(invokeLog)")
    public void PointCut(InvokeLog invokeLog){

    }
    //前置通知
    @Before("PointCut(invokeLog)")
    public void doBefore(JoinPoint joinPoint, InvokeLog invokeLog){
        final Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        System.out.println(invokeLog.value()+invokeLog.start());
        log(LOGGER, invokeLog.value() + invokeLog.start());
        // printArgs(joinPoint, invokeLog, LOGGER);
    }
    //最终通知pointCut
/*    @After(value = "pointCut(invokeLog)")
    public void doAfter(JoinPoint joinPoint, InvokeLog invokeLog){
        Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        log(LOGGER, invokeLog.logLevel(), invokeLog.value() + invokeLog.end());
    }*/

/*    //结束后(后置)通知
    @AfterReturning(pointcut = "pointCut(invokeLog)", returning = "returnValue")
    public void doAfterReturning(JoinPoint joinPoint, InvokeLog invokeLog, Object returnValue){

    }
    //例外通知
    @AfterThrowing(pointcut = "pointCut(invokeLog)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e, InvokeLog invokeLog){}*/
}
