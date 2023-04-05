import java.util.*;

public class DotComBust {

    private GameHelper helper = new GameHelper(); //Create Helper for game's tasks
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>(); //List of DotCom Objects
    private int numOfGuesses = 0; //Count of guesses

    private void setUpGame() {
        //Create DotComs objects set their names and add to List
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses.");

        //set dotComs locations through set links to dotCom Objects to dotComToSet
        for (DotCom dotComToSet : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }//close the loop
    }//close the method

private void startPlaying() {
    while (!dotComList.isEmpty()){ //while list is not empty
        String userGuess = helper.getUserInput("Enter a guess"); //get new guesses from user
        checkUserGuess(userGuess); //check user's guess
    }//close while
    finishGame();
}//close the method

private void  checkUserGuess(String userGuess) {

    numOfGuesses++;

    String result = "miss";

    for (DotCom dotComToTest : dotComList) {
        result = dotComToTest.checkYourself(userGuess);
        if (result.equals("hit")) {
            break;
        }
        if (result.equals("kill")) {
            dotComList.remove(dotComToTest);
            break;
        }
    }//close for
    System.out.println(result);
}

private void finishGame() {

    System.out.println("All Dot COmps are dead! y`our stock is now worthless.");
    if (numOfGuesses <= 18) {
        System.out.println("It only took you " + numOfGuesses + " guesses.");
        System.out.println("You got out before your options sank.");
    } else {
        System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
        System.out.println("Fish are dancing with your options.");
    }
}//close method

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }//close main method
}//close the class