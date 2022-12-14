<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"></jsp:include>
<script src="/Kmarket/admin/js/validation.js"></script>
<script>

	
$(function(){
	
	$('select[name=prodCate1]').change(function(){
		
		
		let cate1 = $(this).val();
		//alert(cate1);
		/*var prodCate2El = document.getElementById('prodCate2');
		var prodName = prodNameEl.value
		removeAllchild('select[name=prodCate2]');
		*/
		$.ajax({
	        url : '/Kmarket/admin/product/getCate2.do',
	        method: 'get',
	        data: { "cate1" : cate1 } ,
	        dataType : 'json',
	        success : function ( data ){
	        	$('select[name=prodCate2]').empty();
				$('select[name=prodCate2]').append("<option value='cate0'>2차 분류 선택</option>");
	           var html = "";
	           $.each(data, function(index, item) {
		             html  = "<option value='"+item.cate2+"'>"+item.c2Name+"</option>";
		             $('select[name=prodCate2]').append(html);
	           });
	        }
	      });//$.ajax end
	});
});
	/*
	   $('#cate1').on('click', 'a', function(e){
		   
	      var clickedSaletButton = $('#cate1').text();
	      data: { cate1 : clickedSaleButton }
	      alert(clickedSaleButton);
		
		  $.ajax({
	        url : '/Kmarket/admin/product/getCate2.do',
	        method: 'get',
	        data: { cate1 : selectbox } ,
	        dataType : 'String',
	        success : function ( data ){
	           var html = "";
	           $.each(json.items, function(index, item) {
		      	   	 html  += '<c:forEach var="c" items="${ cate2 }">'; 
		             html  += '<option value="${ c.cate2 }">${ c.c2Name }</option>';
		             html  += '</c:forEach>';
		        
	           });
	            $('#cate2').html(html);
	           }
	          
	      });//$.ajax end
	}); //$function end
	
});
*/

