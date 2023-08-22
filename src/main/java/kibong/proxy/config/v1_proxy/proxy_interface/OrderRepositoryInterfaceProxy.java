package kibong.proxy.config.v1_proxy.proxy_interface;

import kibong.proxy.app.Trace.TraceStatus;
import kibong.proxy.app.Trace.logtrace.LogTrace;
import kibong.proxy.app.v1.OrderRepositoryV1;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        status = logTrace.begin("OrderRepository.save()");
        target.save(itemId);
        logTrace.end(status);
    }
}
