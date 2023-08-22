package kibong.proxy.pureproxy.decorator.code;

public class DecoratorCoffee extends Decorator {

    public DecoratorCoffee(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        return decoratorComponent.operation() + " coffee";
    }
}
