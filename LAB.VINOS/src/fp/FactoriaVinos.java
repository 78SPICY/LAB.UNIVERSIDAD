package fp;

import java.util.ArrayList;
import java.util.List;
import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaVinos {
	
	// Método para construir un objeto de tipo Vino a partir de un String
	private static Vino parsearVino(String nombreFichero) {
		String[] campos = nombreFichero.split(",");
		Checkers.check("La linea debe de contener 5 campos", campos.length == 5);
		String pais = campos[0].trim();
		String region = campos[1].trim();
		int puntos = Integer.parseInt(campos[2].trim());
		double precio = Double.parseDouble(campos[3].trim());
		String uva = campos[4].trim();
		
		return new Vino(pais, region, puntos, precio, uva);
	}
	
	// Método para crear una lista de objetos de tipo Vinos a partir de un fichero
	public static Vinoteca leerVinoteca(String nombreFichero) {
		List<Vino> vinos = new ArrayList<>(); 
		List<String> lineas = Ficheros.leeFichero("Error leyendo fichero", nombreFichero);
		lineas.remove(0);
		for (String linea : lineas) {
			System.out.println(">>>" + linea);
			vinos.add(parsearVino(linea));
		}
		return new VinotecaBucles(vinos);
	}
}