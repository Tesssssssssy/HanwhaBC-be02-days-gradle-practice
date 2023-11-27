package Day06;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Champion champion = new Champion(
                "가렌",
                72,
                100,
                580,
                60,
                1,
                0,
                0.0,
                0.0,
                new String[6]
        );

        // 생성하는 객체의 클래스 이름과 객체를 저장하는 변수의 클래스가 다르다 => 다형성
        Champion tristana = new Tristana(
                "트리스타나",
                72,
                100,
                580,
                60,
                1,
                0,
                0.0,
                0.0,
                new String[6]
        );

        // 제네릭 및 다형성 사용 예시
        List<Champion> championList = new ArrayList<Champion>();

        championList.add(champion);
        championList.add(tristana);

    }
}
