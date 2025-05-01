package fp.universidad.tipos;
import java.util.Objects;
import fp.utiles.Checkers;

public class Espacio implements Comparable<Espacio> {
	
	
	// Atributos
	private TipoEspacio tipoEspacio;
	private String nombre;
	private Integer capacidad;
	private Integer planta;
		
	
	// Constructor
	public Espacio(TipoEspacio tipoEspacio, String nombre, Integer capacidad, Integer planta) {
		this.tipoEspacio = tipoEspacio;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.planta = planta;
		
		
	// Restricción
		Checkers.check("La capacidad de un espacio debe de ser mayor que cero. Introduzca una capacidad válida", capacidad > 0); 
	}
	
	// Constructor con String
	public Espacio(String parametros) {
		String[] lineaParametros = parametros.split(",");
		Checkers.check("Cantidad de parámetros incorrecta. Introduzca un nombre, una capacidad, una planta y un tipo de espacio.", lineaParametros.length == 4);
		nombre = lineaParametros[0].trim();
		planta = Integer.parseInt(lineaParametros[1].trim());
		Integer capacidadAux = Integer.parseInt(lineaParametros[2].trim());
		Checkers.check("La capacidad de un espacio debe de ser mayor que cero. Introduzca una capacidad válida", capacidadAux > 0);
		capacidad = capacidadAux;
		tipoEspacio = TipoEspacio.valueOf(lineaParametros[3].toUpperCase().trim());
	}
		
		
	// Getters
	public TipoEspacio getTipoEspacio() {
		return tipoEspacio;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Integer getCapacidad() {
		return capacidad;
	}
	
	public Integer getPlanta() {
		return planta;
	}
	
	
	// Setters
	public void setTipoEspacio(TipoEspacio tipoEspacio) {
		this.tipoEspacio = tipoEspacio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	
	// Método toString()
	public String toString() {
		return nombre + " (planta " + planta + ")";
	}
	
	
	// Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Espacio) {
			Espacio a = (Espacio)obj;
			res = this.getNombre().equals(a.getNombre()) && this.getPlanta().equals(a.getPlanta());
		}
		return res;
	}
	
	
	// Método hashCode()
	public int hashCode() {
		return Objects.hash(nombre, planta);
	}
	
	
	// Método compareTo()
	public int compareTo(Espacio a) {
		int res = this.getPlanta().compareTo(a.getPlanta());
		if (res == 0) {
			res = this.getNombre().compareTo(a.getNombre());
		}
		return res;
	}
} 