package fp.universidad.tipos;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Set;
import java.util.Comparator;
import java.util.HashSet;
import fp.utiles.Checkers;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;

public class Alumno extends Persona {
	
	
	// Atributos
	private Set<Asignatura> asignaturas;
	private Expediente expediente;
	
	
	// Constructor con email
	public Alumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
		super(dni, nombre, apellidos, fechaNacimiento, email);
		setEmail(email);
		this.asignaturas = new HashSet<>();
		this.expediente = new Expediente();
	}
		
	// Restricciones
		public void setEmail(String email) {
			Checkers.check("El email cuenta con un formato incorrecto. Introduzca uno válido.", email.endsWith("@alum.us.es"));
			super.setEmail(email);
	}
	
	// Constructior sin email
	public Alumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
		super(dni, nombre, apellidos, fechaNacimiento, "");
		this.asignaturas = new HashSet<>();
		this.expediente = new Expediente();
	}
		
	
	// Getters
	public Set<Asignatura> getAsignaturas() {
		return new HashSet<>(asignaturas);
	}
	
	public Integer getCurso() {
		if (asignaturas.isEmpty()) {
			return 0;
		}
		Set<Integer> conjuntoCursos = new HashSet<>(); 
			for (Asignatura n : asignaturas) {
				 conjuntoCursos.add(n.curso());
			}
		return conjuntoCursos.stream().max(Comparator.naturalOrder()).orElseThrow(); 
	}
		
	//OTRA ALTERNATIVA
	//return conjuntoCursos.stream().max(c1, c2) -> c1.compareTo(c2))).orElseThrow();
	
	
	// Getters
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
	
	public Expediente getExpediente() {
		return expediente;
	}
	
	
	// Setters
    // public void setDni(String dni) {
    // HEREDADA
    
    // public void setNombre(String nombre) {
    // HEREDADA
    
    // public void setApellidos(String apellidos) {
    // HEREDADA
    
    // public void setFechaNacimiento(LocalDate fechaNacimiento) {
    // HEREDADA
    
    // public void setEmail(String email) {
    // HEREDADA
	
	
	// Método toString() 
	// HEREDADO
	
	
	// Método eqauals()
	// HEREDADO
	
	
	// Operaciones
	// Método para añadir la asignatura del parámetro al conjunto de las asignaturas en las que está matriculado el alumno
	public void matriculaAsignatura(Asignatura a) {
		Checkers.check("El alumno ya está matriculado en esta asignatura. Introduzca una asignatura en la que el alumno no esté matriculado.", 
				!estaMatriculadoEn(a));
		asignaturas.add(a);	
	}
	
	
	// Método para eliminar la asignatura del parámetro del conjunto de asignaturas en las que está matriculado el alumno
	public void eliminaAsignatura(Asignatura a) {
		Checkers.check("El alumno no está matriculado en esta asignatura. Introduzca una asignatura en la que el alumno esté matriculado.", 
				estaMatriculadoEn(a));
	}
	
	// Método que comprueba si el alumno está matriculado en las asignatura del parámetro
	public boolean estaMatriculadoEn(Asignatura a) {
		return asignaturas.contains(a);
	}
	
	// Método para añadir una nota al expediente
	public void evaluaAsignatura(Asignatura a, Convocatoria c, double valor, Integer curso, boolean mencionHonor) {
		Checkers.check("El alumno no está matriculado en la asignatura dada. Introduzca una asignatura en la que el alumno esté matriculado.", 
				estaMatriculadoEn(a));
		expediente.nuevaNota(new Nota(a, curso, c, valor, mencionHonor));
	}
	
	// Método para corresponder cada asignatura del expediente a su calificaión máxima correspondiente
	public SortedMap<Asignatura, Calificacion> getCalificacionPorAsignatura() {
		SortedMap<Asignatura, Calificacion> serie = new TreeMap<>();
		Set<Asignatura> asignaturas = new HashSet<>(); 
		for (Nota n : expediente.getListaNotas()) {
			asignaturas.add(n.asignatura());
		}
		for (Asignatura a : asignaturas) {
			List<Calificacion>  calificaciones = new ArrayList<>();
			for (Nota n : expediente.getListaNotas()) {
				if (n.asignatura().equals(a)) {
					calificaciones.add(n.getCalificacion());
				}
			}
			Calificacion calificacionMaxima = calificaciones.stream().max((c1, c2) -> c1.compareTo(c2)).orElse(null);
			serie.put(a, calificacionMaxima);
		}
		return serie;
	}
	
	// Método para asociar cada curso con el número de asignaturas de ese curso 
	public Map<Integer, Integer> getNumAsignaturasPorCurso() {
		Map<Integer, Integer> serie = new HashMap<>();
		SortedSet<Integer> cursos = new TreeSet<>();
		for (Asignatura a1 : asignaturas) {
			cursos.add(a1.curso());
		}
		for (Integer c : cursos) {
			int contador = 0;
			for (Asignatura a2 : asignaturas) {
				if (a2.curso() == c) {
					contador ++;
				}
			}
			serie.put(c, contador);
		}
		return serie;
	}
	
}