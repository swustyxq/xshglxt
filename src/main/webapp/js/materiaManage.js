
var materials;
var pageindex = 1;
var pagenum;
var pagecontent = [];
var materialtypestr;
var departmentstr;
var mtrId;
window.onload = initpage();
function makepage() {
	var count = 1;
	pageindex = 1;
	pagecontent = [];
	$("#materials").empty();
	$("#page").empty();
	$
			.each(
					materials,
					function(key, val) {
						var t = 0;
						if (count % 8 != 0)
							t = Math.floor(count / 8) + 1;
						else
							t = Math.floor(count / 8);
						if (val.mtrName == null)
							val.mtrName = "";
						if (val.mtrColor == null)
							val.mtrColor = "";
						if (val.mtrSize == null)
							val.mtrSize = "";
						if (val.mtrStocknum == null)
							val.mtrStocknum = "";
						if (val.mtrTotalnum == null)
							val.mtrTotalnum = "";
						if (val.mtrType == null)
							val.mtrType = "";
						if (val.mtrDeptname == null)
							val.mtrDeptname = "";
						if (val.mtrImportance == null)
							val.mtrImportance = "";
						if (val.mtrPostil == null)
							val.mtrPostil = "";
						pagecontent[t] += "<tr class='info' ><td>" + count
								+ "</td><td>" + val.mtrName + "</td><td>"
								+ val.mtrColor + "</td><td>" + val.mtrSize
								+ "</td><td>" + val.mtrStocknum + "</td><td>"
								+ val.mtrTotalnum + "</td><td>" + val.mtrType
								+ "</td><td>" + val.mtrDeptname + "</td><td>"
								+ val.mtrImportance + "</td><td>"
								+ val.mtrPostil + "</td><td>";
						var operatestr = "<div class='btn-group'><button class='btn' >操作</button>"
								+ "<button data-toggle='dropdown' class='btn dropdown-toggle'>"
								+ "<span class='caret'></span></button>"
								+ "<ul class='dropdown-menu' >"
								+ "<li><a  data-toggle='modal' data-target='#updateModal' name='"
								+ "' onclick='javascript:initupdatamaterial("
								+ count
								+ ")'>修改</a></li>"
								+ "<li><a onclick='javascript:deletematerial("
								+ val.mtrId
								+ ")' >删除</a></li>"
								+ "</ul>"
								+ "</div>";
						$
								.ajax({
									type : "post",
									contentType : "application/x-www-form-urlencoded;charset=UTF-8",
									url : '/StuMtrManageSys/userController/showUser.do',
									async : false,
									data : {},
									dataType : 'json',
									success : function(msg) {
										if (msg.result == true) {
											if (msg.user.userType != "普通用户") {
												pagecontent[t] += operatestr;
											} else {
												document
														.getElementById("addmaterial").style.display = "none";
												document
														.getElementById("handler").style.display = "none";
											}
										}
									}
								});
						pagecontent[t] += "</tr>";
						count++;
					});
	if ((count - 1) % 8 == 0)
		pagenum = Math.floor((count - 1) / 8);
	else
		pagenum = Math.floor((count - 1) / 8) + 1;
	var pagestr;
	$("#materials").append(pagecontent[pageindex]);
	pagestr = "<li";
	/*
	 * if(pageindex==1) pagestr+="class='disabled'";
	 */
	var topagenum = 0;
	topagenum = pageindex - 1;
	pagestr += "><a href='javascript:lastpage()'>&laquo;</a></li>";
	for (var i = 1; i <= pagenum; i++) {
		pagestr += "<li";
		/*
		 * if(pageindex==i) pagestr+="class='active'";
		 */
		topagenum = pageindex + i - 1;
		pagestr += "><a href='javascript:topage(" + topagenum + ")'>" + i
				+ "</a></li>";
	}
	pagestr += "<li"
	/*
	 * if(pageindex==pagenum) pagestr+="class='disabled'";
	 */
	topagenum = pageindex + 1;
	pagestr += "><a href='javascript:nextpage()'>&raquo;</a></li>";
	$("#page").append(pagestr);
	var pagenotestr;
	pagenotestr =   "第" + pageindex + "页   "+"共" + pagenum + "页";
	$("#pagenote").empty().append(pagenotestr);
}
function initpage() {

	materials = null;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/materialController/showAllMaterial.do',
		async : false,
		data : {},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				materials = msg.materials;
				makepage();
			}
		}
	});

}
function nextpage() {
	if (pageindex < pagenum) {
		pageindex++;
		$("#materials").empty().append(pagecontent[pageindex]);
		var pagenotestr;
		pagenotestr =   "第" + pageindex + "页   "+"共" + pagenum + "页";
		$("#pagenote").empty().append(pagenotestr);
	}
}
function lastpage() {
	if (pageindex > 1) {
		pageindex--;
		$("#materials").empty().append(pagecontent[pageindex]);
		var pagenotestr;
		pagenotestr =   "第" + pageindex + "页   "+"共" + pagenum + "页";
		$("#pagenote").empty().append(pagenotestr);
	}
}
function topage(to) {
	if (pageindex != to && to >= 1 && to <= pagenum) {
		pageindex = to;
		$("#materials").empty().append(pagecontent[to]);
		var pagenotestr;
		pagenotestr =   "第" + pageindex + "页   "+"共" + pagenum + "页";
		$("#pagenote").empty().append(pagenotestr);
	}
}
function addmaterials() {
	var mtrColor = "", mtrDeptname = "", mtrImportance = "", mtrName = "", mtrPostil = "", mtrSize = "", mtrStocknum = "", mtrTotalnum = "", mtrType = "";
	mtrColor = document.getElementById("mtrColor").value;
	mtrDeptname = document.getElementById("mtrDeptname").value;
	mtrImportance = document.getElementById("mtrImportance").value;
	mtrName = document.getElementById("mtrName").value;
	mtrPostil = document.getElementById("mtrPostil").value;
	mtrSize = document.getElementById("mtrSize").value;
	mtrStocknum = document.getElementById("mtrStocknum").value;
	mtrTotalnum = document.getElementById("mtrTotalnum").value;
	mtrType = document.getElementById("mtrType").value;
	if (mtrName == "") {
		alert("请输入物资名称！");
		return;
	}
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/materialController/addMaterial.do',
		async : false,
		data : {
			mtrColor : mtrColor,
			mtrDeptname : mtrDeptname,
			mtrImportance : mtrImportance,
			mtrName : mtrName,
			mtrPostil : mtrPostil,
			mtrSize : mtrSize,
			mtrStocknum : mtrStocknum,
			mtrTotalnum : mtrTotalnum,
			mtrType : mtrType
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				alert(msg.message);
			} else {
				alert(msg.message);
			}
		}
	});
	initpage();
	$("#addModal").modal('hide');
}
function initselect() {
	materialtypestr = null;
	departmentstr = null;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/materialtypeController/showAllMaterialtype.do',
		async : false,
		data : {},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var materialtypes = msg.materialtypes;
				$.each(materialtypes, function(key, val) {
					if (val.typeName != null)
						materialtypestr += "<option>" + val.typeName
								+ "</option>";
				});

			}
		}
	});
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
}
function initaddmaterial() {
	initselect();
	$("#mtrType").empty();
	$("#mtrType").append(materialtypestr);
	$("#mtrDeptname").empty;
	$("#mtrDeptname").append(departmentstr);
}
function initupdatamaterial(count) {
	// console.log(materials[1]);
	initselect();
	$("#umtrType").empty();
	$("#umtrType").append(materialtypestr);
	$("#umtrDeptname").empty();
	$("#umtrDeptname").append(departmentstr);
	document.getElementById("umtrColor").value = materials[count - 1].mtrColor;
	document.getElementById("umtrDeptname").value = materials[count - 1].mtrDeptname;
	document.getElementById("umtrImportance").value = materials[count - 1].mtrImportance;
	document.getElementById("umtrName").value = materials[count - 1].mtrName;
	document.getElementById("umtrPostil").value = materials[count - 1].mtrPostil;
	document.getElementById("umtrSize").value = materials[count - 1].mtrSize;
	document.getElementById("umtrStocknum").value = materials[count - 1].mtrStocknum;
	document.getElementById("umtrTotalnum").value = materials[count - 1].mtrTotalnum;
	document.getElementById("umtrType").value = materials[count - 1].mtrType;
	mtrId = materials[count - 1].mtrId;
}
function updatamaterial() {
	var mtrColor = "", mtrDeptname = "", mtrImportance = "", mtrName = "", mtrPostil = "", mtrSize = "", mtrStocknum = "", mtrTotalnum = "", mtrType = "";
	mtrColor = document.getElementById("umtrColor").value;
	mtrDeptname = document.getElementById("umtrDeptname").value;
	mtrImportance = document.getElementById("umtrImportance").value;
	mtrName = document.getElementById("umtrName").value;
	mtrPostil = document.getElementById("umtrPostil").value;
	mtrSize = document.getElementById("umtrSize").value;
	mtrStocknum = document.getElementById("umtrStocknum").value;
	mtrTotalnum = document.getElementById("umtrTotalnum").value;
	mtrType = document.getElementById("umtrType").value;
	if (mtrName == "") {
		alert("请输入物资名称！");
		return;
	}
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/materialController/updateMaterial.do',
		async : false,
		data : {
			mtrId : mtrId,
			mtrColor : mtrColor,
			mtrDeptname : mtrDeptname,
			mtrImportance : mtrImportance,
			mtrName : mtrName,
			mtrPostil : mtrPostil,
			mtrSize : mtrSize,
			mtrStocknum : mtrStocknum,
			mtrTotalnum : mtrTotalnum,
			mtrType : mtrType
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				alert(msg.message);
				initpage();
			} else {
				alert(msg.message);
			}
		}
	});
	$("#updateModal").modal('hide');
}
function deletematerial(id) {
	if (!window.confirm("您确定要删除该物资？")) {
		return;
	}
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/materialController/deletMaterial.do',
		async : false,
		data : {
			mtrId : id
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				alert(msg.message);
				initpage();
			} else {
				alert(msg.message);
			}
		}
	});
}
function searchmaterialbytype() {
	var input, type;
	input = document.getElementById("materialsearchinput").value;
	type = document.getElementById("materialsearch").value;
	materials = null;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/materialController/searchMaterialByType.do',
		async : false,
		data : {
			input : input,
			type : type
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				materials = msg.materials;
				makepage();
			} else {
				alert(msg.message);
			}
		}
	});
}