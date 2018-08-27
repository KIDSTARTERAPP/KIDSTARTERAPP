$(document).ready(function () {
    getLocation();
    getJobs();
});

var latitude;
var longitude;

function getJobs() {
    let url = "/api/jobs";

    $.ajax({
        type: "GET",
        url: url,
        datatype: "JSON",
        success: function (jobs) {
            for (var i in jobs) {
                $('#select-jobs').append("<option value='" + jobs[i].id + "'>" + jobs[i].name + "</option>");
            }
        }
    })

}

function addMentor() {
    var jobs = $('#select-jobs').val();
    $.ajax({
        type: "GET",
        url: "/api/job/select_jobs",
        datatype: "JSON",
        data: {jobs:JSON.stringify(jobs)},
        success: function (response) {
            let wrap = {
                jobs: response,
                description: $('#description').val(),
                experience: $("#experience").val(),
                pointX: latitude,
                pointY: longitude
            };
            let data = JSON.stringify(wrap);
            send_create(data);
        }
    });
}

function send_create(data) {
    $.ajax({
        type: "POST",
        url: "/api/mentor",
        contentType: "application/json; charset=utf-8",
        data: data,
        success:function () {
            window.location.replace("/main");
        }
    })
}

function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(log_position);
    } else {
        alert("Geolocation is not supported by this browser.");
    }
}

function log_position(position) {
    console.log(position.coords.latitude);
    latitude = position.coords.latitude;
    console.log(position.coords.longitude);
    longitude = position.coords.longitude;
}