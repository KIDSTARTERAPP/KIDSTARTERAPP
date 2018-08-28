$(document).ready(function () {
    get_current_user();
    $("#table_organization_requests").empty();
    fill_organization_requests_table();
});

function fill_organization_requests_table() {
    console.log("here");
    $("#table_organization_requests").empty();
    $.ajax({
        type: "GET",
        url: "/api/requests",
        dataType: "JSON",
        success: function (response) {
            console.log(response);
            $.each(response, function(i, item) {
                var tr;
                if(item.status == "NEW") {
                    tr = $('<tr>').append(
                        // $('<td>').text(item.id),
                        $('<td>').text(item.description),
                        $('<td>').text(item.job.name),
                        // $('<td>').text(item.kids.length),
                        $('<td>').text('нет'),
                        $('<td>').text('нет'),
                        $('<td>').text(item.price / 100),
                        $('<td>').text(item.status),
                        $('<td>').append("<form onsubmit='remove_request(" + item.id + ");return false'><input class='btn btn-lg btn-primary btn-block' type='submit' value='Удалить запрос'></form>"),
                        $('<td>').text(" ")
                    );
                } else if(item.status == "READY") {
                    tr = $('<tr>').append(
                        // $('<td>').text(item.id),
                        $('<td>').text(item.description),
                        $('<td>').text(item.job.name),
                        // $('<td>').text(item.kids.length),
                        $('<td>').text(item.mentor.user.email),
                        $('<td>').text(item.mentor.user.phone),
                        $('<td>').text(item.price /100),
                        $('<td>').text(item.status),
                        $('<td>').append("<form onsubmit='get_request_for_update(" + item.id + ");return false'><input class='btn btn-lg btn-primary btn-block' type='submit' value='Подтвердить'></form>"),
                        $('<td>').append("<form onsubmit='get_request_for_decline(" + item.id + ");return false'><input class='btn btn-lg btn-primary btn-block' type='submit' value='Отклонить'></form>")
                    );
                } else {
                    tr = $('<tr>').append(
                        // $('<td>').text(item.id),
                        $('<td>').text(item.description),
                        $('<td>').text(item.job.name),
                        // $('<td>').text(item.kids.length),
                        $('<td>').text('нет'),
                        $('<td>').text('нет'),
                        $('<td>').text(item.price / 100),
                        $('<td>').text(item.status),
                        $('<td>').text(" "),
                        $('<td>').text(" ")
                    );
                }
                if (item.creator.user.id == current_user.id) {
                    $("#table_organization_requests").append(tr);
                }
            });
        }
    })
}

function remove_request(requestId) {
    var url = "/api/request/" + requestId;
    $.ajax({
        type: "DELETE",
        url: url,
        dataType: "JSON",
        success: function () {
            fill_organization_requests_table();
        }
    })
}


function get_request_for_update(requestId) {
    var url = "/api/request/" + requestId;
    $.ajax({
        type: "GET",
        url: url,
        dataType: "JSON",
        success: function (response) {
            var data = {
                id: response.id,
                description: response.description,
                job: response.job,
                kids: response.kids,
                teachers: response.teachers,
                price: response.price,
                sponsors: response.sponsors,
                mentor: response.mentor,
                account: response.account,
                creator: response.creator,
                status: "IN_PROGRESS"
            };
            approve_request(JSON.stringify(data));
        }
    })
}

function get_request_for_decline(requestId) {
    var url = "/api/request/" + requestId;
    $.ajax({
        type: "GET",
        url: url,
        dataType: "JSON",
        success: function (response) {
            var data = {
                id: response.id,
                description: response.description,
                job: response.job,
                kids: response.kids,
                teachers: response.teachers,
                price: response.price,
                sponsors: response.sponsors,
                mentor: null,
                account: response.account,
                creator: response.creator,
                status: "NEW"
            };
            approve_request(JSON.stringify(data));
        }
    })
}

function approve_request(response) {
    $.ajax({
        type: "PUT",
        url: "/api/request",
        contentType : "application/json; charset=UTF-8",
        dataType: "JSON",
        data: response,
        success: function () {
            fill_organization_requests_table();
        }
    })
}

