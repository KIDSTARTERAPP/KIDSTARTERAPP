$(document).ready(function () {
    fill_kid_job_list();
});

function fill_kid_job_list() {
    $("#table_kid_joblist").empty();
    $.ajax({
        type: "GET",
        url: "./api/jobs/kid",
        dataType: "JSON",
        success: function (response) {
            for (var i in response) {
                var tags = [];
                for (var j in response[i].tags) {
                    tags.push(response[i].tags[j].name);
                }
                $("#table_kid_joblist").append("<tr><td>" + response[i].id + "</td><td>" +
                    response[i].name + "</td><td>" +
                    response[i].description + "</td><td>" +
                    tags + "</td><td>" +
                    "<form class='navbar-form' onsubmit='remove_job_from_whish_list(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Передумал'></form></td><td>" +
                    "</tr>");
            }
        }
    })
}

function remove_job_from_whish_list(job_id) {
    var url = "/api/job/unwish_job/" + job_id;
    var data = JSON.stringify({jobId: job_id});
    $.ajax({
        type: "PUT",
        url: url,
        success: function () {
            fill_kid_job_list();
        }
    })
}