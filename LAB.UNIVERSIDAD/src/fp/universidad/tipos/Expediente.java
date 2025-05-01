package fp.universidad.tipos;
import java.util.List;
import java.util.ArrayList;

public class Expediente {
	
	
	// Atributos
	private List<Nota> listaNotas;
	
	
	// Constructores
	public Expediente() {
		this.listaNotas = new ArrayList<>(); // El constructor está definido sin parámetros, el tipo se inicializa a partir de una lista vacía
	}
	
	
	// Método para obtener la nota media
	public double getNotaMedia() {
		double suma = 0;
		int contador = 0;
		for (Nota n : listaNotas) {
			if (n.valor() >= 5) {
				suma += n.valor();
				contador++;
			}
		}
		if (contador > 0) {
				return suma/contador;
			} else {
				return 0.0;
			}
	}

	
	// Método para añadir nuevas notas
	public void nuevaNota(Nota a) {
		listaNotas.removeIf(n -> n.equals(a));
		listaNotas.add(a);	
	}
	
	
	// Getters
	public List<Nota> getListaNotas() {
		return new ArrayList<>(listaNotas);
	}
	
	
	// Método toString()
	public String toString() {
		return listaNotas.toString();
	}
	
	
	// Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Expediente) {
			Expediente a = (Expediente)obj;
			if (a.listaNotas.size() == this.listaNotas.size()) { 
				for (int i = 0; i < a.listaNotas.size(); i++) {
					if (a.listaNotas.get(i).equals(this.listaNotas.get(i))) {
						res = true;
						break;
					}
				}
			}
		}
		return res;
	}
}