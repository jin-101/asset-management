$(function(){
	const PATH = getContextPath();
	$(".equipMenuBtn").click(function(){
		location.href = PATH + "/equi/equiList.do"
	});
	
	$(".empMenuBtn").click(function(){
		location.href = PATH + "/emp/empList.do";
	});
})