package kibong.proxy.pureproxy.concreteproxy;

import kibong.proxy.pureproxy.concreteproxy.code.ConcreteProxy;
import kibong.proxy.pureproxy.concreteproxy.code.ConcreteProxyClient;
import kibong.proxy.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteProxy concreteProxy = new ConcreteProxy();
        ConcreteProxyClient concrete = new ConcreteProxyClient(concreteProxy);
        concrete.execute();
    }

    @Test
    void proxy(){
        ConcreteProxy concreteProxy = new ConcreteProxy();
        TimeProxy timeProxy = new TimeProxy(concreteProxy);
        ConcreteProxyClient client = new ConcreteProxyClient(timeProxy);
        client.execute();
    }
}
