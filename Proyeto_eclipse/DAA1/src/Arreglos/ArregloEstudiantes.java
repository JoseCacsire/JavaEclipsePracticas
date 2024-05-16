package Arreglos;

import java.util.ArrayList;
import semana_09.clases.Estudiante;

public class ArregloEstudiantes {
	private ArrayList<Estudiante> aEstudiante;

	public ArregloEstudiantes() {
		aEstudiante = new ArrayList<Estudiante>();
		aEstudiante.add(new Estudiante(123, "Juan", 16, 17));
		aEstudiante.add(new Estudiante(231, "Carlos", 18, 20));
		aEstudiante.add(new Estudiante(423, "Luis", 13, 14));
		aEstudiante.add(new Estudiante(273, "Felipe", 10, 9));
		aEstudiante.add(new Estudiante(315, "Pablo", 17, 18));
	}
	
	public int tamanio() {
		return aEstudiante.size();
	}
	
	public Estudiante obtener(int posicion) {
		return aEstudiante.get(posicion);
	}
	
	public void adicionar(Estudiante objeto) {
		aEstudiante.add(objeto);
	}
	
	public void eliminarAlFinal() {
		aEstudiante.remove(tamanio()-1);
	}
	
	public void eliminarTodo() {
		aEstudiante.clear();
	}
	
	public Estudiante buscar(int codigo) {
		for (int i=0;i<tamanio();i++) {
			if (obtener(i).getCodigo()==codigo) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public void eliminar(Estudiante objeto) {
		aEstudiante.remove(objeto);
	}
	
}

