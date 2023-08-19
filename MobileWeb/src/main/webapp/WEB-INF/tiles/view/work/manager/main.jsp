<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Body -->
<div class="my-3 p-3 bg-body rounded shadow-sm">
  <h6 class="border-bottom pb-2 mb-0" id="userName">${name}</h6>
  <div class="d-flex text-muted pt-2" id="detailLink">
    <img src="/image/123.png" width="32" height="32"  class="bd-placeholder-img flex-shrink-0 me-2 rounded" >
   <div class="pb-3 mb-0 small lh-sm border-bottom w-100">
      <div class="d-flex justify-content-between">
        <strong class="text-gray-dark" id="todayIconPhrase"></strong>
        <a href="#" id="regionName"> </a>
      </div>
      <span class="d-block" id="todayTemperature"></span>
    </div>
  </div>
</div>
<div class="col-sm-6 col-lg-4 mb-4" id="workStart">
  <a href="/work/manager/fieldinformation/fieldinformationlist" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
    <img src="//upload.wikimedia.org/wikipedia/commons/thumb/d/d0/QR_code_for_mobile_English_Wikipedia.svg/220px-QR_code_for_mobile_English_Wikipedia.svg.png" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
    <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">MY 현장정보</h6>
      </div>
    </div>
  </a>
</div>
<div class="col-sm-6 col-lg-4 mb-4" id="workStart">
  <a href="javascript:void(0);" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
    <img src="//upload.wikimedia.org/wikipedia/commons/thumb/d/d0/QR_code_for_mobile_English_Wikipedia.svg/220px-QR_code_for_mobile_English_Wikipedia.svg.png" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
    <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">공지 사항</h6>
      </div>
    </div>
  </a>
</div>
<div class="col-sm-6 col-lg-4 mb-4" id="workStart">
  <a href="/work/manager/irrationality/exposure" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
    <span class="material-symbols-outlined">contact_page</span>
    <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">불합리 적발</h6>
      </div>
    </div>
  </a>
</div>
<div class="col-sm-6 col-lg-4 mb-4" id="workStart">
  <a href="/work/worker/end/workReview" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
    <span class="material-symbols-outlined">warning</span>
    <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">작업 후기</h6>
      </div>
    </div>
  </a>
</div>
<div class="col-md-4">
  <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
      <div class="carousel-item active" data-bs-interval="3000">
        <img src="/image/1.png" class="d-block w-100" alt="광고1">
      </div>
      <div class="carousel-item" data-bs-interval="3000">
        <img src="/image/2.png" class="d-block w-100" alt="광고1">
      </div>
      <div class="carousel-item" data-bs-interval="3000">
        <img src="/image/3.png" class="d-block w-100" alt="광고1">
      </div>
    </div>
  </div>
</div>
<div class="my-3 p-3 bg-body rounded shadow-sm">
  <h6 class="border-bottom pb-2 mb-0">나의 지난 작업(7일간)</h6>
</div>
<script src="/js/work/manager/main.js"></script>


