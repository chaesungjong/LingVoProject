$(document).ready(function() {

    /**
     * 위도 경도를 가져와서 화면에 뿌려준다.
     */
    getLocation(locationUI);

    //document.getElementById("home").href = "/work/manager/main";
    locationUI();

    // 사용자를 환영하는 메시지 설정
    $("#userName").html(userName + '님 환영합니다.');
});


/**
 * 위도 경도를 가져와서 화면에 뿌려준다.
 * @param {*} res 
 */
function locationUI(res){

    //지역
    $("#regionName").text('한국');
    //현재 날씨
    $("#todayIconPhrase").text("추움");
    //오늘 날씨 
    $("#todayTemperature").text("현재 : 30도, 최저 30도, 최고 30 도");
    //상세 날씨 이동 
    $("#regionName").text("테스트");
    //날씨 클릭 시 상세 페이지로 이동
    $("#detailLink").on("click",function(){
        //location.href = res.MobileLink;
    });
}
