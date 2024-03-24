processGet = (empleados) => {
    $("#tblEmpleados").removeClass("ocultar");
    $("#tblEmpleados").addClass("mostrar");

    let tbody = $("#tblEmpleados tbody");
    tbody.html("");

    if(empleados.length <= 0){
        let tr = $("<tr></tr>");
        tr.append("<tr><td colspan = '3'>No se encontraron empleados</td></tr>");
        tbody.append(tr);
    }
    else {
        empleados.forEach (empleado => {
            tbody.append(createTr(empleado));
        });
    }
}

createTd = (value) => {
    return $("<td>"+value+"</td>");
}

createEdit = (value) => {
    return $("<div class='1'><button class='btnEditar' background-color: yellow>"+value+"</button></div>");
}

createDelete = (value) => {
    return $("<div><button class='btnDelete'>"+value+"</button></div>")
}

createTdEdit = (empleado) => {
    let td = createEdit("Editar");
    td.click(function () {
        showForm(empleado);
    });
    return td;
}

createTdDelete = (empleado) => {
    let td = createDelete("Eliminar");
    td.click(function () {
        invokeDelete(empleado);
    });
    return td;
}

createTr = (empleado) => {
    let tr = $("<tr></tr>");

    tr.append(createTd(empleado.id));
    tr.append(createTd(empleado.nombreCompleto));
    tr.append(createTd(empleado.rol.descripcion_rol));
    tr.append(createTd(empleado.id_TipoDocumento.descripcion_documento));
    tr.append(createTd(empleado.numDoc_Empleado));
    tr.append(createTd(empleado.telefono));
    tr.append(createTd(empleado.direccion));
    tr.append(createTd(empleado.salario));
    tr.append(createTd(empleado.fechaNacimiento));
    tr.append(createTd(empleado.fechaIngreso));

    tr.append(createTdEdit(empleado));
    tr.append(createTdDelete(empleado));

    return tr;
}

invokeDelete = (empleado) => {
    console.log("empleado que quiero eliminar ", empleado);

    $.ajax({
        url: "http://localhost:8080/api/empleado/"+ empleado.id,
        success: function () {
            invokeGet();

            alert("empleado eliminado correctamente");
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            alert("No fue posible eliminar el empleado");
        },
        type: "DELETE"
    });
}

invokeGet = () => {
    console.log("vamos a cargar los empleados");
    $.get("http://localhost:8080/api/empleado/lista", function(empleados) {
        processGet(empleados);
        populateRolesDropdown();
        populateDocumentosDropdown();
    });
}

showForm = (data) => {
    $("#tblEmpleados").removeClass("mostrar");
    $("#tblEmpleados").addClass("ocultar");
    $("#frmEmpleados").removeClass("ocultar");
    $("#frmEmpleados").addClass("mostrar");
    console.log("Data For Form: ", data);

    // para editar
    if(!!data ) {
        $("#divId").addClass("mostrar");
        $("#divId").removeClass("ocultar");

        $("#id_empleado").val(data.id);
        $("#nombre_empleado").val(data.nombreCompleto);
        $("#num_doc_empleado").val(data.numDoc_Empleado);
        $("#telefono_empleado").val(data.telefono);
        $("#direccion_empleado").val(data.direccion);
        $("#salario_empleado").val(data.salario);
        $("#fecha_nacimiento").val(data.fechaNacimiento);
        $("#fecha_ingreso").val(data.fechaIngreso);
    }
    else { // para mostrar
        $("#divId").addClass("ocultar");
        $("#divId").removeClass("mostrar");

        $("#id_empleado").val("");
        $("#nombre_empleado").val("");
        $("#id_rol").val("");
        $("#id_tipo_documento").val("");
        $("#num_doc_empleado").val("");
        $("#direccion_empleado").val("");
        $("#salario_empleado").val("");
        $("#fecha_nacimiento").val("");
        $("#fecha_ingreso").val("");
    }
}

sendForm = () => {
    if ($("#nombre_empleado").val() == undefined || $("#nombre_empleado").val() == null || $("#nombre_empleado").val() == "") {
        alert("Por favor verifique el campo nombre");
        return;
    }

    let data = {
        "nombre_empleado": $("#nombre_empleado").val(),
        "id_rol": {
            "id_rol": $("#rol").val()
        },
        "id_tipo_documento" : {
            "id_tipo_documento": $("#id_tipo_documento").val()
        },
        "num_doc_empleado" : $("#num_doc_empleado").val(),
        "telefono_empleado" : $("#telefono_empleado").val(),
        "direccion_empleado" : $("#direccion_empleado").val(),
        "fecha_nacimiento" : $("#fecha_nacimiento").val(),
        "fecha_ingreso" : $("#fecha_ingreso").val(),
        "salario_empleado" : $("#salario_empleado").val()
    };
    console.log("Data ", data);

    let url = "";
    if ($("#id_empleado").val() !== "") {
        url = "http://localhost:8080/api/empleado/actualizar/" + $("#id_empleado").val();
    } else {
        url = "http://localhost:8080/api/empleado/crear"; // Si no hay ID, es una solicitud de creación (POST)
    }

    $.ajax({
        url: url,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            invokeGet();
            $("#frmEmpleados").removeClass("mostrar");
            $("#frmEmpleados").addClass("ocultar");

            let message = (url.includes("crear")) ? "Empleado registrado exitosamente" : "Empleado actualizado exitosamente";
            alert(message);
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            let message = (url.includes("crear")) ? "No fue posible registrar el empleado" : "No fue posible actualizar el empleado";
            alert(message);
        },
        dataType: "json",
        type: ($("#id_empleado").val() !== "") ? "PUT" : "POST" // Usa PUT si hay un ID, de lo contrario, usa POST
    });
}

populateRolesDropdown = () => {
    $.get("http://localhost:8080/api/roles/lista", function(roles) {
        let dropdown = $("#rol");
        dropdown.empty();
        $.each(roles, function(index, rol) {
            dropdown.append(`<option value="${rol.id_rol}">${rol.descripcion_rol}</option>`);
        });
    });
}

populateDocumentosDropdown = () => {
    $.get("http://localhost:8080/api/documentos/lista", function(documentos) {
        let dropdown = $("#id_tipo_documento"); // Selecciona el elemento select
        dropdown.empty(); // Vacía el dropdown para evitar duplicados

        // Itera sobre la lista de documentos y agrega cada uno como una opción en el dropdown
        $.each(documentos, function(index, documento) {
            dropdown.append(`<option value="${documento.id_tipo_documento}">${documento.descripcion_documento}</option>`);
        });
    });
}


$(document).ready(function () {
    $("#btnAdd").click(function () {
        showForm(null);
    })

    $("#btnEnviar").click(sendForm);

    $("#btnCancelar").click(function () {
        $("#frmEmpleados").removeClass("mostrar");
        $("#frmEmpleados").addClass("ocultar");
        $("#tblEmpleados").removeClass("ocultar");
        $("#tblEmpleados").addClass("mostrar");
    });

    invokeGet();
})

