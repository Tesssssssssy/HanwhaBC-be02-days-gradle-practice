package Day06.StreamExample;

import java.io.*;
import java.util.Scanner;

public class StreamMain4 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        // file을 읽을 때 글자 단위로 읽는다.
        FileWriter fileWriter = null;

        BufferedReader br = new BufferedReader(fileReader);
        // fileReader보다 성능이 더 좋다.

        try {
            fileReader = new FileReader("D:\\workspace\\spring_workspace\\Hanwha_javabasic2\\hanwha_javabasic2\\src\\main\\java\\Day06\\StreamExample\\streamtest.txt");
            fileWriter = new FileWriter("D:\\workspace\\spring_workspace\\Hanwha_javabasic2\\hanwha_javabasic2\\src\\main\\java\\Day06\\StreamExample\\streamtestOutPutByReader.txt");

            int data = 0;

            while( (data = fileReader.read()) != -1) {
                System.out.println((char)data);
                fileWriter.write(data);
                /*
                    streamtestOutPutByReader.txt
                        -> "streamtest.txt" 저장
                */
            }
        } catch (FileNotFoundException e) {
            System.out.println("error1");
        } catch (IOException e) {
            System.out.println("error2");
        } finally {
            if(fileReader != null) {
                fileReader.close();
            }
            if(fileWriter != null) {
                fileWriter.close();
            }
        }

        /*
                s
                t
                r
                e
                a
                m
                t
                e
                s
                t
                .
                t
                x
                t
        */
    }
}
