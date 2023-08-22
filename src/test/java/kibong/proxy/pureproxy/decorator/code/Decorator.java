package kibong.proxy.pureproxy.decorator.code;

abstract class Decorator implements Component{

    protected Component decoratorComponent;

    public Decorator(Component component) {
        this.decoratorComponent = component;
    }

    public String operation(){
        return decoratorComponent.operation();
    }
}
