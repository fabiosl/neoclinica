<div class="list">
<table>
	<thead>
		<tr>
			<g:sortableColumn property="id"
				title="${message(code: 'paciente.id.label', default: 'Id')}" action="list" params="['nome' : nomeBuscado]" />
			<g:sortableColumn property="nome"
				title="${message(code: 'paciente.nome.label', default: 'Nome')}" action="list" params="['nome' : nomeBuscado]" />
			<g:sortableColumn property="nascimento"
				title="${message(code: 'Idade')}" action="list" params="['nome' : nomeBuscado]" />
			<g:sortableColumn property="telefone"
				title="${message(code: 'paciente.telefone.label', default: 'Telefone')}" action="list" params="['nome' : nomeBuscado]" />
			<g:sortableColumn property="sexo"
				title="${message(code: 'paciente.sexo.label', default: 'Sexo')}" action="list" params="['nome' : nomeBuscado]" />
			<g:sortableColumn property="nascimento"
				title="${message(code: 'paciente.nascimento.label', default: 'Data de Nascimento')}" action="list" params="['nome' : nomeBuscado]" />
			<g:sortableColumn property="profissao"
				title="${message(code: 'paciente.profissao.label', default: 'Profiss&atilde;o')}" action="list" params="['nome' : nomeBuscado]" />
			<g:sortableColumn property="rg"
				title="${message(code: 'paciente.rg.label', default: 'RG')}" action="list" params="['nome' : nomeBuscado]" />
			<g:sortableColumn property="idExterno"
				title="${message(code: 'paciente.idExterno.label', default: 'ID Externo')}" action="list" params="['nome' : nomeBuscado]" />
			<g:sortableColumn property="convenio"
				title="${message(code: 'paciente.convenio.label', default: 'Conv&ecirc;nio')}" action="list" params="['nome' : nomeBuscado]" />
		</tr>
	</thead>
	<tbody>
		<g:each in="${pacienteInstanceList}" status="i" var="pacienteInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				<td><g:link action="show" id="${pacienteInstance.id}"
					name="${pacienteInstance.id}">
					${fieldValue(bean: pacienteInstance, field: "id")}
				</g:link></td>
				<td>
				${fieldValue(bean: pacienteInstance, field: "nome")}
				</td>
				<td>
				${pacienteInstance.calculaIdade()}
				</td>
				<td>
				${fieldValue(bean: pacienteInstance, field: "telefone")}
				</td>
				<td>
				${fieldValue(bean: pacienteInstance, field: "sexo")}
				</td>
				<td><g:formatDate format="dd/MM/yyyy"
					date="${pacienteInstance.nascimento}" /></td>
				<td>
				${fieldValue(bean: pacienteInstance, field: "profissao")}
				</td>
				<td>
				${fieldValue(bean: pacienteInstance, field: "rg")}
				</td>
				<td>
				${fieldValue(bean: pacienteInstance, field: "idExterno")}
				</td>
				<td>
				${fieldValue(bean: pacienteInstance, field: "convenio")}
				</td>
			</tr>
		</g:each>
	</tbody>
</table>
</div>
