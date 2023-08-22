package kibong.proxy.pureproxy.decorator.code;

public class DecoratorMilk extends Decorator{

    public DecoratorMilk(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        return decoratorComponent.operation() + " milk";
    }
}
