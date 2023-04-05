public class Dentist extends Doctor {

    private String name;
    private String position;



    public String doctorSays(String m) {
        String adMessage = m;
        String doctorMessage = "Hi! " + adMessage + " My name " + adMessage + " is " + name + ". Today " + adMessage + " I'll be your " + position + " " + adMessage + ".";
        return doctorMessage;
    }


}
