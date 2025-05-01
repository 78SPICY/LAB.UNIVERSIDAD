package fp;
import fp.utiles.Checkers;

public record Vino(String pais, String region, Integer puntos, Double precio, String uva) {

	// Restricción
	public Vino {
		Checkers.check("Los puntos deben de estar entre cero y cien", puntos <= 100 && puntos >= 0);
		Checkers.check("El precio debe de ser mayor que 0", precio > 0);
	}
	
	// Método para obtener la proporción calidad-precio
	public Double getCalidadPrecio() {
		return puntos/precio;
	}
}
