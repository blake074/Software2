processGet = (estados) => {
    $("#tblEstados").removeClass("ocultar");
    $("#tblEstados").addClass("mostrar");

    let tbody = $("#tblEstados tbody");
    tbody.html("");

    if(estados.length <= 0){
        let tr = $("<tr></tr>");
        tr.append("<tr><td colspan = '3'>No se encontraron estados</td></tr>");
        tbody.append(tr);
    }
    else {
        estados.forEach (estado => {
            tbody.append(createTr(estado));
        });
    }
}

createTd = (value) => {
    return $("<td>"+value+"</td>");
}

createTdEdit = (estado) => {
    let td = createTd("Editar");
    td.click(function () {
        showForm(estado);
    });
    return td;
}

createTdDelete = (estado) => {
    let td = createTd("Eliminar");
    td.click(function () {
        invokeDelete(estado);
    });
    return td;
}

createTr = (estado) => {
    let tr = $("<tr></tr>");

    tr.append(createTd(estado.id_estado_proyecto));
    tr.append(createTd(estado.descripcion_estado_proyecto));

    tr.append(createTdEdit(estado));
    tr.append(createTdDelete(estado));

    return tr;
}

invokeDelete = (estado) => {
    console.log("estado que quiero eliminar ", estado);

    $.ajax({
        url: "http://localhost:8080/api/estados/"+ estado.id_estado_proyecto,
        success: function () {
            invokeGet();
            alert("estado eliminado correctamente");
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            alert("No fue posible eliminar el estado");
        },
        type: "DELETE"
    });
}

invokeGet = () => {
    console.log("vamos a cargar los estados");
    $.get("http://localhost:8080/api/estados/lista", function(estados) {
        processGet(estados);
    });
}

showForm = (data) => {
    $("#tblEstados").removeClass("mostrar");
    $("#tblEstados").addClass("ocultar");
    $("#frmEstados").removeClass("ocultar");
    $("#frmEstados").addClass("mostrar");
    console.log("Data For Form: ", data);

    // para editar
    if(!!data ) {
        $("#divId").addClass("mostrar");
        $("#divId").removeClass("ocultar");

        $("#id_estado_proyecto").val(data.id_estado_proyecto);
        $("#descripcion_estado_proyecto").val(data.descripcion_estado_proyecto);
    }
    else { // para mostrar
        $("#divId").addClass("ocultar");
        $("#divId").removeClass("mostrar");

        $("#id_estado_proyecto").val("");
        $("#descripcion_estado_proyecto").val("");
    }
}

sendForm = () => {
    let data = {
        "id_estado_proyecto" : $("#id_estado_proyecto").val(),
        "descripcion_estado_proyecto" : $("#descripcion_estado_proyecto").val()
    };
    console.log("Data ", data);

    let url = "";
    if ($("#id_estado_proyecto").val() !== "") {
        url = "http://localhost:8080/api/estados/actualizar/" + $("#id_estado_proyecto").val();
    } else {
        url = "http://localhost:8080/api/estados/crear";
    }

    $.ajax({
        url: url,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            invokeGet();
            $("#frmEstados").removeClass("mostrar");
            $("#frmEstados").addClass("ocultar");

            let message = (url.includes("crear")) ? "Estado registrado exitosamente" : "Estado actualizado exitosamente";
            alert(message);
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            let message = (url.includes("crear")) ? "No fue posible registrar el estado" : "No fue posible actualizar el estado";
            alert(message);
        },
        dataType: "json",
        type: ($("#id_estado_proyecto").val() !== "") ? "PUT" : "POST"
    });
}

$(document).ready(function () {
    $("#btnAdd").click(function () {
        showForm(null);
    })

    $("#btnEnviar").click(sendForm);

    $("#btnCancelar").click(function () {
        $("#frmEstados").removeClass("mostrar");
        $("#frmEstados").addClass("ocultar");
        $("#tblEstados").removeClass("ocultar");
        $("#tblEstados").addClass("mostrar");
    });

    invokeGet();
})