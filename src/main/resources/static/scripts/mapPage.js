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
            center: [65, 95],
            zoom: 1
        });

        myMap.events.add('click', function (e) {
            var coordsX = e.get('coords')[0];
            console.log(coordsX);
            var coordsY = e.get('coords')[1];
            console.log(coordsY);
            var myPlacemark = new ymaps.Placemark([coordsX, coordsY], {
                hintContent: 'Содержимое всплывающей подсказки',
                balloonContent: 'Содержимое балуна'

            });
            var coodr = [];
            coodr[0] = coordsX;
            coodr[1] = coordsY;

            myMap.geoObjects.add(myPlacemark);
            $.ajax({
                type: "POST",
                url: "/../api/organization/add_map",
                data: {
                    myArray: coodr
                },
                success: function () {
                    window.location.replace("/organization/add_maps");
                }
            })
        });
    });
}