<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"></jsp:include>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/Kmarket/member/js/zipcode.js"></script>
<script>

	//데이터 검증에 사용하는 정규표현식
	let regUid = /^[a-z]+[a-z0-9]{5,19}$/g;
	let regPass = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{5,16}$/;
	let regName = /^[ㄱ-힣]+$/;
	let regNick = /^[a-zA-Zㄱ-힣0-9][a-zA-Zㄱ-힣0-9]*$/;
	let regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	let regHp = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;
	
	// 폼 데이터 검증 결과 상태변수
	let isUidOk = false;
	let isPass1Ok = false;
	let isPass2Ok = false;
	let isNameOk = false;
	let isNickOk = false;
	let isEmailOk = false;
	let isEmailAuthOk = false;
	let isHpOk = false;
	
	$(function(){
		
		// 아이디 검사하기
		$('input[name=km_uid]').keydown(function(){
			isUidOk = false;
		});
		
		$('#btnIdCheck').click(function(){
			
			let uid = $('input[name=km_uid]').val();
			
			if(isUidOk) {
				return;
			}
			
			if(!uid.match(regUid)) {
				isUidOk = false;
				$('.msgId').css('color', 'red').text('유효한 아이디 형식이 아닙니다.');
				return;
			}
			
			let jsonData = {"uid":uid};
			
			setTimeout(function(){
				
				$.ajax({
					url: '/Kmarket/member/checkUid.do',
					method:'get',
					data: jsonData,
					dataType: 'json',
					success: function(data) {
						
						if(data.result == 0) {
							isUidOk = true;
							$('.msgId').css('color', 'green').text('사용 가능한 아이디 입니다.');
						}else {
							isUidOk = false;
							$('.msgId').css('color', 'red').text('이미 사용중인 아이디 입니다.');
						}
					}
				});
				
			}, 500);
		});
		
		// 비밀번호 일치여부 확인
		$('input[name=km_pass1]').keydown(function(){
			isPass1Ok = false;
		});
		
		
		
		$('input[name=km_pass2]').keydown(function(){
			isPass2Ok = false;
		});
		
		$('input[name=km_pass1]').focusout(function() {
			
			let pass1 = $('input[name=km_pass1]').val();
			
			if(!pass1.match(regPass)){
				isPass1Ok = false;
				$('.msgPass1').css('color', 'red').text('숫자,영문,특수문자 포함 8자리 이상이어야 합니다.');
			}else {
				isPass1Ok = true;
				$('.msgPass1').css('color', 'black').text('영문, 숫자, 특수문자를 조합하여 8~12자까지 설정해 주세요.');
			}
			
		});
		
		$('input[name=km_pass2]').focusout(function() {
			
			let pass1 = $('input[name=km_pass1]').val();
			let pass2 = $('input[name=km_pass2]').val();
			
			if(pass1 == ''){
				return;
			}
			
			if(pass2 == ''){
				return;
			}
			
			if (pass1 == pass2) {
				isPass2Ok = true;
				$('.msgPass2').css('color', 'green').text('사용하실 수 있는 비밀번호 입니다.');
			} else {
				isPassOk = false;
				$('.msgPass2').css('color', 'red').text('비밀번호가 일치하지 않습니다.');
			}
			
		});
		
	});

</script>
        <main id="member">
            <div class="register">
                <nav>
                    <h1>일반 회원가입</h1>
                </nav>
                <form action="/Kmarket/member/register.do" method="POST">
                    <section>
                        <table>
                            <caption>필수 정보입력</caption>
                            <tr>
                                <th><span class="essential">*</span>아이디</th>
                                <td>
                                    <input type="text" name="km_uid" placeholder="아이디 입력" required>
                                   	<button type="button" id="btnIdCheck">중복확인</button>
                                    <span class="msgId">&nbsp;&nbsp;영문, 숫자로 4~12자까지 설정해 주세요.</span>
                                </td>
                            </tr>
                            <tr>
                                <th><span class="essential">*</span>비밀번호</th>
                                <td>
                                    <input type="password" name="km_pass1" placeholder="비밀번호 입력" required>
                                    <span class="msgPass1">&nbsp;&nbsp;영문, 숫자, 특수문자를 조합하여 8~12자까지 설정해 주세요.</span>
                                </td>
                            </tr>
                            <tr>
                                <th><span class="essential">*</span>비밀번호확인</th>
                                <td>
                                    <input type="password" name="km_pass2" placeholder="비밀번호 확인" required>
                                    <span class="msgPass2">&nbsp;&nbsp;비밀번호 재입력</span>
                                </td>
                            </tr>
                        </table>
                    </section>
                    <section>
                        <table>
                            <caption>기본 정보입력</caption>
                            <tr>
                                <th><span class="essential">*</span>이름</th>
                                <td>
                                    <input type="text" name="km_name" placeholder="이름 입력" required>
                                </td>
                            </tr>
                            <tr>
                                <th><span class="essential">*</span>성별</th>
                                <td>
                                    <label><input type="radio" name="km_gender" value="1" checked>&nbsp;남</label>
                                    <label><input type="radio" name="km_gender" value="2">&nbsp;여</label>
                                </td>
                            </tr>
                            <tr>
                                <th><span class="essential">*</span>EMAIL</th>
                                <td>
                                    <input type="email" name="km_email" placeholder="이메일 입력" required>
                                </td>
                            </tr>
                            <tr>
                                <th><span class="essential">*</span>휴대폰</th>
                                <td>
                                    <input type="text" name="km_hp" maxlength="13" placeholder="휴대폰번호 입력" required>
                                    <span class="msgHp">&nbsp;&nbsp;- 포함 13자리를 입력하세요.</span>
                                </td>
                            </tr>
                            <tr class="addr">
                                <th>주소</th>
                                <td>
                                    <div>
                                        <input type="text" name="km_zip" id="zip" placeholder="우편번호 입력 클릭" readonly>
                                        <button type="button" onclick="zipcode()">우편번호 찾기</button>
                                    </div>
                                    <div>
                                        <input type="text" name="km_addr1" id="addr1" size="50" placeholder="주소를 검색하세요." readonly>
                                    </div>
                                    <div>
                                        <input type="text" name="km_addr2" id="addr2" size="50" placeholder="상세주소를 입력하세요.">
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </section>
                    <div>
                        <input type="submit" class="join" value="회원가입">
                    </div>
                </form>
            </div>
        </main>
<jsp:include page="./_footer.jsp"></jsp:include>