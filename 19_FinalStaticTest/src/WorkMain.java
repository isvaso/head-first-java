import java.util.*;

public class WorkMain {

    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        ArrayList<GetPlus> ar = new ArrayList<GetPlus>();

        for (int i = 0; i < 2; i++) {

            ar.add(new GetPlus());

            System.out.println(Integer.toString(ar.size()));
            if (!ar.isEmpty()) {
                ar.remove(0);
            }
            System.out.println(Integer.toString(ar.size()));
        }


        System.out.println(Integer.toString(GetPlus.getCounter()));
    }
}
