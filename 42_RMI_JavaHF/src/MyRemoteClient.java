import java.rmi.*;

public class MyRemoteClient {

    public static void main(String[] args) {

        new MyRemoteClient().go();
    }

    public void go() {

        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://localhost:1099/Remote Hello");
            String s = service.sayHello();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
