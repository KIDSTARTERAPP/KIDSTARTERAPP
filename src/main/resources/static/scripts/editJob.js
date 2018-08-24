$(document).ready(function () {
    add_tags();
    fill_job_form();
});

function add_tags() {
    $.ajax({
        type: "GET",
        url: "/api/tags",
        datatype: "JSON",
        success: function (response) {
            for (var i in response) {
                $("#select_tagselect").append("<option value='" + response[i].name + "'>" + response[i].name + "</option>");
            }
        }
    })
}

function fill_job_form() {
    var pathname = window.location.pathname;
    var id = pathname.substring(pathname.lastIndexOf("/") + 1, pathname.length);
    var url = "/api/job/" + id;
    $.ajax({
        type: "GET",
        url: url,
        datatype: "JSON",
        success: function (response) {
            $("#hidden_id").val(response.id);
            $("#input_jobname").val(response.name);
            $("#input_jobdesc").val(response.description);
            $.each(response.tags, function (i,e) {
                $("#select_tagselect option[value='" + e.name + "']").prop("selected", true);
            });
        }
    })
}

function edit_job() {
    var role_list = JSON.stringify($("#select_tagselect").val());
    $.ajax({
        type: "GET",
        url: "/api/select_tags",
        dataType: "JSON",
        data: {tags : role_list},
        success: function (response) {
            var data = {
              id: $("#hidden_id").val(),
                name:  $("#input_jobname").val(),
                description: $("#input_jobdesc").val(),
                tags: response
            };
            send_update(JSON.stringify(data));
        }
    })
}

function send_update(data) {
    $.ajax({
        type: "PUT",
        url: "/api/job",
        contentType : "application/json; charset=UTF-8",
        encoding: "UTF-8",
        data: data,
        success: function (response) {
            window.location.replace("/jobPage");
        }
    })
}