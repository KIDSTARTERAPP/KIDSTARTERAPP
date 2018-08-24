$(document).ready(function () {
    fillOrgform();
});

function fillOrgform() {
    var pathname = window.location.pathname;
    var id = pathname.substring(pathname.lastIndexOf("/") + 1, pathname.length);
    var url = "/api/organization/" + id;
    $.ajax({
        type: "GET",
        url: url,
        datatype: "JSON",
        success: function (response) {
            $("#hidden_id").val(response.id);
            $("#name").val(response.name);
            $("#phone").val(response.phone);
            $("#email").val(response.email);
            $("#country").val(response.country);
            $("#address").val(response.address);
            $("#createDate").val(response.createDate);
        }
    })
}

function updateOrganization() {
    var wrap = {
        id: $("#hidden_id").val(),
        name: $("#name").val(),
        phone: $('#phone').val(),
        email: $('#email').val(),
        country: $('#country').val(),
        createDate: $("#createDate").val(),
        address: $('#address').val(),
        account: null
    };
    var data = JSON.stringify(wrap);

    $.ajax({
        type: "PUT",
        url: "/api/organization",
        contentType : "application/json; charset=UTF-8",
        data: data,
        success: function (response) {
            window.location.replace("/organizationPage");
        }
    })
}
