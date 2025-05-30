package fp.universidad.tipos.test;
import java.util.Set;
import java.util.HashSet;
import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.TipoAsignatura;
import fp.universidad.tipos.Grado;

public class TestGrado {

	public static void main(String[] args) {
		Set<Asignatura> asignaturasObligatoriasRosa = new HashSet<>();
		Asignatura redesComputadores = new Asignatura("Redes de Computadores", "2060009", 1.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2025);
		Asignatura diseñoDatos = new Asignatura("Diseño de Datos y Algoritmos", "2060008", 1.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2025);
		asignaturasObligatoriasRosa.add(diseñoDatos);
		asignaturasObligatoriasRosa.add(redesComputadores);
		
		Set<Asignatura> asignaturasOptativasRosa = new HashSet<>();
		Asignatura logicaInformatica = new Asignatura("Lógica Informática", "2084319", 1.0, TipoAsignatura.ANUAL, 2025);
		asignaturasOptativasRosa.add(logicaInformatica);

		Set<Asignatura> asignaturasObligatoriasAna = new HashSet<>();
		Asignatura ingenSoft = new Asignatura("Introducción a la Ingeniería del Software y los Sistemas de Información", "1680008", 1.0, TipoAsignatura.ANUAL, 2025);
		Asignatura topologia = new Asignatura("Topologia", "1880009", 1.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2025);
		asignaturasObligatoriasAna.add(ingenSoft);
		asignaturasObligatoriasAna.add(topologia);
		
		Set<Asignatura> asignaturasOptativasAna = new HashSet<>();
		Asignatura analisisFunc = new Asignatura("Análisis Funcional", "3680438", 1.0, TipoAsignatura.ANUAL, 2025);
		asignaturasOptativasAna.add(analisisFunc);


		Grado ttII = new Grado("Grado en Ingeniería Informática - Tecnologías Informáticas", asignaturasObligatoriasAna, asignaturasOptativasAna, 108.0);
		Grado dobleGrado = new Grado("Doble Grado en Ingeniería Informática - Tecnologías Informáticas y en Matemáticas", asignaturasObligatoriasRosa, asignaturasOptativasRosa, 102.0);
		
		System.out.println("PRUEBA DEL TIPO GRADO");
		System.out.println("Representación del tipo Grado ===> " + ttII.toString());
		System.out.println("Nombre del grado ===> " + ttII.getNombre());
		System.out.println("Asignaturas optativas del grado ===> " + ttII.getAsignaturasOptativas());
		System.out.println("Asignaturas obligatorias del grado ===> " + ttII.getAsignaturasObligatorias());
		System.out.println("Todas las asignaturas del grado ===> " + ttII.getAsignaturas());
		System.out.println("Créditos totales del grado ===> " + ttII.calcularCreditosTotales());
		System.out.println("Créditos mínimos del grado ===> " + ttII.getMinimoCreditos());
		System.out.println("Método equals() del tipo Grado ===> " + ttII.equals(dobleGrado));
		System.out.println("Método compareTo() del tipo Grado ===> " + ttII.compareTo(dobleGrado));
		System.out.println("Asignatura específica del grado ===> " + ttII.getAsignatura("2060008"));
	}
}