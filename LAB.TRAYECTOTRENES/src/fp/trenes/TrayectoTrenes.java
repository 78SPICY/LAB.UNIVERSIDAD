package fp.trenes;
import java.util.List;
import java.time.LocalTime;
import java.time.Duration;

public interface TrayectoTrenes {
	String getCodigoTren();
	String getNombre();
	List<String> getEstaciones();
	List<LocalTime> getHorasSalida();
	List <LocalTime> getHorasEntrada();
	LocalTime getHoraSalida();
	LocalTime getHoraEntrada();
	LocalTime getHoraSalida(String estacion);
	LocalTime getHoraEntrada(String estacion);
	Duration getDuracionTrayecto();
	void anadirEstacionIntermedia(int posicion, String estacion, LocalTime horaLlegada, LocalTime horaSalida);
	void eliminarEstacionIntermedia(String estacion);
}
