package fp.universidad.tipos;
import fp.utiles.Ficheros;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class FactoriaUniversidad {
	
	
	// FUNCIONES PARA ESPACIO
	public static Espacio creaEspacio(String parametrosEspacio) {
		Espacio espacioNuevo = new Espacio(parametrosEspacio);
		return espacioNuevo;
	}
	
	public static List<Espacio> leeEspacios(String nombreFichero) {
		List<Espacio> espacios = new ArrayList<>();
		List<String> lineas = Ficheros.leeFichero("Error leyendo fichero", nombreFichero);
		for (String linea : lineas) {
			System.out.println(">>>" + linea);
			espacios.add(creaEspacio(linea));
		}
		return espacios;
	}
	
	
	//FUNCIONES PARA DESPACHO
	public static Despacho creaDespacho(String parametrosDespacho) {
		Despacho despachoNuevo = new Despacho(parametrosDespacho);
		return despachoNuevo;
	}
	
	public static List<Despacho> leeDespachos(String nombreFichero) {
		List<Despacho> despachos = new ArrayList<>();
		List<String> lineas = Ficheros.leeFichero("Error leyendo fichero", nombreFichero);
		for (String linea : lineas) {
			System.out.println(">>>" + linea);
			despachos.add(creaDespacho(linea));
		}
		return despachos;
	}

	
	//FUNCIONES PARA ALUMNO
	public static Alumno creaAlumno(String parametrosAlumno) {
		String[] lineaParametros = parametrosAlumno.split(",");
		String dni = lineaParametros[0].trim();
		String nombre = lineaParametros[1].trim();
		String apellidos = lineaParametros[2].trim();
		LocalDate fechaNacimiento = LocalDate.parse(lineaParametros[3].trim());
		String email = lineaParametros[4].trim();
		Alumno alumnoNuevo = new Alumno(dni, nombre, apellidos, fechaNacimiento, email);
		return alumnoNuevo;
		
	}
	public static List<Alumno> leeAlumnos(String nombreFichero) {
		List<Alumno> alumnos = new ArrayList<>();
		List<String> lineas = Ficheros.leeFichero("Error leyendo fichero", nombreFichero);
		lineas.remove(0);
		for (String linea : lineas) {
			alumnos.add(creaAlumno(linea));
		}
		return alumnos;
	}
	
	
	//FUNCIONES PARA ASIGNATURA
	public static Asignatura creaAsignatura(String parametrosAsignatura) {
		String[] lineaParametros = parametrosAsignatura.split(",");
		String nombre = lineaParametros[0].trim();
		String codigo = lineaParametros[1].trim();
		Double creditos = Double.parseDouble(lineaParametros[2].trim());
		TipoAsignatura tipoAsignatura = TipoAsignatura.valueOf(lineaParametros[3].trim().toUpperCase());
		Integer curso = Integer.parseInt(lineaParametros[4].trim());
		Asignatura asignaturaNueva = new Asignatura(nombre, codigo, creditos, tipoAsignatura, curso);
		return asignaturaNueva;
	}
	
	public static List<Asignatura> leeAsignaturas(String nombreFichero) {
		List<Asignatura> asignaturas = new ArrayList<>();
		List<String> lineas = Ficheros.leeFichero("Error leyendo fichero", nombreFichero);
		lineas.remove(0);
		for (String linea : lineas) {
			asignaturas.add(creaAsignatura(linea));
		}
		return asignaturas;
	}
	
	
	//FUNCIONES PARA NOTA
	public static Nota creaNota(String parametrosNota) {
		String parametrosAsignatura = parametrosNota.subSequence(0, 5).toString();
		Asignatura asignatura = FactoriaUniversidad.creaAsignatura(parametrosAsignatura); 
		String[] lineaParametros = parametrosNota.split(",");
		Integer curso = Integer.parseInt(lineaParametros[5].trim());
		Convocatoria convocatoria = Convocatoria.valueOf(lineaParametros[6].trim().toUpperCase());
		Double valor = Double.parseDouble(lineaParametros[7].trim());
		boolean mencionHonor = Boolean.parseBoolean(lineaParametros[8].trim().toLowerCase());
		Nota notaNueva = new Nota(asignatura, curso, convocatoria, valor, mencionHonor);
		return notaNueva;
	}
	
	public static List<Nota> leeNotas(String nombreFichero) {
		List<Nota> notas = new ArrayList<>();
		List<String> lineas = Ficheros.leeFichero("Error leyendo fichero", nombreFichero);
		lineas.remove(0);
		for (String linea : lineas) {
			notas.add(creaNota(linea));
		}
		return notas;
	}
}
