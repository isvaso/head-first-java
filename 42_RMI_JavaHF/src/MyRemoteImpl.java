import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    protected MyRemoteImpl() throws RemoteException {}

    @Override
    public String sayHello() throws RemoteException {
        return "Server says, 'HEY!'";
    }

    public static void main(String[] args) {

        try {
            MyRemoteImpl service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (RemoteException | MalformedURLException ex) {
            ex.printStackTrace();
        }
    }
}
