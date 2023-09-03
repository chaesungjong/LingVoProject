$(document).ready(function() {
    
    if (grade.indexOf('S') != -1) {
        $("#grade").show();
    } 

    $(".col-md-4").click(function() {
        location.href = "/work/manager/fieldinformation/choiceFiedList?select=" +$(this).find("input").val();
    });

});
