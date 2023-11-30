package Day07.Thread;

public class Thread02 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("새로운 스레드에서 실행: " + i);
        }
    }
    // alt + insert하면 implements할 method 나옴
}
