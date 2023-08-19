$(document).ready(function() {
    /**
     * 
     */
    $('div[name=next]').click(function() {
        alert($("#name").val() + " 님 금일 "+ $("#siteName").val()  +" 작업 전 안전예방활동을  시작하겠습니다.");
        localStorage.setItem("workGubun",$(this).attr('value'));
        location.href = "/work/worker/start/workCheckStep?workType=&" + "workGubun=" + $(this).attr('value');
    });

});