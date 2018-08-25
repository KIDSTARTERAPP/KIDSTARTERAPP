function create_user() {
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
            send_create(JSON.stringify(data));
        }
    })
}

function send_create(data) {
    $.ajax({
        type: "POST",
        url: "/api/user/",
        contentType : "application/json; charset=UTF-8",
        encoding: "UTF-8",
        data: data,
        success: function () {
            window.location.replace("/adminpage");
        }
    })
}