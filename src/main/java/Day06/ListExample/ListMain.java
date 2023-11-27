package Day06.ListExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListMain {
    public static void main(String[] args) {

        // 기존 방식
        ArrayList arrayList = new ArrayList();

        ListCounter.sizeOf(arrayList);

        // 다형성 활용
        List list = new ArrayList();

        // 다형성 활용
        List arrayList2 = new Stack();

        ListCounter.sizeOf(arrayList2);;

        // 다형성 활용
        // 기존 방식에서 100개 넘게 써놨는데
        // arraylist 사용하지 말고 모두 stack으로 바꿔야 한다면?
        // 일일히 모두 바꿔줘야 함.

        // ArrayList는 순서가 있는 list이다.

    }
}
