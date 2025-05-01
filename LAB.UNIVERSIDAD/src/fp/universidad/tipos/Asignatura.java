package fp.universidad.tipos;

import fp.utiles.Checkers;
import fp.utiles.Validators;

// Atributos
	public record Asignatura(
		String nombre,
		String codigo,
		Double creditos,
		TipoAsignatura tipoAsignatura,
		Integer curso) implements Comparable<Asignatura> {

		
	// Restricciones 
	public Asignatura {
		Checkers.check("Código inválido. Introduzca uno válido.", (esCodigoValido(codigo)));
	}
	
	private Boolean esCodigoValido(String codigo) {
		return codigo != null && codigo.length() == 7 && Validators.sonDigitos(codigo);
 	}
		
	
	// Método para obtener el acrónimo de una asignatura
	public String getAcronimo() {
		String[] palabras = nombre.split(" ");
		char[] primerasLetras = new char[palabras.length];
		for (int i = 0; i < palabras.length; i++) {
				primerasLetras[i] = palabras[i].charAt(0);
		}
		String acronimo = new String(primerasLetras);
		return acronimo;
	}
	
	
	// Método toString()
	public String toString() {
		return "(" + codigo + ") " + nombre;
	}
	
	
	// Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Asignatura) {
			Asignatura a = (Asignatura)obj;
			res = this.codigo().equals(a.codigo());
			}
		return res;
		}
	
	
	// Método hashCode()
	public int hashCode() {
		return codigo.hashCode();
	}
	
	
	// Método compareTo()
	public int compareTo(Asignatura a) {
		return codigo.compareTo(a.codigo);
	}
	
}
