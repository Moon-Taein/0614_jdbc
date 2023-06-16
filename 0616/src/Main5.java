import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main5 {
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
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();

			// 1번째 commit
			// 아메리카노 2000

			// 2번째 commit
			// 카페라떼 2500
			// 카페모카 2700

			// 3번째 commit
			// 모든 메뉴 가격 + 100
//			String query = "insert into coffee (name, price) values ('아메리카노', 2000);";
//			String query = "insert into coffee (name, price) values ('카페라떼', 2500), ('카페모카', 2700);";

			String query = "update coffee set price = price + 100;";
			int result = stmt.executeUpdate(query);
			System.out.println("executeUpdate 반환값: " + result);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
					System.out.println("연결을 해제하였습니다");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
