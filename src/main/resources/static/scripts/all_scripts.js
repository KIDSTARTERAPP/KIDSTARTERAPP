$(document).ready(function () {
    setLinks();
    setBreadCrumb();

});

function setBreadCrumb() {
    let pathname = document.location.pathname;
    var link = "";
    var name;
    var myArray = {

        "main": "Главная",
        "createorganization": "Добавление организации",
        "mentor": "Главная страница ментора",
        "requests": "Список запросов",
        "activerequests": "Список активных заявок",
        "profile": "Профиль",
        "admin": "Главная страница админа",
        "organizations": "Список организаций",
        "users": "Список пользователей",
        "tags": "Теги",
        "jobs": "Интересы",
        "organization": "Главная страница организации",
        "kids": "Дети",
        "add": "Добавление",
        "teachers": "Учителя",
        "addrequest": "Добавление  запроса",
        "kid": "Главная страница ребёнка",
        "registration": "Регистрация",
        "login": "Логин",
        "create-organization" : "Создание организации",
        "become-mentor": "Стать ментором",
        "suitable-requests": "Список открытых запросов",
        "my-requests": "Список моих запросов",
        "add-kid": "Добавление ребёнка",
        "add-request": "Создание запроса"
    };

    var linksArray = ["editUser","editOrganization","editJob"];

    let splitter = pathname.split("/");
    for (let i  in splitter) {

        if (i == 0) {
            continue;
        }
        if (splitter[i].match(/^[-\+]?\d+/) === null) {
            name = myArray[splitter[i]]
        }
        link += "/" + splitter[i];
        if (linksArray.includes(splitter[i])) {
            continue;
        }
        // console.log(link);
        if (i == splitter.length - 1) {
            $('#breadcrumbMain').append("<li class='breadcrumb-item active' >" + name + "</li>");
        }
        else {
            $('#breadcrumbMain').append("<li class='breadcrumb-item'><a href=" + link + " >" + name + "</li>");
        }
    }

}

function setLinks() {
    let pathname = document.location.pathname;

    if (pathname.includes('/main')) {
        $('#main-link').attr('class', 'active');
    }
    if (pathname.includes('/activerequests')) {
        $('#active-requests-link').attr('class', 'active');
    }
    if (pathname == ('/profile')) {
        $('#profile-link').attr('class', 'active');
    }


    if (pathname.includes('/mentor')) {
        $('#mentor-link').attr('class', 'active');
    }

    if (pathname.includes('/organization')) {
        $('#organization-link').attr('class', 'active');
    }
    if (pathname.includes('/kid')) {
        $('#kid-link').attr('class', 'active');
    }
}
//---------------Get-user-principal-------------------
var current_user;

function get_current_user() {
    $.ajax({
        type: "GET",
        url: "/api/user/current",
        dataType: "JSON",
        async: false,
        success: function (response) {
            current_user = response;
        }
    })
}
//---------------Get-user-principal-------------------