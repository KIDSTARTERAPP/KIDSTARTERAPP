$(document).ready(function () {
    setActiveLink();
});

function setActiveLink() {
    let pathname = document.location.pathname;

    if (pathname.includes('/main')) {
        var main = document.getElementById("main-link");
        main.className += "active";
    }
    if (pathname.includes('/tagPage')) {
        var tag = document.getElementById("tage-link");
        tag.className += "active";
    }
    if (pathname.includes('/cretejobtag')) {
        var createTag = document.getElementById("create-tag-link");
        createTag.className += "active";
    }
    if (pathname.includes('/create_user')) {
        var createUser = document.getElementById("create-user-link");
        createUser.className += "active";
    }
    if (pathname.includes('/editUser')) {
        var editUser = document.getElementById("edit-user-link");
        editUser.className += "active";
    }
    if (pathname.includes("/jobPage")) {
        var job = document.getElementById("jobs-link");
        job.className += "active";
    }
    if (pathname.includes("/adminpage")) {
        var admin = document.getElementById("users-link");
        admin.className += "active";
    }
}
