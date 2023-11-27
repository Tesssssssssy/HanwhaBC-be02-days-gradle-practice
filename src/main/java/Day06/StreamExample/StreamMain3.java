package Day06.StreamExample;

import java.io.*;
import java.util.Scanner;

public class StreamMain3 {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = null;
        BufferedInputStream bis = new BufferedInputStream(fileInputStream);

        try {
            fileInputStream = new FileInputStream("D:\\workspace\\spring_workspace\\Hanwha_javabasic2\\hanwha_javabasic2\\src\\main\\java\\Day06\\StreamExample\\streamtest.txt");

            int data = 0;

            while ((data = bis.read()) != -1) {
                System.out.println((char) data);
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
            if (bis != null) {
                bis.close();
            }
        }
    }
}
