<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"></jsp:include>
            
            <section class="list">              
                <!-- 제목, 페이지 네비게이션 -->
                <nav>
                    <h1>상품목록</h1>
                    <p>HOME > <span>${c1Name}</span> > <strong>${c2Name}</strong></p>
                </nav>

                <!-- 정렬 메뉴 -->
                <ul class="sort">
                    <li><a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&sort=sold" class="${sort eq 'sold'?'on':'off'}">판매많은순</a></li>
                    <li><a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&sort=lowprice" class="${sort eq 'lowprice'?'on':'off'}">낮은가격순</a></li>
                    <li><a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&sort=price" class="${sort eq 'price'?'on':'off'}">높은가격순</a></li>
                    <li><a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&sort=score" class="${sort eq 'score'?'on':'off'}">평점높은순</a></li>
                    <li><a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&sort=review" class="${sort eq 'review'?'on':'off'}">후기많은순</a></li>
                    <li><a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&sort=rdate" class="${sort eq 'rdate'?'on':'off'}">최근등록순</a></li>
                </ul>

                <!-- 상품목록 -->              
                <table border="0">     
                    <c:forEach var="product" items="${products}">
                    <tr>
                    <td><a href="#" class="thumb"><img src="<c:url value='${product.thumb1}'/>" alt="상품이미지"/></a></td>
                    <td>
                        <h3 class="name">${product.prodName}</h3>
                        <a href="#" class="desc">${product.descript}</a>
                    </td>
                    <td>
                        <ul>
                        <li><ins class="dis-price">${product.disprice}</ins></li>
                        <li>
                            <del class="org-price">${product.price}</del>
                            <span class="discount">${product.discount}%</span>
                        </li>
                        <li><span class="free-delivery">무료배송</span></li>
                        </ul>
                    </td>
                    <td>
                        <h4 class="seller"><i class="fas fa-home"></i>&nbsp;판매자</h4>
                        <h5 class="badge power">판매자등급</h5>
                        <h6 class="rating star1">상품평</h6>
                    </td>
                    </tr>
					</c:forEach>
                </table>            

                <!-- 상품목록 페이지번호 -->
                <div class="paging">
                    <span class="prev">
                    <a href="#"><&nbsp;이전</a>
                    </span>
                    <span class="num">
                    <a href="#" class="on">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">6</a>
                    <a href="#">7</a>
                    </span>
                    <span class="next">
                    <a href="#">다음&nbsp;></a>
                    </span>
                </div>

                </section>
            </main>
<jsp:include page="./_footer.jsp"></jsp:include>