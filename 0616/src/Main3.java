import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main3 {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/world";
		String username = "root";
		String password = "root";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 커넥션 생성
			conn = DriverManager.getConnection(url, username, password);
			// 쿼리문 작성
			String query = "select * from country where code in ('kor', 'jpn', 'chn')";
			// 쿼리문 실행할 Statement 객체 생성
			stmt = conn.createStatement();
			// 쿼리문 실행해서 ResultSet에 반환
			rs = stmt.executeQuery(query);
			// 한 row 씩 살펴보기
			while (rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				double LifeExpectancy = rs.getDouble("LifeExpectancy");
				int indepyear = rs.getInt("indepyear");

				System.out.printf("code : %s , name : %s, LifeExpectancy : %f, indepyear : %d\n", code, name,
						LifeExpectancy, indepyear);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
