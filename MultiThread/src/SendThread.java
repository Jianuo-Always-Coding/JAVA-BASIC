import java.util.List;

public class SendThread extends Thread {
    private List<Integer> gift;
    private int count;

    public SendThread(List<Integer> gift, String name) {
        super(name);
        this.gift = gift;
        this.count = 0;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (gift) {
                if (gift.size() < 10) {
                    break;
                }
                gift.remove(gift.size() - 1);
                count++;
                System.out.println(this.getName() + "send" + count + "次");


            }

        }
        System.out.println(this.getName() + "send" + count + "次");

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
