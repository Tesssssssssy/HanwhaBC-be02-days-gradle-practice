package Day07.Thread;

// 여러 스레드를 이용해서 동시에 여러 작업을 수행한다.
// 장점: 작업 속도가 빨라진다.
//      비동기 작업이 가능하다.
// 단점: context switching이 많이 일어나면 오히려 작업 속도가 느려질 수 있다.
//      동기화가 어려워진다.
//      thread safe하지 않을 수 있다.

public class Thread01Main {
    public static void main(String[] args) {
        // 스레드 객체 생성
        Thread thread01 = new Thread01();
        // 다형성 이용

        // start() 메소드로 스레드 시작, 시작시키면 스레드에 있는 run 메소드가 실행된다.
        thread01.start();


        Runnable runnable02 = new Thread02();
        Thread thread02 = new Thread(runnable02);
        thread02.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("메인 스레드에서 실행: " + i);
        }
    }
}
