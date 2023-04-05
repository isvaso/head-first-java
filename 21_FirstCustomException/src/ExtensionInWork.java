public class ExtensionInWork {

    public static void main(String[] args) {
        Psycho p = new Psycho();
        try {
            p.getName();
        } catch (AllExceptions e) {
            System.out.println(e.getMessage());

        }
    }
}
