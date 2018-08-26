function create_organization() {
    let url = '/api/organization';
    let wrap = {
        name: $("#name").val(),
        phone: $('#phone').val(),
        email: $('#email').val(),
        country: $('#country').val(),
        address: $('#address').val()
    };
    let data = JSON.stringify(wrap);

    $.ajax({
        type: "POST",
        url: url,
        contentType : "application/json; charset=UTF-8",
        data: data,
        success: function () {
            window.location.replace("/organizationPage");
        },
        error: function (e) {
            console.log("ERROR");
        }
    });
}


$(document).ready(function () {
    fill_organization_table();
});

function fill_organization_table(){
    $("#table_body_organizationlist").empty();
    $.ajax({
        type: "GET",
        url: "/api/organizations",
        datatype: "JSON",
        success: function (response) {
            for (var i in response) {
                $("#table_body_organizationlist").append("<tr><td>" + response[i].id + "</td><td>" +
                    response[i].name + "</td><td>" +
                    response[i].createDate + "</td><td>" +
                    response[i].phone + "</td><td>" +
                    response[i].address + "</td><td>" +
                    response[i].country + "</td><td>" +
                    response[i].email + "</td><td>" +
                    "<form class='navbar-form' onsubmit='edit_organization(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Изменить'></form></td><td>" +
                    "<form class='navbar-form' onsubmit='delete_organization(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Удалить'></form></td><td>" +
                    "<form class='navbar-form' onsubmit='show_organization_list(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Информация об организации'></form></td><td>" +
                    "</tr>");
            }
        }
    })
}

function edit_organization(organizationId) {
    var url = "/editOrganization/" + organizationId;
    window.location.replace(url);
}

function show_organization_list(requestId) {
    var url = "/organizationInfoPage/" + requestId;
    window.location.replace(url);
}

function delete_organization(organizationId) {
    var url = "/api/organization/" + organizationId;
    $.ajax({
        type: "DELETE",
        url: url,
        datatype: "JSON",
        success: function () {
            fill_organization_table();
        }
    });
}
