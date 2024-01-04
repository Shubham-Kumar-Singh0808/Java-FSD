package exceptionHandling;

public class ThreadExample {
    public static class MyThread extends Thread {
        public void run() {
            System.out.println("Concurrent thread started running..");
        }

        public static void main(String args[]) {
            MyThread mt = new MyThread();
            mt.start();
        }
    }

    public static class MyRunnableThread implements Runnable {
        public static int myCount = 0;

        public MyRunnableThread() {
        }

        public void run() {
            while (MyRunnableThread.myCount <= 10) {
                try {
                    System.out.println("Expl Thread: " + (++MyRunnableThread.myCount));
                    Thread.sleep(100);
                } catch (InterruptedException iex) {
                    System.out.println("Exception in thread: " + iex.getMessage());
                }
            }
        }
    }

    public static void main(String a[]) {
        System.out.println("Starting Main Thread...");

        MyRunnableThread mrt = new MyRunnableThread();

        Thread t = new Thread(mrt);

        MyThread mt = new MyThread();
        mt.start();
        t.start();

        while (MyRunnableThread.myCount <= 10) {
            try {
                System.out.println("Main Thread: " + (++MyRunnableThread.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex) {
                System.out.println("Exception in main thread: " + iex.getMessage());
            }
        }

        System.out.println("End of Main Thread...");
    }
}
