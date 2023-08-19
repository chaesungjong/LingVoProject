
window.onload = function() {
 
    function onClick() {
        document.querySelector('.modal_wrap').style.display ='block';
        document.querySelector('.black_bg').style.display ='block';
    }   
    function offClick() {
        document.querySelector('.modal_wrap').style.display ='none';
        document.querySelector('.black_bg').style.display ='none';
    }

    $("#userInfor").html(userName+'님<span>(' +userid+')</span>');
};

function openAlert() {
    document.getElementById("popup_Alert").style.display = "block";

}
function closeAlert() {
    document.getElementById("popup_Alert").style.display = "none";
}

function openPop() {
    document.getElementById("popup_layer").style.display = "block";

}
function closePop() {
    document.getElementById("popup_layer").style.display = "none";
}

