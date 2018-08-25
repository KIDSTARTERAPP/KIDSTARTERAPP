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
            for (var i in response) {
                var tags = [];
                for (var j in response[i].tags) {
                    tags.push(response[i].tags[j].name);
                }
                $("#table_joblist").append("<tr><td>" + response[i].id + "</td><td>" +
                    response[i].name + "</td><td>" +
                    response[i].description + "</td><td>" +
                    tags + "</td><td>" +
                    response[i].kids.length + "</td><td>" +
                    response[i].mentors.length + "</td><td>" +
                    response[i].teachers.length + "</td><td>" +
                    "<form class='navbar-form' onsubmit='add_job_to_whish_list(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Хочу изучить'></form></td><td>" +
                    "<form class='navbar-form' onsubmit='edit_job(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Изменить'></form></td><td>" +
                    "<form class='navbar-form' onsubmit='delete_job(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Удалить'></form></td><td>" +
                    "</tr>");
            }
        }
    })
}

function delete_job(job_id) {
    var url = "./api/job/" + job_id;
    $.ajax({
        type: "DELETE",
        url: url,
        dataType: "JSON",
        success: function () {
            fill_job_list();
        }
    })
}

function add_job_to_whish_list(job_id) {
    var url = "/api/job/wish_job/" + job_id;
    var data = JSON.stringify({jobId: job_id});
    $.ajax({
        type: "PUT",
        url: url,
        success: function () {
            fill_job_list();
        }
    })
}

function edit_job(jobId) {
    var url = "/editJob/" + jobId;
    window.location.replace(url);
}