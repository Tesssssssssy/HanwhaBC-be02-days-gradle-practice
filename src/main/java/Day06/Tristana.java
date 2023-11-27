package Day06;

public class Tristana extends Champion {
    // super -> 부모 생성자 호출

    Integer z;

    void jump() {
        z = z + 10;
    }

    public Tristana(String name) {
        super(name);
    }

    public Tristana(Integer hp) {
        super(hp);
    }

    public Tristana(String name, Integer attackDamage, Integer attackRange, Integer hp, Integer defense, Integer level, Integer exp, Double x, Double y, String[] itemList) {
        super(name, attackDamage, attackRange, hp, defense, level, exp, x, y, itemList);
    }


}
