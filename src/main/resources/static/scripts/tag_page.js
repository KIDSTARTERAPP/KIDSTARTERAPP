$(document).ready(function () {
    fill_tag_list();
});

function fill_tag_list() {
    $("#table_tag_list").empty();
    $.ajax({
        type: "GET",
        url: "./api/tags",
        dataType: "JSON",
        success: function (response) {
            console.log(response);
           for (var i in response) {
               $("#table_tag_list").append("<tr><td>" + response[i].id + "</td><td>" +
                   response[i].name + "</td><td>" +
                   // response[i].jobs + "</td><td>" +
                   "<form class='navbar-form' onsubmit='delete_tag(" + response[i].id + ");return false'><input class='form-control' type='submit' value='Удалить'></form></td><td>" +
                   "</tr>");
           }
        }
    })
}

function delete_tag(tagId) {
    var url = "./api/tag/" + tagId;
    $.ajax({
        type: "DELETE",
        url: url,
        dataType: "JSON",
        success: function () {
            fill_tag_list();
        }
    })
}