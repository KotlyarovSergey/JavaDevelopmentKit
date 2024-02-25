package task2;

public class Main {
    private static volatile boolean switcher;
    private static boolean work = true;

    public static void main(String[] args) {
        Thread changer = new Thread(() -> {
            while (work) {
                switcher = !switcher;
                System.out.println("switcher: " + switcher);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
               
            }
        });

        Thread counter = new Thread(() -> {
            int count = 100;
            while (count > 0) {
                if(switcher){
                    System.out.println(count--);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
                // try {
                //     Thread.sleep(10);
                // } catch (InterruptedException e) {
                //     // TODO Auto-generated catch block
                //     e.printStackTrace();
                // }
            }
            work = false;
        });

        changer.start();
        counter.start();
    }
}
