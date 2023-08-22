package kibong.proxy.pureproxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImpl implements AInterface{

    @Override
    public String call() {
        log.info("A 인터페이스 호출");
        return "A";
    }
}
