package Day07.Thread.ChatWithMultiThread.reference;

/**
 * https://ssons.tistory.com/50 참고
 */
public class ChatServerMain {
    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.giveAndTake();
    }
}
