$(document).ready(function() {
    
    $(".col-md-4").click(function() {
        location.href = "/work/manager/fieldinformation/choiceFiedList?select=" +$(this).find("input").val();
    });

});
