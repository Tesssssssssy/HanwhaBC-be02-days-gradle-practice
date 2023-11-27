package Day06;

public class Customer {
    int money;

    public Customer(int money) {
        this.money = money;
    }

/*
    // 다형성을 모를 떄는 메뉴가 계속 생길 떄마다 계속 만들어줘야 함.
    => 다형성 개념 사용

    void buyCoffee(Latte latte) {
        if (this.money > latte.price) {
            System.out.println("라뗴 구매 가능");
        } else {
            System.out.println("라뗴 구매 불가능");
        }
    }

    void buyCoffee(Americano americano) {
        if (this.money > americano.price) {
            System.out.println("아메리카노 구매 가능");
        } else {
            System.out.println("아메리카노 구매 불가능");
        }
    }
 */

    void buyCoffee(Coffee coffee) {
        if (this.money >= coffee.price) {
            System.out.println("구매 가능");
        } else {
            System.out.println("구매 불가능");
        }
    }

}
