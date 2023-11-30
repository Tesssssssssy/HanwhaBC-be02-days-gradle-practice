<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Tomcat9</title>
  </head>
  <body>
  <h1>Intellij Ultimate + Apache Tomcat9 + vm mysql-server</h1>
  <a> vm server8 - Student 테이블 조회</a>
  <table border="1">
    <%
      // JDBC 참조 변수 준비
      String url = "jdbc:mysql://110.110.110.170:3306/JdbcTest231130";
      String id = "ltw";
      String pw = "qwer1234";

      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      Class.forName("com.mysql.cj.jdbc.Driver");

      // 2) DB연결(DB url, DB id, DB pw)
      conn = DriverManager.getConnection(url, id, pw);

      String sql = "select * from Student";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        Integer num = rs.getInt("id");
        String s_name = rs.getString("s_name");
        Integer s_age = rs.getInt("s_age");

    %>
    <tr>
      <td><%=num%></td>
      <td><%=s_name%></td>
      <td><%=s_age%></td>
    </tr>
    <%
      }
    %>
  </table>
  <%
    // JDBC 자원 닫기
    rs.close();
    pstmt.close();
    conn.close();
  %>
  </body>
</html>
