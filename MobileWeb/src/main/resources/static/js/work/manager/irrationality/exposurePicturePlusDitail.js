$(document).ready(function() {

    //부합리 종류 선택
    var exposure = localStorage.getItem("exposure");
    $("#exposure").val(exposure);

    if(exposure == "근로자 불합리") {
        $("#workOrlocationTh").text("위반자 ID");
    }else{
        $("#workOrlocationTh").text("위치");
    }

    //캡쳐 이미지 가져 오고 세팅 하기
    $("#imageList").val(localStorage.getItem("issuesImageList"));
    var imageListArray = $("#imageList").val() ? $("#imageList").val().split(",") : [];

    for(var i = 0; i < imageListArray.length; i++) {
        $("#imgDiv").append("<img src='" + imageListArray[i] + "' width='100px' height='100px'>");
    }

    $("#next").click(function() {

        if(validateForm()){
            $('#Comfirm').submit();
        }
    });
    
});

function validateForm() {
    // 부합리 유형 검사
    var exposure = document.getElementById("exposure").value;
    if (exposure === "") {
        alert("부합리 유형을 입력해주세요.");
        return false;
    }

    // 위치 또는 작업 검사
    var workOrlocation = document.getElementById("workOrlocation").value;
    if (workOrlocation === "") {
        alert("위치 또는 작업을 입력해주세요.");
        return false;
    }

    // 내용 검사
    var content = document.getElementById("content").value;
    if (content === "") {
        alert("내용을 입력해주세요.");
        return false;
    }

    // 모든 검사를 통과하면 true 반환
    return true;
}