public class FatGuy {

    private static final int MIN_WEIGHT = 90;
    private int weight;
    private static int fatGuysCount = 0;

    public FatGuy() {
        fatGuysCount++;
    }
    public FatGuy(boolean b) {
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
        return fatGuysCount;
    }

    public void say() {
        System.out.println("Hello! I'm fat and like me " + fatGuysCount + " people. ");
    }
}
