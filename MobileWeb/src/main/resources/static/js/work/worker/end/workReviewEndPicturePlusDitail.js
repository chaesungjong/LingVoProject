$(document).ready(function() {

    var issue = localStorage.getItem("issue");
    var issuesList = localStorage.getItem("issuesList");
    var issuesImageList = localStorage.getItem("issuesImageList");
    var issueCode = localStorage.getItem("issueCode");

    // 가져온 값들을 각각의 HTML 요소에 할당
    $("#issueGubun").val(issueCode);
    $("#reqReason").val(issuesList);
    $("#imgPaths").val(issuesImageList);
    $("#requestWork").text(issue);

    var issuesListArray = $("#issuesList").val() ?  $("#issuesList").val().split(",") : [];
    var imageListArray = $("#imageList").val() ? $("#imageList").val().split(",") : [];

    for(var i = 0; i < imageListArray.length; i++) {
        $("#imgDiv").append("<img src='" + imageListArray[i] + "' width='100px' height='100px'>");
    }

    for(var i = 0; i < issuesListArray.length; i++) {
        $("#requestWork").append("<br>" + issuesListArray[i]);
    }

    if('WR_FACILIT' == issueCode){
        $('#field').show();
        $('#userid').show();
        $('#stopwork').show();
        $('#picture').show();
    }else if('WR_RISKMNG' == issueCode){
        $('#field').show();
        $('#userid').show();
        $('#locationDiv').show();
        $('#picture').show();
    } else if('WR_ETC' == issueCode){
        $('#field').show();
        $('#userid').show();
        $('#content').show();
        $('#picture').show();
    }

    $("#next").click(function() {
        
        if(forbiddenWordsCheck($("#requestcontent").val()) || forbiddenWordsCheck($("#location").val())){

            alert('금지된 단어가 포함되어 있습니다.');
            return;
        }

        if(issueCode == 'WR_ETC'){
            $("#reqReason").val($('#requestcontent').val());
        }
         $('#Comfirm').submit();
    });
    
    
});