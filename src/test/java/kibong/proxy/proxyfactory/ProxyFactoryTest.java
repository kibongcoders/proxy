package kibong.proxy.proxyfactory;

import kibong.proxy.common.ServiceInterface;
import kibong.proxy.common.ServiceInterfaceImpl;
import kibong.proxy.common.TimeAdvice;
import kibong.proxy.pureproxy.concreteproxy.code.ConcreteProxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

import static org.junit.Assert.*;

@Slf4j
public class ProxyFactoryTest {

    @Test
    @DisplayName("인터페이스가 있으면 JDK 동적 프록시 사용")
    public void interfaceProxy(){

        ServiceInterface target = new ServiceInterfaceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        proxy.save();
        proxy.find();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        Assertions.assertTrue(AopUtils.isAopProxy(proxy));
        Assertions.assertTrue(AopUtils.isJdkDynamicProxy(proxy));
        Assertions.assertTrue(AopUtils.isCglibProxy(proxy));
    }

    @Test
    public void concreteProxy(){
        ConcreteProxy target = new ConcreteProxy();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ConcreteProxy proxy = (ConcreteProxy) proxyFactory.getProxy();
        proxy.operation();

        Assertions.assertTrue(AopUtils.isAopProxy(proxy));
        Assertions.assertTrue(AopUtils.isJdkDynamicProxy(proxy));
        Assertions.assertTrue(AopUtils.isCglibProxy(proxy));
    }


}
