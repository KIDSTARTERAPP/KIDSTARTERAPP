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
        }
    });
    $("#select_tagselect").empty();
    filltagselect();
}

function createjob() {
    var name = $("#input_jobname").val();
    var description = $("#input_jobdesc").val();
    var tag = $("#select_tagselect").val();
    $.ajax({
        type: "POST",
        url: "./api/job",
        datatype: "JSON",
        data: {name:name,description:description,tag:tag},
        success: function (response) {
            $("#input_jobname").val('');
            $("#input_jobdesc").val('');
            $("#label_job_result").empty().append("Интерес " + response.name + " создан!")
        }
    });
}
