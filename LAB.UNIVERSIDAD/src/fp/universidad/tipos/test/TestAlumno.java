package fp.universidad.tipos.test;
import java.time.LocalDate;
import fp.universidad.tipos.Alumno;
import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.TipoAsignatura;
import fp.universidad.tipos.Convocatoria;

public class TestAlumno {

	public static void main(String[] args) {
		Asignatura redesComputadores = new Asignatura("Redes de Computadores", "2066509", 1.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2025);
		Asignatura diseñoDatos = new Asignatura("Diseño de Datos y Algoritmos", "2066508", 1.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2025);
		Asignatura fisica = new Asignatura("Fundamentos Físicos de la Informática", "2060009", 1.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2025);
		Asignatura estructuras = new Asignatura("Estructura de Computadores", "2060008", 1.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2025);
		
		Asignatura algebraBasica = new Asignatura("Álgebra Básica", "1680008", 1.0, TipoAsignatura.ANUAL, 2025);
		Asignatura calculoNumerico = new Asignatura("Cálculo Numérico I", "1680009", 1.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2025);
		
		Alumno jesus = new Alumno("53916213G", "Jesús", "Valenzuela Alves", LocalDate.of(2006, 12, 3), "jesvalalv@alum.us.es");
		Alumno ana = new Alumno("59238943K", "Ana", "Bohueles Zorrilla", LocalDate.of(2006, 5, 13), "anabo@alum.us.es");
				
		System.out.println("PRUEBA DEL TIPO ALUMNO");
		System.out.println("Representación del tipo Alumno ===> " + jesus);
		System.out.println("DNI del alumno ===> " + jesus.getDni());
		System.out.println("Nombre del alumno ===> " + jesus.getNombre());
		System.out.println("Apellido del alumno ===> " + jesus.getApellidos());
		System.out.println("Fecha de nacimiento del alumno ===> " + jesus.getFechaNacimiento());
		System.out.println("Email del alumno ===> " + jesus.getEmail());
		
		ana.matriculaAsignatura(algebraBasica);
		ana.matriculaAsignatura(calculoNumerico);
		
		System.out.println("Método compareTo del tipo Alumno ===> " + jesus.compareTo(ana));
		System.out.println("Método equals() del tipo Alumno ===> " + jesus.equals(ana));
		System.out.println("Asignaturas en las que está matriculado el alumno antes del método matriculaAsignatura() ===> " + jesus.getAsignaturas());
		
		jesus.matriculaAsignatura(estructuras);
		jesus.matriculaAsignatura(fisica);
		jesus.matriculaAsignatura(redesComputadores);
		jesus.matriculaAsignatura(diseñoDatos);

		System.out.println("Asignaturas en las que está matriculado el alumno después del método matriculaAsignatura() ===> " + jesus.getAsignaturas());
		System.out.println("Curso del alumno ===> " + jesus.getCurso());

		jesus.eliminaAsignatura(fisica);
		try {
		jesus.eliminaAsignatura(algebraBasica);
		} catch (IllegalArgumentException e) {
			System.out.println("Asignaturas en las que está matriculado el alumno después del método eliminaAsignatura() ===> EL ALUMNO NO ESTÁ MATRICULADO EN " + algebraBasica.nombre().toUpperCase() + ". EL CÓDIGO SIGUE.");
		}
		
		System.out.println("Asignaturas en las que está matriculado el alumno después del método eliminaAsignatura() ===> " + jesus.getAsignaturas());
		System.out.println("Expediente del alumno después del método evaluaAsignatura() ===> " + jesus.getExpediente());

		jesus.evaluaAsignatura(estructuras, Convocatoria.PRIMERA, 9.8, estructuras.curso(), true);
		jesus.evaluaAsignatura(redesComputadores, Convocatoria.TERCERA, 9.0, redesComputadores.curso(), true);
		jesus.evaluaAsignatura(estructuras, Convocatoria.SEGUNDA, 6.5, estructuras.curso(), false);
		
		System.out.println("Expediente del alumno después del método evaluaAsignatura() ===> " + jesus.getExpediente());
		System.out.println("Método estaMatriculadoEn() del tipo Alumno ===> " + jesus.estaMatriculadoEn(fisica));
	}
}