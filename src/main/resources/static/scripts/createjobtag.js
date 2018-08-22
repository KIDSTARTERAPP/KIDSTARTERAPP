$(document).ready(function () {
    filltagselect();
});

function filltagselect() {
    $.ajax({
        type: "GET",
        url: "./api/tags",
        datatype: "JSON",
        success: function (response) {
            for (var i in response) {
                $("#select_tagselect").append("<option value='" + response[i].name + "'>" + response[i].name + "</option>");
            }
        }
    })
}

function createtag(name) {
    $.ajax({
        type: "POST",
        url: "./api/tag",
        datatype: "JSON",
        data: {name:name},
        success: function (response) {
            $("#input_tag_name").val('');
            $("#label_tag_result").empty().append("Тэг " + response.name + " создан!")
            $("#select_tagselect").empty();
            filltagselect();
        }
    });
}

function createjob() {
    var tag_list = JSON.stringify($("#select_tagselect").val());
    $.ajax({
        type: "GET",
        url: "/api/select_tags",
        datatype: "JSON",
        data: {tags : tag_list},
        success: function (response) {
            var data = {
                id: "",
                name: $("#input_jobname").val(),
                tags: response,
                description: $("#input_jobdesc").val(),
                kids: [],
                mentors: [],
                teachers: []
            };
            send_create(JSON.stringify(data));
        }
    });
}

function send_create(data) {
    $.ajax({
        type: "POST",
        url: "/api/job/",
        contentType : "application/json; charset=UTF-8",
        encoding: "UTF-8",
        data: data,
        success: function (response) {
            console.log(response);
            $("#input_jobname").val('');
            $("#input_jobdesc").val('');
            $("#label_job_result").empty().append("Интерес " + response.name + " создан!")
        }
    });
}