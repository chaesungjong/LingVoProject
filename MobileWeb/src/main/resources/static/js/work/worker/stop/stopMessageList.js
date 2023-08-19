$(document).ready(function() {
    
    // 페이지 로드 시 제목 섹션 업데이트
    updateTitleSection();

    // '다음' 버튼 클릭 이벤트 설정
    $("#next").click(handleNextButtonClick);
});

/**
 * 제목 섹션에 아이콘과 이슈 내용을 설정하는 함수
 */
function updateTitleSection() {
    const issue = localStorage.getItem("issue");
    const titleContent = '<img src="/assets/icon_main06.png" />' + issue;
    $("#title").html(titleContent);
}

/**
 * '다음' 버튼 클릭 이벤트 핸들러
 */
function handleNextButtonClick() {
    // 체크된 라디오 버튼 값 수집
    const checkedValues = collectCheckedValues();

    // 사용자가 선택한 이슈를 로컬 스토리지에 저장
    localStorage.setItem("issuesList", checkedValues);
    const issueCode = localStorage.getItem("issueCode");

    // 선택한 이슈 코드에 따른 페이지 이동 처리
    navigateToAppropriatePage(issueCode);
}

/**
 * 체크된 라디오 버튼의 값들을 수집하는 함수
 */
function collectCheckedValues() {
    const checkedValues = [];
    $(".select input[type='radio']:checked").each(function() {
        checkedValues.push($(this).val());
    });
    return checkedValues;
}

/**
 * 이슈 코드에 따른 페이지 이동 처리 함수
 */
function navigateToAppropriatePage(issueCode) {
    if (['WS_SHIELD', 'WS_HEALTH'].includes(issueCode)) {
        location.href = "/work/worker/stop/requestPicturePlusDitail";
    } else if ('WS_FACILIT' === issueCode) {
        const message = "개선이 필요한 부분의<br/> <span class='txt_point'>사진을 등록해주세요 </div>";
        openAlert(message, function() {
            // 확인 버튼을 클릭했을 때의 동작
            location.href = "/work/worker/stop/requestPicturePlus";
        });
    }
}