package fp;

import fp.utiles.Checkers;

public record EstadisticasIMDB(Double scoreIMDB, Long popularidadIMDB) {

	// Restricciones
	public EstadisticasIMDB {
	Checkers.check("La puntuación de IMDB debe de estar comprendida entre 0 y 10", 0.0 <= scoreIMDB && scoreIMDB <= 10.0);
	Checkers.check("La popularidad eb IMDB debe ser igual o superior a 0", 0 <= popularidadIMDB);
	}
}
