package fp.universidad.tipos.test;

import fp.universidad.tipos.Tutoria;
import java.time.LocalTime;

public class TestTutoria {

	public static void main(String[] args) {
		Tutoria tutoriaMiercoles = new Tutoria('X', LocalTime.of(12, 0), LocalTime.of(12, 30));
		Tutoria tutoriaMartes = new Tutoria('M', LocalTime.of(12, 30), 30);
				
		System.out.println("PRUEBA DEL TIPO TUTORÍA");
		System.out.println("Representación del tipo Tutoría ===> " + tutoriaMiercoles);
		System.out.println("Dia de la semana del tipo Tutoría ===> " + tutoriaMiercoles.getDiaSemana());
		System.out.println("Hora de comienzo del tipo Tutoría ===> " + tutoriaMiercoles.getHoraComienzo());
		System.out.println("Hora de finalización del tipo Tutoría ===> " + tutoriaMiercoles.getHoraFin());
		System.out.println("Duración del tipo Tutoría ===> " + tutoriaMiercoles.getDuracion());
		System.out.println("Hashcode del tipo Tutoría ===> " + tutoriaMiercoles.hashCode());
		System.out.println("Método compareTo() del tipo Tutoría ===> " + tutoriaMiercoles.compareTo(tutoriaMartes));
		System.out.println("Método equals() del tipo Tutoría ===> " + tutoriaMiercoles.equals(tutoriaMartes));
	}
}