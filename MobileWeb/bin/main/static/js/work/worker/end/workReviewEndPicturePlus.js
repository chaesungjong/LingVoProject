$(document).ready(function() {

    var imageList = [];
    /**
     * 사진 추가
     */
    $("#addPicture").click(function() { 

        var callback = function(image){
            imageList.push(image);
            $('#imageDiv').append('<div><img src='+image+' alt=""></div>');
        };

        callCamera(callback); 
    });

    $("#addGallery").click(function() {

        var callback = function(image){
            imageList.push(image);
            $('#imageDiv').append('<div><img src='+image+' alt=""></div>');
        };

        callGallery(callback); 
    });

    /**
     * 확인 버튼
     */
    $("#next").click(function() {
        
        localStorage.setItem("issuesImageList", imageList);
        location.href = "/work/worker/end/workReviewEndPicturePlusDitail";
        
    });

});