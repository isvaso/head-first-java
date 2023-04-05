public class DotComGame {

    public static void main(String[] args) {

        int numOfGuess = 0;

        GameHelper helper = new GameHelper();
        DotCom theDotCom = new DotCom();

        int randomNum = (int) (Math.random() * 5);
        //System.out.println(randomNum);

        String[] locations = {randomNum, randomNum + 1, randomNum + 2};
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
