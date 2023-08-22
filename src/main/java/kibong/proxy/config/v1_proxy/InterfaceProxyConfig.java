package kibong.proxy.config.v1_proxy;

import jakarta.annotation.PostConstruct;
import kibong.proxy.app.Trace.logtrace.LogTrace;
import kibong.proxy.app.v1.*;
import kibong.proxy.config.v1_proxy.proxy_interface.OrderControllerInterfaceProxy;
import kibong.proxy.config.v1_proxy.proxy_interface.OrderRepositoryInterfaceProxy;
import kibong.proxy.config.v1_proxy.proxy_interface.OrderServiceInterfaceProxy;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public OrderControllerV1 OrderController(LogTrace logTrace){
        OrderControllerV1Impl orderControllerV1 = new OrderControllerV1Impl(orderService(logTrace));
        return new OrderControllerInterfaceProxy(orderControllerV1, logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace){
        OrderServiceV1Impl orderServiceV1 = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(orderServiceV1, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace){
        OrderRepositoryV1Impl orderRepositoryV1 = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(orderRepositoryV1, logTrace);
    }
}
