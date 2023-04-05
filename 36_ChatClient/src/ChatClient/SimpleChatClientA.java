package ChatClient;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SimpleChatClientA {

    JTextField outgoing;
    PrintWriter writer;
    Socket socket;

    public void go() {

        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        setUpNetworking();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void setUpNetworking() {

        try {
            socket = new Socket("192.168.1.127", 5050);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Connection to server 192.168.1.127 was successful");
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

    public static void main(String[] args) {

        SimpleChatClientA simpleChatClientA = new SimpleChatClientA();
        simpleChatClientA.go();
    }
}
