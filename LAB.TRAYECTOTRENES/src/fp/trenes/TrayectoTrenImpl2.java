package fp.trenes;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import utiles.Checkers;

import java.util.LinkedList;

public class TrayectoTrenImpl2 {
	private String codigo;
	private String nombre;
	private TipoTren tipoTren;
	private List<Parada> listaParadas;
	
	
	// Constructor
	public TrayectoTrenImpl2(String codigo, String nombre, TipoTren tipoTren, List<Parada> paradas) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipoTren = tipoTren;
		this.listaParadas = new LinkedList<>();
		for (Parada p : paradas) {
			listaParadas.add(p);
		}
		
		// Restricciones
		Checkers.check("El código debe de tener 5 caracéteres de longitud.", codigo.length() == 5);
		Checkers.checkNoNull(juntarHorasSalida().get(0));
		Checkers.checkNoNull(juntarHorasLlegada().get(1));
		Checkers.check("La hora de salida debe de ser anterior a la hora de llegada.", juntarHorasSalida().get(0).isBefore(juntarHorasLlegada().get(1)));
	}
	
	
	// Clases privadas de utilidad
	private List<String> juntarEstaciones() {
		List<String> listaEstaciones = new LinkedList<>();
		for (Parada p : listaParadas) {
			listaEstaciones.add(p.estacion());
		}
		return listaEstaciones;
	}
	
	private List<LocalTime> juntarHorasSalida() {
		List<LocalTime> listaHorasSalida = new LinkedList<>();
		for (Parada p : listaParadas) {
			listaHorasSalida.add(p.horaSalida());
		}
		return listaHorasSalida;
	}
	
	private List<LocalTime> juntarHorasLlegada() {
		List<LocalTime> listaHorasLlegada = new LinkedList<>();
		for (Parada p : listaParadas) {
			listaHorasLlegada.add(p.horaLlegada());
		}
		return listaHorasLlegada;
	}
	

	// Método toString()
	public String toString() {
		String res = ""; 
		String linea = "";
		for (int i = 0; i < juntarEstaciones().size(); i++) {
			if (juntarHorasLlegada().get(i) == null) {
				linea = "\n" + juntarEstaciones().get(i) + "\t" + "\t" + juntarHorasSalida().get(i).format(DateTimeFormatter.ofPattern("HH:mm")) + "\n"; 
				res = res + linea;
			}
			else if (juntarHorasSalida().get(i) == null) {
				linea = "\n" + juntarEstaciones().get(i) + "\t" + juntarHorasLlegada().get(i).format(DateTimeFormatter.ofPattern("HH:mm")) + "\t" + "\n"; 
				res = res + linea;
			}
			else {
			linea = "\n" + juntarEstaciones().get(i) + "\t" + juntarHorasSalida().get(i).format(DateTimeFormatter.ofPattern("HH:mm")) + 
			"\t" + juntarHorasLlegada().get(i).format(DateTimeFormatter.ofPattern("HH:mm")) + "\n"; 
			}
			res = res + linea;
		}
		
		return nombre + " - " + tipoTren + " - (" + codigo + ") " + "\n" + res;
	}
	
	
	// Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof TrayectoTrenImpl) {
			TrayectoTrenImpl a = (TrayectoTrenImpl)obj;
			res = this.nombre.equals(a.getNombre()) || this.juntarHorasSalida().get(0).equals(a.getHoraSalida()) || this.codigo.equals(a.getCodigoTren());
		}
		return res;
	}
	
	
	// Método compareTo()
	public int compareTo(Object obj) {
		int res = 0;
		if (obj instanceof TrayectoTrenImpl) {
			TrayectoTrenImpl a = (TrayectoTrenImpl)obj;
			res = this.nombre.compareTo(a.getCodigoTren());
			if (res == 0) {
				res = this.juntarHorasSalida().get(0).compareTo(a.getHoraSalida());
				if (res == 0) {
					res = this.juntarHorasLlegada().get(0).compareTo(a.getHoraEntrada());
				}
			}
		}
		return res;
	}
	
	
	// Getters
	public String getCodigoTren() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public TipoTren getTipoTren() {
		return tipoTren;
	}
	
	public List<String> getEstaciones() {
		return new LinkedList<>(juntarEstaciones());
	}
	
	public List<LocalTime> getHorasSalida() {
		return new LinkedList<>(juntarHorasSalida());
	}
	
	public List<LocalTime> getHorasEntrada() {
		return new LinkedList<>(juntarHorasLlegada());
	}
	
	public LocalTime getHoraSalida() {
		return juntarHorasSalida().getFirst();
	}
	
	public LocalTime getHoraEntrada() {
		return juntarHorasLlegada().getLast();
	}
	
	public Duration getDuracionTrayecto() {
		return Duration.between(getHoraSalida(), getHoraEntrada());
	}
	
	public LocalTime getHoraSalida(String estacion) {
		LocalTime res = null;
		int pos = juntarEstaciones().indexOf(estacion);
		if (pos >= 0) {
			res = juntarHorasSalida().get(pos);
		}
		return res;
	}
	
	public LocalTime getHoraEntrada(String estacion) {
		LocalTime res = null;
		int pos = juntarEstaciones().indexOf(estacion);
		if (pos >= 0) {
			res = juntarHorasLlegada().get(pos);
		}
		return res;
	}
	
	
	// Operaciones
	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		Checkers.check("La posición intermedia no esta entre 1 y n", posicion > 0 && posicion <= listaParadas.size() - 1);
		Checkers.check("La hora de salida no puede ser anterior a la hora de llegada.", horaSalida.isAfter(horaLlegada));
		Checkers.check("La hora de llegada no puede ser anterior a la hora de salida de la estación anterior", horaLlegada.isAfter(juntarHorasSalida().get(posicion)));
		Checkers.check("La hora de salida no puede ser posterior a la hora de llegada de la estación anterior", horaSalida.isBefore(juntarHorasLlegada().get(posicion)));
		Parada nuevaParada = new Parada(estacion, horaLlegada, horaSalida);
		listaParadas.add(posicion, nuevaParada);
	}

	public void eliminarEstacionIntermedia(String estacion) {
		int index = juntarEstaciones().indexOf(estacion);
		Checkers.check("No se puede borrar la estacion.", index != -1 || index != 1 || juntarEstaciones().contains(estacion));
		listaParadas.remove(index);
	}
}