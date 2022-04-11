package INF_HW;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;




public class Threads {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            try {
                while (!Thread.interrupted()) {
                    System.out.println("TEXT MESSAGE");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        });
        thread.start();
        Scanner scanner = new Scanner(System.in);

        String enterKey = scanner.nextLine();
        if (enterKey == "") {
            thread.interrupt();
        }
    }
}