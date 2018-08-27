$(document).ready(function () {
    $("#request_result").empty();
    fill_new_requests_table();
});

function fill_new_requests_table() {
    $("#table_new_requests").empty();
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
                    $('<td>').text(item.price),
                    $('<td>').text(item.status),
                    $('<td>').append("<form onsubmit='add_mentor(" + item.id + ");return false'><input class='btn btn-lg btn-primary btn-block' type='submit' value='Подать заявку'></form>")
                );
                if (item.status == "NEW") {
                    $("#table_new_requests").append(tr);
                }
            });
        }
    })
}

function add_mentor(item) {
    var url = "/api/request/" + item + "/mentor";
    $.ajax({
        type: "POST",
        url: url,
        dataType: "JSON",
        success: function () {
            $("#request_result").empty();
            $("#request_result").append('Заявка принята!');
            fill_new_requests_table();
        }
    })
}