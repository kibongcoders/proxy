package kibong.proxy.pureproxy.concreteproxy.code;

public abstract class Concrete extends ConcreteProxy {

    protected ConcreteProxy concreteProxy;

    public Concrete(ConcreteProxy concreteProxy) {
        this.concreteProxy = concreteProxy;
    }

    @Override
    public String operation() {
        return concreteProxy.operation();
    }
}
