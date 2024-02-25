package hw5;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(5);
        for (Philosopher philosopher : table.getPhilosophers()) {
            // Thread tread = new Thread(philosopher);
            // tread.start();
            new Thread(philosopher).start();
        }
    }
}
