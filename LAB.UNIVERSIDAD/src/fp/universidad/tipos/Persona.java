package fp.universidad.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import fp.utiles.Checkers;
import fp.utiles.Validators;

	// Atributos 
	public class Persona implements Comparable<Persona> {
		private String dni;
		private String nombre;
		private String apellidos;
		private LocalDate fechaNacimiento;
		private String email;
		
    // Constructor principal
    public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;

        
    // Restricciones
        // Se puede hacer definiendo métodos privados o se pueden definir las restricciones directamente
        Checkers.check("DNI inválido. Introduzca un DNI válido.", esDniValido(dni));
        Checkers.check("El email cuenta con un formato incorrecto. Introduzca uno válido.", esEmailValido(email));
        }
        
        private Boolean esDniValido(String dni) {
        	return dni.length() == 9 && Validators.sonDigitos(dni.substring(0, 8)) && Character.isLetter(dni.charAt(8)); 
         }
        
        private Boolean esEmailValido(String email) {
        	return email.isEmpty() || email.contains("@");
        }
  
        
    // Constructor sin email
    public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
        this(dni, nombre, apellidos, fechaNacimiento, "");
        }
   
    
    // Constructor con String (NO ME LO PIDEN)
    public Persona(String datosPersona) {
    String[] arrayDatos = datosPersona.split(",");
    Checkers.check("Formato inválido. Introduzca una línea de caractéres correcta.", arrayDatos.length != 4 || arrayDatos.length != 5);
        this.dni = arrayDatos[0].trim();
        this.nombre = arrayDatos[1].trim();
        this.apellidos = arrayDatos[2].trim();
        this.fechaNacimiento = LocalDate.parse(arrayDatos[3].trim(), DateTimeFormatter.ofPattern("d/M/y"));
        if (arrayDatos.length == 5) {
        	this.email = arrayDatos[4].trim();
        } else {
        	this.email = "";
        }
    } 
    
    
    // Getters
    public String getDni() {
        return dni;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
    	if (email == null) {
    		return "La persona no cuenta con un email.";
    	} else {
            return email;
    	}
    }
    
    public Integer getEdad() {
        return fechaNacimiento.until(LocalDate.now()).getYears();
    }
    
    
    // Setters
    public void setDni(String dni) {
    	this.dni = dni;
    }
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    // Método toString()
    public String toString() {
        return dni + " - " + apellidos + ", " + nombre + " - " + 
               fechaNacimiento.format(DateTimeFormatter.ofPattern("d/M/y"));
    }
    
    
    // Método equals()
    public boolean equals(Object obj) {
    	boolean res = false;
    	if (obj instanceof Persona) {
    		Persona a = (Persona)obj;
    		res = this.getDni().equals(a.getDni()) && this.getNombre().equals(a.getNombre()) && this.getApellidos().equals(a.getApellidos());
    	}
    	return res;
    } 
    
    
    // Método hashCode()
    public int hashCode() {
    	return Objects.hash(dni, nombre, apellidos);
    }
    
    
    // Método compareTo()
    public int compareTo(Persona a) {
    	int res = this.apellidos.compareTo(a.apellidos);
    	if (res == 0) {
    		res = this.nombre.compareTo(a.nombre);
    		if (res == 0) {
    			res = this.dni.compareTo(a.dni);
    		}
    	}
    	return res;	
    }
}