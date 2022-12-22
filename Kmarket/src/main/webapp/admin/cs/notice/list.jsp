<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"></jsp:include>
<script>
	$(document).ready(function(){
		
		
		
		$(document).on('change', 'select[name=category]', function(e){
			
			console.log('here1');
			
			let cate = $(this).val();
			
			console.log('here2');
			
			$.ajax({
				url: '/Kmarket/admin/cs/notice/list.do',                                                                                                                                                                                                                                                                                               
				method: 'POST',
				data: {"cate":cate},
				dataType:'json',
				success: function(data){
					console.log('here3');
										
					$('.paging').empty();
					
					for(let vo of data.notices){
						//let pageStartNum = vo.pageStartNum;
						console.log('pageStartNum : ' + data.pageStartNum);
						
						let tags = "<tr clss='row'><input type='hidden' value='"+vo.no+"'>";
							tags += "<td><input type='checkbox' name='chkbox'/></td>";
							tags += "<td>"+(data.pageStartNum--)+"</td>";
							tags += "<td>"+vo.cateName+"</td>";
							tags += "<td><a href='./view.do?no="+vo.no+"&pg=1'>"+vo.title+"</a></td>";
							tags += "<td>"+vo.hit+"</td>";
							tags += "<td>"+vo.rdate+"</td>";
							tags += "<td><a href='#' class='remove'>[삭제]</a>";
							tags += "<a href='#' class='modify'>[수정]</a></td></tr>";
							
						$('table').append(tags);
						
					}
					
					// 페이징 관련
					for(var i = data.pageGroupStart; i <= data.pageGroupEnd; i++){
						let tags = "<span class='num'>"
							  + "<a href='/Kmarket/admin/cs/notice/list.do?cate="+data.cate+"&pg="+i+"'>"+i+"</a></span>";
							  
						$('.paging').append(tags);
					}
					
					$('.num').eq(data.currentPage - 1).find('> a').addClass('on');
					
					console.log('pageGroupEnd : ' + data.pageGroupEnd);
					console.log('lastPageNum : ' + data.lastPageNum);
					
					if(data.pageGroupEnd < data.lastPageNum) {
						$('.paging').append("<span class='next'><a href='/Kmarket/admin/cs/notice/list.do?cate="+data.cate+"&pg="+(data.pageGroupEnd + 1)+"'>다음&nbsp;</a></span>");
					}
				}
			});			
			
		});
		
		// 체크박스
		let chkList = $('input[name=chkbox]');
		
		$(document).on('click', 'input[name=all]', function(e){
			
			if($(this).is(":checked")){
				chkList.prop("checked", true);
			}else{
				chkList.prop("checked", false);
			}
		});
		
		
		
		
		
	});
	
	// 체크박스 선택후 삭제
	function deleteNotices(){
		
		let checkboxArr = [];
		$('input[name=chkbox]:checked').each(function(){
			
			let no = $(this).parent().prev().val();
			
			checkboxArr.push(no);
			
			
		})
		
		console.log(checkboxArr);
		
	}

	</script>
            <section id="admin-notice-list">
                <nav>
                    <h3>공지사항 목록</h3>
	                    
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
                <!-- 게시글목록 컨텐츠 시작 -->                                
                <section>
                    <div>
                        <select name="category">
                            <option value="0">유형선택</option>
                            <option value="1">고객서비스</option>
                            <option value="2">안전거래</option>
                            <option value="3">위해상품</option>                                    
                            <option value="4">이벤트당첨</option>                                    
                        </select>
                    </div>
                    <table>
                        <tr>
                            <th><input type="checkbox" name="all"/></th>
                            <th>번호</th>
                            <th>유형</th>
                            <th>제목</th>
                            <th>조회</th>
                            <th>날짜</th>
                            <th>관리</th>
                        </tr>
                        
                        <!-- 게시글 목록 나열 -->
                        <c:forEach var="notice" items="${notices}">
	                        <tr class="row">
	                        	<input type="hidden" value="${notice.no}">
	                            <td><input type="checkbox" name="chkbox"/></td>
	                            <td>${pageStartNum = pageStartNum-1}</td>
	                            <td>${notice.cateName}</td>
	                            <td><a href="./view.do?no=${notice.no}&pg=${currentPage}">${notice.title}</a></td>
	                            <td>${notice.hit}</td>
	                            <td>${notice.rdate}</td>
	                            <td>
	                                <a href="#" class="remove">[삭제]</a>
	                                <a href="#" class="modify">[수정]</a>
	                            </td>
	                        </tr>
	                   </c:forEach>
                    </table>
                    
                    <!-- 선택한 게시글 삭제 -->
                    <input type="button" onclick="deleteNotices()" value="선택삭제" />
                    <!-- 공지사항 글 등록 -->
                    <a href="/Kmarket/admin/cs/notice/write.do" class="btn btnSubmit">등록하기</a>
                                  
					<!-- 페이징 -->         
                    <div class="paging">
                    
                    	<c:if test="${pageGroupStart > 1}">
	                        <span class="prev">
	                            <a href="/Kmarket/admin/cs/notice/list.do?cate=${cate}&pg=${pageGroupStart - 1}">&nbsp;이전</a>
	                        </span>
	                    </c:if>
	                    
	                    <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
	                        <span class="num">
	                            <a href="/Kmarket/admin/cs/notice/list.do?cate=${cate}&pg=${i}" class="${currentPage == i ? 'on':'off'}">${i}</a>
	                        </span>
	                    </c:forEach>
	                    
	                    <c:if test="${pageGroupEnd < lastPageNum}">
	                        <span class="next">
	                            <a href="/Kmarket/admin/cs/notice/list.do?cate=${cate}&pg=${pageGroupEnd + 1}">다음&nbsp;</a>
	                        </span>
                        </c:if>
                        
                    </div>

                </section>                
               
                <!-- 게시글 컨텐츠 끝 -->
            </section>
        </main>
<jsp:include page="../_footer.jsp"></jsp:include>