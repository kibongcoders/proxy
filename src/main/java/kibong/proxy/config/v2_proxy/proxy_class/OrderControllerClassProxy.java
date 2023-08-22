package kibong.proxy.config.v2_proxy.proxy_class;

import kibong.proxy.Trace.TraceStatus;
import kibong.proxy.Trace.logtrace.LogTrace;
import kibong.proxy.app.v2.OrderControllerV2;

public class OrderControllerClassProxy extends OrderControllerV2 {
    private final OrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerClassProxy(OrderControllerV2 orderControllerV2, LogTrace logTrace) {
        super(null);
        this.target = orderControllerV2;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {

        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");
            String result = target.request(itemId);
            logTrace.end(status);
            return result;

        } catch (Exception e) {
            logTrace.exception(status,e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return super.noLog();
    }
}
