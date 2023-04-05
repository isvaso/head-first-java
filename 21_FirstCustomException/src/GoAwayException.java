public class GoAwayException extends AllExceptions {

    public GoAwayException(String message) {
        super("GO AWAY! " + message);
    }

    public GoAwayException() {
        super("HA!");
    }
}
