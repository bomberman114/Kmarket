<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../_header.jsp"></jsp:include>
            <section id="admin-product-list">
                <nav>
                    <h3>공지사항 목록</h3>
	                    
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <!-- 상품목록 컨텐츠 시작 -->                                
                <section>
                    <div>
                    	 <form name="keywordForm" action="/Kmarket/admin/product/list.do" method="get">
	                        <select name="category">
	                            <option value="prodName">상품명</option>
	                            <option value="prodNo">상품코드</option>
	                            <option value="seller">판매자</option>                                    
	                        </select>
	                      </form>
                    </div>
                    <table>
                        <tr>
                            <th><input type="checkbox" name="all"/></th>
                            <th>번호</th>
                            <th>유형</th>
                            <th>제목</th>
                            <th>조회</th>
                            <th>날짜</th>
                            <th>관리</th>
                        </tr>
                        
                        <!-- 상품 목록 나열 -->
	                        <tr>
	                            <td><input type="checkbox" name="상품코드"/></td>
	                            <td>1</td>
	                            <td>고객서비스</td>
	                            <td>[안내]해외결제 사칭 문자 주의</td>
	                            <td>120</td>
	                            <td>22.12.24</td>
	                            <td>

	                                <a href="#" class="remove">[삭제]</a>

	
	                                <a href="#" class="modify">[수정]</a>
	                            </td>
	                        </tr>
                    </table>
                    
                    <!-- 선택한 상품 삭제 -->
                    <input type="button" value="선택삭제" />
                                  
					<!-- 페이징 -->         
                    <div class="paging">
                    
                    	<c:if test="${pageGroupStart > 1}">
	                        <span class="prev">
	                            <a href="/Kmarket/admin/product/list.do?pg=${pageGroupStart - 1}">&nbsp;이전</a>
	                        </span>
	                    </c:if>
	                    
	                    <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
	                        <span class="num">
	                            <a href="/Kmarket/admin/product/list.do?pg=${i}" class="${currentPage == i ? 'on':'off'}">${i}</a>
	                        </span>
	                    </c:forEach>
	                    
	                    <c:if test="${pageGroupEnd < lastPageNum}">
	                        <span class="next">
	                            <a href="/Kmarket/admin/product/list.do?pg=${pageGroupEnd + 1}">다음&nbsp;</a>
	                        </span>
                        </c:if>
                        
                    </div>

                </section>                
               
                <!-- 상품목록 컨텐츠 끝 -->
            </section>
        </main>
<jsp:include page="../_footer.jsp"></jsp:include>