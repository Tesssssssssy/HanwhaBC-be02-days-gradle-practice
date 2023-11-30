package Day08;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    public void doGet(HttpRequest request, HttpServletResponse response) throws IOException {
        System.out.println("클라이언트가 웹 브라우저로 클래스 파일을 실행");
    }
}
