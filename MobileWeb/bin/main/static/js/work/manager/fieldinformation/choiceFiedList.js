$(document).ready(function() {

    if($("#select").val() == "svgCode"){
        $("#select").val("siteSubAddr2");
    }else if($("#select").val() == "siteSubAddr2"){
        $("#select").val("siteCode");
    }else if($("#select").val() == "siteCode"){
        $("#select").val("stopWork");
    }

    $('[name="detail"]').on('click', function() {
         location.href = "/work/manager/fieldinformation/choiceFiedList?select=" + $("#select").val() + "&title=" +  $(this).closest('tr').find('td:first').text();
    });

    $('#next').on('click', function() {
        location.href = "/work/manager/main";
   });
});
