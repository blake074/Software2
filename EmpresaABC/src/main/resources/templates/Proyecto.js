processGet = (proyectos) => {
    $("#tblProyectos").removeClass("ocultar");
    $("#tblProyectos").addClass("mostrar");

    let tbody = $("#tblProyectos tbody");
    tbody.html("");

    if(proyectos.length <= 0){
        let tr = $("<tr></tr>");
        tr.append("<tr><td colspan = '3'>No se encontraron proyectos</td></tr>");
        tbody.append(tr);
    }
    else {
        proyectos.forEach (proyecto => {
            tbody.append(createTr(proyecto));
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

createTdEdit = (proyecto) => {
    let td = createEdit("Editar");
    td.click(function () {
        showForm(proyecto);
    });
    return td;
}

createTdDelete = (proyecto) => {
    let td = createDelete("Eliminar");
    td.click(function () {
        invokeDelete(proyecto);
    });
    return td;
}

createTr = (proyecto) => {
    let tr = $("<tr></tr>");

    tr.append(createTd(proyecto.id_proyecto));
    tr.append(createTd(proyecto.nombre_proyecto));
    tr.append(createTd(proyecto.descripcion_proyecto));
    tr.append(createTd(proyecto.presupuesto));
    tr.append(createTd(proyecto.fecha_inicio));
    tr.append(createTd(proyecto.fecha_fin));
    tr.append(createTd(proyecto.id_estado_proyecto.descripcion_estado_proyecto));

    tr.append(createTdEdit(proyecto));
    tr.append(createTdDelete(proyecto));

    return tr;
}

invokeDelete = (proyecto) => {
    console.log("proyecto que quiero eliminar ", proyecto);

    $.ajax({
        url: "http://localhost:8080/api/proyectos/"+ proyecto.id_proyecto,
        success: function () {
            invokeGet();

            alert("proyecto eliminado correctamente");
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            alert("No fue posible eliminar el proyecto");
        },
        type: "DELETE"
    });
}

invokeGet = () => {
    console.log("vamos a cargar los proyectos");
    $.get("http://localhost:8080/api/proyectos/lista", function(proyectos) {
        processGet(proyectos);
        populateEstadosDropdown();

    });
}

showForm = (data) => {
    $("#tblProyectos").removeClass("mostrar");
    $("#tblProyectos").addClass("ocultar");
    $("#frmProyectos").removeClass("ocultar");
    $("#frmProyectos").addClass("mostrar");
    console.log("Data For Form: ", data);

    // para editar
    if(!!data ) {
        $("#divId").addClass("mostrar");
        $("#divId").removeClass("ocultar");

        $("#id_proyecto").val(data.id_proyecto);
        $("#nombre_proyecto").val(data.nombre_proyecto);
        $("#descripcion_proyecto").val(data.descripcion_proyecto);
        $("#presupuesto").val(data.presupuesto);
        $("#fecha_inicio").val(data.fecha_inicio);
        $("#fecha_fin").val(data.fecha_fin);
        //$("#id_estado_proyecto").val(data.estado.id_estado_proyecto);

    }
    else { // para mostrar
        $("#divId").addClass("ocultar");
        $("#divId").removeClass("mostrar");

        $("#id_proyecto").val("");
        $("#nombre_proyecto").val("");
        $("#descripcion_proyecto").val("");
        $("#presupuesto").val("");
        $("#fecha_inicio").val("");
        $("#fecha_fin").val("");
        //$("#id_estado_proyecto").val(data.estado.id_estado_proyecto);
    }
}

sendForm = () => {
    let data = {
        "nombre_proyecto": $("#nombre_proyecto").val(),
        "descripcion_proyecto" : $("#descripcion_proyecto").val(),
        "presupuesto" : $("#presupuesto").val(),
        "fecha_inicio" : $("#fecha_inicio").val(),
        "fecha_fin" : $("#fecha_fin").val(),
        "id_estado_proyecto": {
            "id_estado_proyecto": $("#estado").val()
        }
    };
    console.log("Data ", data);

    let url = "";
    if ($("#id_proyecto").val() !== "") {
        url = "http://localhost:8080/api/proyectos/actualizar/" + $("#id_proyecto").val();
    } else {
        url = "http://localhost:8080/api/proyectos/crear";
    }

    $.ajax({
        url: url,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            invokeGet();
            $("#frmProyectos").removeClass("mostrar");
            $("#frmProyectos").addClass("ocultar");

            let message = (url.includes("crear")) ? "Proyecto registrado exitosamente" : "Proyecto actualizado exitosamente";
            alert(message);
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            let message = (url.includes("crear")) ? "No fue posible registrar el proyecto" : "No fue posible actualizar el proyecto";
            alert(message);
        },
        dataType: "json",
        type: ($("#id_proyecto").val() !== "") ? "PUT" : "POST"
    });
}

populateEstadosDropdown = () => {
    $.get("http://localhost:8080/api/estados/lista", function(estados) {
        let dropdown = $("#estado");
        dropdown.empty();
        $.each(estados, function(index, estado) {
            dropdown.append(`<option value="${estado.id_estado_proyecto}">${estado.descripcion_estado_proyecto}</option>`);
        });
    });
}

$(document).ready(function () {
    $("#btnAdd").click(function () {
        showForm(null);
    })

    $("#btnEnviar").click(sendForm);

    $("#btnCancelar").click(function () {
        $("#frmProyectos").removeClass("mostrar");
        $("#frmProyectos").addClass("ocultar");
        $("#tblProyectos").removeClass("ocultar");
        $("#tblProyectos").addClass("mostrar");
    });

    invokeGet();
})

