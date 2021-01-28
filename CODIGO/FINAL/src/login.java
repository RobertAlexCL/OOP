import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conectorBD.MySQLConexion;

/*Proyecto Voluntarios
  Fecha 281018
  Entrega 4
  Archivo login.java*/

public class login {
	
	public voluntario obtenerUsuario(usuario usu) {
		voluntario user=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			con=MySQLConexion.getConexion();
			String sql  ="select*from voluntarios where usuario=? and contrasena=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,usu.getUsuario());
			pst.setString(2,usu.getContra());
			
			rs=pst.executeQuery();
			
			while(rs.next()) {
				user =new voluntario(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(6));
			}
		}catch(Exception e){
			System.out.println("Error al obtener usuario.");
		}
		
		return user;
	}
}
