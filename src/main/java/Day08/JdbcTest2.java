package Day08;

import java.sql.*;

public class JdbcTest2 {
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

            String sname = "oh";
            int sage = 37;

            stmt = conn.createStatement();
            String sql = "INSERT INTO Student (s_name, s_age) VALUES ('" + sname + "', " + sage + ")";
            Integer result = stmt.executeUpdate(sql);    // executeUpdate는 int를 반환

            if (result > 0) {
                System.out.println("INSERT SUCCESS");
            } else {
                System.out.println("INSERT FAILURE");
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
