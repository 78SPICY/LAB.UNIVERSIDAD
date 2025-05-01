package fp.universidad.tipos.test;

import java.time.LocalDate;
import fp.universidad.tipos.*;

public class TestPersona {

	public static void main(String[] args) {
		Persona jesus = new Persona("53916213G", "Jesús", "Valenzuela Alves", LocalDate.of(2006, 12, 3));	
		Persona pedro = new Persona("25915704V", "Pedro", "Valenzuela Alves", LocalDate.of(1947, 4, 12), "pvg640@hotmail.com");
		
		System.out.println("PRUEBA DEL TIPO PERSONA");
		System.out.println("Representación del tipo Persona ===> " + jesus);
		System.out.println("DNI del tipo Persona ===> " + jesus.getDni());
		System.out.println("Nombre del tipo Persona ===> " + jesus.getNombre());
		System.out.println("Apellido del tipo Persona ===> " + jesus.getApellidos());
		System.out.println("Fecha de nacimiento del tipo Persona ===> " + jesus.getFechaNacimiento());
		System.out.println("Email de nacimiento del tipo Persona antes de añadir un correo electrónico ===> " + jesus.getEmail());
		
		jesus.setEmail("jvalenzuelaalves@gmail.com");
		
		System.out.println("Email de nacimiento del tipo Persona después de añadir un correo electrónico ===> " + jesus.getEmail());
		System.out.println("Edad del tipo Persona ===> " + jesus.getEdad());
		System.out.println("Hashcode del tipo Persona ===> " + jesus.hashCode());
		System.out.println("Método compareTo del tipo Persona ===> " + jesus.compareTo(pedro));
		System.out.println("Método equals() del tipo Persona ===> " + jesus.equals(pedro));
		
		System.out.println();
		System.out.println();

		Persona jesusConString = new Persona("53916213G, Jesús, Valenzuela Alves, 3/12/2006");

		System.out.println("Representación del tipo Persona con el constructor con String ===> " + jesusConString);
		System.out.println("Email de nacimiento del tipo Persona con el constrcutor con String ===> " + jesus.getEmail());

	}
}