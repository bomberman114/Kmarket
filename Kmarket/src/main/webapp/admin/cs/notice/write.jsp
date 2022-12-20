<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../_header.jsp"></jsp:include>
        <section id="admincs">
            <div class="notice">
                <section class="write">
                	<nav>
	                    <h3>공지사항</h3>
	                    <p>
	                        HOME > 고객센터 > <strong>공지사항</strong>
	                    </p>
	                </nav>
                    <article>
                        <form action="#" method="post">
                        <input type="hidden" name="uid" value="${sessUser.uid}"/>
                            <table>
                                <tr>
                                    <td>문의유형</td>
                                    <td>
                                        <select name="cate2">
                                            <option value="0">선택</option>
                                            <option value="1">고객서비스</option>
                                            <option value="2">안전거래</option>
                                            <option value="3">위해상품</option>
                                            <option value="4">이벤트당첨</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>문의제목</td>
                                    <td>
                                        <input type="text" name="title" placeholder="제목을 입력하세요." required/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>문의내용</td>
                                    <td>
                                        <textarea name="content" placeholder="내용을 입력하세요." required></textarea>
                                    </td>
                                </tr>
                            </table>
                            <div>
                                <a href="/Kmarket/cs/qna/list.do?cate1=${cate1}" class="btn btnCancle">취소하기</a>
                                <input type="submit" class="btn btnComplete" value="등록하기">
                            </div>
                        </form>
                    </article>
                </section>
            </div>
        </section>
               </div>
            </section>
        </main>
<jsp:include page="../_footer.jsp"></jsp:include>