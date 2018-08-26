$(document).ready(function () {
    get_current_user();
    $("#table_organization_requests").empty();
    fill_organization_requests_table();
});

function fill_organization_requests_table() {
    $("#table_organization_requests").empty();
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
                    $('<td>').text(item.teachers.length),
                    $('<td>').text(item.price),
                    $('<td>').text(item.status),
                    $('<td>').append("<form onsubmit='add_mentor(" + item.id + ");return false'><input class='btn btn-lg btn-primary btn-block' type='submit' value='Подать заявку'></form>")
                );
                if (item.mentor.user.id == current_user.id) {
                    $("#table_organization_requests").append(tr);
                }
            });
        }
    })
}