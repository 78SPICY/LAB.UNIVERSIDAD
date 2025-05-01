package fp.universidad.tipos.test;

import fp.universidad.tipos.Espacio;
import fp.universidad.tipos.TipoEspacio;

public class TestEspacio {

	public static void main(String[] args) {
		Espacio H010 = new Espacio(TipoEspacio.TEORIA, "H0.10", 80, 1);
		Espacio A213 = new Espacio(TipoEspacio.EXAMEN, "A2.13", 200, 3);
	
		System.out.println("PRUEBA DEL TIPO ESPACIO");
		System.out.println("Representación del tipo Espacio ===> " + H010);
		System.out.println("Tipo del tipo Espacio ===> " + H010.getTipoEspacio());
		System.out.println("Nombre del tipo Espacio ===> " + H010.getNombre());
		System.out.println("Capacidad del tipo Espacio ===> " + H010.getCapacidad());
		System.out.println("Planta del tipo Espacio ===> " + H010.getPlanta());
		System.out.println("Hashcode del tipo Espacio ===> " + H010.hashCode()); 
		System.out.println("Método compareTo() del tipo Espacio ===> " + H010.compareTo(A213));
		System.out.println("Método equals() del tipo Espacio ===> " + H010.equals(A213));
		System.out.println();
		System.out.println();
		
		Espacio H010ConString = new Espacio("H0.10, 80, 1, TEORIA");

		System.out.println("Representación del tipo Espacio a partir de un String ===> " + H010ConString);
		System.out.println("Tipo del tipo Espacio a partir de un String ===> " + H010.getTipoEspacio());
		System.out.println("Nombre del tipo Espacio a partir de un String ===> " + H010.getNombre());
		System.out.println("Capacidad del tipo Espacio a partir de un String ===> " + H010.getCapacidad());
		System.out.println("Planta del tipo Espacio a partir de un String ===> " + H010.getPlanta());
		System.out.println("Hashcode del tipo Espacio a partir de un String ===> " + H010.hashCode()); 

	}
}