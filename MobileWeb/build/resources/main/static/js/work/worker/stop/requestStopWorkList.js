$(document).ready(function() {
    
    $('.btn_main_menu').on('click', function() {
        var menuText = $(this).find('.menu_txt').text();
        localStorage.setItem("issue", menuText);
        localStorage.setItem("issueCode", $(this).attr("value"));
        location.href = "/work/worker/stop/stopMessageList?issueGubun=" + $(this).attr("value");
        
    });

});
