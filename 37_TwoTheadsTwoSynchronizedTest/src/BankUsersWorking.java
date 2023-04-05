public class BankUsersWorking {

    BankAccount account = new BankAccount();

    public void go() {

        BankAccount account = new BankAccount();
        BankAccountUserType1 userOne = new BankAccountUserType1();
        BankAccountUserType2 userTwo = new BankAccountUserType2();
        Thread one = new Thread(userOne);
        Thread two = new Thread(userTwo);
        one.setName("UserOne");
        two.setName("UserTwo");
        one.start();
        two.start();
    }


    public static void main(String[] args) {
        BankUsersWorking work = new BankUsersWorking();
        work.go();
    }


    public class BankAccountUserType1 implements Runnable {

        public void run() {

            for (int i = 0; i < 10; i++) {

                withdrawPlus(10);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                withdrawMinus(20);
            }
        }

        public void withdrawPlus(int amount) {

            if (account.getBalance() >= amount) {

                System.out.println(Thread.currentThread().getName() + " going to withdraw plus");

                try {
                    System.out.println(Thread.currentThread().getName() + " thinking about withdraw plus");
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " did withdraw plus");
                account.withdrawPlus(10);
            } else {
                System.out.println("No money, no honey!");
            }
        }

        public void withdrawMinus(int amount) {

            if (account.getBalance() >= amount) {

                System.out.println(Thread.currentThread().getName() + " going to withdraw minus");

                try {
                    System.out.println(Thread.currentThread().getName() + " thinking about withdraw minus");
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " did withdraw minus");
                account.withdrawMinus(amount);
            } else {
                System.out.println("No money, no honey " + Thread.currentThread().getName());
            }
        }
    }


    public class BankAccountUserType2 implements Runnable {

        public void run() {

            for (int i = 0; i < 10; i++) {

                withdrawMinus(20);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                withdrawPlus(10);
            }
        }

        public void withdrawPlus(int amount) {

            if (account.getBalance() >= amount) {

                System.out.println(Thread.currentThread().getName() + " going to withdraw plus");

                try {
                    System.out.println(Thread.currentThread().getName() + " thinking about withdraw plus");
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                account.withdrawPlus(10);
            } else {
                System.out.println("No money, no honey " + Thread.currentThread().getName());
            }
        }


        public void withdrawMinus(int amount) {

            if (account.getBalance() >= amount) {

                System.out.println(Thread.currentThread().getName() + " going to withdraw minus");

                try {
                    System.out.println(Thread.currentThread().getName() + " thinking about withdraw minus");
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                account.withdrawMinus(amount);
            } else {
                System.out.println("No money, no honey!");
            }
        }
    }





}
