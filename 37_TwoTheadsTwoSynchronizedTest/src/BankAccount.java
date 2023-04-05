public class BankAccount {

    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public synchronized void withdrawPlus(int amount) {

        try {
            System.out.println("!!! " + Thread.currentThread().getName() + " doing withdraw PLUS !!! \n");
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        balance = balance + amount;

        System.out.println(Thread.currentThread().getName() + " did withdraw PLUS");
    }

    public synchronized void withdrawMinus(int amount) {
        balance = balance - amount;

        System.out.println(Thread.currentThread().getName() + " did withdraw MINUS");
    }
}
