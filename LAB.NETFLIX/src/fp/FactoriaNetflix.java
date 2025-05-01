package fp;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FactoriaNetflix {
	private static ProduccionNetflix parse(String s) {
		String[] campos = s.split(",");
		Checkers.check("La línea debe de contener 8 campos", campos.length == 8);
		String titulo = campos[0].trim();
		Tipo tipo = Tipo.valueOf(campos[1].trim());
		Integer añoProduccion = Integer.parseInt(campos[2].trim());
		Duration duracion = Duration.parse(campos[3].trim());
		Set<String> generos = new HashSet<>(Arrays.stream(campos[4].replaceAll("[\\[\\]'']", "").split(";")).map(g -> g.trim()).collect(Collectors.toList()));
		Integer numeroTemporadas = Integer.parseInt(campos[5].trim());
		Double scoreIMDB = Double.parseDouble(campos[6].trim());
		Long popularidadIMDB = Long.parseLong(campos[7].trim());
		EstadisticasIMDB estadisticas = new EstadisticasIMDB(scoreIMDB, popularidadIMDB);
		return new ProduccionNetflix(titulo, tipo, añoProduccion, duracion, generos, numeroTemporadas, estadisticas);
	}
	
	public static CatalogoNetflix leeNetflix(String rutaFichero) {
		List<ProduccionNetflix> producciones = new ArrayList<>(); 
		List<String> lineas = Ficheros.leeFichero("Error leyendo fichero", rutaFichero);
		lineas.remove(0);
		for (String linea : lineas) {
			System.out.println(">>>" + linea);
			producciones.add(parse(linea));
		}
		return new CatalogoNetflix(producciones.stream());
	}
}
