$(document).ready(function () {
    get_mentor();
});

function get_mentor() {
    var url = "/api/mentor/1";
    $.ajax({
        type: "GET",
        url: url,
        datatype: "JSON",
        success: function (response) {
            ymaps.ready(init(response));
        }
    })
}

function init(response) {
    ymaps.ready(function () {
        var myMap = new ymaps.Map('map', {
            center: [response['pointX'], response['pointY']],
            zoom: 9
        });

        var myPlacemark = new ymaps.Placemark([response['pointX'], response['pointY']], {
            hintContent: 'Содержимое всплывающей подсказки',
            balloonContent: 'Содержимое балуна'
        });

        myMap.geoObjects.add(myPlacemark);
    });




}