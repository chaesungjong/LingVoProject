<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="container">		
  <div class="work_review">			
    <div class="review_01" id="save">
      <div><img src="/assets/icon_review01.png" alt=""></div>
      <div class="review_txt">안전합니다.</div>
    </div>
    <div class="review_02" id="review">
      <div><img src="/assets/icon_review02.png" alt=""></div>
      <div class="review_txt">개선이<br />필요합니다.</div>
    </div>		
  </div>
</div>
<script src="/js/include/footer.js"></script>
<script>
    $("#save").click(function() {
        location.href = "/work/worker/end/workReviewEnd";
    });

    $("#review").click(function() {
        location.href = "/work/worker/end/workImprovementReview";
    });
</script>