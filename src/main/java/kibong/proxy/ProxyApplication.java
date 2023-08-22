package kibong.proxy;

import kibong.proxy.Trace.logtrace.LogTrace;
import kibong.proxy.Trace.logtrace.ThreadLocalTrace;
import kibong.proxy.config.v6_aop.AopConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV2Config.class, AppV1Config.class}) //하지 않으면 자동 컴포넌트 스캔 대상이 됨
@Import(AopConfig.class)
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
