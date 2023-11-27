package Day06.NetworkExample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMain {
    public static void main(String[] args) {
        /*  java엔 socket이 있다.
            어떤 운영체제이던 랜카드와 연결할 수 있는 socket이 있다.
            서버 소켓과 클라이언트 소켓이 있다.
            자바에서는 2개로 나누어져 있다.

            서버 소켓은 내 컴퓨터의 랜카드와 프로그램이랑 스트리밍, 즉 통로를 여는 것.
            내 프로그램을 다른 사람들이 찾아올 수 있어야 한다.
            port 번호를 써주면 된다.
        */

        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            /*
                ()안에 port 번호를 적으면 된다.
                ServerSocket이 애초에 생성자에 포트 번호를 넣도록 만들어져 있다.
                특정 port 번호를 listen 상태로 변경해 줌.
                왜...?
                    그냥 그렇게 만들어 놨으니까.
            */

            // 내 프로그램이랑 내 랜카드와의 통로가 열린 것.
            // 이 통로를 통해 누군가가 들어온다면 serverSocket을 통해 처리를 해줄 수 있다.

            Socket clientsocket = serverSocket.accept();
            // 변수를 만들고 받아서 사용한 것.
            // 변수를 만드는 건 객체 생성이 아님.
            // 확실하지 않지만 client가 들어올 때까지 무한 반복

            System.out.println(clientsocket.getInetAddress() + " 접속함");

            InputStream clientInputStream = clientsocket.getInputStream();
            // 문법적으로 method
            // 이 method는 InputStream 객체를 반환
            /// 나는 이 값을 또 사용하고 싶으면 InputStream 타입의 변수에 저장해야 함.

            int num = clientInputStream.read();
            System.out.println(num);
            // client가 write를 해야 출력할 수 있음. 그 때까지 기다리고 있음.


            OutputStream clientOutputStream = clientsocket.getOutputStream();
            clientOutputStream.write(200);
            // 이번엔 server가 client에 값 보냄


            // ServerSocket,. Socket 모두 stream
            // 닫아주어야 함.
            serverSocket.close();
            clientsocket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
