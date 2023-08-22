package kibong.proxy.config.v2_proxy.proxy_class;

import kibong.proxy.Trace.TraceStatus;
import kibong.proxy.Trace.logtrace.LogTrace;
import kibong.proxy.app.v2.OrderRepositoryV2;

public class OrderRepositoryClassProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    public OrderRepositoryClassProxy(OrderRepositoryV2 target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");
            target.save(itemId);
            logTrace.end(status);

        } catch (Exception e) {
            logTrace.exception(status,e);
            throw e;
        }
    }
}
