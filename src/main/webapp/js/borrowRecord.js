/**
 * @author LJY
 * 
 */
var details;
var situId = null;
var detailId;
var pageindex = 1;
var pagenum;
var pagecontent = [];
var situDescription;
var detailsId;
window.onload = initpage();
function makepage() {
	var count = 1;
	pageindex = 1;
	pagecontent = [];
	$("#details").empty();
	$("#page").empty();
	$.each(details, function(key, val) {
		var t = 0;
		if (count % 8 != 0)
			t = Math.floor(count / 8) + 1;
		else
			t = Math.floor(count / 8);
		var inspStatestr = "", returnStatestr = "";
		if (val.inspState == 0)
			inspStatestr = "未审核";
		else if (val.inspState == 1)
			inspStatestr = "审核通过";
		else if (val.inspState == 2)
			inspStatestr = "审核未通过";
		if (val.returnState == 0)
			returnStatestr = "未归还";
		else if (val.returnState == 1)
			returnStatestr = "归还";

		pagecontent[t] += "<tr class='info' ><td>" + count + "</td><td>"
				+ val.mtrName + "</td><td>" + val.mtrType + "</td><td>"
				+ val.applyNum + "</td><td>" + val.applyerName + "</td><td>"
				+ val.applyerloginName + "</td><td>"
				+ val.applyTime.substring(0, 10) + "</td><td>" + inspStatestr
				+ "</td><td>" + returnStatestr + "</td><td>";

		pagecontent[t] += "</tr>"
		count++;
	});
	if ((count - 1) % 8 == 0)
		pagenum = Math.floor((count - 1) / 8);
	else
		pagenum = Math.floor((count - 1) / 8) + 1;
	var pagestr;
	$("#details").append(pagecontent[pageindex]);
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
}
function initpage() {
	details = null;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/detailController/findAllDetail.do',
		async : false,
		data : {},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				details = msg.details;
				makepage();
			}
		}
	});

}
function nextpage() {
	if (pageindex < pagenum) {
		pageindex++;
		$("#details").empty().append(pagecontent[pageindex]);
	}
}
function lastpage() {
	if (pageindex > 1) {
		pageindex--;
		$("#details").empty().append(pagecontent[pageindex]);
	}
}
function topage(to) {
	if (pageindex != to && to >= 1 && to <= pagenum) {
		pageindex = to;
		$("#details").empty().append(pagecontent[to]);
	}
}
function initupdataDetail(count) {
	detailId = details[count - 1].detailId;

	situId = details[count - 1].detailReturnsituation;
	document.getElementById("mtrName").value = details[count - 1].mtrName;
	document.getElementById("mtrType").value = details[count - 1].mtrType;
	document.getElementById("applyNum").value = details[count - 1].applyNum;
	var str = "";
	if (details[count - 1].inspState == 0)
		str = "未审核";
	else if (details[count - 1].inspState == 1)
		str = "审核通过";
	else if (details[count - 1].inspState == 2)
		str = "审核未通过";
	document.getElementById("inspState").value = str;
	if (details[count - 1].inspState == 2)
		document.getElementById("rejectReason").readOnly = false;
	document.getElementById("rejectReason").details = users[count - 1].rejectReason;
	if (details[count - 1].returnState == 0)
		str = "未归还";
	else if (details[count - 1].returnState == 1)
		str = "归还";

	document.getElementById("returnState").value = str;
	if (details[count - 1].returnState == 0
			|| details[count - 1].returnState == 1)
		document.getElementById("rejectReason").readOnly = false;
	document.getElementById("detailPostil").value = details[count - 1].detailPostil;
}
function updatadetail() {
	var rejectReason, detailPostil;
	if (situId == null)
		situId = -1;
	rejectReason = document.getElementById("rejectReason").value;
	detailPostil = document.getElementById("detailPostil").value;
	situDescription = document.getElementById("situDescription").value;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/detailController/updateDetail.do',
		async : false,
		data : {
			detailId : detailId,
			rejectReason : rejectReason,
			detailPostil : detailPostil,
			situDescription : situDescription,
			situId : situId
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
}
function deletedetail(id) {
	if (!window.confirm("您确定要删除该条记录？")) {
		return;
	}
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/detailController/deleteDetail.do',
		async : false,
		data : {
			detailId : id
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
	details = null;
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
				details = msg.materials;
				makepage();
			} else {
				alert(msg.message);
			}
		}
	});
}