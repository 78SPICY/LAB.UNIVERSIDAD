package fp.universidad.tipos.test;

import java.util.HashSet;
import java.util.Set;
import fp.universidad.tipos.Centro;
import fp.universidad.tipos.Espacio;
import fp.universidad.tipos.TipoEspacio;


public class TestCentro {

	public static void main(String[] args) {
		Espacio H010 = new Espacio(TipoEspacio.TEORIA, "H0.10", 80, 1);
		Espacio A213 = new Espacio(TipoEspacio.EXAMEN, "A2.13", 200, 3);
		
		Set<Espacio> espacios1 = new HashSet<>();
		espacios1.add(H010);
		espacios1.add(A213);
		
		Espacio B013 = new Espacio(TipoEspacio.TEORIA, "B0.10", 120, 2);
		Espacio C213 = new Espacio(TipoEspacio.EXAMEN, "C2.13", 300, 3);
		
		Set<Espacio> espacios2 = new HashSet<>();
		espacios2.add(B013);
		
		Centro etsii = new Centro("Escuela Téncica Superior de Ingeniería Informática", "Av. de la Reina Mercedes, 41012 Sevilla", 4, 0, espacios1);
		Centro etsi = new Centro("Escuela Técnica Superior de Ingeniería", "Camino de los Descubrimientos, 41092 Sevilla", 5, 0, espacios2);
		
		System.out.println("PRUEBA DEL TIPO CENTRO");
		System.out.println("Representación del tipo Centro ===> " + etsii);
		System.out.println("Nombre del tipo Centro ===> " + etsii.getNombre());
		System.out.println("Dirección del tipo Centro ===> " + etsii.getDireccion());
		System.out.println("Cantidad de plantas del tipo Centro ===> " + etsii.getCantidadPlantas());
		System.out.println("Cantidad de sótanos del tipo Centro ===> " + etsii.getCantidadSotanos());
		System.out.println("Conjunto de espacios inicial ===> " + etsii.getConjuntoEspacio());
		
		etsii.nuevoEspacio(C213);
		
		System.out.println("Conjunto de espacios después del método nuevoEspacio() ===> " + etsii.getConjuntoEspacio());
		
		etsii.eliminarEspacio(A213);
		
		System.out.println("Conjunto de espacios después del método eliminarEspacio() ===> " + etsii.getConjuntoEspacio());
		System.out.println("Método toCompare() del tipo Centro ===> " + etsii.compareTo(etsi));
		System.out.println("Método equals() del tipo Centro ===> " + etsii.equals(etsi));
		System.out.println("Método getConteoEspacios ===> " + etsii.getConteosEspacios());
		System.out.println("Método getConteoDespachos ===> " + etsii.getDespachos());
		System.out.println("Método getConteoProfesores ===> " + etsii.getProfesores());
		System.out.println("Método getEspacioMayorCantidad ===> " + etsii.getEspacioMayorCapacidad());
	}
}