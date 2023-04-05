import java.util.*;

public class HeightCompare implements Comparator<Mountain> {

    public int compare(Mountain o1, Mountain o2) {
        return (o2.height - o1.height);
    }
}
