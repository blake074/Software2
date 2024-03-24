processGet = (roles) => {
    $("#tblRoles").removeClass("ocultar");
    $("#tblRoles").addClass("mostrar");

    let tbody = $("#tblRoles tbody");
    tbody.html("");

    if(roles.length <= 0){
        let tr = $("<tr></tr>");
        tr.append("<tr><td colspan = '3'>No se encontraron roles</td></tr>");
        tbody.append(tr);
    }
    else {
        roles.forEach (rol => {
            tbody.append(createTr(rol));
        });
    }
}

createTd = (value) => {
    return $("<td>"+value+"</td>");
}

createTdEdit = (rol) => {
    let td = createTd("Editar");
    td.click(function () {
        showForm(rol);
    });
    return td;
}

createTdDelete = (rol) => {
    let td = createTd("Eliminar");
    td.click(function () {
        invokeDelete(rol);
    });
    return td;
}

createTr = (rol) => {
    let tr = $("<tr></tr>");

    tr.append(createTd(rol.id_rol));
    tr.append(createTd(rol.descripcion_rol));

    tr.append(createTdEdit(rol));
    tr.append(createTdDelete(rol));

    return tr;
}

invokeDelete = (rol) => {
    console.log("rol que quiero eliminar ", rol);

    $.ajax({
        url: "http://localhost:8080/api/roles/"+ rol.id_rol,
        success: function () {
            invokeGet();
            alert("rol eliminado correctamente");
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            alert("No fue posible eliminar el rol");
        },
        type: "DELETE"
    });
}

invokeGet = () => {
    console.log("vamos a cargar los roles");
    $.get("http://localhost:8080/api/roles/lista", function(roles) {
        processGet(roles);
    });
}

showForm = (data) => {
    $("#tblRoles").removeClass("mostrar");
    $("#tblRoles").addClass("ocultar");
    $("#frmRoles").removeClass("ocultar");
    $("#frmRoles").addClass("mostrar");
    console.log("Data For Form: ", data);

    // para editar
    if(!!data ) {
        $("#divId").addClass("mostrar");
        $("#divId").removeClass("ocultar");

        $("#id_rol").val(data.id_rol);
        $("#descripcion_rol").val(data.descripcion_rol);
    }
    else { // para mostrar
        $("#divId").addClass("ocultar");
        $("#divId").removeClass("mostrar");

        $("#id_rol").val("");
        $("#descripcion_rol").val("");
    }
}

sendForm = () => {
    let data = {
        "id_rol" : $("#id_rol").val(),
        "descripcion_rol" : $("#descripcion_rol").val()
    };
    console.log("Data ", data);

    let url = "";
    if ($("#id_rol").val() !== "") {
        url = "http://localhost:8080/api/roles/actualizar/" + $("#id_rol").val();
    } else {
        url = "http://localhost:8080/api/roles/crear";
    }

    $.ajax({
        url: url,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            invokeGet();
            $("#frmRoles").removeClass("mostrar");
            $("#frmRoles").addClass("ocultar");

            let message = (url.includes("crear")) ? "Rol registrado exitosamente" : "Rol actualizado exitosamente";
            alert(message);
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            let message = (url.includes("crear")) ? "No fue posible registrar el rol" : "No fue posible actualizar el rol";
            alert(message);
        },
        dataType: "json",
        type: ($("#id_rol").val() !== "") ? "PUT" : "POST" // Usa PUT si hay un ID, de lo contrario, usa POST
    });
}

$(document).ready(function () {
    $("#btnAdd").click(function () {
        showForm(null);
    })

    $("#btnEnviar").click(sendForm);

    $("#btnCancelar").click(function () {
        $("#frmRoles").removeClass("mostrar");
        $("#frmRoles").addClass("ocultar");
        $("#tblRoles").removeClass("ocultar");
        $("#tblRoles").addClass("mostrar");
    });

    invokeGet();
})

