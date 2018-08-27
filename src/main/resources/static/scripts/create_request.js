$(document).ready(function () {
    fill_job_select();
    fill_kids_modal();
    // fill_teachers_modal();
});

// var selected_kids = [];
var selected_teachers = [];

//--------------------------------------------------------------------------------------
// Get the modal
var modal_kids = document.getElementById('kids_modal');
// var modal_teachers = document.getElementById('teachers_modal');

// Get the button that opens the modal
var btn_kids = document.getElementById("button_select_kid");
// var btn_teachers = document.getElementById("button_select_teacher");

// Get the <span> element that closes the modal
var span_kids = document.getElementById("span_kids");
// var span_teachers = document.getElementById("span_teachers");

var submit_kids = document.getElementById("submit_kids");
// var submit_teachers = document.getElementById("submit_teachers");

// When the user clicks the button, open the modal
btn_kids.onclick = function() {
    modal_kids.style.display = "block";
};
// btn_teachers.onclick = function() {
//     modal_teachers.style.display = "block";
// };

// When the user clicks on <span> (x), close the modal
span_kids.onclick = function() {
    modal_kids.style.display = "none";
};

// span_teachers.onclick = function() {
//     modal_teachers.style.display = "none";
// };

// When the user clicks on submit, close the modal
submit_kids.onclick = function() {
    modal_kids.style.display = "none";
};
// submit_teachers.onclick = function() {
//     modal_teachers.style.display = "none";
// };

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal_kids) {
        modal_kids.style.display = "none";
    }
    // if (event.target == modal_teachers) {
    //     modal_teachers.style.display = "none";
    // }
};
//--------------------------------------------------------------------------------------
//Sortable list config
$( function() {
    $( "#kids_sortable1, #kids_sortable2" ).sortable({
        connectWith: ".connectedSortable"
    }).disableSelection();
} );

// $( function() {
//     $( "#teachers_sortable1, #teachers_sortable2" ).sortable({
//         connectWith: ".connectedSortable"
//     }).disableSelection();
// } );
//--------------------------------------------------------------------------------------
function fill_job_select() {
    $("#select_job").empty();
    $.ajax({
        type: "GET",
        url: "/api/jobs",
        contentType : "application/json; charset=UTF-8",
        dataType: "JSON",
        success: function (response) {
            for (var i in response) {
                $("#select_job").append("<option value='" + response[i].id + "'>" + response[i].name + "</option>");
            }
        }
    })
}

function fill_kids_modal() {
    $.ajax({
        type: "GET",
        url: "/api/organization/kids",
        contentType : "application/json; charset=UTF-8",
        dataType: "JSON",
        success: function (response) {
            for (var i in response) {
                var fio = response[i].user.lastName + " " + response[i].user.firstName + " " + response[i].user.patronymic;
                $("#kids_sortable1").append("<li class='ui-state-default' rel='" + response[i].id + "'>" + fio + "</li>");
            }

        }
    })
}   

// function fill_teachers_modal() {
//     $.ajax({
//         type: "GET",
//         url: "/api/organization/teachers",
//         contentType : "application/json; charset=UTF-8",
//         dataType: "JSON",
//         success: function (response) {
//             console.log(response);
//             for (var i in response) {
//                 var fio = response[i].user.lastName + " " + response[i].user.firstName + " " + response[i].user.patronymic;
//                 $("#teachers_sortable1").append("<li class='ui-state-default' rel='" + response[i].id + "'>" + fio + "</li>");
//             }
//
//         }
//     })
// }

function select_kids() {
    var localSelected = []
    $("#kids_sortable2 li").each(function (i) {
        localSelected.push($(this).attr('rel'));
    });
    selected_kids = localSelected;
}

// function select_teachers() {
//     var localSelected = []
//     $("#teachers_sortable2 li").each(function (i) {
//         localSelected.push($(this).attr('rel'));
//     });
//     selected_teachers = localSelected;
// }

var jobJSON;
var kidJSON;
var teacherJSON;

function job_to_JSON() {
    var job_id = $("#select_job").val();
    var url = "/api/job/" + job_id;
    $.ajax({
        type: "GET",
        url: url,
        contentType : "application/json; charset=UTF-8",
        dataType: "JSON",
        async: false,
        success: function (response) {
            jobJSON = response;
        }
    })
}

function kids_to_JSON() {
    var localKids = [];
    for (var i in selected_kids) {
        var url = "/api/organization/kid/" + selected_kids[i];
        console.log(url);
        $.ajax({
            type: "GET",
            url: url,
            dataType: "JSON",
            async: false,
            success: function (response) {
                localKids.push(response);
            }
        })
    }
    kidJSON = localKids;
}

// function teachers_to_JSON() {
//     var localTeachers = [];
//     for (var i in selected_teachers) {
//         var url = "/api/teacher/" + selected_teachers[i];
//         $.ajax({
//             type: "GET",
//             url: url,
//             dataType: "JSON",
//             async: false,
//             success: function (response) {
//                 localTeachers.push(response);
//             }
//         })
//     }
//     teacherJSON = localTeachers;
// }

function create_request() {
    job_to_JSON();
    kids_to_JSON();
    // teachers_to_JSON();

    var data = {
        description: $("#request_description").val(),
        job: jobJSON,
        kids: kidJSON,
        teachers: teacherJSON,
        price: $("#request_price").val(),
        status: "NEW"
    };
    var json = JSON.stringify(data);
    $.ajax({
        type: "POST",
        url: "/api/request",
        contentType : "application/json; charset=UTF-8",
        encoding: "UTF-8",
        dataType: "JSON",
        async: false,
        data: json,
        success: function () {
            window.location.replace("/organization/requests");
        }
    })
}