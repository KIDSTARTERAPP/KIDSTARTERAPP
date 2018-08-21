$(document).ready(function () {
    fill_job_list();
});

function fill_job_list() {
    $("#table_joblist").empty();
    $.ajax({
        type: "GET",
        url: "./api/jobs",
        dataType: "JSON",
        success: function (response) {
            console.log(response);
            for (var i in response) {
                $("#table_joblist").append("<tr><td>" + response[i].id + "</td><td>" +
                    response[i].name + "</td><td>" +
                    response[i].description + "</td><td>" +
                    response[i].tag + "</td><td>" +
                    // tags + "</td><td>" +
                    "<form class='navbar-form' onsubmit='edit_job(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Изменить'></form></td><td>" +
                    "<form class='navbar-form' onsubmit='delete_job(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Удалить'></form></td><td>" +
                    "</tr>");
            }
        }
    })

}