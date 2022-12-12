<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>케이마켓::대한민국 1등 온라인 쇼핑몰</title>
    <link rel="shortcut icon" type="image/x-icon" href="/Kmarket/img/favicon.ico" />
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <link rel="stylesheet" href="/Kmarket/css/common.css"/>
    <link rel="stylesheet" href="/Kmarket/product/css/product.css"/>
    <script>
      $(document).ready(function () {
        $(".slider > ul").bxSlider({
          easing: "linear",
        });
      });

      $(function () {
        var best = $("aside > .best");

        $(window).scroll(function () {
          var t = $(this).scrollTop();

          if (t > 620) {
            best.css({
              position: "fixed",
              top: "0",
            });
          } else {
            best.css({ position: "static" });
          }
        });
      });
    </script>
  </head>
  <body>
    <div id="wrapper">
      <header>
        <div class="top">
          <div>
            <a href="./member/login.html">로그인</a>
            <a href="#">회원가입</a>
            <a href="#">마이페이지</a>
            <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니</a>
          </div>
        </div>
        <div class="logo">
          <div>
            <a href="#"><img src="/Kmarket/img/header_logo.png" alt="로고" /></a>
            <form action="#">
              <input type="text" name="search" />
              <button><i class="fa fa-search"></i></button>
            </form>
          </div>
        </div>
        <div class="menu">
          <div>
            <ul>
              <li><a href="#">히트상품</a></li>
              <li><a href="#">추천상품</a></li>
              <li><a href="#">최신상품</a></li>
              <li><a href="#">인기상품</a></li>
              <li><a href="#">할인상품</a></li>
            </ul>
            <ul>
              <li><a href="#">공지사항</a></li>
              <li><a href="#">자주묻는질문</a></li>
              <li><a href="#">문의하기</a></li>
              <li><a href="#">고객센터</a></li>
            </ul>
          </div>
        </div>
      </header>
      
      <main id="product">            
            <aside>
				<ul class="category">
		        	<li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
		            <li>
		              <a href="#"><i class="fas fa-shopping-bag"></i>브랜드 패션<i class="fas fa-angle-right"></i></a>
		              <ol>
		                <li><a href="#">브랜드 여성의류</a></li>
		                <li><a href="#">브랜드 남성의류</a></li>
		                <li><a href="#">브랜드 진/캐쥬얼</a></li>
		                <li><a href="#">브랜드 신발/가방</a></li>
		                <li><a href="#">브랜드 쥬얼리/시계</a></li>
		                <li><a href="#">브랜드 아웃도어</a></li>
		              </ol>
		            </li>
		            <li>
		              <a href="#"><i class="fas fa-tshirt"></i>패션의류·잡화·뷰티<i class="fas fa-angle-right"></i></a>
		              <ol>
		                <li><a href="#">여성의류</a></li>
		                <li><a href="#">남성의류</a></li>
		                <li><a href="#">언더웨어</a></li>
		                <li><a href="#">신발</a></li>
		                <li><a href="#">가방/잡화</a></li>
		                <li><a href="#">쥬얼리/시계</a></li>
		                <li><a href="#">화장품/향수</a></li>
		                <li><a href="#">바디/헤어</a></li>
		              </ol>
		            </li>
		            <li>
		              <a href="#"><i class="fas fa-baby-carriage"></i>유아동<i class="fas fa-angle-right"></i></a>
		              <ol>
		                <li><a href="#">출산/육아</a></li>
		                <li><a href="#">장난감/완구</a></li>
		                <li><a href="#">유아동 의류</a></li>
		                <li><a href="#">유아동 신발/잡화</a></li>
		              </ol>
		            </li>
		            <li>
		              <a href="#"><i class="fas fa-utensils"></i>식품·생필품<i class="fas fa-angle-right" ></i></a>
		              <ol>
		                <li><a href="#">신선식품</a></li>
		                <li><a href="#">가공식품</a></li>
		                <li><a href="#">건강식품</a></li>
		                <li><a href="#">커피/음료</a></li>
		                <li><a href="#">생필품</a></li>
		                <li><a href="#">바디/헤어</a></li>
		              </ol>
		            </li>
		            <li>
		              <a href="#"><i class="fas fa-home"></i>홈데코·문구·취미·반려<i class="fas fa-angle-right"></i></a>
		              <ol>
		                <li><a href="#">가구/DIY</a></li>
		                <li><a href="#">침구/커튼</a></li>
		                <li><a href="#">조명/인테리어</a></li>
		                <li><a href="#">생활용품</a></li>
		                <li><a href="#">주방용품</a></li>
		                <li><a href="#">문구/사무용품</a></li>
		                <li><a href="#">사무기기</a></li>
		                <li><a href="#">악기/취미</a></li>
		                <li><a href="#">반려동물용품</a></li>
		              </ol>
		            </li>
		            <li>
		              <a href="#"><i class="fas fa-tv"></i>컴퓨터·디지털·가전<i class="fas fa-angle-right"></i></a>
		              <ol>
		                <li><a href="#">노트북/PC</a></li>
		                <li><a href="#">모니터/프린터</a></li>
		                <li><a href="#">PC주변기기</a></li>
		                <li><a href="#">모바일/태블릿</a></li>
		                <li><a href="#">카메라</a></li>
		                <li><a href="#">게임</a></li>
		                <li><a href="#">영상가전</a></li>
		                <li><a href="#">주방가전</a></li>
		                <li><a href="#">계절가전</a></li>
		                <li><a href="#">생활/미용가전</a></li>
		                <li><a href="#">음향가전</a></li>
		                <li><a href="#">건강가전</a></li>
		              </ol>
		            </li>
		            <li>
		              <a href="#"><i class="fas fa-running"></i>스포츠·건강·렌탈<i class="fas fa-angle-right"></i></a>
		              <ol>
		                <li><a href="#">스포츠의류/운동화</a></li>
		                <li><a href="#">휘트니스/수영</a></li>
		                <li><a href="#">구기/라켓</a></li>
		                <li><a href="#">골프</a></li>
		                <li><a href="#">자전거/보드/기타레저</a></li>
		                <li><a href="#">캠핑/낚시</a></li>
		                <li><a href="#">등산/아웃도어</a></li>
		                <li><a href="#">건강/의료용품</a></li>
		                <li><a href="#">건강식품</a></li>
		                <li><a href="#">렌탈서비스</a></li>
		              </ol>
		            </li>
		            <li>
		              <a href="#"><i class="fas fa-car"></i>자동차·공구<i class="fas fa-angle-right"></i></a>
		              <ol>
		                <li><a href="#">자동차용품</a></li>
		                <li><a href="#">공구/안전/산업용품</a></li>
		              </ol>
		            </li>
		            <li>
		              <a href="#"><i class="fas fa-book"></i>여행·도서·티켓·e쿠폰<i class="fas fa-angle-right"></i></a>
		              <ol>
		                <li><a href="#">여행/항공권</a></li>
		                <li><a href="#">도서/음반/e교육</a></li>
		                <li><a href="#">공연티켓</a></li>
		                <li><a href="#">e쿠폰</a></li>
		                <li><a href="#">상품권</a></li>
		              </ol>
		            </li>
		          </ul>
            </aside>
      