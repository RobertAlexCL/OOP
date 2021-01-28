package conectorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConexion {
	
		public static Connection getConexion() {
			
			Connection con=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost/voluntarios";
				String user = "root";
				String password= "";
				con= DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al cargar el Driver");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error con la BD");
				e.printStackTrace();
			}
			return con;
		}
	    
	}

