$(document).ready(function() {
    // 작업 시작 버튼 클릭 이벤트 설정
    $('div[name=next]').click(handleWorkStartClick);
});

/**
 * 작업 시작 버튼 클릭 이벤트 핸들러
 */
function handleWorkStartClick() {
    var selectedValue = $(this).attr('value');

    // 다음 작업 단계 함수 설정
    var nextStep = function() {
        localStorage.setItem("workGubun", selectedValue);
        location.href = "/work/worker/start/workCheckStep?workType=&workGubun=" + selectedValue;
    };

    // 알림 메시지 텍스트 설정
    var alertMessage = [
        "<strong>", $("#name").val(), "님</strong><br />",
        "금일 ", $("#siteName").val(), "<br />",
        "<span class='txt_point'>작업 전 안전예방활동</span>을 시작하겠습니다."
    ].join('');

    // 사용자에게 알림 팝업 표시
    openAlert(alertMessage, nextStep);
}