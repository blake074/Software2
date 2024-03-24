processGet = (etapasproyectos) => {
    $("#tblEtapasProyectos").removeClass("ocultar");
    $("#tblEtapasProyectos").addClass("mostrar");

    let tbody = $("#tblEtapasProyectos tbody");
    tbody.html("");

    if(etapasproyectos.length <= 0){
        let tr = $("<tr></tr>");
        tr.append("<tr><td colspan = '3'>No se encontraron etapas proyectos</td></tr>");
        tbody.append(tr);
    }
    else {
        etapasproyectos.forEach (etapasproyecto => {
            tbody.append(createTr(etapasproyecto));
        });
    }
}

createTd = (value) => {
    return $("<td>"+value+"</td>");
}

createEdit = (value) => {
    return $("<div class='1'><button class='btnEditar'>"+value+"</button></div>");
}

createDelete = (value) => {
    return $("<div><button class='btnDelete'>"+value+"</button></div>")
}

createTdEdit = (etapasproyecto) => {
    let td = createEdit("Editar");
    td.click(function () {
        showForm(etapasproyecto);
    });
    return td;
}

createTdDelete = (etapasproyecto) => {
    let td = createDelete("Eliminar");
    td.click(function () {
        invokeDelete(etapasproyecto);
    });
    return td;
}

createTr = (etapasproyecto) => {
    let tr = $("<tr></tr>");

    tr.append(createTd(etapasproyecto.id_asignacion_etapa_proyecto));
    tr.append(createTd(etapasproyecto.id_proyecto.nombre_proyecto));
    tr.append(createTd(etapasproyecto.id_ciclo_vida_proyecto.descripcion_ciclo_vida_proyecto));
    tr.append(createTd(etapasproyecto.fecha_inicio));
    tr.append(createTd(etapasproyecto.fecha_fin));

    tr.append(createTdEdit(etapasproyecto));
    tr.append(createTdDelete(etapasproyecto));

    return tr;
}

invokeDelete = (etapasproyecto) => {
    console.log("etapas proyecto que quiero eliminar ", empleado);

    $.ajax({
        url: "http://localhost:8080/api/etapasproyectos/"+ empleado.id,
        success: function () {
            invokeGet();

            alert("Etapas proyecto eliminado correctamente");
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            alert("No fue posible eliminar la etapa proyecto");
        },
        type: "DELETE"
    });
}

invokeGet = () => {
    console.log("vamos a cargar las etapas proyecto");
    $.get("http://localhost:8080/api/etapasproyectos/lista", function(etapasproyecto) {
        processGet(etapasproyecto);
        populateProyectosDropdown();
        populateEtapasDropdown();
    });
}

showForm = (data) => {
    $("#tblEtapasProyectos").removeClass("mostrar");
    $("#tblEtapasProyectos").addClass("ocultar");
    $("#frmEtapasProyectos").removeClass("ocultar");
    $("#frmEtapasProyectos").addClass("mostrar");
    console.log("Data For Form: ", data);

    // para editar
    if(!!data ) {
        $("#divId").addClass("mostrar");
        $("#divId").removeClass("ocultar");

        $("#id_asignacion_etapa_proyecto").val(data.id_asignacion_etapa_proyecto);
        console.log("hola ", data.id_asignacion_etapa_proyecto);
        $("#fecha_inicio").val(data.fecha_inicio);
        $("#fecha_fin").val(data.fecha_fin);
    }
    else { // para mostrar
        $("#divId").addClass("ocultar");
        $("#divId").removeClass("mostrar");

        $("#id_asignacion_etapa_proyecto").val("");
        $("#id_proyecto").val("");
        $("#id_ciclo_vida_proyecto").val("");
        $("#fecha_inicio").val("");
        $("#fecha_fin").val("");
    }
}

sendForm = () => {
    /*
    if ($("#nombre_empleado").val() == undefined || $("#nombre_empleado").val() == null || $("#nombre_empleado").val() == "") {
        alert("Por favor verifique el campo nombre");
        return;
    }

     */

    let data = {
        "id_asignacion_etapa_proyecto": $("#id_asignacion_etapa_proyecto").val(),
        "id_proyecto": {
            "id_proyecto": $("#id_proyecto").val()
        },
        "id_ciclo_vida_proyecto" : {
            "id_ciclo_vida_proyecto": $("#id_ciclo_vida_proyecto").val()
        },
        "fecha_inicio" : $("#fecha_inicio").val(),
        "fecha_fin" : $("#fecha_fin").val()
    };
    console.log("Data ", data);

    let url = "";
    if ($("#id_asignacion_etapa_proyecto").val() !== "") {
        url = "http://localhost:8080/api/etapasproyectos/actualizar/" + $("#id_asignacion_etapa_proyecto").val();
    } else {
        url = "http://localhost:8080/api/etapasproyectos/crear";
    }

    $.ajax({
        url: url,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            invokeGet();
            $("#frmEtapasProyectos").removeClass("mostrar");
            $("#frmEtapasProyectos").addClass("ocultar");

            let message = (url.includes("crear")) ? "Etapas proyectos registrado exitosamente" : "Etapas proyectos actualizado exitosamente";
            alert(message);
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            let message = (url.includes("crear")) ? "No fue posible registrar la etapa proyecto" : "No fue posible actualizar la etapa proyecto";
            alert(message);
        },
        dataType: "json",
        type: ($("#id_asignacion_etapa_proyecto").val() !== "") ? "PUT" : "POST"
    });
}

populateProyectosDropdown = () => {
    $.get("http://localhost:8080/api/proyectos/lista", function(proyectos) {
        let dropdown = $("#id_proyecto");
        dropdown.empty();
        $.each(proyectos, function(index, proyecto) {
            dropdown.append(`<option value="${proyecto.id_proyecto}">${proyecto.nombre_proyecto}</option>`);
        });
    });
}

populateEtapasDropdown = () => {
    $.get("http://localhost:8080/api/etapas/lista", function(etapas) {
        let dropdown = $("#id_ciclo_vida_proyecto");
        dropdown.empty();

        $.each(etapas, function(index, etapa) {
            dropdown.append(`<option value="${etapa.id_ciclo_vida_proyecto}">${etapa.descripcion_ciclo_vida_proyecto}</option>`);
        });
    });
}

$(document).ready(function () {
    $("#btnAdd").click(function () {
        showForm(null);
    })
    $("#btnEnviar").click(sendForm);

    $("#btnCancelar").click(function () {
        $("#frmEtapasProyectos").removeClass("mostrar");
        $("#frmEtapasProyectos").addClass("ocultar");
        $("#tblEtapasProyectos").removeClass("ocultar");
        $("#tblEtapasProyectos").addClass("mostrar");
    });
    invokeGet();
})