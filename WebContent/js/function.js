function collapse(element) {
	$(element).toggleClass('active');
}

function selectRow(row)
{
    var firstInput = row.getElementsByTagName('input')[0];
    firstInput.checked = !firstInput.checked;
}

function delesectAll() {
	var field = document.getElementsByName('nomi_ingredienti')[0];	
	var id = document.getElementsByName('id_ingredienti')[0];
	field.value = "";
	id.value = "";
	var tbl = document.getElementById('table');
	var numRows = tbl.rows.length;
	for(var i=1; i<numRows; i++) {
		var input = tbl.rows[i].getElementsByTagName('input')[0];
		if(input.checked) {
			input.checked = !input.checked;
		}
	}
}

function printSelected() {
	var tbl = document.getElementById('table');
	var field = document.getElementsByName('nomi_ingredienti')[0];
	var id = document.getElementsByName('id_ingredienti')[0];
	field.value = "";
	id.value = "";
	var numRows = tbl.rows.length;
	var cont = 0;
	
	for(var i=1; i<numRows; i++) {
		var text = tbl.rows[i].getElementsByTagName('td')[1].innerText;
		var cod = tbl.rows[i].getElementsByTagName('td')[0].innerText;
		var input = tbl.rows[i].getElementsByTagName('input')[0];
		if(input.checked) {
			if(cont == 0) {				
				field.value = text;
				id.value = cod;
			}else {
				field.value += ", "+text;
				id.value += ", "+cod;
			}
			cont++;
		}
	}	
}