$(document).ready(function () {
    getJobs();
});

function getJobs() {
    let url = "/api/jobs";

    $.ajax({
        type: "GET",
        url: url,
        datatype: "JSON",
        success: function (jobs) {
            for (var i in jobs) {
                $('#select-jobs').append("<option value='" + jobs[i].name + "'>" + jobs[i].name + "</option>");

            }
        }
    })

}

function addMentor() {
    let url = "/api/mentor/add";

    let wrap = {
        description: $('#description').val()
    };

    let data = JSON.stringify(wrap);

    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json; charset=utf-8",
        data: data,
        success:function () {
            window.location.replace("/main");
        }
    })

}