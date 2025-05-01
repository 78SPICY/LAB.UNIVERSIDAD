package fp;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import fp.utiles.Checkers;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.SortedMap;
import java.util.Map;
import java.util.TreeMap;

public class VinotecaStream implements Vinoteca {
	
	
	// Atributos
	public Set<Vino> vinos;
	
	
	// Constructor sin parámetros
	public VinotecaStream() {
		this.vinos = new HashSet<>();
	}
	
	
	// Constructor a partir de una Collection de Vino
	public VinotecaStream(Collection<Vino> colecVinos) {
		this.vinos = new HashSet<Vino>(colecVinos);
	}
	
	
	// Operaciones
	public void agregarVino(Vino vino) {
		vinos.add(vino);
	}
		
	public void eliminarVino(Vino vino) {
		Checkers.check("No existe el elemento en el conjunto", vinos.contains(vino));
		vinos.remove(vino);
	}
		
	public Integer obtenerNumeroVinos() {
		int res = 0;
		for (int i = 0; i < vinos.size(); i++) {
			res++;
		}
		return res;		
	}
		
	public boolean contieneVino(Vino vino) {
		return vinos.contains(vino);
	}
		
	public void agregarVinos(Collection<Vino> colecVinos) {
		vinos.addAll(colecVinos);
	}
		
	public boolean contieneVinos(Collection<Vino> colecVinos) {
		return vinos.containsAll(colecVinos);
	}
	
	// Tratamientos secuenciales simples
	public double calcularNumeroVinosDePais(String pais) {
		return vinos.stream().filter(v -> v.pais().equals(pais)).count();
	}
	
	public Collection<Vino> obtenerVinosRangoPuntos(int inf, int sup) {
		Checkers.check("El valor límite inferior del rango es superior al valor del límite superior.", inf > sup);
		return vinos.stream().filter(v -> v.puntos() >= inf && v.puntos() <= sup).toList();	
		}
	
	public double calcularNumeroVinosDePaisConPuntuacionSuperior(String pais, int umbral) {
		return vinos.stream().filter(v -> v.puntos() > umbral).count();
	}
	
	public Set<Vino> obtenerVinosBaratos(double precio) {
		return vinos.stream().filter(v -> v.puntos() < precio).collect(Collectors.toSet());	
	}
	
	public boolean existeVinoDeUvaEnRegion(String region, String uva) {
		return vinos.stream().anyMatch(v -> v.uva().equals(uva) && v.region().equals(region)); 
	}
	
	// Tratamientos secuenciales de acumulación
	public Set<String> calcularUvasDeRegion(String region) {
		return vinos.stream().filter(v -> v.region().equals(region)).map(v -> v.uva()).collect(Collectors.toSet());
	}

	public int calcularTotalPuntosVinosDeRegion(String region) {
		return vinos.stream().filter(v -> v.region().equals(region)).mapToInt(v -> v.puntos()).sum();
	}
	
	public double calcularMediaPuntosVinosDeUva(String uva) {
		return vinos.stream().filter(v -> v.uva().equals(uva)).mapToInt(v -> v.puntos()).average().getAsDouble();
	}
	
	// Tratamientos secuanciales con criterios de ordenación
	public Vino obtenerVinoMejorPuntuado() {	
		return vinos.stream().max(Comparator.comparing(v -> v.puntos())).get();
	}
	
	public Vino obtenerVinoMejorPuntuadoDePais(String pais) {
		return vinos.stream().filter(v -> v.pais() == pais).max(Comparator.comparingInt(v -> v.puntos())).orElseThrow(() -> new NoSuchElementException("No se pudo calcular."));	
	}
	
	public List<Vino> obtenerNVinosRegionOrdenadosPrecio(String region, int n) {
		return vinos.stream().filter(v -> v.region().equals(region)).sorted(Comparator.comparing(Vino::precio).reversed()).limit(n).toList();
	}
	
	// Tratamientos secuenciales con Map
	public Map<String, List<Vino>> agruparVinosPorPais() {
		return vinos.stream().collect(Collectors.groupingBy(Vino::pais));
	}
		
	public Map<String, Set<String>> agruparUvasPorPais() {
		return vinos.stream().collect(Collectors.groupingBy(Vino::pais, Collectors.mapping(Vino::uva, Collectors.toSet())));
	}
	
	public Map<String, Long> calcularCalidadPrecioPorRegionMayorDe(double umbral) {
		return vinos.stream().filter(v -> v.getCalidadPrecio() > umbral).collect(Collectors.groupingBy(Vino::region, Collectors.counting()));
	}
	
	public Map<String, Vino> calcularVinoMasCaroPorPais() {
		return vinos.stream().collect(Collectors.groupingBy(Vino::pais, Collectors.collectingAndThen(Collectors
		.maxBy(Comparator.comparingDouble(Vino::precio)), optionalVino -> optionalVino.orElse(null))));
	}

	public SortedMap<String, List<Vino>> calcularNMejoresVinosPorPais(int n) {
		return vinos.stream().collect(Collectors.groupingBy(Vino::pais, TreeMap::new, Collectors.collectingAndThen(
		Collectors.toList(), listaVinos -> { 
		listaVinos.sort((v1, v2) -> Integer.compare(v2.puntos(), v1.puntos()));
		return listaVinos.subList(0, Math.min(n, listaVinos.size())); 
		})));
	}

	public String calcularRegionConMejoresVinos(double umbral) {
		return vinos.stream().filter(v -> v.getCalidadPrecio() > umbral).collect(Collectors.groupingBy(Vino::region, Collectors.counting()))
		.entrySet().stream().sorted(Comparator.comparingLong(Map.Entry<String, Long>::getValue).reversed()).findFirst().map(Map.Entry::getKey).get();
	}
}