package Day06;

import java.util.Arrays;

/**
 * 공통적인 특성
 * - 이름
 * - 공격력
 * - 공격 사거리
 * - 체력
 * - 방어력
 * - 레벨
 * - 경험치
 * - 좌표x, y
 * - 아이템 목록 (배열, 아이템은 최대 6개까지 가질 수 있다.)
 *
 * - 공통 기능
 *     - 경험치 업
 *     - 레벨 업
 *     - 이동
 *     - 귀환
 *     - 공격
 *     - 죽는다 (죽으면 귀환을 함)
 *     - 아이템 구매
 */
public class Champion {
    String name;    // 이름
    Integer attackDamage;  // 공격력
    Integer attackRange;  // 공격 사거리
    Integer hp;  // 체력
    Integer defense;  // 방어력
    Integer level;  // 레벨
    Integer exp;  // 경험치
    Double x;  // 좌표 x
    Double y;  // 좌표 y
    String[] itemList;   // 아이템 목록 (최대 6개)

    @Override
    public String toString() {
        return "Champion{" +
                "name='" + name + '\'' +
                ", attackDamage=" + attackDamage +
                ", attackRange=" + attackRange +
                ", hp=" + hp +
                ", defense=" + defense +
                ", level=" + level +
                ", exp=" + exp +
                ", x=" + x +
                ", y=" + y +
                ", itemList=" + Arrays.toString(itemList) +
                '}';
    }

    public Champion() {
        System.out.println("생성자가 생성되었다");
    }

    Champion(String name){
        this.name = name;
    }

    Champion(Integer hp){
        this.hp = hp;
    }

    public Champion(String name, Integer attackDamage, Integer attackRange, Integer hp, Integer defense, Integer level, Integer exp, Double x, Double y, String[] itemList) {
        this.name = name;
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
        this.hp = hp;
        this.defense = defense;
        this.level = level;
        this.exp = exp;
        this.x = x;
        this.y = y;
        this.itemList = itemList;
        for (int i=0; i<this.itemList.length; i++) {
            this.itemList[i] = "빈칸";
        }
    }

    Integer expUp(String enemy) {   // 경험치 업

        if (enemy == "미니언") {   // 만약  enemy가 미니언이면 현재 경험치에 10 추가
            exp += 10;
        } else if (enemy == "용") {  // 그렇지 않고 만약 enemy가 용이면 현재 경험치에 50 추가
            exp += 50;
        } else if (enemy == "타워") {  // 그렇지 않고 만약 enemy가 타워면 현재 경험치에 100 추가
            exp += 100;
        }

        if (exp >= 100) {    // 만약 현재 경험치가 100보다 크면 레벨 업
            levelUp();
//          this.levelUp();
            exp = exp % 100;     // 현재 경험치를 수정해줘야 함.
        }

        return exp;
    }

    Integer levelUp() {   // 레벨 업

        level += 1;    // 현재 level에 1 더해서 저장
        attackDamage = (int) (attackDamage + (0.1 * attackDamage));    // attackDamage에 10% 증가
        defense = (int) (defense + (0.05 * defense));    // defense에 5% 증가
        hp = (int) (hp + (0.2 * hp));       // hp에 20% 증가

        /*
        this.level += 1;
        this.attackDamage = (int)(this.attackDamage + (0.1) * attackDamage);
        ...
        */

        return level;
    }

    void move (Double x, Double y) {    // 이동
        this.x = x;
        this.y = y;
    }

    void comeBack() {    // 귀환
//        this.x = 0.0;
        x = 0.0;
        y = 0.0;
    }

    void killed() {
        System.out.println("killed!");
        this.comeBack();    // 체력이 이미 깎여서 죽은 것.
        this.hp = 100;      // 체력 채워서 귀환시켜야 함.
    }

    Integer attacked(Integer attackDamage) {
        this.hp = this.hp - attackDamage;

        if (hp <= 0) {
            this.killed();
        }
        return hp;
    }

    // attacked 메소드를 오버로딩을 이용해
    // 숫자를 하나 더 parameter로 입력받는 걸로 하나 더 만든다.
    Integer attacked(Integer attackDamage, Integer criticalNum) {
        this.hp = this.hp - attackDamage * criticalNum;

        if (hp <= 0) {
            this.killed();
        }

        return hp;
    }


    void attackTo(Champion target) {   // 공격

        // 1-100 사이의 랜덤 숫자를 생성
        // 만약 90 이상이면 3배 크리티컬 공격
        //     80 이상이면 2배 크리티컬 공격
        // 그렇지 않으면 그냥 공격

        int random = (int)(Math.random() * 100) + 1;
        System.out.println("random 수: " + random);
        if (random >= 90) {
            target.attacked(this.attackDamage, 3);
        } else if (random >= 80) {
            target.attacked(this.attackDamage, 2);
        } else {
            target.attacked(this.attackDamage);
        };
    }

    String[] shopping(String item) {
        for (int i=0; i<this.itemList.length; i++) {
            if(this.itemList[i] == "빈칸") {
                this.itemList[i] = item;
                break;
            }
        }
        return itemList;
    }
}
