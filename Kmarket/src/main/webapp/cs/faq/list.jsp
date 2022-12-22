<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"></jsp:include>\
<script>


$(function(){
	
	$('.btnOrder1').click(function(){
		$('section[class=section1]').show();
	});
	
	$('.btnClose1').click(function(){
		$('section[class=section1]').hide();
	});
});
	
	/*
	$('.btnOrder2').click(function(){
		$('section[class=section2]').show();
	});
	
	$('.btnClose2').click(function(){
		$('section[class=section2]').hide();
	});

	
	$('.btnOrder3').click(function(){
		$('section[class=section3]').show();
	
	$('.btnClose3').click(function(){
		$('section[class=section3]').hide();
	});

	
	$('.btnOrder4').click(function(){
		$('section[class=section4]').show();
	
	$('.btnClose4').click(function(){
		$('section[class=section4]').hide();
	});
		});
	*/
	

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
                <li class="on"><a href="/Kmarket/admin/cs/faq/list.do">회원</a></li>
                <li><a href="#">쿠폰/이벤트</a></li>
                <li><a href="#">주문/결제</a></li>
                <li><a href="#">배송</a></li>
                <li><a href="#">취소/반품/교환</a></li>
                <li><a href="#">여행/숙박/항공</a></li>
                <li><a href="#">안전거래</a></li>
            </ul>
            </aside>
            <article>              
            <nav>
                <h1>회원</h1>
                <h2>가장 자주 묻는 질문입니다.</h2>
            </nav>

            <div>
                <h3>가입</h3>
                <ul>
                <li><a href="/Kmarket/admin/cs/faq/view.do"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                 <li class="more"><a href="#" class="btnOrder1" >더보기</a></li>
                	<section class="section1" style="display: none;">
                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                	 <a href="#" class="btnClose1">닫기</a>  
                	</section>
                </ul>
            </div>
            <div>
                <h3>탈퇴</h3>
                <ul>
                <li><a href="#"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
                <li><a href="#"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
                <li><a href="#"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
                <li><a href="#"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
                <li><a href="#"><span>Q.</span>회원탈퇴 후 재가입이 가능한가요?</a></li>
               <li class="more"><a href="#" class="btnOrder2" >더보기</a></li>
                	<section class="section2" style="display: none;">
                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                	 <a href="#" class="btnClose2">닫기</a>  
                	</section>
                </ul>
            </div>
            <div>
                <h3>회원정보</h3>
                <ul>
                <li><a href="#"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
                <li><a href="#"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
                <li><a href="#"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
                <li><a href="#"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
                <li><a href="#"><span>Q.</span>회원정보를 수정하고 싶어요.</a></li>
                 <li class="more"><a href="#" class="btnOrder3" >더보기</a></li>
                	<section class="section3" style="display: none;">
                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                	 <a href="#" class="btnClose3">닫기</a>  
                	</section>
                </ul>
            </div>
            <div>
                <h3>로그인</h3>
                <ul>
                <li><a href="#"><span>Q.</span>로그인에 문제가 있어요.</a></li>
                <li><a href="#"><span>Q.</span>로그인에 문제가 있어요.</a></li>
                <li><a href="#"><span>Q.</span>로그인에 문제가 있어요.</a></li>
                <li><a href="#"><span>Q.</span>로그인에 문제가 있어요.</a></li>
                <li><a href="#"><span>Q.</span>로그인에 문제가 있어요.</a></li>
                <li class="more"><a href="#" class="btnOrder4" >더보기</a></li>
                	<section class="section4" style="display: none;">
                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                	 <li><a href="#"><span>Q.</span>개인회원과 법인회원에 차이가 있나요?</a></li>
                	 <a href="#" class="btnClose4">닫기</a>  
                	</section>
                </ul>
            </div>

            </article>
        </section>
        </div>
    </section>

    <jsp:include page="../_footer.jsp"></jsp:include>