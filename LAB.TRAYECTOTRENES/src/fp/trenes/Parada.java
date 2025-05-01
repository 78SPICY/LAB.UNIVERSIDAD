package fp.trenes;
import java.time.LocalTime;

import utiles.Checkers;

public record Parada(String estacion, LocalTime horaSalida, LocalTime horaLlegada) {
	
	public Parada {
		Checkers.check("La hora de salida debe de ser anterior a la hora de entrada", 
		horaSalida == null && horaLlegada != null || horaSalida != null && horaLlegada == null ||
		horaSalida != null && horaLlegada != null && horaSalida.isBefore(horaLlegada));
	}
}
