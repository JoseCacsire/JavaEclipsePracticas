package semana_11.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import semana_11.entidad.Alumno;
import semana_11.util.Conexion;

public class ModeloAlumno {
	
	public ArrayList<Alumno> listarAlumnos(){
		Connection cn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Alumno> alu = new ArrayList<Alumno>();
		
		try {
			//Establece la conexión con MySql
			cn = Conexion.getConexion();
			//Indica la sentencia que se va a ejecutar 
			String sql = "select * from Alumno";
			ps = cn.prepareStatement(sql);
			//Como es un select se ejecuta con executeQuery
			//y almacena el resultado en un ResultSet
			rs = ps.executeQuery();
			//Creamos un objeto alumno vacío
			Alumno objAlu = null;
			while (rs.next()) {
				//Instanciamos el objeto alumno
				objAlu = new Alumno();
				//Seteamos los atributos del objeto Alumno
				objAlu.setCodigo(rs.getInt("codigo"));
				objAlu.setNombre(rs.getString("nombre"));
				objAlu.setCorreo(rs.getString("correo"));
				//Agregamos el objeto alumno al ArrayList 
				alu.add(objAlu);	
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if (ps!=null) ps.close();
				if (cn!=null) cn.close();
			}
			catch(Exception ex2) {
				ex2.printStackTrace();
			}
		}
		
		return alu;
	}
	
	public int insertarAlumno(Alumno a) {
		Connection cn=null;
		PreparedStatement ps=null;
		int rpta=0;
		
		try {
			//Abrir la conexión 
			cn=Conexion.getConexion();
			//Indicar la sentencia SQL a ejecutar
			String sql = "insert into Alumno values (null,?,?)";
			ps = cn.prepareStatement(sql);
			//Setear los parámetros de la sentencia SQL 
			ps.setString(1, a.getNombre());
			ps.setString(2, a.getCorreo());
			//Ejecutar la instrucción SQL
			rpta = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ps!=null) ps.close();
				if (cn!=null) cn.close();
			}
			catch(Exception ex2) {
				ex2.printStackTrace();
			}
		}
		return rpta;
	}

	public int actualizarAlumno(Alumno a) {
		Connection cn=null;
		PreparedStatement ps=null;
		int rpta=0;
		
		try {
			//Abrir la conexión 
			cn=Conexion.getConexion();
			//Indicar la sentencia SQL a ejecutar
			String sql = "update Alumno set nombre=?,correo=? where codigo=?";
			ps = cn.prepareStatement(sql);
			//Setear los parámetros de la sentencia SQL 
			ps.setString(1, a.getNombre());
			ps.setString(2, a.getCorreo());
			ps.setInt(3, a.getCodigo());
			//Ejecutar la instrucción SQL
			rpta = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ps!=null) ps.close();
				if (cn!=null) cn.close();
			}
			catch(Exception ex2) {
				ex2.printStackTrace();
			}
		}
		return rpta;
	}

	public int eliminarAlumno(int codigo) {
		Connection cn=null;
		PreparedStatement ps=null;
		int rpta=0;
		
		try {
			//Abrir la conexión 
			cn=Conexion.getConexion();
			//Indicar la sentencia SQL a ejecutar
			String sql = "delete from Alumno where codigo=?";
			ps = cn.prepareStatement(sql);
			//Setear los parámetros de la sentencia SQL 
			ps.setInt(1, codigo);
			//Ejecutar la instrucción SQL
			rpta = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ps!=null) ps.close();
				if (cn!=null) cn.close();
			}
			catch(Exception ex2) {
				ex2.printStackTrace();
			}
		}
		return rpta;
	}

}