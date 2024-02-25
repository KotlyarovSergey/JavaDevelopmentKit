package hw5;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Fork> forks;
    private List<Philosopher> philosophers;
    // private int capacity;

    public Table(int capacity) {
        // this.capacity = capacity;
        forks = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            Fork fork = new Fork(i);
            forks.add(fork);
        }

        philosophers = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            String name = ((Integer) i).toString();
            Philosopher philosopher = new Philosopher(name, forks.get(i), forks.get((i + 1) % capacity));
            philosophers.add(philosopher);
        }

        // for (Philosopher philosopher : philosophers) {
        // System.out.println(philosopher);
        // }
    }

    public List<Philosopher> getPhilosophers() {
        return philosophers;
    }
}
