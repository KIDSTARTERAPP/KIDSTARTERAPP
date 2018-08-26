function createKid() {
    let url = "/api/organization/" + $("#id_org").val() + "/kids/create";
    let wrap = {
        firstName: $('#firstname').val(),
        lastName: $('#lastname').val(),
        patronymic: $('#patronymic').val(),
        login: $('#login').val(),
        password: $('#password').val(),
        age: $('#age').val(),
        sex: $('#sex').val(),
        phone: $('#phone').val(),
        email: $('#email').val(),
        country: $('#country').val(),
        address: $('#address').val()
    };
    let data = JSON.stringify(wrap);

    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json; charset=utf-8",
        data: data,
        success: function () {
            window.location.replace("/main/organization/" + $("#id_org").val() + "/kids");
        },
        error: function (e) {

        }
    });
}