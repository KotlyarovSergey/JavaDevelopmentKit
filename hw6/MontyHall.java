package hw6;

import java.util.Random;

public class MontyHoll {
    private static int ROUNDS = 1000;

    public static void main(String[] args) {
        int wins = 0;
        int count = ROUNDS;
        Random rnd = new Random();

        while (count-- > 0) {
            int prize = rnd.nextInt(3);
            int firstChoise = rnd.nextInt(3);
            int opened = opened(prize, firstChoise);
            int secondChoise = secondChoise(firstChoise, opened);

            if (secondChoise == prize)
                wins++;
        }

        System.out.printf("win: %s, lose: %s\n", wins, ROUNDS - wins);
    }

    private static int opened(int prize, int choise) throws RuntimeException {
        for (int i = 0; i < 3; i++)
            if (i != prize && i != choise)
                return i;

        throw new RuntimeException(String.format("Opened is failure! prize: %s, choise: %s", prize, choise));
    }

    private static int secondChoise(int firstChoise, int opened) {
        for (int i = 0; i < 3; i++)
            if (i != firstChoise && i != opened)
                return i;

        throw new RuntimeException(
                String.format("SecondChoise if failure! first: %s, opened: %s", firstChoise, opened));
    }

}