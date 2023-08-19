<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container mt-5">
  <div class="row">
    <div class="col-md-4" name="next">
      <div class="card mb-4">
        <div class="row g-0">
          <div class="col-auto">
          </div>
          <div class="col">
            <div class="card-body">
              <p class="card-text">전체 보기</p>
              <input type="hidden" id="click" name="click" value="allField">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-4" name="next">
      <div class="card mb-4">
        <div class="row g-0">
          <div class="col-auto">
          </div>
          <div class="col">
            <div class="card-body">
              <p class="card-text">행정구역별 보기</p>
              <input type="hidden" id="click" name="click" value="svgCode">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-4" name="next">
        <div class="card mb-4">
            <div class="row g-0">
            <div class="col-auto">
            </div>
            <div class="col">
                <div class="card-body">
                  <p class="card-text">시공사별 보기</p>
                  <input type="hidden" id="click" name="click" value="constCode">
                </div>
            </div>
            </div>
        </div>
    </div>
  </div>
</div>
<script src="/js/work/manager/fieldinformation/fieldinformationlist.js"></script>
