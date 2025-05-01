package fp;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;

import fp.utiles.Checkers;

public class VinotecaBucles implements Vinoteca {
	public Set<Vino> vinos;
	
	// Constructor sin parámetros
	public VinotecaBucles() {
		this.vinos = new HashSet<>();
	}
	
	// Constructor a partir de una Collection de Vino
	public VinotecaBucles(Collection<Vino> colecVinos) {
		this.vinos = new HashSet<Vino>(colecVinos);
	}
	
	
	// Método toString()
	public String toString() {
		return String.valueOf(obtenerNumeroVinos());
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

	public double calcularNumeroVinosDePais(String pais) {
	    int contador = 0;
	    for (Vino v : vinos) {
	        if (v.pais().equals(pais)) {
	            contador++;
	        }
	    }
	    return contador;
	}

	public Collection<Vino> obtenerVinosRangoPuntos(int inf, int sup) {
	    Checkers.check("El valor límite inferior del rango es superior al valor del límite superior.", inf > sup);
	    List<Vino> resultado = new ArrayList<>();
	    for (Vino v : vinos) {
	        if (v.puntos() >= inf && v.puntos() <= sup) {
	            resultado.add(v);
	        }
	    }
	    return resultado;
	}

	public double calcularNumeroVinosDePaisConPuntuacionSuperior(String pais, int umbral) {
	    int contador = 0;
	    for (Vino v : vinos) {
	        if (v.pais().equals(pais) && v.puntos() > umbral) {
	            contador++;
	        }
	    }
	    return contador;
	}

	public Set<Vino> obtenerVinosBaratos(double precio) {
	    Set<Vino> resultado = new HashSet<>();
	    for (Vino v : vinos) {
	        if (v.puntos() < precio) {
	            resultado.add(v);
	        }
	    }
	    return resultado;
	}

	public boolean existeVinoDeUvaEnRegion(String region, String uva) {
	    for (Vino v : vinos) {
	        if (v.uva().equals(uva) && v.region().equals(region)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public Set<String> calcularUvasDeRegion(String region) {
	    Set<String> uvas = new HashSet<>();
	    for (Vino v : vinos) {
	        if (v.region().equals(region)) {
	            uvas.add(v.uva());
	        }
	    }
	    return uvas;
	}

	public int calcularTotalPuntosVinosDeRegion(String region) {
	    int total = 0;
	    for (Vino v : vinos) {
	        if (v.region().equals(region)) {
	            total += v.puntos();
	        }
	    }
	    return total;
	}

	public double calcularMediaPuntosVinosDeUva(String uva) {
	    int suma = 0;
	    int contador = 0;
	    for (Vino v : vinos) {
	        if (v.uva().equals(uva)) {
	            suma += v.puntos();
	            contador++;
	        }
	    }
	    return (contador > 0) ? (double) suma / contador : 0.0;
	}

	public Vino obtenerVinoMejorPuntuado() {
		List<Vino> listaVinos = new ArrayList<>(vinos);
	    Vino mejor = listaVinos.get(0);
	    for (Vino v : listaVinos) {
	        if (v.puntos() > mejor.puntos()) {
	            mejor = v;
	        }
	    }
	    return mejor;
	}

	public Vino obtenerVinoMejorPuntuadoDePais(String pais) {
	    Vino mejor = null;
	    for (Vino v : vinos) {
	        if (v.pais().equals(pais)) {
	            if (mejor == null || v.puntos() > mejor.puntos()) {
	                mejor = v;
	            }
	        }
	    }
	    return mejor;
	}

	public List<Vino> obtenerNVinosRegionOrdenadosPrecio(String region, int n) {
	    List<Vino> filtrados = new ArrayList<>();
	    for (Vino v : vinos) {
	        if (v.region().equals(region)) {
	            filtrados.add(v);
	        }
	    }
	    filtrados.sort(Comparator.comparingDouble(v -> v.precio()));
	    return filtrados.subList(0, Math.min(n + 1, filtrados.size()));
	}

	public Map<String, List<Vino>> agruparVinosPorPais() {
	    Map<String, List<Vino>> mapa = new HashMap<>();
	    for (Vino v : vinos) {
	        mapa.computeIfAbsent(v.pais(), k -> new ArrayList<>()).add(v);
	    }
	    return mapa;
	}

	public Map<String, Set<String>> agruparUvasPorPais() {
	    Map<String, Set<String>> mapa = new HashMap<>();
	    for (Vino v : vinos) {
	        mapa.computeIfAbsent(v.pais(), k -> new HashSet<>()).add(v.uva());
	    }
	    return mapa;
	}

	public Map<String, Long> calcularCalidadPrecioPorRegionMayorDe(double umbral) {
	    Map<String, Long> mapa = new HashMap<>();
	    for (Vino v : vinos) {
	        if (v.puntos() / v.precio() > umbral) {
	            mapa.put(v.region(), mapa.getOrDefault(v.region(), 0L) + 1);
	        }
	    }
	    return mapa;
	}

	public Map<String, Vino> calcularVinoMasCaroPorPais() {
	    Map<String, Vino> mapa = new HashMap<>();
	    for (Vino v : vinos) {
	        String pais = v.pais();
	        if (!mapa.containsKey(pais) || v.precio() > mapa.get(pais).precio()) {
	            mapa.put(pais, v);
	        }
	    }
	    return mapa;
	}

	public SortedMap<String, List<Vino>> calcularNMejoresVinosPorPais(int n) {
	    SortedMap<String, List<Vino>> mapa = new TreeMap<>();
	    for (Vino v : vinos) {
	        mapa.computeIfAbsent(v.pais(), k -> new ArrayList<>()).add(v);
	    }
	    for (String pais : mapa.keySet()) {
	        List<Vino> lista = mapa.get(pais);
	        lista.sort(Comparator.comparingInt(Vino::puntos).reversed());
	        mapa.put(pais, lista.subList(0, Math.min(n + 1, lista.size())));
	    }
	    return mapa;
	}

	public String calcularRegionConMejoresVinos(double umbral) {
	    Map<String, Long> contadorPorRegion = new HashMap<>();
	    for (Vino v : vinos) {
	        if (v.puntos() > umbral) {
	            contadorPorRegion.put(v.region(), contadorPorRegion.getOrDefault(v.region(), 0L) + 1);
	        }
	    }
	    String mejorRegion = null;
	    long max = -1;
	    for (Map.Entry<String, Long> entry : contadorPorRegion.entrySet()) {
	        if (entry.getValue() > max) {
	            max = entry.getValue();
	            mejorRegion = entry.getKey();
	        }
	    }
	    return mejorRegion;
	}
}