$(document).ready(function() {


    $(".col-md-4").click(function() {
        var pElement = $(this).find("p");
        localStorage.setItem("exposure", pElement.text());
        location.href = "/work/manager/irrationality/exposurePicturePlus";
    });

});
