package fp.universidad.tipos;
import java.util.Set;
import java.util.HashSet;
import fp.utiles.Checkers;

public class Despacho extends Espacio {
	
	
	//Atributos
	private Set<Profesor> profesores;
	
	
	// Primer constructor
	public Despacho(String nombre, Integer capacidad, Integer planta, Set<Profesor> profesores) {
		super(TipoEspacio.OTRO, nombre, capacidad, planta);
		this.profesores = new HashSet<>(profesores);
	}
	
	
	// Restricciones
	public void setProfesores() {
		Checkers.check("La cantidad de profesores no puede superar la capacidad del despacho.", profesores.size() <= getCapacidad());
 		this.profesores = new HashSet<>(profesores);
	}

	
	public void setTipoEspacio(TipoEspacio tipoEspacio) {
		throw new UnsupportedOperationException("Un despacho siempre debe de tener como tipo de espacio 'OTRO'");
	}

	
	// Segundo constructor
	public Despacho(String nombre, Integer capacidad, Integer planta, Profesor profesor) {
		super(TipoEspacio.OTRO, nombre, capacidad, planta);
		this.profesores = new HashSet<>();
		this.profesores.add(profesor);
	}
		
	
	// Tercer constrctor
	public Despacho(String nombre, Integer capacidad, Integer planta) {
		super(TipoEspacio.OTRO, nombre, capacidad, planta);
		this.profesores = new HashSet<>();
		}
	
	
	// Tercer constructor con String
	public Despacho(String parametros) {
		super(parametros + ", OTRO");
		this.profesores = new HashSet<>();
	}
	
	
	// Getters
	public Set<Profesor> getProfesores() {
		return new HashSet<>(profesores);
	}

	
	// Método toString()
	public String toString() {
		return super.toString() + " " + profesores;
	}
}