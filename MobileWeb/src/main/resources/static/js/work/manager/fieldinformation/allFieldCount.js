$(document).ready(function() {


    if (grade == "C1") {
        $("#myFieldInfo").href = "/work/manager/fieldinformation/myFieldInfoField";
    }
    
    $("#next").click(function() {
        location.href = "/work/manager/fieldinformation/choiceFiedList?select=svgCode";
    });

});
