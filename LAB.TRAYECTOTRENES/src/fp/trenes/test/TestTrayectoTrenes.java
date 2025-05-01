package fp.trenes.test;
import java.time.LocalTime;
import java.util.List;
import java.util.LinkedList;
import fp.trenes.TrayectoTrenImpl;
import fp.trenes.TrayectoTrenImpl2;
import fp.trenes.Parada;
import fp.trenes.TipoTren;

public class TestTrayectoTrenes {

	public static void main(String[] args) {
		Parada cadiz = new Parada("CÁDIZ", LocalTime.of(7, 5), null);
		Parada jaen = new Parada("JAÉN", null, LocalTime.of(19, 30));
		List<Parada> listaParadas = new LinkedList<>();
		listaParadas.add(cadiz);
		listaParadas.add(jaen);
	
		TrayectoTrenImpl cadiz_jaen1 = new TrayectoTrenImpl("04322", "CÁDIZ - JAEN", TipoTren.LD_MD, "Cádiz", "Jaén", LocalTime.of(7, 5), LocalTime.of(19, 30));
		TrayectoTrenImpl2 cadiz_jaen2 = new TrayectoTrenImpl2("04322", "CÁDIZ - JAÉN", TipoTren.LD_MD, listaParadas);

		System.out.println("PRUEBA DEL TIPO TRAYECTORENES" + "\n");
		System.out.println("Representación del tipo TrayectoTrenes usando la primera implementación:" + "\n" + "\n" + cadiz_jaen1.toString() + "\n");
		System.out.println("Representación del tipo TrayectoTrenes usando la segunda implementación:" + "\n" + "\n" + cadiz_jaen2.toString());
		System.out.println("Código del trayecto ===> " + cadiz_jaen1.getCodigoTren());
		System.out.println("Nombre del trayecto ===> " + cadiz_jaen1.getNombre());
		System.out.println("Tipo del tren del trayecto ===> " + cadiz_jaen1.getTipoTren());
		System.out.println("Horas de llegada del trayecto usando la primera implementación ===> " + cadiz_jaen1.getHorasEntrada());
		System.out.println("Horas de llegada del trayecto usando la segunda implementación ===> " + cadiz_jaen2.getHorasEntrada());
		System.out.println("Horas de salida del trayecto usando la primera implementación ===> " + cadiz_jaen1.getHorasSalida());
		System.out.println("Horas de salida del trayecto usando la segunda implementación ===> " + cadiz_jaen2.getHorasSalida());
		System.out.println("Hora de llegada del trayecto usando la primera implementación ===> " + cadiz_jaen1.getHoraEntrada());
		System.out.println("Hora de llegada del trayecto usando la segunda implementación ===> " + cadiz_jaen2.getHoraEntrada());
		System.out.println("Hora de salida del trayecto usando la primera implementación ===> " + cadiz_jaen1.getHoraSalida());
		System.out.println("Hora de salida del trayecto usando la segunda implementación ===> " + cadiz_jaen2.getHoraSalida());
		System.out.println("Hora de llegada de un trayecto en concreto usando la primera implementación ===> " + cadiz_jaen1.getHoraSalida("04322"));
		System.out.println("Hora de llegada de un trayecto en concreto usando la segunda implementación ===> " + cadiz_jaen2.getHoraSalida("04322"));
		System.out.println("Hora de llegada de un trayecto en concreto usando la primera implementación ===> " + cadiz_jaen1.getHoraEntrada("04322"));
		System.out.println("Hora de llegada de un trayecto en concreto usando la segunda implementación ===> " + cadiz_jaen2.getHoraEntrada("04322"));		


		
		

	}

}
