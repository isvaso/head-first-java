import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer {

    HashMap serviceList;

    public ServiceServerImpl() throws RemoteException {
        setUpServices();
    }

    private void setUpServices() {
        serviceList = new HashMap();
        serviceList.put("Dice Rolling", new DiceService());
        serviceList.put("Day of the Week", new DayOfTheWeakService());
        serviceList.put("Visual Music", new MiniMusicService());
    }

    @Override
    public Object[] getServiceList() throws RemoteException {
        System.out.println("In remote");
        return serviceList.keySet().toArray();
    }

    @Override
    public Service getService(Object serviceKey) throws RemoteException {
        Service theService = (Service) serviceList.get(serviceKey);
        return theService;
    }

    public static void main(String[] args) throws RemoteException {

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        //ServiceServer remoteServer = new ServiceServerImpl();

        try {
            //ServiceServer stub = (ServiceServer) UnicastRemoteObject.exportObject(remoteServer, 0); //If remote object doesn't implements UnicastRemoteObject
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("ServiceServer", new ServiceServerImpl());
            System.out.println("Remote service is running");
        } catch (Throwable cause) {
            System.err.println("Couldn't 'MyRemoteInterface' cause " + cause.getMessage());
        }

    }


}
