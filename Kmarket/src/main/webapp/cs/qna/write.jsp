<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../_header.jsp"></jsp:include>
        <section id="cs">
            <div class="qna">
                <nav>
                    <div>
                        <p>홈<span>></span>문의하기</p>
                    </div>
                </nav>
                <section class="write">
                    <aside>
                        <h2>문의하기</h2>
                        <ul>
                            <li class="${cate1 eq '1'?'on':'off'}"><a href="#">회원</a></li>
                            <li class="${cate1 eq '2'?'on':'off'}"><a href="#">쿠폰/이벤트</a></li>
                            <li class="${cate1 eq '3'?'on':'off'}"><a href="#">주문/결제</a></li>
                            <li class="${cate1 eq '4'?'on':'off'}"><a href="#">배송</a></li>
                            <li class="${cate1 eq '5'?'on':'off'}"><a href="#">취소/반품/교환</a></li>
                            <li class="${cate1 eq '6'?'on':'off'}"><a href="#">여행/숙박/항공</a></li>
                            <li class="${cate1 eq '7'?'on':'off'}"><a href="#">안전거래</a></li>
                        </ul>
                    </aside>
                    <article>
                        <form action="#">
                            <table>
                                <tr>
                                    <td>문의유형</td>
                                    <td>
                                        <select name="type">
                                            <option value="0">선택</option>
                                            <option value="0">회원</option>
                                            <option value="0">쿠폰/혜택/이벤트</option>
                                            <option value="0">주문/결제</option>
                                            <option value="0">배송</option>
                                            <option value="0">취소/반품/교환</option>
                                            <option value="0">여행/숙박/항공</option>
                                            <option value="0">안전거래</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>문의제목</td>
                                    <td>
                                        <input type="text" name="title" placeholder="제목을 입력하세요.">
                                    </td>
                                </tr>
                                <tr>
                                    <td>문의내용</td>
                                    <td>
                                        <textarea name="content" placeholder="내용을 입력하세요."></textarea>
                                    </td>
                                </tr>
                            </table>
                            <div>
                                <a href="./qnaList.html" class="btnList">취소하기</a>
                                <input type="submit" class="btnSubmit" value="등록하기">
                            </div>
                        </form>
                    </article>
                </section>
            </div>
        </section>
<jsp:include page="../_footer.jsp"></jsp:include>