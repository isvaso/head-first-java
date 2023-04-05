import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        Registry registry = LocateRegistry.getRegistry("192.168.1.127");
        MyRemoteInterface stub = (MyRemoteInterface) registry.lookup("MyRemoteObject");

        System.out.println("Increased number: " + stub.getIncreasedNumber(1));
    }
}
