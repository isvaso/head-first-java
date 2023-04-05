import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceServer extends Remote {
    Object [] getServiceList() throws RemoteException;
    Service getService (Object serviceKey) throws RemoteException;
}
