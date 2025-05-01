package fp.trenes;
import java.util.List;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import utiles.Checkers;

public class TrayectoTrenImpl implements TrayectoTrenes {
	private String codigo;
	private String nombre;
	private TipoTren tipoTren;
	private List<String> estaciones;
	private List<LocalTime> horasSalida;
	private List<LocalTime> horasLlegada;
	
	
	// Constructor
	public TrayectoTrenImpl(String codigo, String nombre, TipoTren tipoTren, 
	String estacionPrimera, String estacionFinal, LocalTime horaSalida, LocalTime horaLlegada) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipoTren = tipoTren;
		estaciones = new LinkedList<>(); estaciones.add(estacionPrimera); estaciones.add(estacionFinal);
		horasSalida = new LinkedList<>(); horasSalida.add(horaSalida); horasSalida.add(null);
		horasLlegada = new LinkedList<>(); horasLlegada.add(null); horasLlegada.add(horaLlegada);
	
		// Restricciones
		Checkers.check("El código debe de tener 5 caracéteres de longitud.", codigo.length() == 5);
		Checkers.checkNoNull(horasSalida.get(0));
		Checkers.checkNoNull(horasLlegada.get(1));
		Checkers.check("La hora de salida debe de ser anterior a la hora de llegada.", horaSalida.isBefore(horaLlegada));
	}
	
	
	// Método toString()
	
	
	public String toString() {
		String res = ""; 
		String linea = "";
		for (int i = 0; i < estaciones.size(); i++) {
			if (horasLlegada.get(i) == null) {
				linea = "\n" + estaciones.get(i) + "\t" + "\t" + horasSalida.get(i).format(DateTimeFormatter.ofPattern("HH:mm")) + "\n"; 
				res = res + linea;
			}
			else if (horasSalida.get(i) == null) {
				linea = "\n" + estaciones.get(i) + "\t" + horasLlegada.get(i).format(DateTimeFormatter.ofPattern("HH:mm")) + "\t" + "\n"; 
				res = res + linea;
			}
			else {
			linea = "\n" + estaciones.get(i) + "\t" + horasSalida.get(i).format(DateTimeFormatter.ofPattern("HH:mm")) + 
			"\t" + horasLlegada.get(i).format(DateTimeFormatter.ofPattern("HH:mm")) + "\n"; 
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
			res = this.nombre.equals(a.getNombre()) || this.horasSalida.get(0).equals(a.getHoraSalida()) || this.codigo.equals(a.getCodigoTren());
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
				res = this.horasSalida.get(0).compareTo(a.getHoraSalida());
				if (res == 0) {
					res = this.horasLlegada.get(0).compareTo(a.getHoraEntrada());
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
		return new LinkedList<String>(estaciones);
	}
	
	public List<LocalTime> getHorasSalida() {
		return new LinkedList<LocalTime>(horasSalida);
	}
	
	public List<LocalTime> getHorasEntrada() {
		return new LinkedList<LocalTime>(horasLlegada);
	}
	
	public LocalTime getHoraSalida() {
		return getHorasSalida().getFirst();
	}
	
	public LocalTime getHoraEntrada() {
		return getHorasEntrada().getLast();
	}
	
	public Duration getDuracionTrayecto() {
		return Duration.between(getHoraSalida(), getHoraEntrada());
	}
	
	public LocalTime getHoraSalida(String estacion) {
		LocalTime res = null;
		int pos = estaciones.indexOf(estacion);
		if (pos >= 0) {
			res = horasSalida.get(pos);
		}
		return res;
	}
	
	public LocalTime getHoraEntrada(String estacion) {
		LocalTime res = null;
		int pos = estaciones.indexOf(estacion);
		if (pos >= 0) {
			res = horasLlegada.get(pos);
		}
		return res;
	}
	
	
	// Operaciones
	public void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida) {
		Checkers.check("La posición intermedia no esta entre 1 y n", posicion > 0 && posicion <= estaciones.size() - 1);
		Checkers.check("La hora de salida no puede ser anterior a la hora de llegada.", Duration.between(horaSalida, horaLlegada).isPositive());
		Checkers.check("La hora de llegada no puede ser anterior a la hora de salida de la estación anterior", horaLlegada.isAfter(horasSalida.get(posicion)));
		Checkers.check("La hora de salida no puede ser posterior a la hora de llegada de la estación anterior", horaSalida.isBefore(horasLlegada.get(posicion)));
		estaciones.add(posicion, nombre);
		horasSalida.add(posicion, horaSalida);
		horasLlegada.add(posicion, horaLlegada);
	}

	public void eliminarEstacionIntermedia(String estacion) {
		int index = estaciones.indexOf(estacion);
		Checkers.check("No se puede borrar la estacion.", index != -1 || index != 1 || estaciones.contains(estacion));
		estaciones.remove(estacion);
	}

}