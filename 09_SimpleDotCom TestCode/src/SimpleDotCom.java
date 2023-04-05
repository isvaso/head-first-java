public class SimpleDotCom {
    //what the object knows, instance variables
    int [] locationCells;
    int numOfHits = 0;
    //what the object does
    public void setLocationCells(int[] locationCells) {
        this.locationCells = locationCells;
    }

    public String checkYourself(String stringGuess){
        //set integer guess by converting entered by user string guess (1,2,3 etc.) to integer
        int guess = Integer.parseInt(stringGuess);
        //set local variable player's shot result and default value of it
        String result = "miss";

        for (int cell : locationCells) {

            if (guess == cell) {
                result = "hit";
                numOfHits++;
                break;

            }
        }//out of the loop

        if (numOfHits == locationCells.length) {

            result = "kill";

        }//end if

        System.out.println(result);

        return result;

    }//close method
}//close class
