public class Main {
    public static void main(String[] args) {
        ObjectA objectA = new ObjectA();
        ObjectB objectB = new ObjectB();

        Thread threadFirst = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (objectA) {
                    System.out.println("Thread1 synhronized object: A");
                    System.out.println("Try to synh obj: B");
                    synchronized (objectB) {
                        System.out.println("Thread1 synhronized object: B");
                    }
                }
            }

        });

        Thread threadSecond = new Thread(() -> {

            synchronized (objectB) {
                System.out.println("Thread2 synhronized object: B");
                System.out.println("Try to synh obj: A");
                synchronized (objectA) {
                    System.out.println("Thread2 synhronized object: A");
                }
            }

        });

        threadFirst.start();
        threadSecond.start();
    }
}
