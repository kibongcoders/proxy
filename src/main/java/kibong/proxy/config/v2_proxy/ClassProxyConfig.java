package kibong.proxy.config.v2_proxy;

import kibong.proxy.app.Trace.logtrace.LogTrace;
import kibong.proxy.app.v2.OrderControllerV2;
import kibong.proxy.app.v2.OrderRepositoryV2;
import kibong.proxy.app.v2.OrderServiceV2;
import kibong.proxy.config.v2_proxy.proxy_class.OrderControllerClassProxy;
import kibong.proxy.config.v2_proxy.proxy_class.OrderRepositoryClassProxy;
import kibong.proxy.config.v2_proxy.proxy_class.OrderServiceClassProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassProxyConfig {

    @Bean
    public OrderControllerV2 orderControllerClass(LogTrace logTrace) {
        OrderControllerV2 orderControllerV2 = new OrderControllerV2(orderServiceClass(logTrace));
        return new OrderControllerClassProxy(orderControllerV2, logTrace);
    }

    @Bean
    public OrderServiceV2 orderServiceClass(LogTrace logTrace) {
        OrderServiceV2 orderServiceV2 = new OrderServiceV2(orderRepositoryClass(logTrace));
        return new OrderServiceClassProxy(orderServiceV2, logTrace);
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryClass(LogTrace logTrace) {
        OrderRepositoryV2 orderRepositoryV2 = new OrderRepositoryV2();
        return new OrderRepositoryClassProxy(orderRepositoryV2, logTrace);
    }
}
