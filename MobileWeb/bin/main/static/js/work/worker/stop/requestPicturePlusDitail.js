$(document).ready(function() {

    $("#issue").val(localStorage.getItem("issue"));
    $("#issuesList").val(localStorage.getItem("issuesList"));
    $("#imageList").val(localStorage.getItem("issuesImageList"));

    $("#requestWork").text($("#issue").val());

    var issuesListArray = $("#issuesList").val() ?  $("#issuesList").val().split(",") : [];
    var imageListArray = $("#imageList").val() ? $("#imageList").val().split(",") : [];

    for(var i = 0; i < imageListArray.length; i++) {
        $("#imgDiv").append("<img src='" + imageListArray[i] + "' width='100px' height='100px'>");
    }

    for(var i = 0; i < issuesListArray.length; i++) {
        $("#requestWork").append("<br>" + issuesListArray[i]);
    }

    var issueCode = localStorage.getItem("issueCode");

    if('WS_FACILIT' == issueCode){
        $('#field').show();
        $('#userid').show();
        $('#stopwork').show();
        $('#picture').show();
    }else if('WS_SHIELD' == issueCode || 'WS_HEALTH' == issueCode){
        $('#location').show();
        $('#field').show();
        $('#constName').show();
        $('#userid').show();
        $('#stopwork').show();
    }

    $("#next").click(function() {
         $('#Comfirm').submit();
    });
    
});
