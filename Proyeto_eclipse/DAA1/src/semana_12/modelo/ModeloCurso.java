package semana_12.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import semana_12.util.Conexion;
import semana_12.entidad.Curso;

public class ModeloCurso {
	
	public ArrayList<Curso> listaCursos(){
		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		ArrayList<Curso> arregloCurso = new ArrayList<Curso>();
		
		try {
			cn = Conexion.getConexion();
			String sql = "{call usp_ListaCursos()}";
			cs = cn.prepareCall(sql);
			rs = cs.executeQuery();
			
			Curso objCurso = null;
			while (rs.next()) {
				objCurso = new Curso();
				objCurso.setCodigo(rs.getInt("codigo"));
				objCurso.setNombre(rs.getString("nombre"));
				objCurso.setCreditos(rs.getInt("creditos"));
				objCurso.setCarrera(rs.getInt("carrera"));
				objCurso.setNombreCarrera(rs.getString("nombreCarrera"));
				arregloCurso.add(objCurso);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (cs!=null) cs.close();
				if (cn!=null) cn.close();
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return arregloCurso;
	}
	
	public int insertaCurso(Curso objCurso) {
		Connection cn=null;
		CallableStatement cs=null;
		int rpta=0;
		
		try {
			cn=Conexion.getConexion();
			String sql="{call usp_InsertaCurso(?,?,?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, objCurso.getNombre());
			cs.setInt(2, objCurso.getCreditos());
			cs.setInt(3, objCurso.getCarrera());
			rpta = cs.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (cs!=null) cs.close();
				if (cn!=null) cn.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rpta;
	}
	
	public int actualizaCurso(Curso objCurso) {
		Connection cn=null;
		CallableStatement cs=null;
		int rpta=0;
		
		try {
			cn=Conexion.getConexion();
			String sql="{call usp_ActualizaCurso(?,?,?,?)}";
			cs=cn.prepareCall(sql);
			cs.setInt(1,objCurso.getCodigo());
			cs.setString(2, objCurso.getNombre());
			cs.setInt(3, objCurso.getCreditos());
			cs.setInt(4, objCurso.getCarrera());
			rpta = cs.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (cs!=null) cs.close();
				if (cn!=null) cn.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rpta;
	}

	public int eliminaCurso(int codigo) {
		Connection cn=null;
		CallableStatement cs=null;
		int rpta=0;
		
		try {
			cn=Conexion.getConexion();
			String sql="{call usp_EliminaCurso(?)}";
			cs=cn.prepareCall(sql);
			cs.setInt(1,codigo);
			rpta = cs.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (cs!=null) cs.close();
				if (cn!=null) cn.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rpta;
	}

}
