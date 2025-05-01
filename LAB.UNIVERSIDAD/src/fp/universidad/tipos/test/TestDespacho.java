package fp.universidad.tipos.test;
import fp.universidad.tipos.Profesor;
import fp.universidad.tipos.TipoEspacio;
import fp.universidad.tipos.Categoria;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import fp.universidad.tipos.Despacho;

public class TestDespacho {

	public static void main(String[] args) {
		Profesor paquirri = new Profesor("32423567E", "Francisco José", "Jacòme Maura", LocalDate.of(1989, 5, 12), Categoria.TITULAR);
		paquirri.nuevaTutoria(LocalTime.of(12, 0), 30, DayOfWeek.MONDAY);
		paquirri.nuevaTutoria(LocalTime.of(12, 30), 60, DayOfWeek.TUESDAY);
		paquirri.nuevaTutoria(LocalTime.of(14, 0), 45, DayOfWeek.WEDNESDAY);
		
		Profesor collarin = new Profesor("23032095K", "Francisco José", "Galán Cortés", LocalDate.of(1965, 7, 14), Categoria.AYUDANTE_DOCTOR);
		paquirri.nuevaTutoria(LocalTime.of(13, 0), 50, DayOfWeek.THURSDAY);
		paquirri.nuevaTutoria(LocalTime.of(14, 30), 55, DayOfWeek.FRIDAY);
		
		Set<Profesor> profesores = new HashSet<>();
		profesores.add(paquirri);
		profesores.add(collarin);
		
		Despacho despacho1 = new Despacho("A3.21", 5, 3, profesores);
		
		System.out.println("PRUEBA DEL TIPO DESPACHO");
		System.out.println("Representación del tipo Despacho ===> " + despacho1.toString());
		System.out.println("Nombre del despacho ===> " + despacho1.getNombre());
		System.out.println("Capacidad del despacho ===> " + despacho1.getCapacidad());
		System.out.println("Planta del despacho ===> " + despacho1.getPlanta());
		System.out.println("Profesores del despacho ===> " + despacho1.getProfesores());
		
		try {
		despacho1.setTipoEspacio(TipoEspacio.EXAMEN);
		} catch (Exception e) {
			System.out.println("Método setTipoEspacio del tipo Despacho ===> NO SE PUEDE CAMBIAR EL TIPO DEL DESPACHO. EL CÓDIGO SIGUE.");
		}

		Profesor laJeanes = new Profesor("23083245J", "Maria", "Fernandez Lebrón", LocalDate.of(1963, 10, 6), Categoria.TITULAR);
		Despacho despacho2 = new Despacho("B4.32", 5, 4, laJeanes);
		
		System.out.println("Método equals() del tipo Despacho ===> " + despacho1.equals(despacho2));
		System.out.println();
		System.out.println();
		
		Despacho despacho3 = new Despacho("B2.23, 6, 2");
		System.out.println("Representación del tipo Despacho a partir de un String ===> " + despacho3.toString());
		System.out.println("Nombre del despacho a partir de un String ===> " + despacho3.getNombre());
		System.out.println("Capacidad del despacho a partir de un String ===> " + despacho3.getCapacidad());
		System.out.println("Planta del despacho a partir de un String ===> " + despacho3.getPlanta());
	}
}