$(document).ready(function() {

    // 사용자를 환영하는 메시지 설정
    $("#Welcome").html(userName + '님 환영합니다.');

    // 위치 정보를 가져와서 화면에 표시
    getLocation(locationUI);

    // 금일 작업 시작 버튼 클릭 이벤트 설정
    $("#workStart").click(function() {
        openQRCode('/work/worker/start/workQRConfirm');
    });

});

/**
 * 위치 정보를 기반으로 화면의 날씨 관련 UI를 갱신한다.
 *
 * @param {*} res - 위치 정보와 날씨 데이터를 포함한 객체
 */
function locationUI(res){
    // 지역명 설정
    $("#regionName").text(res.regionName);

    // 현재 날씨 설명 설정
    $("#todayIconPhrase").html(res.todayIconPhrase);

    // 현재 온도 설정
    $("#currentTemperature").html(res.currentTemperature + '&#8451;');

    // 오늘의 최저, 최고 온도 설정
    $("#todayTemperature").html("최저 " + res.todayLowTemperature + "&#8451;, 최고 " + res.todayHighTemperature + "&#8451;");

    // 날씨 정보의 상세 페이지로 이동하는 클릭 이벤트 설정
    $("#detailLink").on("click", function(){
        location.href = res.MobileLink;
    });
}