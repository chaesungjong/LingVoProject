$(document).ready(initializeEvents());

/**
 * 페이지 로드 완료 후 실행되는 초기화 함수
 */
function initializeEvents() {
    // 메인 메뉴 버튼 클릭 이벤트 설정
    $('.btn_main_menu').on('click', handleMainMenuButtonClick);
}

/**
 * 메인 메뉴 버튼 클릭 이벤트 핸들러
 */
function handleMainMenuButtonClick() {
    // 메뉴 텍스트와 메뉴 코드를 로컬 스토리지에 저장
    localStorage.setItem("illegalClass", $(this).attr("value"));
    // 이슈 구분 값에 따라 작업자의 중지 메시지 목록 페이지로 이동
    location.href = "/work/manager/irrationality/exposurePicturePlus";
}