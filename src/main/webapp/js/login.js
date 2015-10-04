/**
 * 功能名称：登陆
 * 作者：Simon
 * 时间：2015.1.08
 */

$(document).ready(function (){
	
	document.onkeydown = function(e){    
	    var ev = document.all ? window.event : e;  
	    if(ev.keyCode==13) {    // 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发  
	        //要处理的事件  
	    	document.getElementById("loginBtn").click(); //调用登录按钮的登录事件  
	    }
	  };
	  
	$("#loginBtn").click(function (){
		

		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/StuMtrManageSys/userController/login.do',
			async : false,
			data : {
				username:username,
				password:password
			}, 
			dataType : 'json',
			success : function(msg) {			
				if (msg.result == true){
					window.location.href = "index.html";
				}
				else{
					 $("#SysHint").empty().append("<font color='red'>用戶名或密碼錯誤！</font>");
					 document.getElementById("SysHint").style.display = "block";
				}
			},error: function(msg){
			    alert("网络超时!");
			}
		});
	});
	
});

/*js捕获回车事件*/
function hideHint() {
	document.getElementById("SysHint").style.display = "none";
}
