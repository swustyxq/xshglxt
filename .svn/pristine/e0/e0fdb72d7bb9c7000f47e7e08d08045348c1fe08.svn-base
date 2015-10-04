$(document).ready(function() {

	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/userController/showUser.do',
		async : false,
		data : {},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var url = window.location.href;
				var curPage = url.slice(getRootPath().length+6);
				var str = "<li class='nav-header'>导航</li> ";
				if (curPage == "index.html"){
					str += "<li  class='active'><a href = 'index.html'><i class='icon-home'></i> 首页</a></li>";
				}else{
					str += "<li><a href = 'index.html'><i class='icon-home'></i> 首页</a></li>";
				}
				if (curPage == "material.html"){
					str += "<li  class='active'><a href = 'material.html'><i class='icon-list'></i> 物资列表</a></li>";
				}else{
					str += "<li><a href = 'material.html'><i class='icon-list'></i> 物资列表</a></li>";
				}
				if (msg.user.userType != "普通用户"){
					if (curPage == "checkMaterial.html"){
						str += "<li  class='goodsND systemND active'><a href = 'checkMaterial.html'><i class='icon-time'></i>审核物资</a></li>";
					}else{
						str += "<li class='goodsND systemND'><a href = 'checkMaterial.html'><i class='icon-time'></i>审核物资</a></li>";
					}
				}
				if (msg.user.userType != "普通用户"){
					if (curPage == "borroweRecord.html"){
						str += "<li  class='goodsND systemND active'><a href = 'borroweRecord.html'><i class='icon-pencil'></i>借还记录</a></li>";
					}else{
						str += "<li class='goodsND systemND'><a href = 'borroweRecord.html'><i class='icon-pencil'></i>借还记录</a></li>";
					}
				}
				if (msg.user.userType == "普通用户"){
					if (curPage == "applyMaterial.html"){
						str += "<li  class='commonND active'><a href = 'applyMaterial.html'><i class='icon-edit'></i>申请物资</a></li>";
					}else{
						str += "<li class='commonND'><a href = 'applyMaterial.html'><i class='icon-edit'></i>申请物资</a></li>";
					}
				}
				if (msg.user.userType != "普通用户"){
					if (curPage == "materialType.html"){
						str += "<li  class='systemND active'><a href = 'materialType.html'><i class='icon-book'></i>类型管理</a></li>";
					}else{
						str += "<li class='systemND'><a href = 'materialType.html'><i class='icon-book'></i>类型管理</a></li>";
					}
				}
				if (msg.user.userType == "高级管理员"){
					if (curPage == "userManagement.html"){
						str += "<li  class='systemND active'><a href = 'userManagement.html'><i class='icon-user'></i>用户管理</a></li>";
					}else{
						str += "<li class='systemND'><a href = 'userManagement.html'><i class='icon-user'></i>用户管理</a></li>";
					}
				}
				str += "<li class='nav-header'>个人中心</li>";
				
				if (msg.user.userType == "普通用户"){
					if (curPage == "borroweRecord.html"){
						str += "<li  class='systemND active'><a href = 'borroweRecord.html'><i class='icon-pencil'></i>借还记录</a></li>";
					}else{
						str += "<li class='systemND'><a href = 'borroweRecord.html'><i class='icon-pencil'></i>借还记录</a></li>";
					}
				}
				if (curPage == "personalData.html"){
					str += "<li  class='systemND active'><a href = 'personalData.html'><i class='icon-cog'></i>我的资料</a></li>";
				}else{
					str += "<li class='systemND'><a href = 'personalData.html'><i class='icon-cog'></i>我的资料</a></li>";
				}
				str += "<li onclick='changePsw()'><a data-toggle='modal' data-target='#chagpwdMdl'><i class='icon-lock'></i>修改密码</a></li>"
					+ "<li class='divider'></li><li class='nav-header'><a>帮助</a></li>";
				if (curPage == "instruction.html"){
					str += "<li  class='systemND active'><a href = 'instruction.html'><i class='icon-blue icon-question-sign'></i>使用说明</a></li>";
				}else{
					str += "<li class='systemND'><a href = 'instruction.html'><i class='icon-blue icon-question-sign'></i>使用说明</a></li>";
				}		
				if (curPage == "systemDesc.html"){
					str += "<li  class='systemND active'><a href = 'systemDesc.html'><i class='icon-exclamation-sign'></i>系统说明</a></li>";
				}else{
					str += "<li class='systemND'><a href = 'systemDesc.html'><i class='icon-exclamation-sign'></i>系统说明</a></li>";
				}
				if (curPage == "friendlyLinks.html"){
					str += "<li  class='systemND active'><a href = 'friendlyLinks.html'><i class='icon-plane'></i>友情链接</a></li>";
				}else{
					str += "<li class='systemND'><a href = 'friendlyLinks.html'><i class='icon-plane'></i>友情链接</a></li>";
				}			
						
				$("#navigation").empty().append(str);
				$("#username").empty().append("@" + msg.user.userName);
				
				var passWordModal="";
				passWordModal += "<div class='modal fade' id='chagpwdMdl' tabindex='-1' role='dialog'\
				aria-labelledby='myModalLabel' aria-hidden='true'>\
				<div class='modal-dialog'>\
					<div class='modal-content'>\
						<div class='modal-header'>\
							<button type='button' class='close' data-dismiss='modal'>\
								<span aria-hidden='true'>×</span><span class='sr-only'></span>\
							</button>\
						</div>\
						<div class='modal-body'>\
							<div class='control-group'>\
								<center><div style='color: #333; font-size: 14px; line-height: 20px; padding: 8px 0 12px 0;'><span id='chgpUsnm'></span></div>\
									<input id='oldassword' placeholder='原密码' type='password'\
										maxLength='16' /><br> <input id='newPassword'\
										placeholder='新密码' type='password' maxLength='16' /><br> <input\
										id='confirmPassword' placeholder='确认密码' type='password'\
										maxLength='16' /><br>\
								</center>\
							</div>\
						</div>\
						<div class='modal-footer'>\
							<button type='button' class='btn btn-default'\
								data-dismiss='modal'>取消</button>\
							<button type='button' class='btn btn-primary' id='savePSW' onclick='savePSW()'>保存</button>\
						</div>\
					</div>\
				</div>\
			</div>";
			var div = document.createElement("div");
			div.innerHTML = passWordModal;
			document.body.appendChild(div);
			/*document.getElementById("changePsw").innerHTML = passWordModal;*/
		/*	$("#changePsw").empty().append(passWordModal);*/
			}else{
				window.location.href = "login.html";
			}
		}
	});
});
function logout() {
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/userController/logout.do',
		async : false,
		data : {},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				window.location.href = "login.html";
			}
		},
		error : function(msg) {
			alert("网络超时!");
		}
	});
}

function changePsw() {
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/userController/showUser.do',
		async : false,
		data : {},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var str = msg.user.userName;
				$("#chgpUsnm").empty().append(str);
			}
		}
	});
}

function savePSW() {

	var OldPSW = document.getElementById("oldassword").value;
	var NewPSW = document.getElementById("newPassword").value;
	var ConfirmPSW = document.getElementById("confirmPassword").value;
	if (OldPSW.length == 0) {
		alert("密码不能为空")
		return;
	}
	if (NewPSW.length == 0) {
		alert("新密码不能为空")
		return;
	}
	if (ConfirmPSW.length == 0) {
		alert("确认密码不能为空")
		return;
	}
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/userController/changePSW.do',
		async : false,
		data : {
			OldPSW : OldPSW,
			NewPSW : NewPSW,
			ConfirmPSW : ConfirmPSW,
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				$("#chagpwdMdl").modal('hide');
			}
			var str = msg.message;
			$("#SysHint").empty().append(str);
			$("#SysWindow").modal('show');
		}
	});
}

//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}