<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"></jsp:include>
<script>
$(document).on('click', '.remove', function(e){
	e.preventDefault();
	
	let isDeleteOk = confirm("정말 삭제하시겠습니까?");
			
	if (isDeleteOk){
		let prodNo = $(this).attr('data-prodNo');
		//let no = $(this).attr(prodNo);
		//let prodNo1 = $( '<td>${product.prodNo}</td>').val();
	
		//console.log('no : ' + no);
		console.log('prodNo : ' + prodNo);
		//console.log('prodNo1 : ' + prodNo1);
		
		
		let jsonData = {"prodNo" : prodNo};
		//let jsonData1 = {"prodNo1" : prodNo1};
		
		$.ajax ({
			url: '/Kmarket/admin/product/list.do',
			type: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				if(data.result == 1){
					alert('상품이 삭제되었습니다.');
					product.hide();
				}
			}
		});
	}
});
</script>

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
                    	 <form name="keywordForm" action="/Kmarket/admin/product/list.do" method="get">
	                        <select name="category">
	                            <option value="prodName">상품명</option>
	                            <option value="prodNo">상품코드</option>
	                            <option value="seller">판매자</option>                                    
	                        </select>
	                        <input name="keyword" type="text" placeholder="키워드 검색">
	                        <input type="submit" value="검색">
	                      </form>
                    </div>
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

	                            <td>
	                            	<img src="<c:url value='${product.thumb1}'/>" class="thumb">
	                            </td>

	                            <td>${product.prodNo}</td>
	                            <td>${product.prodName}</td>
	                            <td>${product.price}</td>
	                            <td>${product.discount}</td>
	                            <td>${product.point}</td>
	                            <td>${product.stock}</td>
	                            <td>${product.seller}</td>
	                            <td>${product.hit}</td>
	                            <td>
	                               <!--   <a href="#" class="remove" data-prodNo="${product.prodNo}">[삭제]</a>-->
	                                <a href="#" class="remove" data-prodNo="${product.prodNo}">[삭제]</a>
	                                <a href="#" class="modify">[수정]</a>
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

                
                <p class="ico info">
                    <strong>Tip!</strong>
                    전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
                </p>

                

                <!-- 상품목록 컨텐츠 끝 -->
            </section>
        </main>
       <jsp:include page="../_footer.jsp"></jsp:include>