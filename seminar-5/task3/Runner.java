package task3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner implements Runnable{
    private String name;
    private CountDownLatch cdl;

    public Runner(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
    }

    // public String getName(){return name;}

    @Override
    public void run() {
        try{
            goToStart();
            cdl.await();
            running();

        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    public void goToStart() throws InterruptedException{
        System.out.println(name + " идёт к старту");
        Thread.sleep(new Random().nextInt(3000, 5000));
        System.out.println(name + " пришёл к старту");
        cdl.countDown();
    }

    public void running() throws InterruptedException{
        System.out.println(name + " стартовал");
        Thread.sleep(new Random().nextInt(4000, 7000));
        System.out.println(name + " финисшировал");
    }
}
