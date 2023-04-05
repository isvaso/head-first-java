import java.util.ArrayList;
import java.util.List;

public class DotCom {

    private List<ArrayList<String>> locationCells;
    //private numOfHits;
    //don't need that now

    public void setLocationCells(ArrayList<String> loc) {


        locationCells = loc;
    }

    public String checkYourself(String userInput){

        String result = "miss";
        //check userInput in locationCells is
        int index = locationCells.indexOf(userInput);
        //if userInput is in locationCells index will be >= 0 and will be remove
        if (index >= 0) locationCells.remove(index);
        //if userInput isn't in locationCells
        if (locationCells.isEmpty()) {
            result = "kill";
        } else {
            result = "hit";
        }//close outer if
        return result;
    }//close method
}//close class
