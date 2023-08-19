$(document).ready(function() {

    /**
     * 위도 경도를 가져와서 화면에 뿌려준다.
     */
    getLocation(locationUI);

    document.getElementById("home").href = "/work/manager/main";
});


/**
 * 위도 경도를 가져와서 화면에 뿌려준다.
 * @param {*} res 
 */
function locationUI(res){

    //지역
    $("#regionName").text(res.regionName);
    //현재 날씨
    $("#todayIconPhrase").text(res.todayIconPhrase);
    //오늘 날씨 
    $("#todayTemperature").text("현재 :" +res.currentTemperature+"도, 최저 "+res.todayLowTemperature+"도, 최고 "+res.todayHighTemperature+"도");
    //상세 날씨 이동 
    $("#regionName").text(res.regionName);
    //날씨 클릭 시 상세 페이지로 이동
    $("#detailLink").on("click",function(){
        location.href = res.MobileLink;
    });
}
