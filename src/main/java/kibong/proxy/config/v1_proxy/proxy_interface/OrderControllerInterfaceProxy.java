package kibong.proxy.config.v1_proxy.proxy_interface;

import kibong.proxy.Trace.TraceStatus;
import kibong.proxy.Trace.logtrace.LogTrace;
import kibong.proxy.app.v1.OrderControllerV1;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;
    private final LogTrace logtrace;

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        status = logtrace.begin("OrderController.request()");
        String result = target.request(itemId);
        logtrace.end(status);
        return result;
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
