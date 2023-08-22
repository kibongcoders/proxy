package kibong.proxy.config.v6_aop.aspect;

import kibong.proxy.Trace.TraceStatus;
import kibong.proxy.Trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class LogTraceAspect {

    private final LogTrace logTrace;

    public LogTraceAspect(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    @Around("execution(* kibong.proxy.app..*(..)) && !execution(* kibong.proxy.app..noLog(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        TraceStatus status = null;

        try {

            String message = joinPoint.getSignature().toShortString();
            status = logTrace.begin(message);

            Object result = joinPoint.proceed();
            logTrace.end(status);
            return result;

        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;

        }
    }
}
