package kibong.proxy.config.v2_dynamicproxy.handler;

import kibong.proxy.app.Trace.logtrace.LogTrace;
import kibong.proxy.app.v1.*;
import kibong.proxy.config.v1_proxy.proxy_interface.OrderControllerInterfaceProxy;
import kibong.proxy.config.v1_proxy.proxy_interface.OrderRepositoryInterfaceProxy;
import kibong.proxy.config.v1_proxy.proxy_interface.OrderServiceInterfaceProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyConfig {
    private static final String[] PATTERNS = {"request*", "order*", "save*"};
    @Bean
    public OrderControllerV1 OrderController(LogTrace logTrace){
        OrderControllerV1 orderControllerV1 = new OrderControllerV1Impl(orderService(logTrace));
        LogTraceFilterHandler logTraceBasicHandler = new LogTraceFilterHandler(orderControllerV1, logTrace, PATTERNS);
        return (OrderControllerV1) Proxy.newProxyInstance(OrderControllerV1.class.getClassLoader(), new Class[]{OrderControllerV1.class}, logTraceBasicHandler);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace){
        OrderServiceV1 orderServiceV1 = new OrderServiceV1Impl(orderRepository(logTrace));
        LogTraceFilterHandler logTraceBasicHandler = new LogTraceFilterHandler(orderServiceV1, logTrace, PATTERNS);
        return (OrderServiceV1) Proxy.newProxyInstance(OrderServiceV1.class.getClassLoader(), new Class[]{OrderServiceV1.class}, logTraceBasicHandler);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace){
        OrderRepositoryV1 orderRepositoryV1 = new OrderRepositoryV1Impl();
        LogTraceFilterHandler logTraceBasicHandler = new LogTraceFilterHandler(orderRepositoryV1, logTrace, PATTERNS);
        return (OrderRepositoryV1) Proxy.newProxyInstance(OrderRepositoryV1.class.getClassLoader(), new Class[]{OrderRepositoryV1.class}, logTraceBasicHandler);
    }
}
