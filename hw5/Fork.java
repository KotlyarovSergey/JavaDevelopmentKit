package hw5;

public class Fork {
    private volatile boolean isFree;
    private int number;

    public Fork(int number) {
        this.number = number;
        isFree = true;
    }

    public int getNumber(){return number;}

    public boolean isFree(){return isFree;}

    public synchronized void setFree(boolean isFree) {
        this.isFree = isFree;
    }

}
