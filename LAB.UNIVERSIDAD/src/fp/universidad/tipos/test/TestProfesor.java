package fp.universidad.tipos.test;
import fp.universidad.tipos.Profesor;
import fp.universidad.tipos.TipoAsignatura;
import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Categoria;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DayOfWeek;

public class TestProfesor {

	public static void main(String[] args) {		
		Profesor paquirri = new Profesor("32423567E", "Francisco José", "Jacòme Maura", LocalDate.of(1989, 5, 12), Categoria.TITULAR);
		Profesor collarin = new Profesor("23032095K", "Francisco José", "Galán Cortés", LocalDate.of(1965, 7, 14), Categoria.AYUDANTE_DOCTOR);
		
		System.out.println("PRUEBA DEL TIPO PROFESOR");
		System.out.println("Representación del tipo Profesor ===> " + paquirri);
		System.out.println("DNI del profesor ===> " + paquirri.getDni());
		System.out.println("Nombre del profesor ===> " + paquirri.getNombre());
		System.out.println("Apellidos del profesor ===> " + paquirri.getApellidos());
		System.out.println("Fecha de nacimiento del profesor ===> " + paquirri.getFechaNacimiento());
		System.out.println("Email del profesor ===> " + paquirri.getEmail());
		System.out.println("Edad del profesor ===> " + paquirri.getEdad());
		System.out.println("Categoría del profesor ===> " + paquirri.getCategoria());
		System.out.println("Método equals() del tipo Profesor ===> " + paquirri.equals(collarin));
		System.out.println("Método compareTo() del tipo Profesor ===> " + paquirri.compareTo(collarin));
		System.out.println("Tutorias del profesor antes del método nuevaTutoria() ===> " + paquirri.getTutorias());
		
		try {
		paquirri.nuevaTutoria(LocalTime.of(13, 0), 50, DayOfWeek.SUNDAY);
		} catch (IllegalArgumentException e) {
			System.out.println("Método nuevaTutoria() ===> LAS TUTORÍAS SOLO SE PUEDEN DAR EN DÍAS LECTIVOS. EL CÓDIGO CONTINUA.");
		}
		
		paquirri.nuevaTutoria(LocalTime.of(13, 0), 50, DayOfWeek.THURSDAY);
		paquirri.nuevaTutoria(LocalTime.of(13, 50), 35, DayOfWeek.MONDAY);

		
		
		System.out.println("Tutorias del profesor despues del método nuevaTutoria() ===> " + paquirri.getTutorias());
		
		paquirri.borraTutoria(LocalTime.of(13, 0), DayOfWeek.THURSDAY);
		
		System.out.println("Tutorias del profesor despues del método borrarTutoria() ===> " + paquirri.getTutorias());
		
		paquirri.borraTutorias();
		
		System.out.println("Tutorias del profesor despues del método borraTutorias() ===> " + paquirri.getTutorias());
		System.out.println("Asignaturas del profesor antes del método imparteAsignaturas() ===> " + paquirri.getAsignaturas());
		System.out.println("Dedicación del profesor antes del método imparteAsignaturas() ===> " + paquirri.getCreditos());
		
		Asignatura fisica = new Asignatura("Fundamentos Físicos de la Informática", "2060009", 1.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2025);
		Asignatura estructuras = new Asignatura("Estructura de Computadores", "2060008", 1.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2025);
		
		paquirri.imparteAsignatura(fisica, 8.0);
		paquirri.imparteAsignatura(estructuras, 6.0);
		
		System.out.println("Asignaturas del profesor después del método imparteAsignaturas() ===> " + paquirri.getAsignaturas());
		System.out.println("Dedicación del profesor después del método imparteAsignaturas() ===> " + paquirri.getCreditos());
		System.out.println("Método dedicacionAsignatura del tipo Profesor ===> " + paquirri.dedicacionAsignatura(fisica));
		System.out.println("Método getDedicacionTotal del tipo Profesor ===> " + paquirri.getDedicacionTotal());

		paquirri.eliminaAsignatura(estructuras);

		System.out.println("Asignaturas del profesor después del método eliminaAsignatura() ===> " + paquirri.getAsignaturas());
		System.out.println("Dedicación del profesor después del método eliminaAsignatura() ===> " + paquirri.getCreditos());



		






		
	}
}