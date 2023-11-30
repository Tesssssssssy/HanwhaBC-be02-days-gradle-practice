package Day07.Thread.Bank;

public class Account {
    int balance = 0;

    // balance를 읽어서 값을 더하고 저장
    // 여러 스레드가 동시에 작업하면 race condition가 된다.
    // 실행 결과가 thread safe하지 않다.
    // synchronized를 사용하면 스레드가 동기화하면서 작업을 진행
    // 사실 이 방식은 내가 읽고 작업을 할 떄 lock을 걸어서 다른 사람들은 작업을 하지 못하게 만듦.
    // 그래서 동시 진행이라고 할 수 없다.
    // lock을 걸고 푸는 건 상호 배제라고도 함.
    public synchronized void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public void check() {
        System.out.println("현재 잔액은 " + this.balance + "원 입니다.");
    }

}
