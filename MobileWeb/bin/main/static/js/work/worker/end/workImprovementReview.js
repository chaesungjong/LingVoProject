$(document).ready(function() {

    $('div[name=next]').click(function() {
        var menuText = $(this).find('.menu_txt').text();
        localStorage.setItem("issue", menuText);
        localStorage.setItem("issueCode", $(this).attr("value"));
        if($(this).attr("value") == 'WR_ETC'){
            location.href = "/work/worker/end/workReviewEndPicturePlus";    
        }else{
            location.href = "/work/worker/end/workReviewissues?issueGubun=" + $(this).attr("value");
        }
    });
  

});
