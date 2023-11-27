package Day06;

public class CoffeeMain {
    public static void main(String[] args) {

        /*
            부모 클래스 객체 변수에 자식 클래스 객체를 생성해서 할당할 수는 있는데 (upcasting)
            자식 클래스 객체 변수에 부모 클래스 객체를 생성해서 할당할 수 없다. (downcasting)
            굳이 하려면 형 변환을 해서 저장해야 함.
            "변수"에 대해서 잘 생각해야 함.

            그래서 부모 클래스 객체가 저장된 변수에 자식 클래스 객체를 할당한다고 하더라도
            기본적으로 변수 자체가 부모 클래스 객체이기 때문에
            자식 클래스의 메소드를 사용할 수 없다.
        */
        Americano americano = new Americano("tall", 4000);
        Latte latte = new Latte("tall", 6000);

        Customer customer = new Customer(5000);

        customer.buyCoffee(americano);
        customer.buyCoffee(latte);

        /*
            구매 가능
            구매 불가능
        */




    }
}
