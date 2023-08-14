package kibong.proxy;

import kibong.proxy.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppV1Config.class) //하지 않으면 자동 컴포넌트 스캔 대상이 됨
@SpringBootApplication(scanBasePackages = "kibong.proxy.app")
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

}
