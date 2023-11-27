package Day06.NetworkExample.ChatPractice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  Scanner로 입력 받고
 *  client -> server    파일 이름을 입력하면
 *  server -> client    파일을 보내준다.
 *  그리고 client가 이를 저장한다

 *  파일은 byte로 주고 받아야 한다.
 */

public class ChatServer2 {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(9998);
            Socket clientSocket = null;

            while(true) {
                System.out.println("클라이언트 접속 대기 중");
                clientSocket = serverSocket.accept();
                System.out.println(clientSocket.getInetAddress()+ " 접속");
                try {
                    while(true) {
                        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
                        DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());

                        File file = new File("D:\\workspace\\spring_workspace\\Hanwha_javabasic2\\hanwha_javabasic2\\src\\main\\java\\Day06\\NetworkExample\\ChatPractice\\freeImg2.jpg");
                        FileInputStream fileInputStream = new FileInputStream(file);
                        DataInputStream dataInputStream2 = new DataInputStream(fileInputStream);

                        byte[] filecontents = new byte[(int)file.length()];
                        dataInputStream2.readFully(filecontents);

                        dataOutputStream.writeLong(filecontents.length);
                        dataOutputStream.write(filecontents);
                        dataOutputStream.flush();
                    }
                } catch(Exception e){
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("연결 오류");
        }
    }
}
