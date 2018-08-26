$(document).ready(function () {
    fillOrgPage();
});

function fillOrgPage() {
    var pathname = window.location.pathname;
    var id = pathname.substring(pathname.lastIndexOf("/") + 1, pathname.length);
    var url = "/api/organization/" + id;
    $.ajax({
        type: "GET",
        url: url,
        datatype: "JSON",
        success: function (response) {
            $("#org_id").val(response.id);
            $("#name").val(response.name);
            $("#phone").val(response.phone);
            $("#email").val(response.email);
            $("#country").val(response.country);
            $("#address").val(response.address);
            $("#createDate").val(response.createDate);
            $("#listKids").append(
                "<form class='navbar-form' onsubmit='list_kid(" + response.id + ");return false'>" +
                "<input class='form-control' type='submit' value='Список детей'>");
        }
    })
}

function list_kid(id) {
    var url = "/../organization/" + id + "/kids";
    window.location.replace(url);
}