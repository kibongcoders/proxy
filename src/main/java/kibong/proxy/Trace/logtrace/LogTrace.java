package kibong.proxy.Trace.logtrace;

import kibong.proxy.Trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);

}
