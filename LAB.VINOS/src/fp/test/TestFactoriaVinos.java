package fp.test;

import fp.FactoriaVinos;
import fp.Vinoteca;

public class TestFactoriaVinos {
	
	public static void main(String[] args) {
		testCreacionVinos("data/wine_reviews.csv");
	}

	private static void testCreacionVinos(String filename) {
		System.out.println("\nTEST de la creacion de vinos");
		try {
			Vinoteca vinos = FactoriaVinos.leerVinoteca(filename);
			System.out.println("   VINOS: "+ vinos);
		} catch(Exception e) {
			System.out.println("ExcepciÃ³n inesperada capturada:\n   " + e);	
		}
	}
}

