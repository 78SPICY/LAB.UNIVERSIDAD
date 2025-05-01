package fp.universidad.tipos;

import java.time.LocalTime;
import java.util.Objects;
import java.time.Duration;
import fp.utiles.Checkers;


	// Atributos
	public record Tutoria(
		char diaSemana, 
		LocalTime horaComienzo,
		LocalTime horaFin,
		long duracion) implements Comparable<Tutoria>{


	// Restricciones
		public Tutoria {
			Checkers.check("Las tutorías deben de darse en días lectivos. Introduzca un día nuevo", String.valueOf(diaSemana).matches("[LMXJV]"));
			Checkers.check("Las tutorías deben de durar por lo menos 15 minutos.", duracion >= 15);
		}
		
		
	// Constructores
	public Tutoria(char diaSemana, LocalTime horaComienzo, LocalTime horaFin) {
		this(diaSemana, horaComienzo, horaFin, Duration.between(horaComienzo, horaFin).toMinutes());
	}
	
	
	public Tutoria(char diaSemana, LocalTime horaComienzo, long duracion) {
		this(diaSemana, horaComienzo, horaComienzo.plusMinutes(duracion), duracion);
	}
	
	
	//Getters
	public char getDiaSemana() {
		return diaSemana;
	}
	
	public LocalTime getHoraComienzo() {
		return horaComienzo;
	}
	
	public LocalTime getHoraFin() {
		return horaFin;
	}
	
	public long getDuracion() {
		return duracion;
	}
	
	
	// Método toString()
	public String toString() {
		return diaSemana + " " + horaComienzo + "-" + horaFin;
	}

	
	// Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Tutoria) {
			Tutoria a = (Tutoria)obj;
			res = this.diaSemana == a.diaSemana && this.horaComienzo.equals(a.horaComienzo);
		}
		return res;
	}
	
	
	// Método hashCode()
	public int hashCode() {
		return Objects.hash(diaSemana, horaComienzo);
	}
	
	
	// Método compareTo()
	public int compareTo(Tutoria a) {
		int res = Character.compare(this.diaSemana, a.diaSemana);
		if (res == 0) {
			res = this.horaComienzo.compareTo(a.horaComienzo);
		}
		return res;
	}			
}