import java.util.*;
public class DuckWork {

    public static void main(String[] args) {
        int ducksCount = 100;
        ArrayList<Duck> duckList = new ArrayList<Duck>();
        String[] duckSays = {"Whoa!", "Suck my tail!", "Soska!", "Hello bitch!"};

        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
            if (i % 6 == 0) {
                Duck d = new Duck();
                duckList.add(d);
            } else {
                Duck d = new Duck(duckSays[(int) (Math.random() * duckSays.length)]);
                duckList.add(d);
            }

        }

    }
}
