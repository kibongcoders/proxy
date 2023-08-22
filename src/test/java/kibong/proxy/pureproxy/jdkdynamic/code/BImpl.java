package kibong.proxy.pureproxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImpl implements BInterface{

    @Override
    public String call() {
        log.info("B 인터페이스 호출");
        return "B";
    }
}
