package fp.universidad.tipos.test;

import java.time.LocalDate;
import fp.universidad.tipos.*;

public class TestPersona {

	public static void main(String[] args) {
		Persona rosa = new Persona("52319013B", "Rosa", "Melano Fuerte", LocalDate.of(2006, 12, 3));	
		Persona ana = new Persona("25915704V", "Ana", "Bohueles Zorrilla", LocalDate.of(1947, 4, 12), "anabohueles@hotmail.com");
		
		System.out.println("PRUEBA DEL TIPO PERSONA");
		System.out.println("Representación del tipo Persona ===> " + rosa);
		System.out.println("DNI del tipo Persona ===> " + rosa.getDni());
		System.out.println("Nombre del tipo Persona ===> " + rosa.getNombre());
		System.out.println("Apellido del tipo Persona ===> " + rosa.getApellidos());
		System.out.println("Fecha de nacimiento del tipo Persona ===> " + rosa.getFechaNacimiento());
		System.out.println("Email de nacimiento del tipo Persona antes de añadir un correo electrónico ===> " + rosa.getEmail());
		
		rosa.setEmail("rosamelanofuerte@gmail.com");
		
		System.out.println("Email de nacimiento del tipo Persona después de añadir un correo electrónico ===> " + rosa.getEmail());
		System.out.println("Edad del tipo Persona ===> " + rosa.getEdad());
		System.out.println("Hashcode del tipo Persona ===> " + rosa.hashCode());
		System.out.println("Método compareTo del tipo Persona ===> " + rosa.compareTo(ana));
		System.out.println("Método equals() del tipo Persona ===> " + rosa.equals(ana));
		
		System.out.println();
		System.out.println();

		Persona rosaConString = new Persona("53916213G, Jesús, Valenzuela Alves, 3/12/2006");

		System.out.println("Representación del tipo Persona con el constructor con String ===> " + rosaConString);
		System.out.println("Email de nacimiento del tipo Persona con el constrcutor con String ===> " + rosa.getEmail());

	}
}