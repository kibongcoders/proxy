package kibong.proxy;

import kibong.proxy.app.Trace.logtrace.LogTrace;
import kibong.proxy.app.Trace.logtrace.ThreadLocalTrace;
import kibong.proxy.config.AppV1Config;
import kibong.proxy.config.AppV2Config;
import kibong.proxy.config.v1_proxy.InterfaceProxyConfig;
import kibong.proxy.config.v2_dynamicproxy.handler.DynamicProxyConfig;
import kibong.proxy.config.v2_proxy.ClassProxyConfig;
import kibong.proxy.config.v3_proxyfactory.ProxyFactoryConfig;
import kibong.proxy.config.v4_postprocessor.BeanPostProcessorConfig;
import kibong.proxy.config.v5_autoproxy.AutoProxyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV2Config.class, AppV1Config.class}) //하지 않으면 자동 컴포넌트 스캔 대상이 됨
@Import(AutoProxyConfig.class)
@SpringBootApplication(scanBasePackages = "kibong.proxy.app")
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalTrace();
    }

}
