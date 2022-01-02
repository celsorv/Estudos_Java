import java.util.Arrays;
import java.util.Random;

public class Horse implements Runnable {

    static final int LINE_LENGTH = 50;
    static final String CHAR_TRACK = "=";

    @Override
    public void run() {

        long elapsedTime = System.currentTimeMillis();

        final String lineStatus = CHAR_TRACK.repeat(LINE_LENGTH);
        final Random generator = new Random();

        int completed = 0;
        int previousSize = 0;
        int size;

        while (completed < 100) {

            size = ++completed * LINE_LENGTH / 100;

            if (size != previousSize) {
                System.out.println(lineStatus.substring(0, size) + " " + Thread.currentThread().getName());
                previousSize = size;
            }

            try {
                Thread.sleep(generator.nextInt(600));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        elapsedTime = System.currentTimeMillis() - elapsedTime;

        System.out.println(lineStatus + " " + Thread.currentThread().getName() + " **[FINISHED " + elapsedTime + "ms]**");

    }

}
