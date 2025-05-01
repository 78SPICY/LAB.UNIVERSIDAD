package fp.universidad.tipos;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import fp.utiles.Checkers;
import java.util.TreeMap;
import java.util.SortedMap;

public class Centro implements Comparable<Centro> {
	
	
	// Atributos
	private String nombre;
	private String direccion;
	private Integer cantidadPlantas;
	private Integer cantidadSotanos;
	private Set<Espacio> conjuntoEspacios;
	
	
	// Constructor
	public Centro(String nombre, String direccion, Integer cantidadPlantas, Integer cantidadSotanos, Set<Espacio> conjuntoEspacios) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.cantidadPlantas = cantidadPlantas;
		this.cantidadSotanos = cantidadSotanos;
		this.conjuntoEspacios = new HashSet<>(conjuntoEspacios);
		
		
	// Restricciones
		Checkers.check("Un centro debe de tener al menos una planta. Introduzca una planta.", cantidadPlantas > 0);
		Checkers.check("No se puede tener una cantidad negativa de sótanos. Introduzca una cantidad correcta", cantidadSotanos >= 0);
	}

	
	// Método para añadir nuevos espacios
	public void nuevoEspacio(Espacio e) {
		Checkers.check("La planta no está en el intervalo " + "[" + -cantidadSotanos + ", " + (cantidadPlantas - 1) + "]", 
				e.getPlanta() >= -cantidadSotanos && e.getPlanta() <= cantidadPlantas - 1);
			conjuntoEspacios.add(e);
		}

	
	// Método para eliminar espacios
	public void eliminarEspacio(Espacio e) {
		conjuntoEspacios.remove(e);
	}
	
	
	// Getters
	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public Integer getCantidadPlantas() {
		return cantidadPlantas;
	}
	
	public Integer getCantidadSotanos() {
		return cantidadSotanos;
	}
	
	public Set<Espacio> getConjuntoEspacio() {
		return new HashSet<>(conjuntoEspacios);
	}
	
	
	// Método toString()
	public String toString() {
		return nombre;
	}
	
	
	// Método equals(){
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Centro) {
			Centro a = (Centro)obj;
			res = this.nombre.equals(a.nombre);
		}
	return res;
	}
	
	
	// Método hashCode(){
	public int hashCode() {
		return nombre.hashCode();
	}
	
	
	// Método compareTo(){
	public int compareTo(Centro a) {
		return nombre.compareTo(a.nombre);
	}
	
	
	// Operaciones
	// Método para devolver la cantidad de espacios de cada tipo
	public String getConteosEspacios() {
		int conteoAulaTeoria = 0;
		int conteoLaboratorio = 0;
		int conteoSeminario = 0;
		int conteoAulaExamen = 0;
		int conteoOtroTipo = 0;
		for (Espacio e : conjuntoEspacios) {
			switch(e.getTipoEspacio()) {
				case TEORIA:
					conteoAulaTeoria ++;
					break;
				case LABORATORIO:
					conteoLaboratorio ++;
					break;
				case SEMINARIO:
					conteoSeminario ++;
					break;
				case EXAMEN:
					conteoAulaExamen ++;
					break;
				case OTRO:
					conteoOtroTipo ++;
					break;
			}
		}
		Integer[] array = {conteoAulaTeoria, conteoLaboratorio, conteoSeminario, conteoAulaExamen, conteoOtroTipo};
		return Arrays.toString(array);
	}
	
	
	// Método para obtener todos los despachos del centro
	public Set<Despacho> getDespachos() {
		Set<Despacho> conjuntoDespachos = new HashSet<>();
		for (Espacio e : conjuntoEspacios) {
			//if (e.getTipoEspacio().getClass().equals(Despacho.class)) {
			if (e.getTipoEspacio() == TipoEspacio.OTRO) {
				Despacho d = (Despacho)e;
				conjuntoDespachos.add(d);
			}
		}
		return conjuntoDespachos;
	}
	
	
	// Método para obtener todos los despachos donde hay al menos un profesor del departamento 'd'
	public Set<Espacio> getDespachos(Departamento departamento) {
		Set<Espacio> despachos = new HashSet<>();
		Set<Despacho> filtroDespachos = new HashSet<>();
		for (Espacio e : conjuntoEspacios) {
			if (e.getTipoEspacio() == TipoEspacio.OTRO) {
				Despacho d = (Despacho)e;
				filtroDespachos.add(d);
			}	
		}
		for (Profesor p : departamento.getConjuntoProfesores()) {
			for (Despacho d : filtroDespachos) {
				if (d.getProfesores().contains(p)) {
					Espacio e = (Espacio)d;
					despachos.add(e);
				}
			}
		}
		return despachos;
	}
	
	
	//Método para obtener todos los profesores con despacho en el centro
	public Set<Profesor> getProfesores() {
		Set<Profesor> conjuntoProfesores = new HashSet<>();
		for (Espacio e : conjuntoEspacios) {
			if (e.getTipoEspacio().getClass().equals(Despacho.class)) {
				Despacho d = (Despacho)e;
				d.getProfesores().spliterator().forEachRemaining(p -> conjuntoProfesores.add(p));
			}
		}
		return conjuntoProfesores;
	}
	
	
	// Método para obtener todos los profesores que pertenecen a un departamento 'd' y tienen un despacho en el centro
	public Set<Profesor> getProfesores(Departamento departamento) {
	Set<Profesor> profesores = new HashSet<>();
	Set<Despacho> despachos = new HashSet<>();
	
	for (Espacio e : conjuntoEspacios) {
		if (e.getTipoEspacio() == TipoEspacio.OTRO) {
			Despacho d = (Despacho)e;
			despachos.add(d);
		}
	}
	for (Profesor p : departamento.getConjuntoProfesores()) {
		for (Despacho d : despachos) {
			if (d.getProfesores().contains(p)) {
				profesores.add(p);
			}	
		}
	}
	return profesores;
	}
	
	
	// Método para obtener el espacio con mayor capacidad del centro
	public Espacio getEspacioMayorCapacidad() {
		Espacio espacioMasGrande = new Espacio(null, null, 1, null);
		for (Espacio e : conjuntoEspacios) {
			if (e.getCapacidad() > espacioMasGrande.getCapacidad()) {
				espacioMasGrande = e;
			}			
		}
		return espacioMasGrande;
	}
	
	// Metodo para asociar a cada profesor con el despacho que ocupa en el centro
	public SortedMap<String, Despacho> getDespachosPorProfesor() {
		SortedMap<String, Despacho> serie = new TreeMap<>();
		Set<Profesor> profesores = new HashSet<>();
		for (Despacho d : getDespachos()) {
			for (Profesor p : d.getProfesores()) {
				profesores.add(p);
			}
		}
		for (Profesor p : profesores) {
			for (Despacho d: getDespachos()) {
				if (d.getProfesores().contains(p)) {
					serie.put(p.toString(), d);
				}
			}
		}
		return serie;
	}
}	
