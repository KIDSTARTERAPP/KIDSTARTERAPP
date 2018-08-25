$(document).ready(function () {
    fillusertable();
});

function fillusertable(){
    $("#table_body_kidlist").empty();
    $.ajax({
        type: "GET",
        url: "/api/organization/kids/all",
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
                    roles.hidden + "</td><td>" +
                    response[i].createDate + "</td><td>" +
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

function edit_kid(userid) {
    var url = "/organization/kids/" + userid;
    window.location.replace(url);
}

function delete_kid(userid) {
    var url = "/api/organization/kid/" + userid;
    $.ajax({
        type: "DELETE",
        url: url,
        datatype: "JSON",
        success: function () {
            fillusertable();
        }
    });
}