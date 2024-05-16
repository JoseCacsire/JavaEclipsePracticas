package ef.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
	public static Connection getConexion() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen?useSSL=false","root","1234");
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception ----> : " + ex.getMessage());
		}
		return cn;
	}
}
