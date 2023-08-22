package kibong.proxy.pureproxy.concreteproxy.code;

public class ConcreteProxyClient extends Concrete{

    public ConcreteProxyClient(ConcreteProxy concreteProxy) {
        super(concreteProxy);
    }

    public void execute(){
        concreteProxy.operation();
    }
}
