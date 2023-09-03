$(document).ready(function() {

    var imageList = [];
    localStorage.setItem("issuesImageList", null);
    /**
     * 사진 추가
     */
    $("#addPicture").click(function() { 

        var callback = function(image){
            imageList.push(image);
            $('#imageDiv').append('<img src='+image+' alt="Description" />');
            $("#loding").hide();
        };
        callCamera(callback); 
    });

    $("#addGallery").click(function() {
        
        var callback = function(image){
            imageList.push(image);
            $('#imageDiv').append('<img src='+image+' alt="Description" />');
            $("#loding").hide();
        };

        callGallery(callback); 
    });

    /**
     * 확인 버튼
     */
    $("#next").click(function() {
        
        localStorage.setItem("issuesImageList", imageList);
        location.href = "/work/manager/irrationality/exposurePicturePlusDitail";
        
    });

});