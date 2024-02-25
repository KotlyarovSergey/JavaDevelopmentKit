package task3;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(4);


        Thread runner1 = new Thread(new Runner("Ivan", cdl));
        Thread runner3 = new Thread(new Runner("Sergey", cdl));
        Thread runner2 = new Thread(new Runner("Andrey", cdl));

        runner1.start();
        runner2.start();
        runner3.start();

        while (cdl.getCount() > 1) {
            Thread.sleep(100);
        }
        
        System.out.println("На старт!");
        Thread.sleep(1000);
        System.out.println("Внимание!");
        Thread.sleep(1000);
        System.out.println("Марш!");
        cdl.countDown();
        
    }
}
