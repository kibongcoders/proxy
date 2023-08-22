package kibong.proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends Concrete{

    public TimeProxy(ConcreteProxy concreteProxy) {
        super(concreteProxy);
    }

    @Override
    public String operation() {
        log.info("TimeDecorator 실행");
        long startTime = System.currentTimeMillis();
        String result = concreteProxy.operation();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime; log.info("TimeDecorator 종료 resultTime={}", resultTime);
        return result;
    }
}
