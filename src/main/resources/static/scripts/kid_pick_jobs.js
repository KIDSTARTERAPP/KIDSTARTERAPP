$(document).ready(function () {
    get_kid_jobs_and_fill_list();
});

function get_kid_jobs_and_fill_list() {
    $.ajax({
        type: "GET",
        url: "/api/jobs/kid",
        dataType: "JSON",
        success: function (response) {
            fill_job_list(response);
        }
    })
}

function fill_job_list(kid_jobs) {
    $("#table_pick_joblist").empty();
    $.ajax({
        type: "GET",
        url: "/api/jobs",
        dataType: "JSON",
        success: function (response) {
            console.log(response);
            for (var i in response) {
                var notContains = true;
                for (var j in kid_jobs) {
                    if (response[i].id == kid_jobs[j].id) {
                        notContains = false;
                    }
                }
                if (notContains) {
                    var tags = [];
                    for (var j in response[i].tags) {
                        tags.push(response[i].tags[j].name);
                    }
                    $("#table_pick_joblist").append("<tr><td>" + response[i].id + "</td><td>" +
                        response[i].name + "</td><td>" +
                        response[i].description + "</td><td>" +
                        tags + "</td><td>" +
                        "<form class='navbar-form' onsubmit='add_job_to_whish_list(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Хочу изучить'></form></td><td>" +
                        "</tr>");
                }
            }
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
            get_kid_jobs_and_fill_list();
        }
    })
}