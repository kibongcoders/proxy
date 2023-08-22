package kibong.proxy.config.v5_autoproxy;

import kibong.proxy.Trace.logtrace.LogTrace;
import kibong.proxy.config.AppV1Config;
import kibong.proxy.config.AppV2Config;
import kibong.proxy.config.v3_proxyfactory.LogAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AutoProxyConfig {

//    @Bean
//    Advisor getAdvisor(LogTrace logTrace) {
//        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
//        pointcut.setMappedNames("request*", "orderItem*", "save");
//        return new DefaultPointcutAdvisor(pointcut, new LogAdvice(logTrace));
//    }

//    @Bean
//    Advisor getAdvisor(LogTrace logTrace) {
//        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//        pointcut.setExpression("execution(* kibong.proxy.app..*(..))");
//        return new DefaultPointcutAdvisor(pointcut, new LogAdvice(logTrace));
//    }

    @Bean
    Advisor getAdvisor(LogTrace logTrace) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* kibong.proxy.app..*(..)) && !execution(* kibong.proxy.app..noLog(..))");
        return new DefaultPointcutAdvisor(pointcut, new LogAdvice(logTrace));
    }


}
