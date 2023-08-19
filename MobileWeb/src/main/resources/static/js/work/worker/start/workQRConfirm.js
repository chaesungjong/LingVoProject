$(document).ready(function() {
  // '다음' 버튼 클릭 이벤트 설정
  $("#next").click(handleNextButtonClick);
});

/**
* '다음' 버튼 클릭 이벤트 핸들러
*/
function handleNextButtonClick() {
  location.href = "/work/worker/start/workedList";
}