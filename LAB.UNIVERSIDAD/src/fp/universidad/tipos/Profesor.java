package fp.universidad.tipos;

import java.time.LocalDate; 
import java.time.LocalTime; 
import java.time.DayOfWeek;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import fp.utiles.Checkers;
import fp.utiles.CharOfWeekDay;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Profesor extends Persona {
    
	
    // Atributos
    private Categoria categoria;
    private SortedSet<Tutoria> tutorias;
    private Map<Asignatura, Double> serieAsignaturas;
    
    
    // Constructor
    public Profesor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, Categoria categoria) {
        super(dni, nombre, apellidos, fechaNacimiento, email);
        this.categoria = categoria;
        this.tutorias = new TreeSet<>();
        this.serieAsignaturas = new HashMap<Asignatura, Double>();
    }
    
    
    // Restricción
    // Debido a que la edad depende de la fecha nacimiento, hay que redefinir el setFechaNacimiento() de la clase hijo.
    public void setFechaNacimiento(LocalDate fecha) {
    	Checkers.check("El profesor debe de ser mayor de edad.", getEdad() >= 18);
    	super.setFechaNacimiento(fecha);
    }
    
   
    // Constructor sin email
    public Profesor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, Categoria categoria) {
        super(dni, nombre, apellidos, fechaNacimiento, "");
        this.categoria = categoria;
        this.tutorias = new TreeSet<>();
        this.tutorias = new TreeSet<>();
        this.serieAsignaturas = new HashMap<Asignatura, Double>();
    }
    
    
    // Getters
    public Categoria getCategoria() {
    	return categoria;
    }
    
    public Set<Tutoria> getTutorias() {
    	return new TreeSet<>(tutorias);
    }
    
    public Set<Asignatura> getAsignaturas() {
    	return new TreeSet<Asignatura>(serieAsignaturas.keySet());
    }
    
    public Collection<Double> getCreditos() {
    	return new TreeSet<Double>(serieAsignaturas.values());
    }
    
    
    // public String getDni() {
    // HEREDADO
    
    // public String getNombre() {
    // HEREDADO
    
    // public String getApellidos() {
    // HEREDADO
 
    // public LocalDate getFechaNacimiento() {
    // HEREDADO

    // public String getEmail() {
    // HEREDADO
    
    // public Integer getEdad() {
    // HEREDADO
  
   
    // Setters
    public void setCategoria(Categoria categoria) {
    	this.categoria = categoria;
    }
    
    // public void setDni(String dni) {
    // HEREDADA
    
    // public void setNombre(String nombre) {
    // HEREDADA
    
    // public void setApellidos(String apellidos) {
    // HEREDADA
    
    // public void setEmail(String email) {
    // HEREDADA
 
    
    // Método toString()
    public String toString() {
    	return super.toString() + "(" + categoria + ")"; 
    }
    
    
    // Método compareTo()
    // HEREDADO DE LA CLASE PERSONA
    
    
    // Método equals()
    // HEREDADO DE LA CLASE PERSONA
    
    
    // Operaciones
    // Método para añadir una nueva tutoría dada una hora de comienzo, una duración y un día de la semana
    public void nuevaTutoria(LocalTime horaComienzo, int duracion, DayOfWeek diaComienzo) {
    	char dia = CharOfWeekDay.getChar(diaComienzo);	
    	tutorias.add(new Tutoria(dia, horaComienzo, duracion));
    }
    
    
    // Método para borrar la tutoría cuya hora de comienzo y cuyo día sean los parámetros otorgados
    public void borraTutoria(LocalTime horaComienzo, DayOfWeek diaComienzo) {
    	char dia = CharOfWeekDay.getChar(diaComienzo);
    	tutorias.removeIf(elem -> elem.horaComienzo().equals(horaComienzo) && elem.getDiaSemana() == dia);		
    }
    
    
    // Método que elimina todas las tutorías del profesor
    public void borraTutorias() {
    	tutorias.clear();
    }
 
    
    // Método que añade una asignatura con su respectiva dedicación / actualiza la dedicación de una asignatura
    public void imparteAsignatura(Asignatura asignatura, Double dedicacion) {
    	serieAsignaturas.put(asignatura, dedicacion);
    }
    
    
    // Método que elimina la asignatura del parámetro de las asignaturas que imparte el profesor
    public void eliminaAsignatura(Asignatura asignatura) {
    	serieAsignaturas.remove(asignatura);
    	}
    
    
    // Método que devuelve el número de créditos impartidos en la asignatura del parámetro
    public Double dedicacionAsignatura(Asignatura asignatura) {
    	if (serieAsignaturas.containsKey(asignatura)) {
    		return serieAsignaturas.get(asignatura);
    	} else {
    		return 0.0;
    	}
    }
    
    
    // Método que devuelve el totál de creditos del profesor
    public Double getDedicacionTotal() {
    	double suma = 0.0;
    	List<Double> dedicaciones = new ArrayList<>(serieAsignaturas.values());
    	for (int i = 0; i < dedicaciones.size(); i++) {
    		suma += dedicaciones.get(i);
    	}
    	return suma;
    }
    
}