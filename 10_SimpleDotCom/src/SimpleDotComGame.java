public class SimpleDotComGame {

    public static void main(String[] args) {

        int numOfGuess = 0;

        GameHelper helper = new GameHelper();
        SimpleDotCom theDotCom = new SimpleDotCom();

        int randomNum = (int) (Math.random() * 5);
        if (randomNum == 0) randomNum = 1;//check outside start 0 location
        //System.out.println(randomNum);

        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        //System.out.println("DotCom is here " + locations[0] + " " + locations[1] + " " + locations[2]);

        theDotCom.setLocationCells(locations);

        boolean isAlive = true;

        while (isAlive) {
            String guess = helper.getUserInput("enter a number");
            String result = theDotCom.checkYourself(guess);
            numOfGuess++;

            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuess + " guesses");
            }
        }
    }
}
