package kibong.proxy.config.v1_proxy.proxy_interface;

import kibong.proxy.app.Trace.TraceStatus;
import kibong.proxy.app.Trace.logtrace.LogTrace;
import kibong.proxy.app.v1.OrderServiceV1;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV1 {

    private final OrderServiceV1 target;
    private final LogTrace logTrace;


    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        status = logTrace.begin("OrderService.orderItem()");
        target.orderItem(itemId);
        logTrace.end(status);
    }
}
