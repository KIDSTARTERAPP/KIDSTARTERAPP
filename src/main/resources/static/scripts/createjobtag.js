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
                $("#tagselect").append("<option value='" + response[i].name + "'>" + response[i].name + "</option>");
            }
        }
    })
}

function createtag(name) {
    console.log(name);
    $.ajax({
        type: "POST",
        url: "./api/tag",
        datatype: "JSON",
        data: {name:name},
        success: function (response) {
            console.log(response);
            if(response == "" ) {
                $("#input_tag_name").val('');
                $("#label_tag_result").empty().append("Error!")
            } else {
                $("#input_tag_name").val('');
                $("#label_tag_result").empty().append("Тэг " + response.name + " создан!")
            }
        }
    });
    $("#tagselect").empty();
    filltagselect();
}

function createjob() {
    
}
