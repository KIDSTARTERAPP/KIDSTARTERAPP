$(document).ready(function () {
    fillusertable();
});

function fillusertable() {
    $("#table_body_kidlist").empty();
    $.ajax({
        type: "GET",
        url: "/api/organization/" + $("#id_org").val() + "/kids",
        datatype: "JSON",
        success: function (response) {
            for (var i in response) {
                var roles = [];
                for (var j in response[i].roles) {
                    roles.push(response[i].roles[j].name);
                }
                $("#table_body_kidlist").append("<tr><td>" +
                    response[i].id + "</td><td>" +
                    response[i].firstName + "</td><td>" +
                    response[i].lastName + "</td><td>" +
                    response[i].patronymic + "</td><td>" +
                    response[i].login + "</td><td>" +
                    response[i].age + "</td><td>" +
                    response[i].sex + "</td><td>" +
                    response[i].phone + "</td><td>" +
                    response[i].email + "</td><td>" +
                    response[i].country + "</td><td>" +
                    response[i].address + "</td><td>" +
                    "<form class='navbar-form' onsubmit='edit_kid(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Изменить'></form></td><td>" +
                    "<form class='navbar-form' onsubmit='delete_kid(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Удалить'></form></td><td>" +
                    "</tr>");
            }
        }
    })
}

function edit_kid(id_kid) {
    var url = "/organization/" + $("#id_org").val() + "/kids/" + id_kid;
    window.location.replace(url);
}

function delete_kid(id_kid) {
    var url = "/api/organization/" + $("#id_org").val() + "/kid/" + id_kid;
    $.ajax({
        type: "DELETE",
        url: url,
        datatype: "JSON",
        success: function () {
            window.location.replace("/organization/" + $("#id_org").val() + "/kids");
        }
    });
}