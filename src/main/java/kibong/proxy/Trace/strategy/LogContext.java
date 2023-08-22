package kibong.proxy.Trace.strategy;

import kibong.proxy.Trace.logtrace.LogTrace;
import kibong.proxy.Trace.TraceStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogContext<T> {

    private final LogTrace trace;
    public T execute(LogStrategy<T> strategy, String message){
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = strategy.call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
