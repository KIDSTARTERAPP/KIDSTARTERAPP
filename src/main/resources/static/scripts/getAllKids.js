$(document).ready(function () {
    fillusertable();
});

function fillusertable() {
    $("#table_body_kidlist").empty();
    $.ajax({
        type: "GET",
        url: "/api/organization/kids",
        datatype: "JSON",
        success: function (response) {
            for (var i in response) {



                var jobs = "";
                for (var job in response[i].jobInterest) {
                    jobs += response[i].jobInterest[job].name += "</br>";
                }

                console.log(jobs);


                var roles = [];
                for (var j in response[i].roles) {
                    roles.push(response[i].roles[j].name);
                }
                $("#table_body_kidlist").append("<tr><td>" +
                    response[i].user.id + "</td><td>" +
                    response[i].user.firstName + "</td><td>" +
                    response[i].user.lastName + "</td><td>" +
                    response[i].user.patronymic + "</td><td>" +
                    response[i].user.login + "</td><td>" +
                    response[i].user.age + "</td><td>" +
                    response[i].user.sex + "</td><td>" +
                    response[i].user.phone + "</td><td>" +
                    response[i].user.email + "</td><td>" +
                    response[i].user.country + "</td><td>" +
                    response[i].user.address + "</td><td>" +
                    jobs + "</td><td>" +
                    "<form class='navbar-form' onsubmit='edit_kid(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Изменить'></form></td><td>" +
                    "<form class='navbar-form' onsubmit='delete_kid(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Удалить'></form></td><td>" +
                    "</tr>");
            }
        }
    })
}

function edit_kid(id_kid) {
    var url = "/main/organization/" + $("#id_org").val() + "/kids/" + id_kid;
    window.location.replace(url);
}

function delete_kid(id_kid) {
    var url = "/api/organization/" + $("#id_org").val() + "/kid/" + id_kid;
    $.ajax({
        type: "DELETE",
        url: url,
        datatype: "JSON",
        success: function () {
            window.location.replace("/main/organization/" + $("#id_org").val() + "/kids");
        }
    });
}