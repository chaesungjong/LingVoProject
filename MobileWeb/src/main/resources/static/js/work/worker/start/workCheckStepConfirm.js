$(document).ready(function() {

  $("#next").click(handleNextButtonClick);

});
/**
 * '다음' 버튼 클릭 이벤트 핸들러
 */
function handleNextButtonClick() {
  // 작업자의 메인 페이지로 이동
  location.href = "/work/worker/main";
}