</script>
            <section id="admin-product-register">
                <nav>
                    <h3>상품등록</h3>
                    <p>
                        HOME > 상품관리 > <strong>상품등록</strong>
                    </p>
                </nav>
                <!-- 상품등록 컨텐츠 시작 -->
                <article>
                    <form action="/Kmarket/admin/product/register.do" method="POST" enctype="multipart/form-data">
                        <!-- 상품분류 -->

                        <input type="hidden" name="seller" id="seller" value="${sessUser.uid}"/>

                        <section>
                            <h4>상품분류</h4>
                            <p>
                                기본분류는 반드시 선택하셔야 합니다. 하나의 상품에 1개의 분류를 지정 합니다.
                            </p>
                            <table>
                                <tr>

							<td>1차 분류</td>
                            <td>
                                <select name="prodCate1">
                                    <option value="cate0">1차 분류 선택</option>
                                    <c:forEach var="c" items="${ vos }">
                                    	<option value="${ c.cate1 }">${ c.c1Name }</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>2차 분류</td>
                            <td>
                                <select name="prodCate2">
                                    <option value="cate0">2차 분류 선택</option>
                                </select>
                            </td>
							</tr>
                            </table>
                        </section>

                        <!-- 기본정보 -->
                        <section>
                            <h4>기본정보</h4>
                            <p>
                                기본정보는 반드시 입력해야 합니다.
                            </p>
                            <table>
                                <tr>
                                    <td>상품명</td>
                                    <td><input type="text" name="prodName" id="prodName"/></td>
                                </tr>
                                <tr>
                                    <td>기본설명</td>
                                    <td>
                                        <span>상품명 하단에 상품에 대한 추가적인 설명이 필요한 경우에 입력</span>
                                        <input type="text" name="descript" id="descript"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>제조사</td>
                                    <td><input type="text" name="company" id="company"/></td>
                                </tr>
                                <tr>
                                    <td>판매가격</td>
                                    <td><input type="text" name="price" id="price"/>&nbsp;원</td>
                                </tr>                                    
                                <tr>
                                    <td>할인율</td>
                                    <td>
                                        <span>0을 입력하면 할인율 없음</span>
                                        <input type="text" name="discount" id="discount"/>&nbsp;원
                                    </td>
                                </tr>
                                <tr>
                                    <td>포인트</td>
                                    <td>
                                        <span>0을 입력하면 포인트 없음</span>
                                        <input type="text" name="point" id="point"/>&nbsp;점
                                    </td>
                                </tr>
                                <tr>
                                    <td>재고수량</td>
                                    <td><input type="text" name="stock" id="stock"/>&nbsp;개</td>
                                </tr>
                                <tr>
                                    <td>배송비</td>
                                    <td>
                                        <span>0을 입력하면 배송비 무료</span>
                                        <input type="text" name="delivery" id="delivery"/>&nbsp;원
                                    </td>
                                </tr>
                                <tr>
                                    <td>상품 썸네일</td>
                                    <td>
                                        <span>크기 190 x 190, 상품 목록에 출력될 이미지 입니다. </span>
                                        <input type="file" name="thumb1" id="thumb1"/>

                                        <span>크기 230 x 230, 상품 메인에 출력될 이미지 입니다. </span>
                                        <input type="file" name="thumb2" id="thumb2"/>

                                        <span>크기 456 x 456, 상품 상세에 출력될 이미지 입니다. </span>
                                        <input type="file" name="thumb3" id="thumb3"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>상세 상품정보</td>
                                    <td>
                                        <span>크기 가로 940px 높이 제약없음, 크기 최대 1MB, 상세페이지 상품정보에 출력될 이미지 입니다.</span>
                                        <input type="file" name="detail" id="detail"/>
                                    </td>
                                </tr>
                            </table>                                
                        </section>

                        <!-- 상품정보 제공 고시 -->
                        <section>
                            <h4>상품정보 제공고시</h4>
                            <p>
                                [전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록해야 되는 정보입니다.
                            </p>
                            <table>
                                <tr>
                                    <td>상품상태</td>
                                    <td><input type="text" name="status" id="status" value="새상품"/></td>
                                </tr>
                                <tr>
                                    <td>부가세 면세여부</td>
                                    <td><input type="text" name="duty" id="duty"  value="과세상품"/></td>
                                </tr>
                                <tr>
                                    <td>영수증발행</td>
                                    <td><input type="text" name="receipt" id="receipt" value="발행가능"/></td>
                                </tr>
                                <tr>
                                    <td>사업자구분</td>
                                    <td><input type="text" name="bizType" id="bizType" value="사업자 판매자"/></td>
                                </tr>                                
                                <tr>
                                    <td>원산지</td>
                                    <td><input type="text" name="origin" id="origin" value="국내산"/></td>
                                </tr>                                
                            </table>                                
                        </section>
                        
                        <input type="submit" value="등록하기" class="btn btnComplete"/>
                    </form>
                </article>

                <p class="ico alert">
                    <strong>Warning!</strong>
                    전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
                </p>
                <!-- 상품등록 컨텐츠 끝 -->
            </section>
        </main>
        
        <!-- Code injected by live-server -->
    <script>
        // <![CDATA[  <-- For SVG support
        if ('WebSocket' in window) {
            (function () {
                function refreshCSS() {
                    var sheets = [].slice.call(document.getElementsByTagName("link"));
                    var head = document.getElementsByTagName("head")[0];
                    for (var i = 0; i < sheets.length; ++i) {
                        var elem = sheets[i];
                        var parent = elem.parentElement || head;
                        parent.removeChild(elem);
                        var rel = elem.rel;
                        if (elem.href && typeof rel != "string" || rel.length == 0 || rel.toLowerCase() == "stylesheet") {
                            var url = elem.href.replace(/(&|\?)_cacheOverride=\d+/, '');
                            elem.href = url + (url.indexOf('?') >= 0 ? '&' : '?') + '_cacheOverride=' + (new Date().valueOf());
                        }
                        parent.appendChild(elem);
                    }
                }
                var protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
                var address = protocol + window.location.host + window.location.pathname + '/ws';
                var socket = new WebSocket(address);
                socket.onmessage = function (msg) {
                    if (msg.data == 'reload') window.location.reload();
                    else if (msg.data == 'refreshcss') refreshCSS();
                };
                if (sessionStorage && !sessionStorage.getItem('IsThisFirstTime_Log_From_LiveServer')) {
                    console.log('Live reload enabled.');
                    sessionStorage.setItem('IsThisFirstTime_Log_From_LiveServer', true);
                }
            })();
        }
        else {
            console.error('Upgrade your browser. This Browser is NOT supported WebSocket for Live-Reloading.');
        }
        // ]]>
    </script>
<jsp:include page="../_footer.jsp"></jsp:include>