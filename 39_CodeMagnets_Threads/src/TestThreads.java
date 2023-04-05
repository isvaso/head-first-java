public class TestThreads {

    public static void main(String[] args) {
        new TestThreads().go();
    }

    public void go() {
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();
        Thread one = new Thread(t1);
        Thread two = new Thread(t2);
        one.start();
        two.start();
    }


    class ThreadOne implements Runnable {

        Accum a = Accum.getAccum();

        public void run() {
            for (int x = 0; x < 98; x++) {
                a.updateCounter(1000);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("one " + a.getCount());
        }
    }

    class ThreadTwo implements Runnable {

        Accum a = Accum.getAccum();

        public void run() {
            for (int x = 0; x < 99; x++) {
                a.updateCounter(1);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("two " + a.getCount());
        }
    }

}
