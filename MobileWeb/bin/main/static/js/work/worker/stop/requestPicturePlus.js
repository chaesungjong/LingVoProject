$(document).ready(function() {
    // 이미지 리스트 초기화
    var imageList = [];

    // 사진 추가 버튼 이벤트 리스너 설정
    $("#addPicture").click(function() {
        handleImageAddition(callCamera);
    });

    // 갤러리 추가 버튼 이벤트 리스너 설정
    $("#addGallery").click(function() {
        handleImageAddition(callGallery);
    });

    // 확인 버튼 이벤트 리스너 설정
    $("#next").click(handleConfirmationClick);

    /**
     * 이미지 추가 처리
     * @param {Function} imageSourceFunction - 이미지를 가져올 함수 (카메라 또는 갤러리)
     */
    function handleImageAddition(imageSourceFunction) {
        var callback = function(image) {
            imageList.push(image);
            appendImageToDiv(image);
        };
        imageSourceFunction(callback);
    }

    /**
     * 이미지를 div 요소에 추가
     * @param {string} image - 추가할 이미지의 URL 또는 데이터
     */
    function appendImageToDiv(image) {
        $('#pictureList').show();
        $('#imageDiv').append('<div><img src="' + image + '" alt="Added Image"></div>');
    }

    /**
     * 확인 버튼 클릭 처리
     */
    function handleConfirmationClick() {
        localStorage.setItem("issuesImageList", imageList);
        location.href = "/work/worker/stop/requestPicturePlusDitail";
    }
});