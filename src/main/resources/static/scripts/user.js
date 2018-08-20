function getRoles() {
    $.get('api/role', function (role) {
        return role;
    })
}

function createUser() {
    console.log("WORK");
    console.log(getRoles());
    let wrap = {
        firstName: $('#firstname').val(),
        lastName: $('#lastname').val(),
        patronymic: $('#patronymic').val(),
        login: $('#login').val(),
        password: $('#password').val(),
        // roles:[{"id":1,"name":"ADMIN","authority":"ADMIN"}],
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
        url: '/api/user',
        contentType: "application/json; charset=utf-8",
        data: data,
        success: function () {
            console.log("Добавить огику")
        },
        error: function (e) {
            console.log("errrrrrr");
        }
    });
}

