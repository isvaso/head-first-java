public class Doctor {

    private String name;
    private String position;

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setPosition(String p) {
        position = p;
    }

    public String getPosition() {
        return position;
    }

    public String doctorSays() {
        String doctorMessage = "Hello! My name is " + name + ". Today I'll be your " + position + ".";
        return doctorMessage;
    }

}
