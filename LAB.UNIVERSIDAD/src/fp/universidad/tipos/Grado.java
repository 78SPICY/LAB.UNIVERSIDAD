package fp.universidad.tipos;
import java.util.Set;
import java.util.HashSet;
import fp.utiles.Checkers;
import java.util.TreeMap;
import java.util.SortedMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
public class Grado {
 
	
	// Atributo
	private String nombre;
	private Set<Asignatura> asignaturasObligatorias;
	private Set<Asignatura> asignaturasOptativas;
	private Double minimoCreditos;
	
	
	// Constructores
	public Grado(String nombre, Set<Asignatura> asignaturasObligatorias, Set<Asignatura> asignaturasOptativas, Double minimoCreditos) {
		this.nombre = nombre;
		this.asignaturasObligatorias = asignaturasObligatorias;
		this.asignaturasOptativas = asignaturasOptativas;
		this.minimoCreditos = minimoCreditos;
		
		
	// Restricciones
		double suma = 0;
		int contador = 0;
		for (Asignatura a: asignaturasOptativas) {
			suma += a.creditos();
			contador ++;
		}
		for (Asignatura a: asignaturasOptativas) {
			Checkers.check("Todas las asignaturas optativas deben de tener el mismo número de creditos.", suma/contador == a.creditos());
			Checkers.check("El mínimo de créditos de asignaturas optativas debe de ser un valor comprendido "
					+ "entre cero y el total de los créditos de las asignaturas optativas. Introduzca un mínimo válido.", 
					minimoCreditos > 0 || minimoCreditos < suma);
		}
	}
	
	
	// Método para calcular el número de creditos totales
	public double calcularCreditosTotales() {
		double suma = 0;
		for (Asignatura a: asignaturasObligatorias) {
			suma += a.creditos();
		}
		return suma + minimoCreditos;
	}
	
	
	// Getters
	public String getNombre() {
		return nombre;
	}
	
	public Set<Asignatura> getAsignaturasObligatorias() {
		return new HashSet<>(asignaturasObligatorias);
	}

	public Set<Asignatura> getAsignaturasOptativas() {
		return new HashSet<>(asignaturasOptativas);
	}
	
	public double getMinimoCreditos() {
		return minimoCreditos;
	}
	
	
	// Método toString()
	public String toString() {
		return nombre;
	}
	
	
	// Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Grado) {
			Grado a = (Grado)obj;
			res = this.nombre.equals(a.nombre);
		}
		return res;
	}
	
	
	// Método compareTo()
	public int compareTo(Grado g) {
		int res = 0;
		res = this.nombre.compareTo(g.nombre);
		return res;
	}
	
	
	// Operaciones 
	// Método para devolver todas las asignaturas del grado
	public Set<Asignatura> getAsignaturas() {
		Set<Asignatura> lista = new HashSet<>();
		for (Asignatura a : asignaturasOptativas) {
			lista.add(a);
		}
		for (Asignatura a : asignaturasObligatorias) {
			lista.add(a);
		}
		return lista;
	}
	
	
	// Método para buscar a una asignatura según su código
	public Asignatura getAsignatura(String codigo) {
		for (Asignatura a : getAsignaturas()) {
			if (codigo.equals(a.codigo())) {
				return a;
				}
			}
		return null;
	}
	
	
	// Método que asocia a cada asignatura con su número de créditos
	public SortedMap<Asignatura, Double> getCreditosPorAsignatura() {
		SortedMap<Asignatura, Double> serie = new TreeMap<>();
		for (Asignatura a : getAsignaturas()) {
			serie.put(a, a.creditos());
		}
		return serie;
	}
	
	
	// Método que corresponde a cada curso el número total de asignaturas de ese curso
	public Map<Integer, Double> getTotalCreditosPorCurso() {
		Map<Integer, Double> serie = new TreeMap<>();
		SortedSet<Integer> cursos = new TreeSet<>();
		for (Asignatura a1 : getAsignaturas()) {
			cursos.add(a1.curso());
		}
		for (Integer c : cursos) {
			double contador = 0.0;
			for (Asignatura a2 : getAsignaturas()) {
				if (a2.curso() == c) {
					contador += a2.creditos();
				}
			}
			serie.put(c, contador);	
		}
		return serie;
	}
	
}