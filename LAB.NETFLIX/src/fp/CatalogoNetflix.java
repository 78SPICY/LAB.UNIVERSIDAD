package fp;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.List;
import java.time.Duration;
import java.util.Optional;

public class CatalogoNetflix {
	public SortedSet<ProduccionNetflix> producciones;
	
	// Constructor
	public CatalogoNetflix(Stream<ProduccionNetflix> parametro) {
		producciones = new TreeSet<>(parametro.collect(Collectors.toSet()));
	}
	
	// Método toString()
	public String toString() {
		return producciones.toString();
	}
	
	// Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof CatalogoNetflix) {
			CatalogoNetflix a = (CatalogoNetflix)obj;
			res = this.producciones.equals(a.producciones);
		}
		return res;
	}
	
	// Tratamientos secuenciales (Ejercicio 4)
	public Map<String, Set<ProduccionNetflix>> getProduccionesPorGenero() {
		Map<String, Set<ProduccionNetflix>> serie = new HashMap<>();
		producciones.stream().flatMap(p -> p.getGeneros().stream().map(g -> Map.entry(g, p))).forEach(entry -> {
			String genero = entry.getKey();
			ProduccionNetflix produccion = entry.getValue();
			serie.computeIfAbsent(genero, k -> new HashSet<>()).add(produccion);
		});
		return serie;
	}
	
	public SortedSet<String> getGeneros() {
		return new TreeSet<String>(producciones.stream().flatMap(p -> p.getGeneros().stream()).toList());
	}
	
	public List<String> getTitulosDeGenerosOrdenadosPorTamanyo(List<String> genres) {
		return producciones.stream().filter(p -> p.getGeneros().containsAll(genres)).map(p -> p.getTitulo()).toList();
	}
	
	public String getGeneroConMayorPopularidadAcumulada() {
		return producciones.stream().flatMap(p -> p.getGeneros().stream().map(g -> Map.entry(g, p.getPopularidadIMDB())))
		.collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingDouble(Map.Entry::getValue))).entrySet()
		.stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElseGet(null);
	}
	
	public SortedMap<Integer, Double> getMediaTopNScoresDeGeneroPorAnyo(String genero, Integer n) {
	    return producciones.stream().map(ProduccionNetflix::getAñoProduccion).distinct().collect(Collectors.toMap(año -> año,
	    año -> producciones.stream().filter(p -> p.getAñoProduccion() == año && p.getGeneros().contains(genero))
	    .mapToDouble(ProduccionNetflix::getScoreIMDB).boxed().sorted(Comparator.reverseOrder()).limit(n)
	    .mapToDouble(Double::doubleValue).average().orElse(0.0),(v1, v2) -> v1, TreeMap::new));
	}

	// Tratamientos secuenciales (Ejercicio 5)
	public SortedMap<Integer, String> getTituloDeTipoMasPopularPorAnyo(Tipo tipo) {
	    return producciones.stream().filter(p -> p.getTipo() == tipo).collect(Collectors.groupingBy(ProduccionNetflix::getAñoProduccion, 
	    Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingLong(ProduccionNetflix::getPopularidadIMDB)), opt -> opt.
	    map(ProduccionNetflix::getTitulo).orElse("Desconocido")))).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
	    Map.Entry::getValue, (a, b) -> a, TreeMap::new));
	}

	public Double getDuracionMediaDeAnyoYTipo(Tipo tipo, Integer anyo) {
		return producciones.stream().filter(p -> p.getTipo() == tipo && p.getAñoProduccion() == anyo).map(ProduccionNetflix::getDuracion)
		.map(Duration::toMinutes).mapToDouble(Long::doubleValue).average().getAsDouble();
	}
	
	public List<Integer> getAnyosConScoreMedioSuperior(Double umbralScore) {
		return producciones.stream().filter(p -> p.getScoreIMDB() > umbralScore).map(ProduccionNetflix::getAñoProduccion).distinct()
		.sorted().toList();
	}
	
	public Map<Integer, Double> getPorcentajeTemporadasSeriesPorAnyo() {
	    long totalTemporadas = producciones.stream().filter(p -> p.getTipo() == Tipo.SHOW)
	    .mapToLong(ProduccionNetflix::getNumeroTemporadas).sum();

	    return producciones.stream().filter(p -> p.getTipo() == Tipo.SHOW).collect(Collectors.groupingBy
	    (ProduccionNetflix::getAñoProduccion, Collectors.summingLong(ProduccionNetflix::getNumeroTemporadas)))
	    .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> (e.getValue() * 100.0) / totalTemporadas));
	}
	
	public Map<Tipo, ProduccionNetflix> getProduccionMenosScorePorTipo() {
		return producciones.stream().collect(Collectors.groupingBy(ProduccionNetflix::getTipo, Collectors.collectingAndThen(Collectors
		.minBy(Comparator.comparingDouble(ProduccionNetflix::getScoreIMDB)), Optional::get)));
	}
	
	public Map<Integer, Set<String>> getGenerosPorAnyo(Tipo tipo) {
		return producciones.stream().filter(p -> p.getTipo() == tipo).collect(Collectors.groupingBy(ProduccionNetflix::getAñoProduccion, 
		Collectors.flatMapping(p -> p.getGeneros().stream(), Collectors.toSet())));
	}

}
	


