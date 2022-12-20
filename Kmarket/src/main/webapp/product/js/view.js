/**
 * 
 */
 
 	$(document).ready(function(){

		// 배송 날짜 구하기
		
		let delivery = new Date();
		let arrival = $('.arrival');
		
		let day = delivery.getDay();
				
		if(day == 5){ // 금요일일 때
		
			delivery.setDate(delivery.getDate()+4);
			
		}else if(day == 6 || 0){ // 주말일 때
			
			delivery.setDate(delivery.getDate()+3);
			
		}else { // 평일일 때
			
			delivery.setDate(delivery.getDate()+2);
		}
		
		let d1 = ['일', '월', '화', '수', '목', '금', '토'];
		
		let dateFormat = (delivery.getMonth()+1) + '/' + delivery.getDate() + '('+ d1[delivery.getDay()] +')  도착예정';
		
		arrival.text(dateFormat);
		
		
		// 상품 수량 더하기
		$('.increase').click(function(){
			
			let num = $('input[name=num]').val();
			
			let count = parseInt(num) + 1;
			
			$('input[name=num]').attr('value', count);
			
			// 총 주문금액 
			let disprice = "${product.disprice}";
			let total = disprice * count;
			total = total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','); // 정규식을 사용하여 세 자릿수마다 , 를 넣기
			
			
			$('.total > span').text(total);
			
		});
		
		// 상품 수량 빼기
		$('.decrease').click(function(){
			
			let num = $('input[name=num]').val();
			
			if(num > 1){
			
				let count = parseInt(num) - 1;
				
				$('input[name=num]').attr('value', count);
				
				// 총 주문금액
				let disprice = "${product.disprice}";
				let total = disprice * count;
				total = total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
				
				$('.total > span').text(total);
			}
		
		});
		
		
		// 장바구니
		$('.cart').click(function(){
				
			let uid = "${sessUser.uid}";
			let prodNo = "${product.prodNo}";
			let count = $('input[name=num]').val();
			let price = "${product.price}";
			let discount = "${product.discount}";
			let point = "${product.point}";
			let delivery = "${product.delivery}";
			
			let jsonData = {
					
				"uid":uid,
				"prodNo":prodNo,
				"count":count,
				"price":price,
				"discount": discount,
				"point": point,
				"delivery":delivery
			}
			
			if(uid == "") {
				alert('로그인 후 물건을 장바구니에 담아주세요.');
				return;
			}

			
			$.ajax({
				url: '/Kmarket/product/addcart.do',
				method: 'POST',
				data: jsonData,
				dataType: 'json',
				success:function(data){
					
					if(data.result > 0) {
						
						let goCart = confirm('물건이 장바구니에 담겼습니다.\n장바구니로 이동하시겠습니까?'); 
						
						if(goCart){
							location.href = "/Kmarket/product/cart.do";
						}
						
					}else {
						
						alert('장바구니에 물건이 담기지 않았습니다.\n잠시 후 다시 시도해주세요. ');
					}
				}
			});
					
		});
		
		// 주문하기
		$('.order').click(function(){
			
			let uid = "${sessUser.uid}";
			let prodNo = "${product.prodNo}";
			let count = $('input[name=num]').val();
			
			let jsonData = {					
				"prodNo":prodNo,
				"count":count
			}
			
			if(uid == "") {
				alert('로그인 후 주문이 가능합니다.');
				return;
			}
			
			$.ajax({
				url: '/Kmarket/product/view.do',
				method: 'POST',
				data: jsonData,
				dataType:'json',
				success: function(data){
				
					if(data.result > 0) {
						location.href = "/Kmarket/product/order.do"
					}else{
						alert('주문하기를 실패하였습니다.\n잠시 후 다시 시도해주세요. ');
					}
				}
				
			});
					
		});

	});