<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"></jsp:include>
            <section class="admin-list" id="admin-qna-list">
                <nav>
                    <h3>문의하기 목록</h3>
	                    
                    <p>
                        HOME > 고객센터 > <strong>문의하기</strong>
                    </p>
                </nav>
                <!-- 게시글목록 컨텐츠 시작 -->                                
                <section>
                    <div>
                        <select name="category1">
                            <option value="0">유형선택</option>
                            <option value="1">회원</option>
                            <option value="2">쿠폰/이벤트</option>
                            <option value="3">주문/결제</option>                                    
                            <option value="4">배송</option>                                    
                            <option value="5">취소/반품/교환</option>                                    
                            <option value="6">여행/숙박/항공</option>                                    
	                        <option value="7">안전거래</option>                                    
                        </select>
                        <select name="category2">
                        <option value="0">유형선택</option>                                  
                        </select>
                    </div>
                    <table>
                        <tr>
                            <th><input type="checkbox" name="all"/></th>
                            <th>번호</th>
                            <th>1차유형</th>
                            <th>2차유형</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>상태</th>
                        </tr>
                        
                        <!-- 게시글 목록 나열 -->
                        <c:forEach var="qna" items="${qnas}">
	                        <tr class="row">
	                            <td><input type="checkbox" id="no" name="chkbox" value="${qna.no}"/></td>
	                            <td>${pageStartNum = pageStartNum-1}</td>
	                            <td>${qna.c1Name}</td>
	                            <td>${qna.c2Name}</td>
	                            <td><a href="./view.do?cate1=${cate1}&cate2=${cate2}&no=${notice.no}&pg=${currentPage}">${qna.title}</a></td>
	                            <td>${(qna.uid).substring(0,3)}**</td>
	                            <td>${qna.rdate}</td>
	                            <td>검토중</td>
	                        </tr>
	                   </c:forEach>
                    </table>
                    
              
                    <input type="button" onclick="deleteNotices()" id="deleteSelected" value="선택삭제" data-cate="${cate}"/>
                    <a href="/Kmarket/admin/cs/notice/write.do?cate=${cate}" class="btn btnSubmit">등록하기</a>
                                  
					<!-- 페이징 -->         
                    <div class="paging">
                    
                    	<c:if test="${pageGroupStart > 1}">
	                        <span class="prev">
	                            <a href="/Kmarket/admin/cs/qna/list.do?cate1=${cate1}&cate2=${cate2}&pg=${pageGroupStart - 1}">&nbsp;이전</a>
	                        </span>
	                    </c:if>
	                    
	                    <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
	                        <span class="num">
	                            <a href="/Kmarket/admin/cs/qna/list.do?cate1=${cate1}&cate2=${cate2}&pg=${i}" class="${currentPage == i ? 'on':'off'}">${i}</a>
	                        </span>
	                    </c:forEach>
	                    
	                    <c:if test="${pageGroupEnd < lastPageNum}">
	                        <span class="next">
	                            <a href="/Kmarket/admin/cs/qna/list.do?cate1=${cate1}&cate2=${cate2}&pg=${pageGroupEnd + 1}">다음&nbsp;</a>
	                        </span>
                        </c:if>
                        
                    </div>

                </section>                
               
                <!-- 게시글 컨텐츠 끝 -->
            </section>
        </main>
<jsp:include page="../_footer.jsp"></jsp:include>