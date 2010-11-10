package controllers

import java.util.Calendar;
import java.util.Date;

import core.Medico
import core.ProcedimentoMedico

class AgendaController {
	
	def procedimentos
	def index = {
	}
	
	def escolherMedico = {
		def nomeMedico = params.medico
		redirect(action:'semanal', params : [medico: nomeMedico])
	}
	
	def semanal = {
		def medico = Medico.findByUserRealName(params.medico)
		procedimentos = ProcedimentoMedico.findByMedico(medico)
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		while(c.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY){
			c.add(Calendar.DAY_OF_WEEK, -1);
		}
		return [tudo: procedimentos, dataCalendar: c.getTime()]
	}
	
	def inicio = {
		redirect(action:'index')
	}
}
