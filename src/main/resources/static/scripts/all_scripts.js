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
        "requests": "Список не активных заявок",
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
        "become-mentor": "Стать ментором"
    };

    var linksArray = ["editUser"];

    let splitter = pathname.split("/");
    for (let i  in splitter) {

        if (i == 0) {
            continue;
        }
        name = myArray[splitter[i]];
        if ( linksArray.includes(splitter[i])) {
            link += "/" + splitter[i];
            continue;
        }
        else {
            link += "/" + splitter[i];
        }
        console.log(link);
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