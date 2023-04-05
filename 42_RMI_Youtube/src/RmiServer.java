import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer {


    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        MyRemoteInterface myRemoteObject = new MyRemoteObject();

        try {
            MyRemoteInterface stub = (MyRemoteInterface) UnicastRemoteObject.exportObject(myRemoteObject, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("MyRemoteObject", stub);
            System.out.println("Bound 'MyRemoteObject'");
        } catch (Throwable cause) {
            System.err.println("Couldn't 'MyRemoteInterface' cause " + cause.getMessage());
        }
    }
}

    interface MyRemoteInterface extends Remote {
        int getIncreasedNumber (int number) throws RemoteException;
    }

    class MyRemoteObject implements MyRemoteInterface {

        @Override
        public int getIncreasedNumber(int number) {
            return number + 1;
        }
    }
