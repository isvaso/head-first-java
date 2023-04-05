import java.io.*;
import java.net.*;

public class DailyAdviceClient {

    public void go() {

        try {

            Socket socket = new Socket("192.168.1.127", 5050);


                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.println("HI!");
                writer.flush();


                InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStream);
                String advice = bufferedReader.readLine();

                System.out.println(advice);

                bufferedReader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        DailyAdviceClient dailyAdviceClient = new DailyAdviceClient();
        dailyAdviceClient.go();
    }
}
