import java.util.Scanner;

public class Work {


    public static void main(String[] args) {
        Cloth w = new Cloth();

        Scanner scan = new Scanner(System.in);
        System.out.println("Look at the weather outside the window and say what a cloth I should wear today:");
        String c = scan.nextLine();


        try {
            w.wear(c);
        } catch (DoExc e) {
            System.out.println("What are you doing?! " + e);
        }
    }
}
