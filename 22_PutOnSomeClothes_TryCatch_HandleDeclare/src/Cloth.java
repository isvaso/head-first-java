public class Cloth {

    public void wear(String s) throws DoExc {

        if (s == null || s.equals("") || s.length() <= 2) {
            throw new DoExc("Enter a wear, bitch! Don't joke with me!");
        } else {
            System.out.println(s + " is on me, bitch! Go away motherfucker!");
        }

    }
}
