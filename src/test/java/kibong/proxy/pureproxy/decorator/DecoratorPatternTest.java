package kibong.proxy.pureproxy.decorator;

import kibong.proxy.pureproxy.decorator.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {
    @Test
     void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new
                DecoratorPatternClient(realComponent);
        client.execute();
    }
    @Test
    void decorator1() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);

        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    @Test
    void decorator2() {
        Component realComponent = new RealComponent();
        Component timeDecorator = new TimeDecorator(realComponent);
        Component messageDecorator = new MessageDecorator(timeDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    @Test
    void decorator3(){
        Component component = new RealComponent();
        Component coffeComponent = new DecoratorCoffee(component);
        Component milkeComponent = new DecoratorMilk(coffeComponent);
        log.info("hello={}", milkeComponent.operation());
        log.info("hello={}", component.operation());
    }

}
