package fp.utiles;

public class Validators {

	public static Boolean sonDigitos(String cadena) {
		Boolean res = true;
		for (int i = 0; i < cadena.length(); i++) {
			if (! Character.isDigit(cadena.charAt(0))) {
				res = false;
			}
		}
		return res;
	}
}
