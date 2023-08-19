<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container mt-5">
    <h2 class="mb-4" id="title">${view}</h2>
    <input type="hidden" id="select" name="select" value="${select}">
    <c:choose>
        <c:when test="${ select == 'svgCode'}">
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <td>위치</td>
                        <td>총인원</td>
                        <td>안전활동완료</td>
                        <td>작업중지요청</td>
                        <td>자세히보기</td>
                    </tr>
                    <tr>
                        <td>${siteSubAddr2}</td>
                        <td>${totalWorker}</td>
                        <td>${successAlCall}</td>
                        <td>${stopWorker}</td>
                        <td name="detail">보기</td>
                    </tr>
                </tbody>
            </table>
        </c:when>
        <c:when test="${ select == 'siteSubAddr2'}">
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <td>현장명</td>
                        <td>총인원</td>
                        <td>안전활동완료</td>
                        <td>작업중지요청</td>
                        <td>자세히보기</td>
                    </tr>
                    <tr>
                        <td>${siteName}</td>
                        <td>${totalWorker}</td>
                        <td>${successAlCall}</td>
                        <td>${stopWorker}</td>
                        <td name="detail">보기</td>
                    </tr>
                </tbody>
            </table>
        </c:when>
        <c:when test="${ select == 'siteCode'}">
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <td>업체명</td>
                        <td>총인원</td>
                        <td>안전활동완료</td>
                        <td>작업중지요청</td>
                    </tr>
                    <tr>
                        <td>${companyName}</td>
                        <td>${totalWorker}</td>
                        <td>${successAlCall}</td>
                        <td name="detail">${stopWorker}</td>
                    </tr>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="container mt-5">
                <table class="table">
                    <tbody>
                      <tr>
                        <th scope="row">위치</th>
                        <td>${siteSubAddr1}</td>
                    </tr>
                      <tr>
                          <th scope="row">현장</th>
                          <td>${siteName}</td>
                      </tr>
                      <tr>
                          <th scope="row">업체명</th>
                          <td>${constName}</td>
                      </tr>
                      <tr>
                          <th scope="row">작업자</th>
                          <td>${userid}</td>
                      </tr>
                      <tr>
                        <th scope="row">작업 중지 요청 사유</th>
                        <td>${issuse}</td>
                    </tr>
                    </tbody>
                </table>
                <div class="row">
                  <div class="col">
                    <button class="btn btn-custom btn-block" id="next">확인</button>
                  </div>
                </div>
              </div>
        </c:otherwise>
    </c:choose>
</div>
<script src="/js/work/manager/fieldinformation/choiceFiedList.js"></script>
