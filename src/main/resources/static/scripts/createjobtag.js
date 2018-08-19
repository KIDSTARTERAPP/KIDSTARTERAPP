console.log("createjobtag");

function filltagselect() {
    $("#tagselect").empty();
    $.ajax({
        type: "GET",
        url: "./api/tags",
        datatype: "JSON",
        success: function (response) {
            var data = response;
            for (var i in data) {
                $("#tagselect").append("<option value='" + data[i].name + "'>" + data[i].name + "</option>");
            }
        }
    })
}