$(document).ready(function () {

    fillusertable();
    console.log("fill");
});

function fillusertable(){
    console.log("func");
    $("#table_body_userlist").empty();
    $.ajax({
        type: "GET",
        url: "./users",
        datatype: "JSON",
        success: function (response) {
            console.log(response);
            for (var i in response) {
                var roles = [];
                for (var j in response[i].roles) {
                    // roles += response[i].roles[j].name;
                    roles.push(response[i].roles[j].name);
                }
                $("#table_body_userlist").append("<tr><td>" + response[i].id + "</td><td>" +
                    response[i].lastname + "</td><td>" +
                    response[i].firstName + "</td><td>" +
                    response[i].initial + "</td><td>" +
                    response[i].login + "</td><td>" +
                    roles + "</td><td>" +
                    response[i].createDate + "</td><td>" +
                    response[i].age + "</td><td>" +
                    response[i].sex + "</td><td>" +
                    response[i].phone + "</td><td>" +
                    response[i].email + "</td><td>" +
                    response[i].country + "</td><td>" +
                    response[i].address + "</td><td>" +
                    response[i].enabled + "</td><td>" +
                    "<input type='submit' value='Изменить'></td><td>" +
                    "<input type='submit' value='Удалить'></td><td>" +
                    "</tr>");
            }
        }
    })

}