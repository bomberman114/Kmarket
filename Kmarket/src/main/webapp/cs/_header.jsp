<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>케이마켓::고객센터</title>
    <link rel="shortcut icon" type="image/x-icon" href="/Kmarket/img/favicon.ico" />
    <link rel="stylesheet" href="/Kmarket/cs/css/style.css">
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script>
        $(function(){
            $('.more').click(function(e){
            e.preventDefault();
            
            /*
            let item = $(this).parent().find('> li:nth-child(n+4)');
            let isVisible = item.is(':visible');

            console.log('isVisible : ' + isVisible);

            if(isVisible){
                item.slideUp(100);
            }else{
                item.slideDown(100);
            }
            */

            });
        });
    </script>
  </head>
  <body>
    <div id="wrapper">
      <header>
        <div class="top">
          <div>
            <p>
              <a href="/Kmarket/member/login.do">로그인</a>
              <a href="/Kmarket/member/join.do">회원가입</a>
              <a href="#">마이페이지</a>
              <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니</a>
            </p>
          </div>
        </div>
        <div class="logo">
          <div>
            <a href="/Kmarket/cs/index.do"><img src="/Kmarket/cs/images/logo.png" alt="로고" />고객센터</a>
          </div>
        </div>
      </header>
