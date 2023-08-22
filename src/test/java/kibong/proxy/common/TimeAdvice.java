package kibong.proxy.common;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeAdvice 실행");
        long startTime = System.currentTimeMillis();
        Object proceed = invocation.proceed();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeAdvice 종료 resultTime={}ms", resultTime);
        return proceed;
    }
}
