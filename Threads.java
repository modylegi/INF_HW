package INF_HW;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;




public class Threads {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Runnable task0 = () -> {
            try {
                while (!Thread.interrupted()) {
                    System.out.println("TEXT MESSAGE");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
            }
        };

        Thread thread0 = new Thread(task0);
        thread0.start();

        String enterKey = scanner.nextLine();
        if (enterKey == "") {
            thread0.interrupt();
        }
    }
}