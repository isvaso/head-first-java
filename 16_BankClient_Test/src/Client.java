abstract public class Client {

    private String name;
    private int age;
    private int bill;

    public Client() {
        name = "Anonymous";
        System.out.println("Default name set.");
    }

    public void setName(String n) {

        name = n;
    }

    public String getName() {

        return name;
    }

    public void setAge(int a) {

        age = a;
    }

    public int getAge() {

        return age;
    }

    public void setBill(int b) {

        bill = b;
    }

    public int getBill() {

        return bill;
    }

    abstract int getFee();

}
