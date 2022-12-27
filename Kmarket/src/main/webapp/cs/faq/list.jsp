<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"></jsp:include>\
<script>

	$(function(){
		
	$('a[class=btnOrder1]').click(function(){
		$('section[class=section1]').show();
	});
	$('a[class=btnClose1]').click(function(){
		$('section[class=section1]').hide();
	});
		});
	

$(function(){
	
	$('a[class=btnOrder2]').click(function(){
		$('section[class=section2]').show();
	});
	
	$('a[class=btnClose2]').click(function(){
		$('section[class=section2]').hide();
	});
});

$(function(){
	
	$('a[class=btnOrder3]').click(function(){
		$('section[class=section3]').show();
	
	});
	$('a[class=btnClose3]').click(function(){
		$('section[class=section3]').hide();
	});
	});
	$(function(){

	
	$('a[class=btnOrder4]').click(function(){
		$('section[class=section4]').show();
	});
	
	$('a[class=btnClose4]').click(function(){
		$('section[class=section4]').hide();
	});
		});

	

</script>
    <section id="cs">
        <div class="faq">
        <nav>
            <div>
            <p>홈<span>></span>자주묻는 질문</p>
            </div>
        </nav>
        <section class="list">
            <aside>
            <h2>자주묻는 질문</h2>
            <ul>
                <li class="${cate1 eq '1'?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=1">회원</a></li>
                <li class="${cate1 eq '2'?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=2">쿠폰/이벤트</a></li>
                <li class="${cate1 eq '3'?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=3">주문/결제</a></li>
                <li class="${cate1 eq '4'?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=4">배송</a></li>
                <li class="${cate1 eq '5'?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=5">취소/반품/교환</a></li>
                <li class="${cate1 eq '6'?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=6">여행/숙박/항공</a></li>
                <li class="${cate1 eq '7'?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=7">안전거래</a></li>
            </ul>
            </aside>
            <article>              
            <nav>
                <h1>회원</h1>
                <h2>가장 자주 묻는 질문입니다.</h2>
            </nav>
			<c:if test="${cate1 eq 1}">
			 	<!-- <div>
	                <h3>가입</h3>
	                <ul>
		                <c:forEach items="${csFaq1}" var="faq">
		                	<li><a href="/Kmarket/admin/cs/faq/view.do"><span>Q.</span>${faq.title}</a></li>
		                </c:forEach>
	                 	<li class="more"><a href="#" class="btnOrder" >더보기</a></li>
	                	<section class="section" style="display: none;">
		                   <c:forEach items="${csFaq2}" var="faq" varStatus="status" >
		                   		<li><a href="/Kmarket/admin/cs/faq/view.do"><span>Q.</span>${faq.title}</a></li>
		                   </c:forEach>
	                	   <a href="#" class="btnClose">닫기</a> 
	                   </section>
	                </ul>
	            </div>
	             -->
	            <c:forEach var="cate1" items="${cateName}">
				<div>
	                <h3>탈퇴</h3>
	                <ul>
	                <li><a href="#"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
	                <li><a href="#"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
	                <li><a href="#"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
	                <li><a href="#"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
	                <li><a href="#"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
	               <li class="more"><a href="#" class="btnOrder${i}" >더보기</a></li>
	                	<section class="section${i}" style="display: none;">
	                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
	                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
	                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
	                	 <a href="#" class="btnClose${i}">닫기</a>  
	                	</section>
	                </ul>
	            </div>
	            </c:forEach>
	            
	           
			</c:if>
			
            </article>
        </section>
        </div>
    </section>

    <jsp:include page="../_footer.jsp"></jsp:include>