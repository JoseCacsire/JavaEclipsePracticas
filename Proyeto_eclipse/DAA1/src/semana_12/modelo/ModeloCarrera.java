package semana_12.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

import java.sql.CallableStatement;

import semana_12.entidad.Carrera;
import semana_12.util.Conexion;

public class ModeloCarrera {
	
	public HashMap<String,Integer> listarCarreras(){
		Connection cn=null;
		CallableStatement cs=null;
		ResultSet rs = null;
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		
		try {
			cn=Conexion.getConexion();
			String sql = "{call usp_ListaCarreras()}";
			cs = cn.prepareCall(sql);
			rs = cs.executeQuery();
			
			Carrera objCarrera= null;
			while (rs.next()) {
				objCarrera = new Carrera();
				objCarrera.setCodigo(rs.getInt("codigo"));
				objCarrera.setNombre(rs.getString("nombre"));
				map.put(objCarrera.getNombre(), objCarrera.getCodigo());
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
		return map;
	}

}
