package hw5;

import java.util.Random;

public class Philosopher extends Thread {
    private final int SATIETY = 3;
    private Fork leftFork, rigFork;
    private String name;


    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rigFork = rightFork;
    }

    @Override
    public void run() {
        int eatCount = 0;
        while (eatCount < SATIETY) {
            // подумать
            think();
            // взять вилки
            if (tryToCatchForks()) {
                // поесть
                eat();
                eatCount++;
                // отпустить вилки
                releaseForks();
            }
        }
        System.out.printf("Философ %s наелся.\n", name);
    }

    private void think() {
        try {
            System.out.printf(" Философ %s задумался\n", name);
            Thread.sleep(new Random().nextInt(2000, 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean tryToCatchForks() {
        // System.out.printf("Ф %s пытается взять вилки\n", name);
        if (leftFork.isFree() && rigFork.isFree()) {
            leftFork.setFree(false);
            rigFork.setFree(false);
            System.out.printf("  Философ %s взял вилки №%s и №%s\n", name, leftFork.getNumber(), rigFork.getNumber());
            return true;
        }
        // System.out.printf("Вилки %s и %s заняты\n", leftFork.getNumber(), rigFork.getNumber());
        return false;
    }

    private void releaseForks() {
        leftFork.setFree(true);
        rigFork.setFree(true);
        System.out.printf("  Философ %s опустил вилки №%s и №%s\n", name, leftFork.getNumber(), rigFork.getNumber());
    }

    private void eat() {
        try {
            System.out.printf("Философ %s ест\n", name);
            Thread.sleep(new Random().nextInt(2000, 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("Философ %s. Вилки: %s и %s\n", name, leftFork.getNumber(), rigFork.getNumber());
    }
}
