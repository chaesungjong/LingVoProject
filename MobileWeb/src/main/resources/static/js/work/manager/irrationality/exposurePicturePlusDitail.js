$(document).ready(function() {
    // 로컬 스토리지에서 저장된 값을 변수에 할당
    var issuesImageList = localStorage.getItem("issuesImageList");
    var illegalClass    = localStorage.getItem("illegalClass");
    // 가져온 값들을 각각의 HTML 요소에 할당
    $("#imgPaths").val(issuesImageList);
    $("#illegalClass").val(illegalClass);

    if($("#illegalClass").val() == "worker"){
        $("#worker").show();
        $("#location").hide();
    }else{
        $("#location").show();
        $("#worker").hide();
    }

    // 문제 리스트와 이미지 리스트를 배열로 변환
    var imageListArray = issuesImageList ? issuesImageList.split(",") : [];

    // 이미지 리스트의 내용을 페이지에 출력
    imageListArray.forEach(function(image) {
        $("#imgDiv").append("<img src='" + image + "' width='100px' height='100px'>");
    });

    // '다음' 버튼을 클릭하면 Comfirm 폼 제출
    $("#next").click(function() {
         $('#Comfirm').submit();
    });
});