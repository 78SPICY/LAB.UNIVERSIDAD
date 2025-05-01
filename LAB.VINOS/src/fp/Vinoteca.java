package fp;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public interface Vinoteca {
	void agregarVino(Vino vino);
	void eliminarVino(Vino vino);
	Integer obtenerNumeroVinos();
	boolean contieneVino(Vino vino);
	void agregarVinos(Collection<Vino> vino);
	boolean contieneVinos(Collection<Vino> vino);
	double calcularNumeroVinosDePais(String pais);
	Collection<Vino> obtenerVinosRangoPuntos(int inf, int sup);
	double calcularNumeroVinosDePaisConPuntuacionSuperior(String pais, int umbral);
	Set<Vino> obtenerVinosBaratos(double precio);
	boolean existeVinoDeUvaEnRegion(String region, String uva);
	Set<String> calcularUvasDeRegion(String region);
	int calcularTotalPuntosVinosDeRegion(String region);
	double calcularMediaPuntosVinosDeUva(String uva);
	public Vino obtenerVinoMejorPuntuado();
	public Vino obtenerVinoMejorPuntuadoDePais(String pais);
	public List<Vino> obtenerNVinosRegionOrdenadosPrecio(String region, int n);
	public Map<String, List<Vino>> agruparVinosPorPais();
	public Map<String, Set<String>> agruparUvasPorPais();
	public Map<String, Long> calcularCalidadPrecioPorRegionMayorDe(double umbral);
	public Map<String, Vino> calcularVinoMasCaroPorPais();
	public SortedMap<String, List<Vino>> calcularNMejoresVinosPorPais(int n);
	public String calcularRegionConMejoresVinos(double umbral);
}

