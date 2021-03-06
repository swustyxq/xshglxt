/*
 * 
 * Function：物资借还记录
 * */

/*存放所有借还记录的物资信息*/
var allReturnRecords;
/*存放当前审核的记录位置*/
var curInspectRecordPos=0;

window.onload=function(){
	UpdateDetailRecords();
	if (allReturnRecords.length != 0){
		InitPage();
	}
	init();
}

function UpdateDetailRecords(){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/detailController/findAllRecords.do',
		async : false,
		data : {},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				allReturnRecords = msg.list;
			}
		},
		error : function(msg) {
			alert("网络超时!");
		}
	});
}

function InitPage(){
	showPage(1);
	var pageStr="<li><a href='#'>&laquo;</a></li>";
	var totalPage=0;
	if (allReturnRecords[0].recordPos.length % 5 == 0){
		totalPage = (allReturnRecords[0].recordPos.length/5|0)-1;
	}else{
		totalPage = allReturnRecords[0].recordPos.length/5|0;
	}
	for (var i=0;i <= totalPage;i++){
		pageStr += "<li><a href='javascript:showPage("+(i+1)+")'>"+(i+1)+"</a></li>";
	}
	pageStr += "<li><a href='#'>&raquo;</a></li>"
		+ "<p>总页数："+(totalPage+1)+"</p>";
	$("#pageIndex").empty().append(pageStr);
}

function showPage(index){
	var key=5*(index-1)+1;
	var strList="";
	for (var i=0;i < 5;i++){
		if (5*(index-1)+i < allReturnRecords[0].recordPos.length){
			strList += "<tr>"
				+ "<td>"+key+"</td>"
				+ "<td>"+allReturnRecords[allReturnRecords[0].recordPos[5*(index-1)+i]].applyerName+"</td>"
				+ "<td>"+allReturnRecords[allReturnRecords[0].recordPos[5*(index-1)+i]].applerDept+"</td>"
				+ "<td>"+allReturnRecords[allReturnRecords[0].recordPos[5*(index-1)+i]].applyTurnTime+"</td>"
				+ "<td><button type='submit' class='btn btn-success btn-xs' " +
						"onclick='inspect("+allReturnRecords[0].recordPos[5*(index-1)+i]+")'>详情</button></td>";
				key++;
		}else{
			break;
		}	
	}
	$("#neededCheckMtr").empty().append(strList);
}
function inspect(recordPos){
	curInspectRecordPos = recordPos;
	var applyerInfo="";
	applyerInfo += "<tr>" + "<td><b>申请人</b> </td> <td>" + allReturnRecords[recordPos].applyerName + " </td>"
	+ "<td><b>所属部门</td></b><td>" + allReturnRecords[recordPos].applerDept + "</td>" + "</tr>"
	+ "<tr>" + "<td ><b>申请时间</b></td> <td colspan='3'>" + allReturnRecords[recordPos].applyTurnTime + "</td></tr>>"
	$("#applyerInfo").empty().append(applyerInfo);
	var detailStr="";
	var index = 1;
	for (var i=0;i < allReturnRecords.length;i++){
		if (allReturnRecords[i].recordId == allReturnRecords[recordPos].recordId){
			detailStr += "<tr><td>"+index+"</td>"
				+ "<td><textarea readonly style='resize:none;height:40px;'>"+allReturnRecords[i].mtrInfo+"</textarea></td>"
				+ "<td>"+allReturnRecords[i].detailMtrnum+"</td>"
				+ "<td><textarea readonly style='resize:none;height:40px;width:80px'>"+allReturnRecords[i].detailApplyreason+"</textarea></td></tr>";
			index++;
		}
	}
	$("#detailMtr").empty().append(detailStr);
	$("#detailModal").modal('show');
}

function passInspect(detailId){
	if (!confirm("您确定要通过该物资申请？")){
		return;
	}
	
	checkDetail(detailId,true,"");
}

function turnToReject(detailId){
	var str="";
	str += "<td colspan='5'><p style='color:red'>驳回理由<input id='rejectReason' type='text' class='form-control'>"
					+		"<button type='button' class='btn btn-danger'"
					+ "onclick='reject("+detailId+")'>驳回</button></p></td>";
	$("#rejectObj").empty().append(str);
	document.getElementById("rejectObj").style.display = "table-row";
}

function reject(detailId){
	if (!confirm("您确定要驳回该物资申请？")){
		document.getElementById("rejectObj").style.display = "none";
		return;
	}
	var rejectReson="";
	rejectReason = document.getElementById("rejectReason").value;
	checkDetail(detailId, false, rejectReason);
}

function checkDetail(detailId,result,rejectReason){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/detailController/checkDetail.do',
		async : false,
		data : {
			detailId:detailId,
			result:result,
			rejectReason:rejectReason
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				if (result == false){//审核不通过，将物资数量恢复
					var mtrId = 0, mtrNum = 0;
					for (var i = 0;i < allReturnRecords.length;i++){
						if (allReturnRecords[i].detailId == detailId){
							mtrId = allReturnRecords[i].mtrId;
							mtrNum = allReturnRecords[i].applyNum + allReturnRecords[i].stockNum;
							break;
						}
					}
					$.ajax({
						type : "post",
						contentType : "application/x-www-form-urlencoded;charset=UTF-8",
						url : '/StuMtrManageSys/materialController/updateMtrNum.do',
						async : false,
						data : {
							mtrId:mtrId,
							mtrNum:mtrNum
						},
						dataType : 'json',
						success : function(msg) {
							if (msg.result == true) {
								document.getElementById("rejectObj").style.display = "none";
							}
						},
						error : function(msg) {
							alert("网络超时!");
						}
					});
				}
				var str = "<font color='red'>操作成功</font>";
				UpdateDetailRecords();
				inspect(curInspectRecordPos);
				$("#SysHint").empty().append(str);
				$("#SysWindow").modal('show');
			}
		},
		error : function(msg) {
			alert("网络超时!");
		}
	});
}
//////////***************************************************

var details;
var pageindex = 1;
var pagenum;
var pagecontent = [];
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
function init() {
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
