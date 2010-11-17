package controllers

import java.util.Calendar;
import java.util.Date;

import core.DateParser;
import core.Medico
import core.ProcedimentoMedico

class AgendaController {
	
	def procedimentos
	def index = {
	}
	
	def escolherMedico = {
		def idMedico = params.medico
		redirect(action:'semanal', params : [medico: idMedico])
	}
	
	def semanal = {
		def idMed = params.medico
		def medico = Medico.get(idMed)
		def procedimentos = ProcedimentoMedico.createCriteria().list() {
                               eq("medico", medico)
        }
		return [tudo: procedimentos, dataCalendar: DateParser.getFirstDayOfWeek(new Date())]
	}
	
	def inicio = {
		redirect(action:'index')
	}
	
	def day = {
		def dia = DateParser.addZeros(Integer.parseInt(params.day), 2)
		def mes = DateParser.addZeros(Integer.parseInt(params.month), 2)
		def ano = DateParser.addZeros(Integer.parseInt(params.year), 4)
		def data = DateParser.getDateFromString(dia + "/" + mes + "/" + ano)
		Calendar c = Calendar.getInstance()
		c.setTime(data)
		c.add(Calendar.DAY_OF_MONTH, 1)
		def dataDois = c.getTime()
		def procedimentos = ProcedimentoMedico.findAllByDataBetween(data, dataDois)
		return [dataDia: data, procs: procedimentos]
	}
}
