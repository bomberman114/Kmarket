<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"></jsp:include>
        
            <section id="admin-product-list">
                <nav>
                    <h3>상품목록</h3>
	                    
                    <p>
                        HOME > 상품관리 > <strong>상품목록</strong>
                    </p>
                </nav>
                <!-- 상품목록 컨텐츠 시작 -->                                
                <section>
                    <div>
                    	<form action="/Kmarket/admin/product/list.do">
	                        <select name="search">
	                            <option value="search1">상품명</option>
	                            <option value="search1">상품코드</option>
	                            <option value="search1">제조사</option>
	                            <option value="search1">판매자</option>                                    
	                        </select>
	                        <input type="text" name="search" placeholder="키워드 검색">
	                        <input type="submit" value="검색">
                        </form>
                    </div>
                    
                    <form action="/Kmarket/admin/product/list.do" method="post" enctype="multipart/form-data">
                    	<input type="text" name="uid" value="${sessUser.uid}">
	                </form>
                    
                    <table>
                        <tr>
                            <th><input type="checkbox" name="all"/></th>
                            <th>이미지</th>
                            <th>상품코드</th>
                            <th>상품명</th>
                            <th>판매가격</th>
                            <th>할인율</th>
                            <th>포인트</th>
                            <th>재고</th>
                            <th>판매자</th>
                            <th>조회</th>
                            <th>관리</th>
                        </tr>
                        
                        <!-- 상품 목록 나열 -->
						<c:forEach var="product" items="${products}">
	                        <tr>
	                            <td><input type="checkbox" name="상품코드"/></td>
	                            <td><img src="${product.tumb1}" class="thumb"></td>
	                            <td>${product.prodNo}</td>
	                            <td>${product.prodName}</td>
	                            <td>${product.price}</td>
	                            <td>${product.discount}</td>
	                            <td>${product.point}</td>
	                            <td>${product.stock}</td>
	                            <td>${product.seller}</td>
	                            <td>${product.hit}</td>
	                            <td>
	                                <a href="#">[삭제]</a>
	                                <a href="#">[수정]</a>
	                            </td>
	                        </tr>
                       </c:forEach>
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
	                            <a href="/Kmarket/admin/product/list.do?pg=${i}" class="${currentPage == i ? 'current':'off'}">${i}</a>
	                        </span>
	                    </c:forEach>
	                    
	                    <c:if test="${pageGroupEnd < lastPageNum}">
	                        <span class="next">
	                            <a href="/Kmarket/admin/product/list.do?pg=${pageGroupEnd + 1}">다음&nbsp;</a>
	                        </span>
                        </c:if>
                        
                    </div>

                </section>                

                
                <p class="ico info">
                    <strong>Tip!</strong>
                    전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
                </p>

                

                <!-- 상품목록 컨텐츠 끝 -->
            </section>
        </main>
       <jsp:include page="../_footer.jsp"></jsp:include>