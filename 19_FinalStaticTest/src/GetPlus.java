public class GetPlus {
   public String s = "sss";
   final static int x = 1;////x or X ???

   private static int counter = 0;

   public GetPlus() {
       counter++;
   }

   static {
       counter = 5;
   }

    public static int getCounter() {
        return counter;
    }

    public static int GetDoublePlus(int a, int b) {
        int sumResult = a * 2 + b * 2;
        return sumResult;
    }
}
