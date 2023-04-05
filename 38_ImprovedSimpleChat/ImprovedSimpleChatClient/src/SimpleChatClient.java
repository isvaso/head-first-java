import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class SimpleChatClient {

    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;

    public static void main(String[] args) {

        SimpleChatClient client = new SimpleChatClient();
        client.go();
    }

    public void go() {

        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        incoming = new JTextArea(15, 40);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(incoming);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        setUpNetworking();

        Thread readThread = new Thread(new IncomingReader());
        readThread.start();

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    public void setUpNetworking() {

        try {
            sock = new Socket("192.168.1.127", 5050);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("Networking established \n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    public class IncomingReader implements Runnable {

        public void run() {

            String message;

            try {

                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    incoming.append(message + "\n");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
