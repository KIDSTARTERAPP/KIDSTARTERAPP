$(document).ready(function () {
    fillteacherstable();
});

function fillteacherstable(){
    $("#table_body_teacherslist").empty();
    $.ajax({
        type: "GET",
        url: "/api/organization/teachers",
        datatype: "JSON",
        success: function (response) {
            for (var i in response) {

                $("#table_body_teacherslist").append("<tr><td>" +
                    response[i].id + "</td><td>" +
                    response[i].firstName + "</td><td>" +
                    response[i].lastName + "</td><td>" +
                    response[i].patronymic + "</td><td>" +
                    response[i].login + "</td><td>" +
                    response[i].createDate + "</td><td>" +
                    response[i].age + "</td><td>" +
                    response[i].sex + "</td><td>" +
                    response[i].phone + "</td><td>" +
                    response[i].email + "</td><td>" +
                    response[i].country + "</td><td>" +
                    response[i].address + "</td><td>" +
                    "<form class='navbar-form' onsubmit='edit_teacher(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Изменить'></form></td><td>" +
                    "<form class='navbar-form' onsubmit='delete_teacher(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Удалить'></form></td><td>" +
                    "</tr>");
            }
        }
    })
}

function edit_teacher(userid) {
    var url = "/organization/teacher/" + userid;
    window.location.replace(url);
}

function delete_teacher(userid) {
    var url = "/api/organization/teacher/" + userid;
    $.ajax({
        type: "DELETE",
        url: url,
        datatype: "JSON",
        success: function () {
            fillteacherstable();
        }
    });
}