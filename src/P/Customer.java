package P;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {
// Customer_App 과 연결하는 과정에서 이제 필요 없어져서 커멘드 처리 함
//	public static void main(String[] args) {
//		createTable();
//		createCustomer("Dan","123456789","Male","23","Note EX..");
//		ArrayList<String> list = getCustomers();
		// 출력
//		for (String item: list) {
//			System.out.println(item);
//		}
		// create
//		createCustomer("Niki","010369758","Female","17","... one two ...");
		
		// 출력
//		list = getCustomers();
//		for (String item: list) {
//			System.out.println(item);
//		}
//	}
	
	public static String[][] getCustomers() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT name, phone, gender, age, note FROM customer");

			// 불러 온 결과 저장
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			// 다음 데이터가 없을 때까지 순차로 데이터를 불러와 저장
			while(results.next()) {
				list.add(new String[] {
						results.getString("name"),
						results.getString("phone"),
						results.getString("gender"),
						results.getString("age"),
						results.getString("note")
						});
			}
			System.out.println("The data has been fetched");
			//return 하기 전 
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void createCustomer (String name, String phone, String gender, String age, String note) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
			+ "INSERT INTO customer"
					+ "(name, phone, gender, age, note)"
					+ "VALUE "
					+ "('"+name+"','"+phone+"','"+gender+"','"+age+"','"+note+"')");
			// ('name','phone','gender','age','note')
			insert.executeUpdate();			
			System.out.println("The data has been saved!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("###insert###");
		}
		
	}
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+ "customer(id int NOT NULL AUTO_INCREMENT, "
					+ "name varChar(255), "
					+ "phone varChar(255), "
					+ "gender varChar(255), "
					+ "age varChar(255), "
					+ "note varChar(255), "
					+ "PRIMARY KEY(id))");
			create.execute();
			System.out.println("Table successfully create");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("###create###");
		}
		
	}
	
	
	// 연결 (connection)
	public static Connection getConnection() {
		try {
			//이메일 참고
			String driver = "com.mysql.cj.jdbc.Driver";
			//"jdbc:mysql://{Database Host}:3306/{Database Name}";	
			String url = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9600939";
			String user = "sql9600939";
			String pass = "MMKllthN26";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("The Connection Successful");
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
