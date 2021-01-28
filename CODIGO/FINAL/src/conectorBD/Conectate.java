package conectorBD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectate {
	private String driver="com.mysql.cj.jdbc.Driver";
	private String cadenaConexion="jdbc:mysql://127.0.0.1/volun";
	private String user="root";
	private String password ="";
	public Connection con;
	
	public Conectate() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(cadenaConexion, user, password);
			System.out.println("Conectado con base de datos");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al establecer conexion con  bd.");
			e.printStackTrace();
		}
	
	}
	
}
