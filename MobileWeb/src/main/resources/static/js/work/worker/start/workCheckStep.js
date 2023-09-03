$(document).ready(function() {
  // 메시지 리스트에서 데이터 추출
  var dataString = $("#messageList").val();

  // 'WorkClassMsgListResponse' 항목들을 정규식을 사용하여 추출
  var matches = dataString.match(/WorkClassMsgListResponse \[\w+=\d+, \w+=\d+, \w+=.*?\]/g);

  // 메시지 항목들을 정리하여 객체 배열로 변환
  var workClassMsgList = matches.map(function(item) {
      return {
          step: extractValueFromText(item, /step=(\d+)/),
          stepTotal: extractValueFromText(item, /stepTotal=(\d+)/),
          message: extractValueFromText(item, /message=(.*?)(?=])/)
      };
  });

  // 초기 설정
  var countClick = 0;
  var isLinkDisabled = true;

  // 초기 UI 업데이트
  updateUI(workClassMsgList[countClick]);

  // "다음" 버튼에 클릭 이벤트 리스너 추가
  $("#next").click(function() {

      if (!isLinkDisabled) return; // 버튼이 비활성화 상태라면 클릭 이벤트를 무시
      $("#next").removeClass("btn_ok_s").addClass("btn_ok_stop");

      countClick++;
      if (workClassMsgList.length != countClick )  {
        updateUI(workClassMsgList[countClick]);
      } else {
           // 다음 작업 단계 함수 설정
           var nextStep = function() { location.href = "/work/worker/start/workCheckStepConfirm?workGubun=" + localStorage.getItem('workGubun'); }; 
           // 알림 메시지 텍스트 설정
           var alertMessage = '일일 안전예방활동을<br />확인하였습니다.<br /><br /> 관리자에게 <span class="txt_point">전송</span> 합니다. ';
           // 사용자에게 알림 팝업 표시
           openAlert(alertMessage, nextStep, 
            function() {
              $("#next").removeClass("btn_ok_stop").addClass("btn_ok_s");
              isLinkDisabled = true;
              countClick--;
              }
            );
           return;
      }
  });

  // 주어진 패턴으로 텍스트에서 값을 추출
  function extractValueFromText(text, pattern) {
      var match = text.match(pattern);
      return match ? match[1].trim() : null;
  }

// UI를 업데이트하는 함수
function updateUI(item) {
  isLinkDisabled = false; // 버튼 클릭을 임시로 비활성화
  $("#click").text(item.step);
  $("#total").text(item.stepTotal);
  typeAnimation($("#title"), item.message);
  //   // 2초 후 버튼을 다시 활성화
  //   setTimeout(() => {
  //     $("#next").removeClass("btn_ok_stop").addClass("btn_ok_s");
  //     isLinkDisabled = true; // 버튼 활성화
  // }, 500);
}

/**
* 요소에 대한 타이핑 애니메이션 함수
* @param {jQuery} $element - 타이핑 애니메이션을 적용할 jQuery 요소
* @param {string} message - 표시될 메시지
* @param {number} [speed=50] - 각 문자가 타이핑되는 속도 (밀리초 단위)
*/
function typeAnimation($element, message, speed = 50) {
  $element.html(''); // 요소의 내용을 초기화

  // <br> 태그를 실제 줄 바꿈 문자로 변환
  message = "반드시!<br><br>" + message ;
  message = message.replace(/<br>/g, '\n');

  let i = 0;

  // 문자를 하나씩 화면에 표시하는 재귀 함수
  function type() {
      if (i < message.length) {
          // 줄 바꿈 문자가 있을 경우 <br> 태그로 다시 변환
          const charToAdd = message.charAt(i) === '\n' ? '<br>' : message.charAt(i);
          $element.append(charToAdd);
          i++;
          setTimeout(type, speed);
      } else {
          $("#next").removeClass("btn_ok_stop").addClass("btn_ok_s");
          isLinkDisabled = true; // 버튼 활성화
      }
  }

  type(); // 애니메이션 시작
}
});