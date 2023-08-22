package kibong.proxy.pureproxy.jdkdynamic;

import kibong.proxy.pureproxy.jdkdynamic.code.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class JdkDynamicTest {

    @Test
    void ADynamicTest(){
        AInterface aInterface = new AImpl();
        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(aInterface);
        AInterface aInterface1 = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, timeInvocationHandler);
        aInterface1.call();
    }

    @Test
     void BDynamicTest(){
        BInterface bInterface = new BImpl();
        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(bInterface);
        BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, timeInvocationHandler);
        proxy.call();
    }
}
