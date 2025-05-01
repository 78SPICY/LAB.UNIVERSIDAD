package fp.universidad.tipos.test;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Convocatoria;
import fp.universidad.tipos.Nota;
import fp.universidad.tipos.TipoAsignatura;
import fp.universidad.tipos.test.TestNota;

public class TestNota {

	public static void main(String[] args) {
		Asignatura fisica = new Asignatura("Fundamentos Físicos de la Informática", "2060009", 1.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2024);
		Asignatura estructuras = new Asignatura("Estructura de Computadores", "2060008", 1.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2024);
		
		Nota notaFisica = new Nota(fisica, fisica.curso(), Convocatoria.PRIMERA, 8.0, false);
		Nota notaEstructuras = new Nota(estructuras, estructuras.curso(), Convocatoria.SEGUNDA, 9.0, true);
				
		System.out.println("PRUEBA DEL TIPO NOTA");
		System.out.println("Representación del tipo Nota ===> " + notaFisica);
		System.out.println("Asignatura del tipo Nota ===> " + notaFisica.asignatura());
		System.out.println("Curso del tipo Nota ===> " + notaFisica.curso());
		System.out.println("Convocatoria del tipo Nota ===> " + notaFisica.convocatoria());
		System.out.println("Valor del tipo Nota ===> " + notaFisica.valor());
		System.out.println("Mención de honor del tipo Nota ===> " + notaFisica.mencionHonor());
		System.out.println("Hashcode del tipo Nota ===> " + notaFisica.hashCode());
		System.out.println("Método toCompare() del tipo Nota ===> " + notaFisica.compareTo(notaEstructuras));
		System.out.println("Método equals() del tipo Nota ===> " + notaFisica.equals(notaEstructuras));
	}
}