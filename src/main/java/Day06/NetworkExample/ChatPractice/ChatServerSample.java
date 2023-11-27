package Day06.NetworkExample.ChatPractice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServerSample {
    public static void main(String[] args) {
        try {
            // 포트를 LISTEN 상태로 변경
            ServerSocket serverSocket = new ServerSocket(9876);
            // serverSocket.accept()는 클라이언트 쪽에서 new Socket()이 실행되어야 끝남
            Socket clientSocket = serverSocket.accept();


            // 여기서부터 보내는 코드
            OutputStream outputStream = clientSocket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner scanner = new Scanner(System.in);
            System.out.print("클라이언트에게 보낼 내용을 입력해주세요 : ");
            String message = scanner.nextLine();

            bufferedWriter.write(message + "\n");
            bufferedWriter.flush();
            // 여기까지 보내는 코드

            // 여기서부터 받는 코드
            InputStream inputStream = clientSocket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String data = bufferedReader.readLine();
            System.out.println(data);
            // 여기까지 받는 코드

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
