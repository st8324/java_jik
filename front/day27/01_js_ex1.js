$(function(){
	$('input').change(function(){
		console.log(123);
		test()
	})
})
/**
 * 테스트용 함수
 * @param {string} str 콘솔에 출력할 문자열
 * @return {void} 없음
 */
function test(str){
	console.log(str);
}

