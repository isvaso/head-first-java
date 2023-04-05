import java.io.*;

public class Helper {

    public String getUserInput(String prompt) {

        String inputLine = null;

        System.out.println(prompt);

        try {

            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();

            if (inputLine.length() == 0) return null;

        } catch (IOException ex) {
            System.out.println("IOException" + ex);
        }

        return inputLine;
    }
}
