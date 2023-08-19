<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container mt-5">
    <div class="row">
        <div class="col">
            <div class="text-center">
                <h5 class="card-title">오늘 하루도<br>안전하게 일해 주시어<br>고맙습니다. </h5>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
          <button class="btn btn-custom btn-block" id="next">확인</button>
        </div>
    </div>
</div>
<script>
    $("#next").click(function() {
        location.href = "/work/worker/main";
    });
</script>
