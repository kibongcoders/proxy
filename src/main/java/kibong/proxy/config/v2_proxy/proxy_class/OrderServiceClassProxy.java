package kibong.proxy.config.v2_proxy.proxy_class;

import kibong.proxy.Trace.TraceStatus;
import kibong.proxy.Trace.logtrace.LogTrace;
import kibong.proxy.app.v2.OrderServiceV2;

public class OrderServiceClassProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceClassProxy(OrderServiceV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");
            target.orderItem(itemId);
            logTrace.end(status);

        } catch (Exception e) {
            logTrace.exception(status,e);
            throw e;
        }
    }
}
