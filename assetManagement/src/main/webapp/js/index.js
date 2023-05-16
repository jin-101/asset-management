function getContextPath() {
  var hostIndex = location.href.indexOf( location.host ) + location.host.length;
  return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}

function makeModal({
		text,
		textSize = 20, //px
		modalPadding = 50, //px
		r = 20, //px
		btnW = 100, //px
		btnH = 50, //px
		callback 
}){
	//모달 컨테이너 만들기
	const modalContainer = document.createElement("div");
	modalContainer.className = "checkModal"
	//모달컨테이너 안의 배경
	const bg = document.createElement("div");
		bg.style.width = "100%";
		bg.style.height = "100%";
		bg.style.position = "fixed";
		bg.style.top = 0;
		bg.style.left = 0;
		bg.style.background ="rgba(0,0,0,0.6)";
		bg.style.zIndex = 998;
	//모달컨테이너 안의 모달
	const modal = document.createElement("div");
		modal.style.position = "absolute";
		modal.style.transform = "translate(-50%,-50%)";
		modal.style.top = "50%";
		modal.style.left = "50%";
		modal.style.borderRadius = r + 'px'
		modal.style.background ="white";
		modal.style.zIndex = 999;
		modal.style.display ="flex";
		modal.style.justifyContent = "center";
		modal.style.alignItems = "center";
		
	//모달 구성요소(콘텐츠)
	const modalContnet = document.createElement("div");
		modalContnet.style.padding = modalPadding + "px";
	
	//모달콘텐츠 구성요소(text + button)
	const textSpan = document.createElement("span");
		textSpan.style.fontSize = textSize + "px";
		textSpan.style.textAlign = "center";
		textSpan.innerText = text;
	const btnDiv = document.createElement("div");
		btnDiv.style.display ="flex";
		btnDiv.style.justifyContent = "center";
		btnDiv.style.alignItems = "center";	
	const yesBtn = document.createElement("button");
		yesBtn.style.width = btnW + "px";
		yesBtn.style.height = btnH + "px";
		yesBtn.style.margin = '20px 20px 0';
		yesBtn.className = "btn btn-primary yesBtn";
		yesBtn.style.color = "white";
		yesBtn.innerText = "네"
	const noBtn = document.createElement("button");
		noBtn.style.width = btnW + "px";
		noBtn.style.height = btnH + "px";
		noBtn.style.margin = '20px 20px 0';
		noBtn.className = "btn btn-danger noBtn";
		noBtn.style.color = "white";
		noBtn.innerText = "아니오"
	
	//구성요소 append 시키기 (하위요소 부터 적용)
	btnDiv.append(yesBtn,noBtn);
	modalContnet.append(textSpan,btnDiv);
	modal.append(modalContnet);
	
	//modalContainer를 메인에 append
	const mainTag = document.querySelector("main");
	modalContainer.append(bg,modal);
	mainTag.append(modalContainer);
	
	
	//버튼 클릭 이벤트
	yesBtn.addEventListener('click',function(){
		yesBtn.removeEventListener('click',this);
		if(callback) callback();
	});
	noBtn.addEventListener('click',function(){
		modalContainer.remove();
	});
};