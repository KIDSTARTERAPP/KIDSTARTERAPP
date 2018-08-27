$(document).ready(function () {
    get_current_user();
    fill_active_requests_table();
});

function fill_active_requests_table() {
    $("#table_active_requests").empty();
    $.ajax({
        type: "GET",
        url: "/api/requests",
        dataType: "JSON",
        success: function (response) {
            $.each(response, function(i, item) {
                var tr = $('<tr>').append(
                    $('<td>').text(item.id),
                    $('<td>').text(item.description),
                    $('<td>').text(item.job.name),
                    $('<td>').text(item.kids.length),
                    $('<td>').text(item.price / 100),
                    $('<td>').text(item.status)
                );
                if (item.status == "IN_PROGRESS") {
                    var tr = $('<tr>').append(
                        $('<td>').text(item.id),
                        $('<td>').text(item.description),
                        $('<td>').text(item.job.name),
                        $('<td>').text(item.kids.length),
                        $('<td>').text(item.price / 100),
                        $('<td>').text(item.status),
                        $('<td>').append("<form onsubmit='get_free_request(" + item.id + ");return false'><input class='btn btn-lg btn-primary btn-block' type='submit' value='Учить бесплатно'></form>")
                    );
                }
                if ((item.status != "NEW") && (item.mentor.user.id == current_user.id)) {
                    $("#table_active_requests").append(tr);
                }
            });
        }
    })
}

function get_free_request(id) {
    var url = "/api/request/" + id;
    $.ajax({
        type: "GET",
        url: url,
        dataType: "JSON",
        success: function (response) {
            response.status = "PAID";
            teach_free(JSON.stringify(response));
        }
    })
}

function teach_free(data) {
    $.ajax({
        type: "PUT",
        url: "/api/request",
        contentType : "application/json; charset=UTF-8",
        dataType: "JSON",
        data:data,
        success: function () {
            fill_active_requests_table();
        }
    })
}