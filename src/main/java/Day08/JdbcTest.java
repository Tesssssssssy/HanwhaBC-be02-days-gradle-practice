package Day08;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) {
        Connection conn = null; // DB 서버와 연결하는 객체
        Statement stmt = null;  // sql 실행하는 객체
        ResultSet resultSet = null;   // sql 실행 결과를 받아오는 객체

        try {
            // vm - server8
            String url = "jdbc:mysql://";
            String id = "";
            String pw = "";

            conn = DriverManager.getConnection(url, id, pw);
            // 연결 설정 완료
            // 이제 Statement 등의 객체 만들어서 사용 가능

            stmt = conn.createStatement();
            String sql = "select * from Student";
            resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Integer num = resultSet.getInt("id");
                String s_name = resultSet.getString("s_name");
                Integer s_age = resultSet.getInt("s_age");

                System.out.println(num + ". " + s_name + ", " + s_age);
            }

            /*
            resultSet.next();
            String s_name = resultSet.getString("s_name");
            System.out.println(s_name);

            Integer s_age = resultSet.getInt("s_age");
            System.out.println(s_age);

            kim
            10
            */

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
