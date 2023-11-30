package Day07.Thread.ChatWithMultiThread.Example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiThreadServer {
    static List<Socket> socketList = new ArrayList<Socket>();
    // 여러 사람들의 정보가 여기에 저장됨.

    public static void main(String[] args) throws IOException {
        int port = 9991;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("서버 시작");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(clientSocket.getInetAddress()+ " 접속");
                socketList.add(clientSocket);
                Thread thread = new MessageProcessThread(clientSocket);
                thread.start();

                Thread thread2 = new ImageProcessThread(clientSocket);
                thread2.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
