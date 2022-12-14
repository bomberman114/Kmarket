<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"></jsp:include>
        <section id="cs">
            <div class="qna">
                <nav>
                    <div>
                        <p>홈<span>></span>문의하기</p>
                    </div>
                </nav>
                <section class="list">
                    <aside>
                        <h2>문의하기</h2>
                        <ul>
                            <li class="${cate1 eq '1'?'on':'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=1">회원</a></li>
                            <li class="${cate1 eq '2'?'on':'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=2">쿠폰/이벤트</a></li>
                            <li class="${cate1 eq '3'?'on':'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=3">주문/결제</a></li>
                            <li class="${cate1 eq '4'?'on':'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=4">배송</a></li>
                            <li class="${cate1 eq '5'?'on':'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=5">취소/반품/교환</a></li>
                            <li class="${cate1 eq '6'?'on':'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=6">여행/숙박/항공</a></li>
                            <li class="${cate1 eq '7'?'on':'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=7">안전거래</a></li>
                        </ul>
                    </aside>
                    <article>
                        <nav>
                            <h1>${c1name}</h1>
                            <h2>${c1name} 문의 내용입니다.</h2>
                        </nav>
                        <table>
                        	<c:forEach var="article" items="${articles}">
                            <tr>
                                <td><a href="./qnaView.html">[가입] ${article.title}</a></td>
                                <td>${(article.uid).substring(0,2)}**</td>
                                <td>${article.rdate}</td>
                            </tr>
                            </c:forEach>
                        </table>

                        <div class="page">
                            <a href="#" class="prev">이전</a>
                            <a href="#" class="num on">1</a>
                            <a href="#" class="num">2</a>
                            <a href="#" class="num">3</a>
                            <a href="#" class="next">다음</a>
                        </div>


                        <a href="/Kmarket/cs/qna/write.do?cate1=${cate1}" class="btnWrite">문의하기</a>


                    </article>
                </section>
            </div>
        </section>

       <jsp:include page="../_footer.jsp"></jsp:include>