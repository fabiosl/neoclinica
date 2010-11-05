var fieldId = 1;

function removerItem() {
	this.parentNode.parentNode.parentNode
			.removeChild(this.parentNode.parentNode);
}

function addItem(area, ids, valores) {
	if (!document.getElementById)
		return; // Prevent older browsers from getting any further.
	var field = "item_";
	var field_area = document.getElementById(area);

	var tr = document.createElement("tr");
	var td = document.createElement("td");

	var select = document.createElement("select");
	select.id = field + "select_" + fieldId;
	select.name = field + "select_" + fieldId;

	var tipos = valores.split("#");
	for (i = 0; i < ids.length; i++) {
		var option = document.createElement("option");
		option.text = tipos[i];
		option.value = ids[i];
		if (document.all && !window.opera) {
			select.add(option);
		} else {
			select.add(option, null);
		}
		;
	}

	var input = document.createElement("input");
	input.id = field + "input_" + fieldId;
	input.name = field + "input_" + fieldId;
	input.type = "text";

	var botao = document.createElement("a");
	botao.className = "delete";
	botao.onclick = removerItem;

	var span = document.createElement("span");
	span.className = "menuButton";

	span.appendChild(botao);

	td.appendChild(document.createTextNode("Lente  "));
	td.appendChild(select);
	td.appendChild(document.createTextNode("   Quantidade   "));
	td.appendChild(input);
	td.appendChild(document.createTextNode(" "));
	td.appendChild(span);

	tr.appendChild(td);
	field_area.appendChild(tr);

	fieldId += 1;
}

