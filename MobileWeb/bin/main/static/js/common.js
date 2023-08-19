
window.onload = function() {
 
    function onClick() {
        document.querySelector('.modal_wrap').style.display ='block';
        document.querySelector('.black_bg').style.display ='block';
    }   
    function offClick() {
        document.querySelector('.modal_wrap').style.display ='none';
        document.querySelector('.black_bg').style.display ='none';
    }

    $("#userInfor").html(userName+'님<span>(' +userid+')</span>');
};

function openPop() {
    document.getElementById("popup_layer").style.display = "block";

}
function closePop() {
    document.getElementById("popup_layer").style.display = "none";
}

/**
 * 사용자에게 알림 팝업을 표시하는 함수
 * 
 * @param {string} message - 팝업에 표시될 메시지
 * @param {function} ok - "확인" 버튼 클릭 시 실행될 콜백 함수
 * @param {function} [cancel] - "취소" 버튼 클릭 시 실행될 콜백 함수 (선택적)
 */
function openAlert(message, ok, cancel) {
    // 팝업 메시지 설정
    $('#popup_message').html(message);

    // "확인" 버튼 이벤트 리스너 설정
    $("#popup_ok").off('click').click(function() {
        ok();
        closeAlert(); // 팝업을 닫는 것이 일반적인 UX 이므로 추가
    });

    // "취소" 버튼 이벤트 리스너 설정
    $("#popup_cancel").off('click').click(function() {
        if (cancel) {
            cancel();
        }
        closeAlert();
    });

    // 팝업 표시
    $('#popup_Alert').show();
}

/**
 * 알림 팝업을 닫는 함수
 */
function closeAlert() {
    $('#popup_Alert').hide();
}

