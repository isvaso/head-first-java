public class SkinnyGuy implements PressOwner{

    private static final int MIN_WEIGHT = 30;
    private int weight;
    private static int skinnyGuysCount = 0;

    public SkinnyGuy() {
        skinnyGuysCount++;
    }

    public SkinnyGuy(boolean b) {
    }

    public void setWeight(int w) {
        weight = w;
    }

    public int getWeight() {
        return weight;
    }

    public static int getMinWeight() {
        return MIN_WEIGHT;
    }

    public static int getFatGuysCount() {
        return skinnyGuysCount;
    }

    public void say() {
        System.out.println("Hello! I'm skinny and like me " + skinnyGuysCount + " people. ");
    }

    public void showPressAndSay(String whatSay) {
        System.out.println("I'm so skinny, here is my press! " + whatSay);
    }
}
