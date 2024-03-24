processGet = (proyectosempleados) => {
    $("#tblProyectosEmpleados").removeClass("ocultar");
    $("#tblProyectosEmpleados").addClass("mostrar");

    let tbody = $("#tblProyectosEmpleados tbody");
    tbody.html("");

    if(proyectosempleados.length <= 0){
        let tr = $("<tr></tr>");
        tr.append("<tr><td colspan = '3'>No se encontraron proyectos empleados</td></tr>");
        tbody.append(tr);
    }
    else {
        proyectosempleados.forEach (proyectosempleado => {
            tbody.append(createTr(proyectosempleado));
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

createTdEdit = (proyectosempleado) => {
    let td = createEdit("Editar");
    td.click(function () {
        showForm(proyectosempleado);
    });
    return td;
}

createTdDelete = (proyectosempleado) => {
    let td = createDelete("Eliminar");
    td.click(function () {
        invokeDelete(proyectosempleado);
    });
    return td;
}

createTr = (proyectosempleado) => {
    let tr = $("<tr></tr>");

    tr.append(createTd(proyectosempleado.id_asignacion_empleado_proyecto));
    tr.append(createTd(proyectosempleado.id_proyecto.nombre_proyecto));
    tr.append(createTd(proyectosempleado.id_empleado.nombre_empleado));

    tr.append(createTdEdit(proyectosempleado));
    tr.append(createTdDelete(proyectosempleado));

    return tr;
}

invokeDelete = (proyectosempleado) => {
    console.log("proyectos empleados que quiero eliminar ", proyectosempleado);

    $.ajax({
        url: "http://localhost:8080/api/proyectosempleados/"+ proyectosempleado.id_asignacion_empleado_proyecto,
        success: function () {
            invokeGet();

            alert("Proyecto empleado eliminado correctamente");
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            alert("No fue posible eliminar el proyecto empleado");
        },
        type: "DELETE"
    });
}

invokeGet = () => {
    $.get("http://localhost:8080/api/proyectosempleados/lista", function(proyectosempleado) {
        processGet(proyectosempleado);
        populateProyectosDropdown();
        populateEmpleadosDropdown();
    });
}

showForm = (data) => {
    $("#tblProyectosEmpleados").removeClass("mostrar");
    $("#tblProyectosEmpleados").addClass("ocultar");
    $("#frmProyectosEmpleados").removeClass("ocultar");
    $("#frmProyectosEmpleados").addClass("mostrar");
    console.log("Data For Form: ", data);

    // para editar
    if(!!data ) {
        $("#divId").addClass("mostrar");
        $("#divId").removeClass("ocultar");

        $("#id_asignacion_empleado_proyecto").val(data.id_asignacion_empleado_proyecto);
    }
    else { // para mostrar
        $("#divId").addClass("ocultar");
        $("#divId").removeClass("mostrar");

        $("#id_asignacion_empleado_proyecto").val("");
        $("#id_proyecto").val("");
        $("#id_empleado").val("");
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
        "id_asignacion_empleado_proyecto": $("#id_asignacion_empleado_proyecto").val(),
        "id_proyecto": {
            "id_proyecto": $("#id_proyecto").val()
        },
        "id_empleado" : {
            "id_empleado": $("#id_empleado").val()
        }
    };
    console.log("Data ", data);

    let url = "";
    if ($("#id_asignacion_empleado_proyecto").val() !== "") {
        url = "http://localhost:8080/api/proyectosempleados/actualizar/" + $("#id_asignacion_empleado_proyecto").val();
    } else {
        url = "http://localhost:8080/api/proyectosempleados/crear";
    }

    $.ajax({
        url: url,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            invokeGet();
            $("#frmProyectosEmpleados").removeClass("mostrar");
            $("#frmProyectosEmpleados").addClass("ocultar");

            let message = (url.includes("crear")) ? "Proyecto empleado registrado exitosamente" : "Proyecto empleado proyectos actualizado exitosamente";
            alert(message);
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            let message = (url.includes("crear")) ? "No fue posible registrar el proyecto empleado" : "No fue posible actualizar el proyecto empleado";
            alert(message);
        },
        dataType: "json",
        type: ($("#id_asignacion_empleado_proyecto").val() !== "") ? "PUT" : "POST"
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

populateEmpleadosDropdown = () => {
    $.get("http://localhost:8080/api/empleado/lista", function(empleados) {
        let dropdown = $("#id_ciclo_vida_proyecto");
        dropdown.empty();

        $.each(empleados, function(index, empleado) {
            dropdown.append(`<option value="${empleado.id_empleado}">${empleado.nombre_empleado}</option>`);
        });
    });
}

$(document).ready(function () {
    $("#btnAdd").click(function () {
        showForm(null);
    })
    $("#btnEnviar").click(sendForm);

    $("#btnCancelar").click(function () {
        $("#frmProyectosEmpleados").removeClass("mostrar");
        $("#frmProyectosEmpleados").addClass("ocultar");
        $("#tblProyectosEmpleados").removeClass("ocultar");
        $("#tblProyectosEmpleados").addClass("mostrar");
    });
    invokeGet();
})