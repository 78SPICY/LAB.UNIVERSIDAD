package fp.universidad.tipos.test;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.TipoAsignatura;

public class TestAsignatura {

	public static void main(String[] args) {
		Asignatura fisica = new Asignatura("Fundamentos Físicos de la Informática", "2060009", 1.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2024);
		Asignatura estructuras = new Asignatura("Estructura de Computadores", "2060008", 1.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2024);
		
		System.out.println("PRUEBA DEL TIPO ASIGNATURA");
		System.out.println("Representación del tipo Asignatura ===> " + fisica);
		System.out.println("Nombre del tipo Asignatura ===> " + fisica.nombre());
		System.out.println("Acrónimo del tipo Asignatura ===> " + fisica.getAcronimo());
		System.out.println("Código del tipo Asignatura ===> " + fisica.codigo());
		System.out.println("Créditos del tipo Asignatura ===> " + fisica.creditos());
		System.out.println("Tipo del tipo Asignatura ===> " + fisica.tipoAsignatura());
		System.out.println("Curso del tipo Asignatura ===> " + fisica.curso());
		System.out.println("Hashcode del tipo Asignatura ===> " + fisica.hashCode());
		System.out.println("Método compareTo() del tipo Asignatura ===> " + fisica.compareTo(estructuras));
		System.out.println("Método equals() del tipo Asignatura ===> " + fisica.equals(estructuras));
	}
}