$(document).ready(function () {
    fill_request_table();
});

function fill_request_table() {
    $.ajax({
        type: "GET",
        url: "../api/requests",
        datatype: "JSON",
        success: function (response) {
                for (var i in response) {
                    // var kidsString;
                    // for(var kid in response[i].kids.user){
                    //     console.log(kid)
                        // kidsString += kid.user.name;
                 if (response[i].status === "IN_PROGRESS") {
                    var targetAmount = response[i].price;
                    var currentPercent = targetAmount / 100;
                    var drawPercent = response[i].account.currentAmount / currentPercent;

                    $(".request-field").append('<div class="panel-group donate-panel-class" id="donate-panel'+response[i].id +'" data-request-id="'+response[i].id +'"><div class="panel panel-default request-modal"><div class="panel-heading skype-panel-head">' + response[i].description + '</div>' +
                        '<br class="panel-body"> Необходимо собрать: '+response[i].price / 100 +'\n' + '<br/>' +   'Собрано: '+response[i].account.currentAmount / 100+' ' + '<div class="progress">' +
                        '<div class="progress-bar progress-bar-success" role="progressbar" style="min-width:' + drawPercent + '%" aria-valuenow="' + response[i].account.currentAmount / 100 + '" aria-valuemin="0" aria-valuemax="' + response[i].account.needAmount / 100 + '"></div>' +
                        '</div>' + '</br> Интерес: ' + response[i].job.name + '<button  data-id="'+response[i].id +'" class="btn btn-sm btn-primary donate-info-button"> Информация о заявке </button>' + '<button  data-id="'+response[i].id +'" class="btn btn-sm btn-success donate-button"> Задонатить </button>' + '</div>').after('<div class="modal fade donate-modal" id="donateModal'+response[i].id +'" tabindex="-1" role="dialog" aria-hidden="true">\n' +
                        '            <div class="modal-dialog">\n' +
                        '                <div class="modal-content">\n' +
                        '                    <div class="modal-header">\n' +
                        '                        <h5 class="modal-title">Информация о заявке</h5>\n' +
                        '                    </div>\n' +
                        '                    <div class="modal-body">' +
                        '                        Описание заявки: '+response[i].description+'\n' + '<br/>' +
                        '                        Интересы: '+response[i].job.name+'\n' + '<br/>' +
                        '                        Необходимо собрать: '+response[i].price / 100 +'\n' + '<br/>' +
                        // '                        Ментор заявки: '+response[i].mentor.user.firstName+'  '+response[i].mentor.user.lastName+'  '+response[i].mentor.user.patronymic+'\n' + '<br/>' +
                        '                        Счет аккаунта: '+response[i].account.currentAmount / 100+'\n' + '<br/>' +
                        '                        Создатель заявки: '+response[i].creator.user.firstName+'  '+response[i].creator.user.lastName+'  '+response[i].creator.user.patronymic+'\n' + '<br/>' +
                        '                        Список детей: '+response[i].kids.kid+'<br/>' +
                        '                        Список спонсоров: '+response[i].kids.kid+'<br/>' +

                        '                    </div>\n' +
                        '                    <div class="modal-footer">\n' +
                        '                        <span class="send-fixed-template"></span>\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '            </div>\n' +
                        '        </div>');

                    $('.donate-info-button').on('click', function (e) {
                        var requestId = $(this).data('id');
                        $('#donateModal'+requestId).modal('show');
                    });
                    $('.donate-button').on('click', function (event) {
                        var requestId = $(this).data('id');
                        $(location).attr('href',"/donate/" + requestId);
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