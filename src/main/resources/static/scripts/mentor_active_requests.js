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
                    $('<td>').text(item.price),
                    $('<td>').text(item.status)
                );
                if ((item.status != "NEW") && (item.mentor.user.id == current_user.id)) {
                    $("#table_active_requests").append(tr);
                }
            });
        }
    })
}