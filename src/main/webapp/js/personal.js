var departmentstr = null	 ;

$(document).ready(function() {
	
	//加载部门信息到select标签
	inintDepartment()
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/userController/showUser.do',
		async : false,
		data : {},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var username = document.getElementById("usernameP");
				username.value = msg.user.userName;
				
				var usertype = document.getElementById("usertypeP");
				usertype.value =  msg.user.userType;
				
			   document.getElementById("departmentP").value =  msg.user.userDeptname;
				
				var tel = document.getElementById("telP");
				 tel.value = msg.user.userTelephone;
				
				var address = document.getElementById("addressP");
				address.value = msg.user.userAddress;
			}
		}
	});
});

//加载部门信息到select标签
function inintDepartment()
{
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/departmentController/showAllDepartment.do',
		async : false,
		data : {},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var departments = msg.departments;
				$.each(departments, function(key, val) {
					departmentstr += "<option>" + val.deptName + "</option>";
				});

			}
		}
	});
	$("#departmentP").empty;
	$("#departmentP").append(departmentstr);
}


//更改用户信息
$(document).ready(function() {
	
	$("#changeP").click(function (){
	     document.getElementById("usernameP").readOnly = false;
		// document.getElementById("departmentP").disabled= false;
		 document.getElementById("telP").readOnly = false;
	     document.getElementById("addressP").readOnly = false;
	});
});

//
$(document).ready(function() {
	
	$("#saveP").click(function (){
		
		var username = document.getElementById("usernameP").value ;
		var tel = document.getElementById("telP").value;
		var address =  document.getElementById("addressP").value;
		var department =  document.getElementById("departmentP").value;
		
		
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/StuMtrManageSys/userController/changeUserInfo.do',
			async : false,
			data : {
				userName:username,
				userDeptname:department,
				userTelephone:tel,
				userAddress:address
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					
					   document.getElementById("usernameP").readOnly = true;
					  // document.getElementById("departmentP").disabled= true;
					  document.getElementById("telP").readOnly = true;
					   document.getElementById("addressP").readOnly = true;
				}
				else{
					alert(msg.message) ;
				}
			}
		});
	});
});