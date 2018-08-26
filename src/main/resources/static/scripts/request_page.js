$(document).ready(function () {
    fill_request_table();
});

function fill_request_table() {
    $.ajax({
        type: "GET",
        url: "./api/requests",
        datatype: "JSON",
        success: function (response) {
            for (var i in response) {
                if (response[i].status === "IN_PROGRESS") {
                    var currentAmount = response[i].account.needAmount;
                    var currentPercent = currentAmount / 100;
                    var drawPercent = response[i].account.currentAmount / currentPercent;

                    $(".request-field").append('<div class="panel-group donate-panel-class" id="donate-panel'+response[i].id +'" data-request-id="'+response[i].id +'"><div class="panel panel-default request-modal"><div class="panel-heading skype-panel-head">' + response[i].description + '</div>' +
                        '<br class="panel-body"> Необходимо собрать: ' + response[i].account.needAmount + '  ' + '<div class="progress">' +
                        '<div class="progress-bar progress-bar-success" role="progressbar" style="min-width:' + drawPercent + '%" aria-valuenow="' + response[i].account.currentAmount + '" aria-valuemin="0" aria-valuemax="' + response[i].account.needAmount + '"></div>' +
                        '</div>' + '</br> Интерес: ' + response[i].job.name + '<button  data-id="'+response[i].id +'" class="btn btn-sm btn-primary donate-info-button"> Информация о заявке </button>' + '<button  data-id="'+response[i].id +'" class="btn btn-sm btn-success donate-button"> Задонатить </button>' + '</div>').after('<div class="modal fade donate-modal" id="donateModal'+response[i].id +'" tabindex="-1" role="dialog" aria-hidden="true">\n' +
                        '            <div class="modal-dialog">\n' +
                        '                <div class="modal-content">\n' +
                        '                    <div class="modal-header">\n' +
                        '                        <h5 class="modal-title">Подтвердите свое действие</h5>\n' +
                        '                    </div>\n' +
                        '                    <div class="modal-body">' +
                        '                        '+response[i].description+'\n' +
                        '                    </div>\n' +
                        '                    <div class="modal-footer">\n' +
                        '                        <span class="send-fixed-template"></span>\n' +
                        '                        <button type="button" class="btn btn-primary send-all-message">Отправить</button>\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '            </div>\n' +
                        '        </div>');

                    $('.donate-info-button').on('click', function (e) {
                        var requestId = $(this).data('id');
                        $('#donateModal'+requestId).modal('show');
                    });
                }
            }
        }
    });


}

$('.donate-modal').on('show.bs.modal', function (e) {
    var requestId = $(this).data('id');
    console.log(requestId);
    $.ajax({
        type: "GET",
        url: 'api/request/' + requestId,
        datatype: "JSON",
        data: requestId,
        success: function (request) {
            console.log(request);
            },
        async: false
    })
});


// $('.request-field').on('click','.donate-button', function (e) {
//     var requestId = $('.donate-panel-class').data('requestId');
//     var currentModal = $('#donateModal').attr('data-id', requestId);
//     console.log(requestId);
//     currentModal.modal('show');
// });



// $('.donate-modal').on('hidden.bs.modal', function (e) {
//     $('.donate-modal').attr('id', 'donateModal');
// });