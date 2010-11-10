package core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateParser {

	public static Date getDateFromString(String date) throws ParseException{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.parse(date);
	}
	
	public static Date getFirstDayOfWeek(Date data){
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		while(c.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY){
			c.add(Calendar.DAY_OF_WEEK, -1);
		}
		return c.getTime();
	}

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
	
	public static String addZeros(int field, int legth){
		String s = String.valueOf(field);
		while(s.length() < legth){
			s = "0" + s;
		}
		return s;
	}
}
