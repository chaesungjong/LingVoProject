<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
  .table {
      border: 1px solid #dee2e6;
  }

  .table th, .table td {
      border: 1px solid #dee2e6;
  }

  .table td {
      vertical-align: middle;
  }
</style>
<form id="Comfirm" action= "/work/manager/irrationality/exposureEnd" method="post">
  <div class="container mt-5">
    <table class="table">
        <tbody>
          <tr>
            <th scope="row">부합리 유형</th>
            <td><input type="text" class="form-control" id="exposure" name="exposure" value="" /></td>
        </tr>
          <tr>
              <th scope="row" id="workOrlocationTh"></th>
              <td><input type="text" class="form-control" id="workOrlocation" name="workOrlocation" value="" /></td>
          </tr>
          <tr>
              <th scope="row">내용</th>
              <td><input type="text" class="form-control" id="content" name="content"  value="" /></td>
          </tr>
          <tr>
              <th scope="row">사진</th>
              <td id="imgDiv"></td>
          </tr>
        </tbody>
    </table>
    <div class="row">
      <div class="col">
        <button class="btn btn-custom btn-block" id="next">확인</button>
      </div>
    </div>
  </div>
<input type="hidden" id="imageList" name="imageList">
</form>
<script src="/js/work/manager/irrationality/exposurePicturePlusDitail.js"></script>
