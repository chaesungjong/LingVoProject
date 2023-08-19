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

    if('WR_FACILIT' == issueCode){
        $('#field').show();
        $('#userid').show();
        $('#stopwork').show();
        $('#picture').show();
    }else if('WR_RISKMNG' == issueCode){
        $('#field').show();
        $('#userid').show();
        $('#location').show();
        $('#picture').show();
    } else if('WR_ETC' == issueCode){
        $('#field').show();
        $('#userid').show();
        $('#content').show();
        $('#picture').show();
    }

    $("#next").click(function() {
        
        if(issueCode == 'WR_ETC'){
            $("#issueList").val($('#requestcontent').val());
        }
         $('#Comfirm').submit();
    });
    
    
});