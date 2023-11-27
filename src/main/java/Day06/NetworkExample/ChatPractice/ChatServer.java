package Day06.NetworkExample.ChatPractice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *  - 한 명은 서버
 *     - Scanner로 console에서 입력한 내용을
 *     - 서버 → client
 *     - client → 서버
 *     - 일단 한 번씩 주고 받는 프로그램 만들기
 * - 한 명은 클라이언트
 */

public class ChatServer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader = null;
        PrintWriter printWriter = null;

        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        Scanner scanner = new Scanner(System.in);

        try {
            serverSocket = new ServerSocket(9999);

            System.out.println("client 연결 대기 중");
            clientSocket = serverSocket.accept();

            System.out.println(clientSocket.getInetAddress() + " 접속함");

            bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            printWriter = new PrintWriter(clientSocket.getOutputStream());

            String inputMessage = bufferReader.readLine();

            System.out.println("Client: " + inputMessage);
            System.out.print("전송하기>>> ");

            String serverMessage = scanner.nextLine();
            printWriter.println(serverMessage);
            printWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            scanner.close();
            clientSocket.close();
            serverSocket.close();
        }
    }
}
