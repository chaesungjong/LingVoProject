$(document).ready(function() {
    // 로컬 스토리지에서 저장된 값을 변수에 할당
    var issue = localStorage.getItem("issue");
    var issuesList = localStorage.getItem("issuesList");
    var issuesImageList = localStorage.getItem("issuesImageList");

    // 가져온 값들을 각각의 HTML 요소에 할당
    $("#issue").val(issue);
    $("#issuesList").val(issuesList);
    $("#imageList").val(issuesImageList);
    $("#requestWork").text(issue);

    // 문제 리스트와 이미지 리스트를 배열로 변환
    var issuesListArray = issuesList ? issuesList.split(",") : [];
    var imageListArray = issuesImageList ? issuesImageList.split(",") : [];

    // 이미지 리스트의 내용을 페이지에 출력
    imageListArray.forEach(function(image) {
        $("#imgDiv").append("<img src='" + image + "' width='100px' height='100px'>");
    });

    // 문제 리스트의 내용을 페이지에 출력
    issuesListArray.forEach(function(issueItem) {
        $("#requestWork").append("<br>" + issueItem);
    });

    var issueCode = localStorage.getItem("issueCode");

    // 문제 코드에 따른 UI 조정
    if (issueCode === 'WS_FACILIT') {
        $('#field, #userid, #stopwork, #picture').show();
    } else if (issueCode === 'WS_SHIELD' || issueCode === 'WS_HEALTH') {
        $('#location, #field, #constName, #userid, #stopwork').show();
    }

    // '다음' 버튼을 클릭하면 Comfirm 폼 제출
    $("#next").click(function() {
         $('#Comfirm').submit();
    });
});