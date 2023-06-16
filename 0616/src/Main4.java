import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main4 {
	public static void main(String[] args) {
		// my_db 데이터베이스 테이블 생성
		// 테이블 커피
		// 이름
		// 가격

		String url = "jdbc:mysql://localhost:3306/my_db";
		String username = "root";
		String password = "root";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 커넥션 생성
			conn = DriverManager.getConnection(url, username, password);
			// 쿼리문 작성
			String query = "create table coffee ( no int auto_increment, name varchar(10) not null unique, price int not null default 2000, primary key (no));";
			stmt = conn.createStatement();
			// executeUpdate -> CRUD 관련
			// 결과 row count 반환
			int result = stmt.executeUpdate(query);
			System.out.println("executeUpdate 반환값: " + result);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
