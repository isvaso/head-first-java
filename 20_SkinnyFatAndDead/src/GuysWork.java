import java.util.*;
import static java.lang.System.out;//Static import!

public class GuysWork {

    public static void main(String[] args) {

        ArrayList guys = new ArrayList();
        int numberOfGuys = 77;
        int numberOfDeadGuys = 0;
        int guyWeight = 0;
        SkinnyGuy skinnyGuyObj = new SkinnyGuy(false);
        FatGuy fatGuyObj = new FatGuy(false);
        Date today = new Date();

        for (int i = 0; i <= numberOfGuys; i++) {

            guyWeight = (int) (Math.random() * 120);

            if (guyWeight >= SkinnyGuy.getMinWeight() && guyWeight < FatGuy.getMinWeight()) {
                SkinnyGuy sg = new SkinnyGuy();
                sg.setWeight(guyWeight);
                guys.add(sg);
            } else if (guyWeight >= FatGuy.getMinWeight()) {
                FatGuy sg = new FatGuy();
                sg.setWeight(guyWeight);
                guys.add(sg);
            } else {
                numberOfDeadGuys++;
            }
        }

            out.format("Today %tA, %<tB %<td, %<tY and we have " + guys.size()+ " alive guys and " + numberOfDeadGuys + " dead guys.\n", today);
            out.println("Among them " + SkinnyGuy.getFatGuysCount() + " are skinny and " + FatGuy.getFatGuysCount() + " are fat.");
            out.println("\nHere is list of skinny guys weights:");

            for (Object o : guys) {
                if (o instanceof SkinnyGuy && ((SkinnyGuy) o).getWeight() == SkinnyGuy.getMinWeight()) {
                    out.format("\n%02d. Has weight %d kg! ", guys.indexOf(o)+1, ((SkinnyGuy) o).getWeight());
                    ((SkinnyGuy) o).showPressAndSay("Yeah...\n");
                } else if (o instanceof SkinnyGuy) {
                    out.format("%02d. Has weight %d kg; \n", guys.indexOf(o)+1, ((SkinnyGuy) o).getWeight());
                }
            }

           out.println("\nAnd is list of fat guys weights:");
            for (Object o : guys) {
                if (o instanceof FatGuy) {
                   out.format("%02d. Has weight %d kg; \n", guys.indexOf(o)+1, ((FatGuy) o).getWeight());
                }
            }
    }
}
