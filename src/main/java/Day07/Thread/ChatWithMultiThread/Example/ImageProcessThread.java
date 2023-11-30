package Day07.Thread.ChatWithMultiThread.Example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ImageProcessThread extends Thread {
    Socket socket;

    public ImageProcessThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            while (true) {
                byte[] fileContents = new byte[(int)dataInputStream.readLong()];
                dataInputStream.readFully(fileContents);

                File destination = new File("D:\\workspace\\spring_workspace\\Hanwha_javabasic2\\hanwha_javabasic2\\src\\main\\resources\\img\\");
                FileOutputStream fileOutputStream = new FileOutputStream(destination);
                DataOutputStream dataOutputStream2 = new DataOutputStream(fileOutputStream);
                dataOutputStream2.write(fileContents);
                dataOutputStream2.flush();
                dataOutputStream2.close();

                System.out.println(destination.getName()+" 파일 다운로드가 완료되었습니다.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
