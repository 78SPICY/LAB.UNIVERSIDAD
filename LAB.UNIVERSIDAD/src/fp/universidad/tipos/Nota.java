package fp.universidad.tipos;

import java.util.Objects;
import fp.utiles.Checkers;

	// Constructores
	public record Nota(	
		Asignatura asignatura,
		Integer curso,
		Convocatoria convocatoria,
		Double valor,
		Boolean mencionHonor) implements Comparable<Nota> {

		
	// Restricciones
	public Nota {
		Checkers.check("Las notas deben de estar comprendidas entre cero y diez. Introduzca otro nuevo", valor >= 0 && valor <= 10);
		Checkers.check("Solo se puede obtener una mención de honor con una nota de 9 o más.", !mencionHonor && valor < 9 || mencionHonor && valor >= 9);
	}

	
	// Constructor extra
    public Nota(Asignatura asignatura, Integer curso, Convocatoria convocatoria, Double valor) {
        this(asignatura, curso, convocatoria, valor, false); 
    }
    
    
    // Método para obtener la calificación
	public Calificacion getCalificacion() {
		Calificacion res = null;
		if (valor < 5) {
			res = Calificacion.SUSPENSO;
		}
		
		else if (valor < 7) {
			res = Calificacion.APDOBADO;
		}
		
		else if (valor < 9) {
			res = Calificacion.NOTABLE;
		}
		
		else if (mencionHonor) {
			res = Calificacion.MATRICULA_DE_HONOR;
		}
		
		else {
			res = Calificacion.SOBRESALIENTE;
		}
		return res;
	}
	

	// Método toString()
	public String toString() {
		return "(" + asignatura.codigo() + ")" + " " + asignatura.nombre() + ", " + curso + 
				"-" + (curso + 1) + ", " + convocatoria + ", " + valor + ", " + getCalificacion();
	}
	
	
	// Método equals()
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Nota) {
			Nota a = (Nota)obj;
			res = this.curso.equals(a.curso) && this.asignatura.equals(a.asignatura) && this.convocatoria.equals(a.convocatoria);
		}
	return res;
	}
	
	
	// Método hashCode()
	public int hashCode() {
		return Objects.hash(curso, asignatura, convocatoria);
	}
	
	
	// Método compareTo()
	public int compareTo(Nota a) {
		int res = this.curso.compareTo(a.curso);
		if (res == 0) {
			res = this.asignatura.compareTo(a.asignatura);
			if (res == 0) {
				res = this.convocatoria.compareTo(a.convocatoria);
			}
		}
		return res;
	}
}
