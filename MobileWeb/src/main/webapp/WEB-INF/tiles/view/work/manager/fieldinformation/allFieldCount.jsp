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
<div class="container mt-5">
  <table class="table">
      <tbody>
        <tr>
          <th scope="row">총 근로자</th>
          <td>${totalWorker}</td>
        </tr>
        <tr>
            <th scope="row">안전활동 완료</th>
            <td>${successAlCall}</td>
        </tr>
        <tr>
            <th scope="row">작업 중지 요청</th>
            <td>${stopWorker}</td>
        </tr>
      </tbody>
  </table>
  <div class="row">
    <div class="col">
      <button class="btn btn-custom btn-block" id="next">자세히 보기</button>
    </div>
  </div>
</div>
<script src="/js/work/manager/fieldinformation/allFieldCount.js"></script>
