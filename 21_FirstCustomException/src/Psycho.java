public class Psycho {
    String name;

    public void getName() throws GoAwayException {
        if (name == null ) {
            throw new GoAwayException("Go away homo!");
        }
    }
}
