processGet = (etapas) => {
    $("#tblEtapas").removeClass("ocultar");
    $("#tblEtapas").addClass("mostrar");

    let tbody = $("#tblEtapas tbody");
    tbody.html("");

    if(etapas.length <= 0){
        let tr = $("<tr></tr>");
        tr.append("<tr><td colspan = '3'>No se encontraron etapas</td></tr>");
        tbody.append(tr);
    }
    else {
        etapas.forEach (etapa => {
            tbody.append(createTr(etapa));
        });
    }
}

createTd = (value) => {
    return $("<td>"+value+"</td>");
}

createTdEdit = (etapa) => {
    let td = createTd("Editar");
    td.click(function () {
        showForm(etapa);
    });
    return td;
}

createTdDelete = (etapa) => {
    let td = createTd("Eliminar");
    td.click(function () {
        invokeDelete(etapa);
    });
    return td;
}

createTr = (etapa) => {
    let tr = $("<tr></tr>");

    tr.append(createTd(etapa.id_ciclo_vida_proyecto));
    tr.append(createTd(etapa.descripcion_ciclo_vida_proyecto));

    tr.append(createTdEdit(etapa));
    tr.append(createTdDelete(etapa));

    return tr;
}

invokeDelete = (etapa) => {
    console.log("etapa que quiero eliminar ", etapa);

    $.ajax({
        url: "http://localhost:8080/api/etapas/"+ etapa.id_ciclo_vida_proyecto,
        success: function () {
            invokeGet();
            alert("etapa eliminada correctamente");
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            alert("No fue posible eliminar la etapa");
        },
        type: "DELETE"
    });
}

invokeGet = () => {
    console.log("vamos a cargar las etapas");
    $.get("http://localhost:8080/api/etapas/lista", function(etapas) {
        processGet(etapas);
    });
}

showForm = (data) => {
    $("#tblEtapas").removeClass("mostrar");
    $("#tblEtapas").addClass("ocultar");
    $("#frmEtapas").removeClass("ocultar");
    $("#frmEtapas").addClass("mostrar");
    console.log("Data For Form: ", data);

    // para editar
    if(!!data ) {
        $("#divId").addClass("mostrar");
        $("#divId").removeClass("ocultar");

        $("#id_ciclo_vida_proyecto").val(data.id_ciclo_vida_proyecto);
        $("#descripcion_ciclo_vida_proyecto").val(data.descripcion_ciclo_vida_proyecto);
    }
    else { // para mostrar
        $("#divId").addClass("ocultar");
        $("#divId").removeClass("mostrar");

        $("#id_ciclo_vida_proyecto").val("");
        $("#descripcion_ciclo_vida_proyecto").val("");
    }
}

sendForm = () => {
    let data = {
        "id_ciclo_vida_proyecto" : $("#id_ciclo_vida_proyecto").val(),
        "descripcion_ciclo_vida_proyecto" : $("#descripcion_ciclo_vida_proyecto").val()
    };
    console.log("Data ", data);

    let url = "";
    if ($("#id_ciclo_vida_proyecto").val() !== "") {
        url = "http://localhost:8080/api/etapas/actualizar/" + $("#id_ciclo_vida_proyecto").val();
    } else {
        url = "http://localhost:8080/api/etapas/crear";
    }

    $.ajax({
        url: url,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            invokeGet();
            $("#frmEtapas").removeClass("mostrar");
            $("#frmEtapas").addClass("ocultar");

            let message = (url.includes("crear")) ? "Etapa registrada exitosamente" : "Etapa actualizada exitosamente";
            alert(message);
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            let message = (url.includes("crear")) ? "No fue posible registrar la etapa" : "No fue posible actualizar la etapa";
            alert(message);
        },
        dataType: "json",
        type: ($("#id_ciclo_vida_proyecto").val() !== "") ? "PUT" : "POST"
    });
}

$(document).ready(function () {
    $("#btnAdd").click(function () {
        showForm(null);
    })

    $("#btnEnviar").click(sendForm);

    $("#btnCancelar").click(function () {
        $("#frmEtapas").removeClass("mostrar");
        $("#frmEtapas").addClass("ocultar");
        $("#tblEtapas").removeClass("ocultar");
        $("#tblEtapas").addClass("mostrar");
    });

    invokeGet();
})