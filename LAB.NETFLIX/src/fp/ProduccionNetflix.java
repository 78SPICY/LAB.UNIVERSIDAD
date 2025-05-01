package fp;
import java.util.Objects;
import java.util.Set;
import java.time.Duration;
import fp.utiles.Checkers;

public class ProduccionNetflix implements Comparable<ProduccionNetflix> {
	public String titulo;
	public Tipo tipo;
	public Integer añoProduccion;
	public Duration duracion;
	public Set<String> generos;
	public Integer numeroTemporadas;
	public Double scoreIMDB;
	public Long popularidadIMDB;
	
	
	// Constructor
	public ProduccionNetflix(String titulo, Tipo tipo, Integer añoProduccion, Duration duracion, Set<String> generos, Integer numeroTemporadas, EstadisticasIMDB estadisticas){
		this.titulo = titulo;
		this.tipo = tipo;
		this.añoProduccion = añoProduccion;
		this.duracion = duracion;
		this.generos = generos;
		this.numeroTemporadas = numeroTemporadas;
		this.scoreIMDB = estadisticas.scoreIMDB();
		this.popularidadIMDB = estadisticas.popularidadIMDB();
		
		// Restricciones
		Checkers.check("El año de producción debe de ser posterior a 1900", añoProduccion > 1900);
		Checkers.check("La puntuación de IMDB debe de estar comprendida entre 0 y 10", 0.0 <= scoreIMDB && scoreIMDB <= 10.0);
		Checkers.check("La popularidad eb IMDB debe ser igual o superior a 0", 0 <= popularidadIMDB);
		Checkers.check("Número de temporadas incorrecto.", (tipo == Tipo.MOVIE && numeroTemporadas == 0) || (tipo == Tipo.SHOW && numeroTemporadas >= 1));
	}


	
	
	// Getters
	public String getTitulo() {
		return titulo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Integer getAñoProduccion() {
		return añoProduccion;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public Set<String> getGeneros() {
		return generos;
	}

	public Integer getNumeroTemporadas() {
		return numeroTemporadas;
	}

	public Double getScoreIMDB() {
		return scoreIMDB;
	}

	public Long getPopularidadIMDB() {
		return popularidadIMDB;
	}

	
	// Método toString()
	public String toString() {
		return titulo + ", " + tipo + ", " + añoProduccion + ", " + duracion + ", " + generos + ", " + numeroTemporadas
		+ ", " + scoreIMDB + ", " + popularidadIMDB;
	}

	
	// Método hashCode()
	public int hashCode() {
		return Objects.hash(añoProduccion, titulo);
	}

	
	// Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof ProduccionNetflix) {
			ProduccionNetflix a = (ProduccionNetflix)obj;
			res = this.getTitulo().equals(a.getTitulo()) && this.getAñoProduccion().equals(a.getAñoProduccion());
		}
		return res;
	}
	
	// Método compareTo()
		public int compareTo(ProduccionNetflix a) {
			int res = this.getTitulo().compareTo(a.getTitulo());
			if (res == 0) {
				res = this.getAñoProduccion().compareTo(a.getAñoProduccion());
			}
			return res;
		}	
}