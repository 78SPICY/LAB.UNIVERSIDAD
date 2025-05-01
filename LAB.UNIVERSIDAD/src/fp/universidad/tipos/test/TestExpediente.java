package fp.universidad.tipos.test;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Convocatoria;
import fp.universidad.tipos.Expediente;
import fp.universidad.tipos.Nota;
import fp.universidad.tipos.TipoAsignatura;

public class TestExpediente {

	public static void main(String[] args) {
		Asignatura fisica = new Asignatura("Fundamentos Físicos de la Informática", "2060009", 1.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2025);
		Asignatura estructuras = new Asignatura("Estructura de Computadores", "2060008", 1.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2025);
		Nota notaFisica = new Nota(fisica, fisica.curso(), Convocatoria.PRIMERA, 8.0);
		Nota notaEstructuras = new Nota(estructuras, estructuras.curso(), Convocatoria.SEGUNDA, 9.0, true);
		
		Expediente expedienteJesus = new Expediente();
		expedienteJesus.nuevaNota(notaFisica);
		expedienteJesus.nuevaNota(notaEstructuras);
		
		Asignatura algebraBasica = new Asignatura("Álgebra Básica", "1680008", 1.0, TipoAsignatura.ANUAL, 2025);
		Asignatura calculoNumerico = new Asignatura("Cálculo Numérico I", "1680009", 1.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2025);
		Nota notaAlgebra = new Nota(algebraBasica, algebraBasica.curso(), Convocatoria.TERCERA, 1.4);
		Nota notaCalculo = new Nota(calculoNumerico, calculoNumerico.curso(), Convocatoria.TERCERA, 0.5);
		
		Expediente expedienteOscar = new Expediente();
		expedienteOscar.nuevaNota(notaAlgebra);
		expedienteOscar.nuevaNota(notaCalculo);
		
		System.out.println("PRUEBA DEL TIPO EXPEDIENTE");
		System.out.println("Representación del tipo Expediente ===> " + expedienteJesus.toString());
		System.out.println("Notas del expediente ===> " + expedienteOscar.getListaNotas());
		System.out.println("Nota media del expediente ===> " + expedienteJesus.getNotaMedia());
		System.out.println("Método equals() del tipo Expediente teniendo dos expedientes del mismo tamaño ===> " + expedienteJesus.equals(expedienteOscar));
		
		Asignatura matesDiscretas = new Asignatura("Matemáticas Discretas", "1680010", 1.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2025);
		Nota notaDiscretas = new Nota(matesDiscretas, matesDiscretas.curso(), Convocatoria.TERCERA, 0.2);
		expedienteOscar.nuevaNota(notaDiscretas);
		
		System.out.println("Método equals() del tipo Expediente teniendo dos expedientes de tamaño distinto ===> " + expedienteJesus.equals(expedienteOscar));
	}
}