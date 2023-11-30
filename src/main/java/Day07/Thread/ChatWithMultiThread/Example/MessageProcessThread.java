package Day07.Thread.ChatWithMultiThread.Example;

import java.io.*;
import java.net.Socket;

public class MessageProcessThread extends Thread {
    Socket socket;

    public MessageProcessThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                String message = bufferedReader.readLine();
                System.out.println("Client: " + message);

                for (int i = 0; i < MultiThreadServer.socketList.size(); i++) {
                    Socket clientSocket = MultiThreadServer.socketList.get(i);
                    OutputStream outputStream = clientSocket.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    bufferedWriter.write(message+"\n");
                    bufferedWriter.flush();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
