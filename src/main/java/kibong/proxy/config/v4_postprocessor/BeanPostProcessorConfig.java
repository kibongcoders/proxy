package kibong.proxy.config.v4_postprocessor;

import kibong.proxy.app.Trace.logtrace.LogTrace;
import kibong.proxy.config.v3_proxyfactory.LogAdvice;
import kibong.proxy.config.v4_postprocessor.postprocessor.PackageLogTraceProxyPostProcessor;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPostProcessorConfig {


    @Bean
    public PackageLogTraceProxyPostProcessor packageLogTraceProxyPostProcessor(LogTrace logTrace){

        return new PackageLogTraceProxyPostProcessor("kibong.proxy.app", getAdvisor(logTrace));
    }

    Advisor getAdvisor(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "orderItem*", "save");
        return new DefaultPointcutAdvisor(pointcut, new LogAdvice(logTrace));
    }
}
