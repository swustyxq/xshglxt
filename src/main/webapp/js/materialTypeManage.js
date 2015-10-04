var materialTypes;
var zone;
var zones;
var pageindex = 1;
var pagenum;
var pagecontent = [];
var materialtype;
$(document).ready(function() {
	initpage();
});

function makepage() {
	var count = 1;
	pageindex = 1;
	pagecontent = [];
	$("#materialTypes").empty();
	$("#page").empty();
	$
			.each(
					materialTypes,
					function(key, val) {
						var t = 0;
						if (count % 8 != 0)
							t = Math.floor(count / 8) + 1;
						else
							t = Math.floor(count / 8);
						pagecontent[t] += "<tr class='info' ><td>" + count
								+ "</td><td>" + val.typeName + "</td><td>"
								+ val.zoneName + "</td><td>";
						var operatestr = "<div class='btn-group'><button class='btn' >操作</button>"
								+ "<button data-toggle='dropdown' class='btn dropdown-toggle'>"
								+ "<span class='caret'></span></button>"
								+ "<ul class='dropdown-menu'>"
								+ "<li><a  data-toggle='modal' data-target='#updateModal' name='"
								+ "' onclick='javascript:initupdatamaterialtype("
								+ count
								+ ")'>修改</a></li>"
								+ "<li><a onclick='javascript:deletematerialtype("
								+ count
								+ ")' >删除</a></li>"
								+ "</ul>"
								+ "</div>";
						pagecontent[t] += operatestr;
						pagecontent[t] += "</tr>"
						count++;
					});
	if ((count - 1) % 8 == 0)
		pagenum = Math.floor((count - 1) / 8);
	else
		pagenum = Math.floor((count - 1) / 8) + 1;
	var pagestr;
	$("#materialTypes").append(pagecontent[pageindex]);
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
	materialTypes = null;
	$
			.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/StuMtrManageSys/materialtypeController/showAllMaterialtypeAndZone.do',
				async : false,
				data : {},
				dataType : 'json',
				success : function(msg) {
					if (msg.result == true) {
						materialTypes = msg.materialtypeAndZones;
						makepage();
					}
				}
			});

}

function nextpage() {
	if (pageindex < pagenum) {
		pageindex++;
		$("#materialTypes").empty().append(pagecontent[pageindex]);
		var pagenotestr;
		pagenotestr =   "第" + pageindex + "页   "+"共" + pagenum + "页";
		$("#pagenote").empty().append(pagenotestr);
	}
}
function lastpage() {
	if (pageindex > 1) {
		pageindex--;
		$("#materialTypes").empty().append(pagecontent[pageindex]);
		var pagenotestr;
		pagenotestr =   "第" + pageindex + "页   "+"共" + pagenum + "页";
		$("#pagenote").empty().append(pagenotestr);
	}
}
function topage(to) {
	if (pageindex != to && to >= 1 && to <= pagenum) {
		pageindex = to;
		$("#materialTypes").empty().append(pagecontent[to]);
		var pagenotestr;
		pagenotestr =   "第" + pageindex + "页   "+"共" + pagenum + "页";
		$("#pagenote").empty().append(pagenotestr);
	}
}
function addmaterialTypes() {
	var mtrType = "", mtrZone = "";
	mtrType = document.getElementById("mtrType").value;
	mtrZone = document.getElementById("mtrZone").value;
	if (mtrType == "") {
		alert("请输入物资类型名称！");
		return;
	}
	var zoneId;
	$.each(zones, function(key, val) {
		if (val.zoneName == mtrZone) {
			zoneId = val.zoneId;
		}
	});
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/materialtypeController/addMaterialtype.do',
		async : false,
		data : {
			mtrType : mtrType,
			zoneId : zoneId
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				alert(msg.message);
				initpage();
			} else {
				alert(msg.message);
				return;
			}
		}
	});
	initpage();
	$("#addModal").modal('hide');
}
function initselect() {
	// materialtypestr = null;
	zone = null;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/zoneController/showAllZone.do',
		async : false,
		data : {},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				zones = msg.zones;
				$.each(zones, function(key, val) {
					zone += "<option>" + val.zoneName + "</option>";
				});

			}
		}
	});
}
function initaddmaterialtype() {
	initselect();
	$("#mtrZone").empty();
	$("#mtrZone").append(zone);
}
function initupdatamaterialtype(count) {
	// console.log(materials[1]);
	initselect();
	$("#umtrZone").empty();
	$("#umtrZone").append(zone);
	document.getElementById("umtrType").value = materialTypes[count - 1].typeName;
	document.getElementById("umtrZone").value = materialTypes[count - 1].zoneName;
	materialtype = materialTypes[count - 1].typeName;
}
function updatamaterialtype() {
	var mtrType = "", mtrZone = "";
	mtrType = document.getElementById("umtrType").value;
	mtrZone = document.getElementById("umtrZone").value;
	var zoneId;
	$.each(zones, function(key, val) {
		if (val.zoneName == mtrZone) {
			zoneId = val.zoneId;
		}
	});
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/materialtypeController/updateMaterialtype.do',
		async : false,
		data : {
			pretypename : materialtype,
			typename : mtrType,
			zoneid : zoneId
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
function addzone() {
	var zoneName = document.getElementById("zonename").value;
	if (zoneName == "") {
		alert("请输入区域名称！");
		return ;
	}
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/zoneController/addZone.do',
		async : false,
		data : {
			zoneName : zoneName
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
	$("#addZoneModal").modal('hide');
}
function deletematerialtype(count) {
	var typeName = materialTypes[count - 1].typeName;
	if (!window.confirm("您确定要删除该物资？")) {
		return;
	}
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/materialtypeController/deletMaterialtype.do',
		async : false,
		data : {
			mtrType : typeName
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