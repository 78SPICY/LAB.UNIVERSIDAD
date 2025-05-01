package fp.universidad.tipos;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class Departamento implements Comparable<Departamento> {
	
	
	// Atributos
	private String nombre;
	private Set<Profesor> conjuntoProfesores;
	private Set<Asignatura> conjuntoAsignaturas;
	
	
	// Constructor
	public Departamento(String nombre) {
		this.nombre = nombre;
		this.conjuntoProfesores = new HashSet<>();
		this.conjuntoAsignaturas = new HashSet<>();
	}
	
	
	// Método toString()
	public String toString() {
		return nombre;
	}

	
	// Getters
	public Set<Profesor> getConjuntoProfesores() {
		return new HashSet<>(conjuntoProfesores);
	}
	
	public Set<Asignatura> getConjuntoAsignaturas() {
		return new HashSet<>(conjuntoAsignaturas);
	}
	
	
	// Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Departamento) {
			Departamento a = (Departamento)obj;
			res = this.nombre.equals(a.nombre);
		}
		return res;
	}
	
	
	// Método compareTo()
	public int compareTo(Departamento obj) {
		int res = this.nombre.compareTo(obj.nombre);
		return res;
	}
	
	
	// Operaciones
	public void nuevoProfesor(Profesor profesor) {
		conjuntoProfesores.add(profesor);
	}
	
	public void eliminaProfesor(Profesor profesor) {
		conjuntoProfesores.remove(profesor);
		}
	
	public void nuevaAsignatura(Asignatura asignatura) {
		conjuntoAsignaturas.add(asignatura);
	}
	
	public void eliminaAsignatura(Asignatura asignatura) {
		conjuntoAsignaturas.remove(asignatura);
	}
	
	public void borraTutorias() {
		for (Profesor p: conjuntoProfesores) {
			p.borraTutorias();
		}
	}
		
	public void borraTutorias(Categoria categoria) {
		for (Profesor p: conjuntoProfesores) {
			if (p.getCategoria() == categoria) {
				p.borraTutorias();
			}
		}
	}
	
	// Método que corresponde a cada asignatura con el conjunto de profesores que la imparten
	public SortedMap<Asignatura, SortedSet<Profesor>> getProfesoresPorAsignatura() {
		SortedMap<Asignatura, SortedSet<Profesor>> serie = new TreeMap<>();
		for (Asignatura a : conjuntoAsignaturas) {
			SortedSet<Profesor> profesores = new TreeSet<>();
			for (Profesor p : conjuntoProfesores) {
				if (p.getAsignaturas().contains(a)) {
					profesores.add(p);
				}
			}	
			serie.put(a, profesores);
		}
		return serie;
		}
	
	// Método para asociar a cada profesor con todas las tutorías que imparte
	public SortedMap<String, SortedSet<Tutoria>> getTutoriasPorProfesor() {
		SortedMap<String, SortedSet<Tutoria>> serie = new TreeMap<>();
		for (Profesor p : conjuntoProfesores) {
			SortedSet<Tutoria> sortedSetTutorias = new TreeSet<>();
			for (Tutoria t : p.getTutorias()) {
				sortedSetTutorias.add(t);	
			}
			serie.put(p.toString(), sortedSetTutorias);
		}
		return serie;
	}
}