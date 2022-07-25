/**
		 * 왼쪽으로 rolling
		 * 
		 * @param {string} parentSelector 부모 선택자
		 * @param {string} childSelector 자식 선택자
		 * @param {number} animateTime 애니메이션 실행 시간
		 * @param {boolean} left 왼쪽이면 true, 오른쪽이면 false
		 * @return {void} 없음
		 * */
function toLeftOrRight(parentSelector, childSelector, animateTime, left){
	let width = -$(childSelector).first().width() + 'px';
	if(left)
		$(childSelector).first().animate(
				{
					'margin-left': width
				},
				animateTime , 
				function(){
					$(this).detach()
								.removeAttr('style')
								.appendTo(parentSelector);
				}
			)
	else
		$(childSelector)
			.last()
			.css('margin-left', width)
			.detach()
			.prependTo(parentSelector)
			.animate(
				{
					'margin-left': '0px'
				},
				animateTime
			)
}

/**
 * 위로 rolling
 * 
 * @param {string} parentSelector 부모 선택자
 * @param {string} childSelector 자식 선택자
 * @param {number} animateTime 애니메이션 실행 시간
 * @return {void} 없음
 * */
function toUp(parentSelector, childSelector, animateTime){
	let height = -$(childSelector).first().height() + 'px';
	$(childSelector).first().animate(
			{
				'margin-top': height
			},
			animateTime , 
			function(){
				$(this).detach()
							.removeAttr('style')
							.appendTo(parentSelector);
			}
		)
}

