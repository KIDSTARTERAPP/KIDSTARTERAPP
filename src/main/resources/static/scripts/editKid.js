$(document).ready(function () {
    fillform();
});

function fillform() {
    var url = "/api/organization/" + $("#id_org").val() + "/kids/" + $("#id_kid").val();
    $.ajax({
        type: "GET",
        url: url,
        datatype: "JSON",
        success: function (response) {
            $("#hidden_id").val(response.id);
            $("#firstname").val(response.firstName);
            $("#lastname").val(response.lastName);
            $("#patronymic").val(response.patronymic);
            $("#login").val(response.firstName);
            $("#password").val('');
            $.each(response.roles, function (i,e) {
                $("#role option[value='" + e.name + "']").prop("selected", true);
            });
            $("#createDate").val(response.createDate);
            $("#age").val(response.age);
            $("#sex").val(response.sex);
            $("#phone").val(response.phone);
            $("#email").val(response.email);
            $("#country").val(response.country);
            $("#address").val(response.address);
        }
    })
}

function updateKid() {
    var role_list = JSON.stringify($("#role").val());
    $.ajax({
        type: "GET",
        url: "/api/select_roles",
        datatype: "JSON",
        data: {roles : role_list},
        success: function (response) {
            var data = {
                id: $("#hidden_id").val(),
                firstName: $("#firstname").val(),
                lastName: $("#lastname").val(),
                patronymic: $("#patronymic").val(),
                login: $("#login").val(),
                password: $("#password").val(),
                roles: response,
                createDate: $("#createDate").val(),
                age: $("#age").val(),
                sex: $("#sex").val(),
                phone: $("#phone").val(),
                email: $("#email").val(),
                country: $("#country").val(),
                address: $("#address").val()
            };
            send_update(JSON.stringify(data));
        }
    })
}

function send_update(data) {
    $.ajax({
        type: "PUT",
        url: "/api/organization/" + $("#id_org").val() + "/kids/" + $("#id_kid").val(),
        contentType : "application/json; charset=UTF-8",
        encoding: "UTF-8",
        data: data,
        success: function () {
            window.location.replace("/organization/" + $("#id_org").val() + "/kids");
        }
    })
}