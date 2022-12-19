<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"></jsp:include>
<script>


</script>

            <!-- 장바구니 페이지 시작 -->
            <section class="cart">
            
            <!-- 제목, 페이지 네비게이션 -->
            <nav>
                <h1>장바구니</h1>
                <p>
                    HOME > <span>패션·의류·뷰티</span> > <strong>장바구니</strong>
                </p>
            </nav>
                            
            <form action="/Kmarket/product/order.do">
                <!-- 장바구니 목록 -->
                <table>
                    <thead>
                    <tr>
                        <th><input type="checkbox" name="all"></th>
                        <th>상품명</th>
                        <th>총수량</th>
                        <th>판매가</th>
                        <th>할인</th>
                        <th>포인트</th>
                        <th>배송비</th>
                        <th>소계</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="empty">
                        <td colspan="7">장바구니에 상품이 없습니다.</td>
                    </tr>
                    <c:set var = "price" value = "0" />
                    <c:set var = "discount" value = "0" />
                    <c:set var = "point" value = "0" />
                    <c:set var = "delivery" value = "0" />
                    <c:set var = "disprice" value = "0" />
                    <c:forEach var="cart" items="${cart}">
                    <tr>
                        <td><input type="checkbox" name=""></td>
                        <td>
                            <article>
                                <a href="/Kmarket/product/view.do?cate1=${product.prodCate1}&cate2=${product.prodCate2}&prodNo=${product.prodNo}">
                                <img src="<c:url value='${cart.detail}'/>" alt="item1"></a>
                                <div>
                                    <h2><a href="#">${cart.proName}</a></h2>
                                    <p>${cart.descript}</p>
                                  <!--   <input type="hidden" name="cartNo" value="${cart.prodNo}" />  -->
                                </div>
                            </article>
                        </td>
                        <td><input name="count" value="${cart.count}" type="number" /></td>
                        <td><input name="price" id="price" value="${cart.price}" readonly="readonly" /></td>
                       <td> <input name="discount" id="idscount" value="${cart.discount}" readonly="readonly"/></td>
                        <td><input name="point" id="point" value="${cart.point}" readonly="readonly"/></td>
                        <c:if test="${cart.delivery eq 0}">
                        <td>무료배송</td>
                        <input type="hidden" id="delivery" value="${cart.delivery}" />
                        </c:if>
                        <c:if test="${cart.delivery ne 0}">
                        <td><input id="delivery" value="${cart.delivery}" /><td>
                        </c:if>
                       <td><input id="total" value=" ${cart.total}" /></td>
                    </tr>
                    <c:set var= "price" value="${price + cart.price}"/>
                    <c:set var= "discount" value="${discount + cart.discount}"/>
                    <c:set var= "point" value="${point + cart.point}"/>
                    <c:set var= "delivery" value="${delivery + cart.delivery}"/>
                    <c:set var= "disprice" value="${disprice + cart.disprice}"/>
                    </c:forEach>
                 
                  
                </tbody>
                </table>
                <input type="button" name="del" value="선택삭제">

                <!-- 장바구니 전체합계 -->
                <div class="total">
                    <h2>전체합계</h2>
                    <table border="1">
                        <tr>
                        <td>상품수</td>
                        <td>1</td>
                        </tr>
                        <tr>
                        <td>상품금액</td>
                        <td><c:out value="${price}"/></td>
                        </tr>
                        <tr>
                        <td>할인율</td>
                        <td><c:out value="${discount}"/></td>
                        </tr>
                        <tr>
                        <td>배송비</td>
                        <c:if test="${delivery eq 0 }">
                        <td>0</td>
                        </c:if>
                          <c:if test="${delivery ne 0 }">
                        <td>${delivery}</td>
                        </c:if>
                        </tr>              
                        <tr>
                        <td>포인트</td>
                        <td><c:out value="${point}"/></td>
                        </tr>
                        <tr>
                        <c:set var="total" value="0"></c:set>
                        <c:set var="total" value="${disprice+delivery}"></c:set>
                        <td>전체주문금액</td>
                        <td><c:out value="${total}"/></td>
                        </tr>
                    </table>
                    <input type="submit"  value="주문하기">    
                </div>
                </form>
            </section>
            <!-- 장바구니 페이지 끝 -->
        </main>
        <jsp:include page="./_footer.jsp"></jsp:include>