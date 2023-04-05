import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;

public class VerySimpleChatServer {

    ArrayList clientOutputStreams;

    public class ClientHandler implements Runnable {

        BufferedReader reader;
        Socket sock;

        public ClientHandler(Socket clientSocket) {

            try {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public void run() {

            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    tellEveryone(message);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new VerySimpleChatServer().go();
    }

    public void tellEveryone(String message) {

        Iterator iterator = clientOutputStreams.iterator();

        while (iterator.hasNext()) {
            try {
                PrintWriter writer = (PrintWriter) iterator.next();
                writer.println(message);
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void go() {

        clientOutputStreams = new ArrayList();

        try {
            ServerSocket serverSocket = new ServerSocket(5050);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
                System.out.println("Got a connection");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
