package thread_programs;

public class ThreadSequencing {

    public static void main(String[] args) {

        OddEvenPrinter oep = new OddEvenPrinter();
        oep.odd = true;

        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        oep.printOdd();

                    }
                }, "Odd Thread");

        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        oep.printEven();
                    }
                }, "Even Thread");
        System.out.println("Printing numbers in sequence using 2 threads : " + "\n");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted");
        }
    }


}

class OddEvenPrinter {
    int i = 1;
    int MAXCOUNT = 50;
    boolean odd;

    public void printOdd() {

        synchronized (this) {
            while (i < MAXCOUNT) {
                while (!odd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " interrupted" + "while waiting");
                    }
                }
                System.out.println(Thread.currentThread().getName() + " prints " + i);
                i++;
                odd = false;
                notify();

            }
        }
    }

    public void printEven() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted " + "while sleeping");
        }
        synchronized (this) {
            while (i < MAXCOUNT) {
                while (odd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " interrupted " + "while waiting");
                    }
                }
                System.out.println(Thread.currentThread().getName() + " prints " + i);
                i++;
                odd = true;
                notify();

            }
        }
    }
}

