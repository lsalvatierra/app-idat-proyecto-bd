$(document).on("click", "#btnagregaralumno", function() {
	$("#txtnomalumno").val("");
	$("#txtapealumno").val("");
	$("#txtprocedencia").val("");
	$("#cboespecialidad").val("0");
	$("#hddidalumno").val("0");
	$("#modalalumno").modal("show");
});


$(document).on("click", ".btnactualizaralumno", function() {
	$("#hddidalumno").val($(this).attr("data-codalumno"));
	$("#txtnomalumno").val($(this).attr("data-nomalumno"));
	$("#txtapealumno").val($(this).attr("data-apealumno"));
	$("#cboespecialidad").val($(this).attr("data-idesp"));
	$("#txtprocedencia").val($(this).attr("data-proce"));
	$("#modalalumno").modal("show");
});

$(document).on("click", "#btnregistraralumno", function() {

	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: '/Alumno/registrarAlumno',
		data: JSON.stringify({
			idalumno: $("#hddidalumno").val(),
			nomalumno: $("#txtnomalumno").val(),
			apealumno: $("#txtapealumno").val(),
			idesp: $("#cboespecialidad").val(),
			proce: $("#txtprocedencia").val()
		}),
		success: function(resultado) {
			if (resultado.respuesta) {
				mostrarMensaje(resultado.mensaje, "success");
				ListarAlumnos();
			} else {
				mostrarMensaje(resultado.mensaje, "danger");
			}
		}
	});
	$("#modalalumno").modal("hide");
});
function ListarAlumnos(){
	$.ajax({
		type: 'GET',
		url: '/Alumno/listarAlumnos',
		dataType: 'json',
		success: function(resultado) {
			$("#tblalumno > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblalumno > tbody").append("<tr>"+
				"<td>"+value.idalumno+"</td>"+
				"<td>"+value.nomalumno+"</td>"+
				"<td>"+value.apealumno+"</td>"+
				"<td>"+value.nomesp+"</td>"+
				"<td><button type='button' class='btn btn-primary btnactualizaralumno'"+
				" data-codalumno='"+value.idalumno+"'"+
				" data-nomalumno='"+value.nomalumno+"'"+
				" data-apealumno='"+value.apealumno+"'"+
				" data-idesp='"+value.idesp+"'"+
				" data-proce='"+value.proce+"'>Actualizar</button></td>"+
				"<td><button type='button' class='btn btn-danger btneliminaralumno'"+
				" data-codalumno='"+value.idalumno+"'"+
				" data-nomalumno='"+value.nomalumno+"'>Eliminar</button></td>"+
				"</tr>");
			});
		}
	});

}

function mostrarMensaje(mensaje, estilo) {
	$("#mensaje").html("");
	$("#mensaje").append("<div class='alert alert-" + estilo + " alert-dismissible fade show' role='alert'>" +
		"<strong>" + mensaje + "</strong>" +
		"<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button>" +
		"</div>");

}