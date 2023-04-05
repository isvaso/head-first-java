import java.io.*;
import java.net.*;

public class DailyAdviceServer {

    String[] adviceList = {
            "Take smaller bytes", "Go for the tight jeans. No the do NOT make you look fat.", "One word: inappropriate",
                    "Jus for today, be honest. Tell your boss that you *really think", "You might want to rethink that haircut"};

    public void go() {

        try {
            ServerSocket serverSocket = new ServerSocket(5050);

            while (true) {

                Socket socket = serverSocket.accept();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.flush();
                System.out.println(advice);

                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                System.out.println(bufferedReader.readLine());


            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
