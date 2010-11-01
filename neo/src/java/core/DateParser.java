package core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateParser {

	public static Date getStartingDate(Date atual){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(atual);
		String dia = addZeros(calendar.get(Calendar.DAY_OF_MONTH), 2);
		String mes = addZeros(calendar.get(Calendar.MONTH) + 1, 2);
		String ano = addZeros(calendar.get(Calendar.YEAR), 4);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date diaAtual = null;
		try {
			diaAtual = formato.parse(dia + "/" + mes + "/" + ano);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return diaAtual;
	}
	
	private static String addZeros(int field, int legth){
		String s = String.valueOf(field);
		while(s.length() < legth){
			s = "0" + s;
		}
		return s;
	}
}
