package fp.utiles;

import java.time.DayOfWeek;

public class CharOfWeekDay {
	public static char getChar(DayOfWeek diaSemana) {
		char diaSemanaChar;
		switch (diaSemana) {
			case MONDAY -> diaSemanaChar = 'L';
			case TUESDAY -> diaSemanaChar = 'M';
			case WEDNESDAY -> diaSemanaChar = 'X';
			case THURSDAY -> diaSemanaChar = 'J';
			case FRIDAY -> diaSemanaChar = 'V';
			default -> throw new IllegalArgumentException("Una tutoría no puede darse en un fin de semana. Introduzca un día válido.");
		}
		return diaSemanaChar; 
	}
}