$(document).ready(function() {

    $("#title").html('<img src="/assets/icon_main06.png" />' + localStorage.getItem("issue"));

    var issueCode = localStorage.getItem("issueCode");

    if('WR_SUPPORT' == issueCode || 'WR_RISKMNG' == issueCode){ 
        $("#next").hide();
        // 모든 라디오 버튼에 대한 클릭 이벤트를 감지
        $('input[type="radio"]').on('click', function() {
            // 클릭된 라디오 버튼의 name 속성 값이 "checkboxValues"로 시작하는 경우에만 처리
            if ($(this).attr('name').startsWith('checkboxValues')) {
                // 클릭된 라디오 버튼의 부모 요소인 .workStop_list 내부의 .issue_name 값을 가져옴
                var issueName = $(this).closest('.workStop_list').find('.issue_name').text();
                
                if('WR_SUPPORT' == issueCode){
                    sendWorkReview(issueName);
                }
                if('WR_RISKMNG' == issueCode){
                    workReviewEndPicturePlus();
                }
            }
        });
    }
    
    /**
     * 다음 버튼 클릭 시
     */
     $("#next").click(function() {
        workReviewEndPicturePlus();
    });

});

function workReviewEndPicturePlus(){
    // 체크된 체크박스의 값을 저장할 배열
    var checkedValues = [];

    // 체크된 체크박스의 값을 배열에 저장
    $(".select input[type='radio']:checked").each(function() {
        checkedValues.push($(this).val());
    });

    // 사용자 체크한 것을 로컬스토리지에 저장
    localStorage.setItem("issuesList", checkedValues);
    // 다음 작업 단계 함수 설정
    var nextStep = function() { location.href = "/work/worker/end/workReviewEndPicturePlus"; }; 
    // 알림 메시지 텍스트 설정
    var alertMessage = "개선이 필요한 부분의 사진을 등록해주세요. ";
    // 사용자에게 알림 팝업 표시
    openAlert(alertMessage, nextStep);
}

function sendWorkReview(issues){
      // POST 요청을 보낼 URL
      var url = '/work/worker/end/sendWorkReview';

      // 동적으로 폼을 생성
      var $form = $('<form>', {
          action: url,
          method: 'post'
      });
  
      // 폼에 파라미터를 추가
      var data = {
        'issueList': issues
      };
  
      $.each(data, function(key, value) {
          $form.append($('<input>', {
              type: 'hidden',
              name: key,
              value: value
          }));
      });
  
      // 폼을 body에 추가
      $('body').append($form);
  
      // 폼을 제출하여 POST 요청을 보냄
      $form.submit();
}