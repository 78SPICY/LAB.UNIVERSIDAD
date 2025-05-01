package fp.universidad.tipos.test;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Categoria;
import fp.universidad.tipos.Departamento;
import fp.universidad.tipos.Profesor;
import fp.universidad.tipos.TipoAsignatura;

public class TestDepartamento {

	public static void main(String[] args) {
		Departamento lenguajesSistemas = new Departamento("Lenguajes y Sistemas Informáticos");
		Departamento matesAplicadas = new Departamento("Departamento de Matemáticas Aplicadas");
		System.out.println("PRUEBA DEL TIPO DEPARTAMENTO");
		System.out.println("Representación del departamento ===> " + lenguajesSistemas.toString());
		System.out.println("Método equals() del tipo Departamento ===> " + lenguajesSistemas.equals(matesAplicadas));
		System.out.println("Método compareTo() del tipo Departamento ===> " + lenguajesSistemas.compareTo(matesAplicadas));
		System.out.println("Profesores del departamento antes del método nuevoProfesor() ===> " + lenguajesSistemas.getConjuntoProfesores());
		System.out.println("Asignaturas del departamento antes del método nuevoAsignatura() ===> " + lenguajesSistemas.getConjuntoAsignaturas());

		
		Profesor paquirri = new Profesor("32423567E", "Francisco José", "Jacòme Maura", LocalDate.of(1989, 5, 12), Categoria.TITULAR);
		Profesor collarin = new Profesor("23032095K", "Francisco José", "Galán Cortés", LocalDate.of(1965, 7, 14), Categoria.AYUDANTE_DOCTOR);
		
		lenguajesSistemas.nuevoProfesor(collarin);
		lenguajesSistemas.nuevoProfesor(paquirri);
		
		Asignatura fisica = new Asignatura("Fundamentos Físicos de la Informática", "2060009", 1.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2024);
		Asignatura estructuras = new Asignatura("Estructura de Computadores", "2060008", 1.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2024);
		
		lenguajesSistemas.nuevaAsignatura(fisica);
		lenguajesSistemas.nuevaAsignatura(estructuras);

		System.out.println("Profesores del departamento después del método nuevoProfesor() ===> " + lenguajesSistemas.getConjuntoProfesores());
		System.out.println("Asignaturas del departamento después del método nuevoAsignatura() ===> " + lenguajesSistemas.getConjuntoAsignaturas());
		
		paquirri.nuevaTutoria(LocalTime.of(13, 0), 50, DayOfWeek.THURSDAY);
		paquirri.nuevaTutoria(LocalTime.of(13, 50), 35, DayOfWeek.MONDAY);
		
		System.out.println("Tutorías de los profesores del departamento antes del método borraTutorias() ===> " + paquirri.getTutorias());

		lenguajesSistemas.borraTutorias();
		
		System.out.println("Tutorías de los profesores del departamento después del método borraTutorias() ===> " + paquirri.getTutorias());
		
		


		
		

		

	}

}
