package java_tests;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

import core.DateParser;


public class DataParserTest extends TestCase{
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	Calendar calendar = Calendar.getInstance();

	@Test
	public void testAddZeros(){
		int dia = 9;
		int mes = 1;
		int ano = 90;
		String saidaCorretaUm = "09";
		String saidaCorretaDois = "01";
		String saidaCorretaTres = "0090";
		String saidaCorretaQuatro = "0000000090";
		String saidaCorretaCinco = "90";
		assertEquals(saidaCorretaUm, DateParser.addZeros(dia, 2));
		assertEquals(saidaCorretaDois, DateParser.addZeros(mes, 2));
		assertEquals(saidaCorretaTres, DateParser.addZeros(ano, 4));
		assertEquals(saidaCorretaQuatro, DateParser.addZeros(ano, 10));
		assertEquals(saidaCorretaCinco, DateParser.addZeros(ano, 2));
		assertEquals(saidaCorretaCinco, DateParser.addZeros(ano, 1));
	}
	
	@Test
	public void testGetStartingDate(){
		//Crio as datas e faco os testes.
		String dateOne = "30/04/1990 18:38";
		Date datOne = null;
		try {
			datOne = formato.parse(dateOne);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fim da criacao da data
		Date answer = DateParser.getStartingDate(datOne);
		assertEquals("Mon Apr 30 00:00:00 GMT-03:00 1990", answer.toString());
		
		String dateTwo = "01/11/2010 13:30";
		Date datTwo = null;
		try {
			datTwo = formato.parse(dateTwo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date answerTwo = DateParser.getStartingDate(datTwo);
		assertEquals("Mon Nov 01 00:00:00 GMT-03:00 2010", answerTwo.toString());
		
		String dateThree = "03/11/2010 00:00";
		Date datThree = null;
		try {
			datThree = formato.parse(dateThree);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date answerThree = DateParser.getStartingDate(datThree);
		assertEquals("Wed Nov 03 00:00:00 GMT-03:00 2010", answerThree.toString());
		
		String dateFour = "07/11/2010 23:59";
		Date datFour = null;
		try {
			datFour = formato.parse(dateFour);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date answerFour = DateParser.getStartingDate(datFour);
		assertEquals("Sun Nov 07 00:00:00 GMT-03:00 2010", answerFour.toString());
		
		String dateFive = "07/11/2010 23:90";
		Date datFive = null;
		try {
			datFive = formato.parse(dateFive);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date answerFive = DateParser.getStartingDate(datFive);
		assertEquals("Mon Nov 08 00:00:00 GMT-03:00 2010", answerFive.toString());
	}
}
