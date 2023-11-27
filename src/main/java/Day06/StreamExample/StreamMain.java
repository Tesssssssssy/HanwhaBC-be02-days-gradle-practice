package Day06.StreamExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamMain {
    public static void main(String[] args) throws IOException {

        // 생성자 만들 때 file 이름을 넣을 것
        // 예외 처리를 하지 않으면 에러 발생

        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2 = null;
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;

        try {
            fileInputStream = new FileInputStream("D:\\workspace\\spring_workspace\\Hanwha_javabasic2\\hanwha_javabasic2\\src\\main\\java\\Day06\\StreamExample\\streamtest.txt");
            fileInputStream2 = new FileInputStream("D:\\workspace\\spring_workspace\\Hanwha_javabasic2\\hanwha_javabasic2\\src\\main\\java\\Day06\\StreamExample\\streamtest.txt");
            int num = fileInputStream.read();
            // 첫 글자 하나만 읽어서 다음에 write하기 때문에
            // streamtestOutPut.txt에 s 하나만 저장된다.

            byte[] bytes = fileInputStream2.readAllBytes();
            // readAllBytes()이니까 저장 변수도 byte 배열 타입으로 선언.
            // 이렇게 하니까 원본 streamtest.txt와 동일한 내용을 가진 streamtestOutPut.txt가 생김 (파일 내용이 복사됨)

            fileOutputStream = new FileOutputStream("D:\\\\workspace\\\\spring_workspace\\\\Hanwha_javabasic2\\\\hanwha_javabasic2\\\\src\\\\main\\\\java\\\\Day06\\\\StreamExample\\\\streamtestOutPut.txt");
            fileOutputStream2 = new FileOutputStream("D:\\\\workspace\\\\spring_workspace\\\\Hanwha_javabasic2\\\\hanwha_javabasic2\\\\src\\\\main\\\\java\\\\Day06\\\\StreamExample\\\\streamtestOutPut2.txt");
            fileOutputStream.write(num);

            for (int i = 0; i < bytes.length; i++) {
                fileOutputStream2.write(bytes[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("그런 파일 없다.");
        } catch (IOException e) {
            System.out.println("읽을 수 없다.");
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        }


        // alt + enter 누르면 해결 방법 제시

    }
}
