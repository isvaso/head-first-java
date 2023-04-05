import java.util.*;

public class SortMountains {

    LinkedList<Mountain> mtn = new LinkedList<Mountain>();

    public static void main(String[] args) {

        SortMountains sortMountains = new SortMountains();
        sortMountains.go();
    }

    public void go() {

        mtn.add(new Mountain("Longs", 14255));
        mtn.add(new Mountain("Elbert", 14433));
        mtn.add(new Mountain("Maroon", 14156));
        mtn.add(new Mountain("Castle", 14256));

        System.out.println("as entered: \n" + mtn);
        NameCompare nc = new NameCompare();
        Collections.sort(mtn, nc);
        System.out.println("by name \n" + mtn);
        HeightCompare hc = new HeightCompare();
        Collections.sort(mtn, hc);
        System.out.println("by height \n" + mtn);
    }
}
