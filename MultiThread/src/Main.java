import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> gift = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            gift.add(i);
        }
        SendThread xm = new SendThread(gift, "xiaoming");
        SendThread xh = new SendThread(gift,"xiaohong");
        xm.start();
        xh.start();

        xm.join();
        xh.join();

        System.out.println(xm.getCount());
        System.out.println(xh.getCount());



    }
}