/**
 * Created by Fly on 07/09/2016.
 */
function googleCall() {
    Array.prototype.forEach.call(document.querySelectorAll('.mdl-card__media'), function (el) {
        var link = el.querySelector('a');
        if (!link) {
            return;
        }
        var target = link.getAttribute('href');
        if (!target) {
            return;
        }
        el.addEventListener('click', function () {
            location.href = target;
        });
    });

//tmp
    $(".mdl-card").remove();

    $(".demo-blog__posts").append(
        "<div class=\"mdl-card coffee-pic mdl-cell mdl-cell--12-col\">" +
        "   <div class=\"mdl-card__media mdl-color-text--grey-50\">" +
        "       <h3><a href=\"entry.html\"> Resto </a></h3>" +
        "   </div>" +
        "   <div class=\"mdl-card__supporting-text meta mdl-color-text--grey-600\">" +
        "       <div class=\"minilogo\"> </div>" +
        "       <div>" +
        "           <strong>Adresse</strong>" +
        "           <span>Distance</span>" +
        "       </div>" +
        "   </div>" +
        "</div>"
    );

//$(".mdl-card").remove();

    document.addEventListener("deviceready", loadSearch, false);

}

function loadSearch() {
    navigator.geolocation.getCurrentPosition(nearSearch);
    function nearSearch(position) {
        $.get("http://localhost:8080/api/restaurants/nearby",
            {
                latitude: position.coords.latitude,
                longitude: position.coords.longitude
            },
            function (data) {
                console.log(data);
                $(".mdl-card").remove();
                $.each(data, function (r) {
                    if (data[r].contentType != null) {
                        $(".demo-blog__posts").append(
                            "<div class=\"mdl-card coffee-pic mdl-cell mdl-cell--12-col\" >" +
                            //   "   <div class=\"mdl-card__media mdl-color-text--grey-50\">" +
                            "   <div class=\"mdl-card__media mdl-color-text--grey-50\" style= \"  background-image: url('data:" + data[r].contentType + ";base64," + data[r].imageData + "')\">" +
                            "       <h3><a href=\"entry.html\"> " + data[r].name + " </a></h3>" +
                            "   </div>" +
                            "   <div class=\"mdl-card__supporting-text meta mdl-color-text--grey-600\">" +
                            "       <div class=\"minilogo\" style= \"  background-image: url('" + data[r].icon + "')\"></div>" +
                            "       <div> " +
                            "           <strong>" + data[r].vicinity + "</strong>" +
                            "           <span> </span>" +
                            "       </div>" +
                            "   </div>" +
                            "</div>"
                        );
                    } else {
                        $(".demo-blog__posts").append(
                            "<div class=\"mdl-card coffee-pic mdl-cell mdl-cell--12-col\" >" +
                            "   <div class=\"mdl-card__media mdl-color-text--grey-50\">" +
                            // "   <div class=\"mdl-card__media mdl-color-text--grey-50\" style= \"  background-image: url('data:" +  data[r].contentType + ";base64," + data[r].imageData + "')\">" +
                            "       <h3><a href=\"entry.html\"> " + data[r].name + " </a></h3>" +
                            "   </div>" +
                            "   <div class=\"mdl-card__supporting-text meta mdl-color-text--grey-600\">" +
                            "       <div class=\"minilogo\" style= \"  background-image: url('" + data[r].icon + "')\"></div>" +
                            "       <div> " +
                            "           <strong>" + data[r].vicinity + "</strong>" +
                            "           <span> </span>" +
                            "       </div>" +
                            "   </div>" +
                            "</div>"
                        );

                    }
                });
            }
        );

    }

}