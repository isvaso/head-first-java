public class GuessGame {

    Player p1;
    Player p2;
    Player p3;

    public void startGame() {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guesp1 = 0;
        int guesp2 = 0;
        int guesp3 = 0;

        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        int targetNumber = (int) (Math.random() * 10);
        System.out.println("I'm thinking of a number between 0 and 9...");

        while (true) {
            System.out.println("Number to guess is " + targetNumber);

            p1.guess();
            p2.guess();
            p3.guess();

            guesp1 = p1.number;
            System.out.println("Player one guessed " + guesp1);

            guesp2 = p2.number;
            System.out.println("Player two guessed " + guesp2);

            guesp3 = p3.number;
            System.out.println("Player three guessed " + guesp3);

            if (guesp1 == targetNumber) {
                p1isRight = true;
            }

            if (guesp2 == targetNumber) {
                p2isRight = true;
            }

            if (guesp3 == targetNumber) {
                p3isRight = true;
            }

            if (p1isRight || p2isRight || p3isRight) {
                System.out.println("We have a winner!");
                System.out.println("Player one got it right? " + p1isRight);
                System.out.println("Player two got it right? " + p2isRight);
                System.out.println("Player three got it right? " + p3isRight);
                System.out.println("Game is over");
                break;
            } else {
                p1isRight = false;
                p2isRight = false;
                p3isRight = false;
                System.out.println("Players will have to try again.");
            }
        }
    }
}
