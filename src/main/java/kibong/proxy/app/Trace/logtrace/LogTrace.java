package kibong.proxy.app.Trace.logtrace;

import kibong.proxy.app.Trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);

}
