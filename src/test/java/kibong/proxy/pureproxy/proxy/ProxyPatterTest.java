package kibong.proxy.pureproxy.proxy;

import kibong.proxy.pureproxy.proxy.code.CacheProxy;
import kibong.proxy.pureproxy.proxy.code.ProxyPatternClient;
import kibong.proxy.pureproxy.proxy.code.RealSubject;
import kibong.proxy.pureproxy.proxy.code.Subject;
import org.junit.jupiter.api.Test;

public class ProxyPatterTest {

    @Test
    void noProxyTesty(){
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest(){
        RealSubject realSubject = new RealSubject();
        Subject cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);
        client.execute();
        client.execute();
        client.execute();
    }
}
