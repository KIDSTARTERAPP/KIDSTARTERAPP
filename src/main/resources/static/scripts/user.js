function createUser() {
    console.log("WORK");
    let url = '/api/user';
    let wrap = {
        firstName: $('#firstname').val(),
        lastName: $('#lastname').val(),
        patronymic: $('#patronymic').val(),
        login: $('#login').val(),
        password: $('#password').val(),
        role: $('#role').find('option:selected').text(),
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
        data: data, rz
        success: function () {
            console.log("Добавить огику")
        },
        error: function (e) {
            console.log("errrrrrr");
        }
    });


}