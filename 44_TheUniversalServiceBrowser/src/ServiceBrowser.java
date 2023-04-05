import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServiceBrowser {

    JPanel mainPanel;
    JComboBox serviceList;
    ServiceServer server;

    public void buildGui() {
        JFrame frame = new JFrame("RMI Browser");
        mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object [] services = getServicesList();

        serviceList = new JComboBox(services);

        frame.getContentPane().add(BorderLayout.NORTH, serviceList);
        serviceList.addActionListener(new MyListListener());

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    void loadService(Object serviceSelection) {
        try {
            Service svc = server.getService(serviceSelection);
            mainPanel.removeAll();
            mainPanel.add(svc.getGuiPanel());
            mainPanel.validate();
            mainPanel.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    Object [] getServicesList() {

        Object obj = null;
        Object[] services = null;

        try {
            Registry registry = LocateRegistry.getRegistry("192.168.1.127");
            // ServiceServer stub = (ServiceServer) registry.lookup("ServiceServer");
            obj = registry.lookup("ServiceServer");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        server = (ServiceServer) obj;

        try {
            services = server.getServiceList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return services;
    }

    class MyListListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object selection = serviceList.getSelectedItem();
            loadService(selection);
        }
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        new ServiceBrowser().buildGui();
    }

}
