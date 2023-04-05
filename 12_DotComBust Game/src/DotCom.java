import java.util.*;

public class DotCom {

    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells (ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput); //get index of part of DotCom if user is hit

        if (index >= 0) {
            locationCells.remove(index); //remove of part of DotCom from list

            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " :( ");
            } else {
                result = "hit";
            } // close if
        } // close if
        return result;
    } //close method
} //close class
