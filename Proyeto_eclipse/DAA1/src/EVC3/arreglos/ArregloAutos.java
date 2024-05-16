package EVC3.arreglos;

import java.util.ArrayList;

import EVC3.clases.Auto;

public class ArregloAutos {
	private ArrayList<Auto> aAuto;
	public ArregloAutos() {
		aAuto = new ArrayList<Auto>();
		aAuto.add(new Auto(100,35000,"NEGRO","HYUNDAI","TUCSON"));
		aAuto.add(new Auto(101,55000,"ROJO","TOYOTA","TUCSON"));
		aAuto.add(new Auto(102,65000,"DORADO","FORD","TUCSON"));
		aAuto.add(new Auto(103,55700,"AZUL","HONDA","TUCSON"));
		aAuto.add(new Auto(104,45000,"MORADO OSCURO","TOYOTA","TUCSON"));
		
	}
	public int tamanio() {
		return aAuto.size();
	}
	
	public Auto obtener(int posicion) {
		return aAuto.get(posicion);
	}
	
	public void adicionar(Auto  objeto) {
		aAuto.add(objeto);
	}
	
	public void eliminarAlFinal() {
		aAuto.remove(tamanio()-1);
	}
	
	public void eliminarTodo() {
		aAuto.clear();
	}
	
	public Auto  buscar(int codigo) {
		for (int i=0;i<tamanio();i++) {
			if (obtener(i).getCodigo()==codigo) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public void eliminar(Auto  objeto) {
		aAuto.remove(objeto);
	}
	
}
