package kibong.proxy.config.v6_aop;

import kibong.proxy.Trace.logtrace.LogTrace;
import kibong.proxy.config.AppV1Config;
import kibong.proxy.config.AppV2Config;
import kibong.proxy.config.v6_aop.aspect.LogTraceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {

    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace){
        return new LogTraceAspect(logTrace);
    }
}
