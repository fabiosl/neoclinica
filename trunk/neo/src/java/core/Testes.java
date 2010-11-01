package core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Testes {

	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		System.out.println("Antes " + c.getTime().toString());
		c.add(Calendar.HOUR, 24);
		Date time = c.getTime();
		System.out.println("Depois " + c.getTime().toString());
	}
}
