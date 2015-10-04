/**
 * 功能名称：申请物资加载用户信息
 * 作者：余方焱
 * 时间：2015.1.08
 */

var selectMtrs;
/*定义用户申请物资的数量*/
var mtrCount = 0; 
/*定义缓存列表存储用户当前选定的物资的名称*/
var curMtrName=[];
/*定义缓存列表存储用户当前选定的物资的id*/
var curMtrId=[];
/*定义缓存列表存储用户当前选定的物资的库存*/
var curMtrStockNum=[];

$(document).ready(
		function() {
			$.ajax({
				type : "post",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url : '/StuMtrManageSys/userController/showUser.do',
				async : false,
				data : {},
				dataType : 'json',
				success : function(msg) {
					if (msg.result == true) {

						var str = "<tr>" + "<td><b>用户名</b> </td> <td>" + msg.user.userName + " </td>"
								+ "<td>所属部门</td> <td>" + msg.user.userDeptname + "</td>" + "</tr>"

								+ "<tr>" + "<td><b>联系电话</b></td> <td>" + msg.user.userTelephone + "</td>"
								+ "<td>寝室号</td> <td>" + msg.user.userAddress + "</td>" + "</tr>";
						$("#userinfo").append(str);
					}
				},
				error : function(msg) {
					alert("网络超时!");
				}
			});
		});

function search() {
	mtrCount = 0;//每次查询，将已选物资数量清空
	var mtrType = document.getElementById("mtrType").value;
	var mtrDept = document.getElementById("department").value;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/materialController/findMtrByDeptAndType.do',
		async : false,
		data : {
			mtrType : mtrType,
			mtrDept : mtrDept
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				selectMtrs = msg.materials;
			}
		},
		error : function(msg) {
			alert("网络超时!");
		}
	});
	InitPage();
	/*<li><a href="#">&laquo;</a></li>
	<li><a href="#">&raquo;</a></li>*/
}

/*初始化第一页*/
function InitPage(){
	showPage(1,false);
	var pageStr="<li><a href='#'>&laquo;</a></li>";
	var totalPage=0;
	if (selectMtrs.length % 5 == 0){
		totalPage = (selectMtrs.length/5|0)-1;
	}else{
		totalPage = selectMtrs.length/5|0;
	}
	for (var i=0;i <= totalPage;i++){
		pageStr += "<li><a href='javascript:showPage("+(i+1)+",true)'>"+(i+1)+"</a></li>";
	}
	pageStr += "<li><a href='#'>&raquo;</a></li>"
		+ "<p>总页数："+(totalPage+1)+"</p>";
	$("#pageIndex").empty().append(pageStr);
}

function showPage(index,isSave){
	//换页前先保存当前页选中的物资信息
	if (isSave == true){
		saveCurMtr();
	}
	var key=5*(index-1)+1;
	var strList="";
	for (var i=0;i < 5;i++){
		if (5*(index-1)+i < selectMtrs.length){
			strList += "<tr>" + "<td>" + key + "</td>" + "<td>" + selectMtrs[5*(index-1)+i].mtrName + "</td>" + "<td>"
			+ selectMtrs[5*(index-1)+i].mtrStocknum + "</td>" + "<td>" + "尺寸:" + selectMtrs[5*(index-1)+i].mtrSize + " 颜色:" +selectMtrs[5*(index-1)+i].mtrColor
			+ "</td>" + "<td>" + selectMtrs[5*(index-1)+i].mtrDeptname + "</td>";
				key++;
			/*判断当前物资是否之前已经选中*/
			var flag = false;
			for (var j = 0;j < mtrCount;j++){
				if (curMtrId[j] == selectMtrs[5*(index-1)+i].mtrId){
					flag = true;
					strList +=  "<td><input name='box' value='" + selectMtrs[5*(index-1)+i].mtrName
					+ " " + selectMtrs[5*(index-1)+i].mtrId + " "+selectMtrs[5*(index-1)+i].mtrStocknum+"' type='checkbox' checked='true'></td>" + "</tr>";
				}
			}
			if (flag == false){
				strList +=  "<td><input name='box' value='" + selectMtrs[5*(index-1)+i].mtrName
				+ " " + selectMtrs[5*(index-1)+i].mtrId +  " "+selectMtrs[5*(index-1)+i].mtrStocknum + "' type='checkbox'></td>" + "</tr>";
			}
		}else{
			break;
		}	
	}
	$("#neededMtr").empty().append(strList);
}

/*保存当前页用户选中的物资到缓存列表中*/
function saveCurMtr(){
	var box = document.getElementsByName('box');
	for ( var i = 0; i < box.length; i++) {
		if (box[i].checked) { // 判断复选框是否选中
			var y = box[i].value;
			var m = y.split(" ");
			if (judge(m[1]) == true){
				continue;
			}
			curMtrName[mtrCount] = m[0];
			curMtrId[mtrCount] = m[1];
			curMtrStockNum[mtrCount++] = m[2];
		}else{
			var y = box[i].value;
			var m = y.split(" ");
			if (judge(m[1]) == true){
				removeOne(m[1]);
			}
		}
	}
}

/*判断该物资id是否已经在缓存列表中*/
function judge(mtrId){
	for (var i = 0;i < mtrCount;i++){
		if (curMtrId[i] == mtrId){
			return true;
		}
	}
	return false;
}

/*从缓存列表中移除一个*/
function removeOne(mtrId){
	for (var i = 0;i < mtrCount;i++){
		if (curMtrId[i] == mtrId){
			for (var j = i; j < mtrCount-1;j++){
				curMtrStockNum[j] = curMtrStockNum[j+1];
				curMtrName[j] = curMtrName[j+1];
				curMtrId[j] = curMtrId[j+1];
			}
			mtrCount--;
			break;
		}
	}
}

/* 确定用户加入的物资*/
function sureMtr() {
	saveCurMtr();
	var selectedMtr = "";
	var index = 1;
	for ( var i = 0; i < mtrCount; i++) {
			selectedMtr += "<tr>" 
				+ "<td >" + index + "</td>" 
				+ "<td >" + curMtrName[i] + "</td>" 
				+ "<td ><div class='form-group'>\
          <input style='width: 50px;' type='text' class='form-control' name='mtrNum' onblur='testApplyNum("+i+")'>\
        </div></td>"
				+  "<td ><div class='form-group'>\
		          <input type='text' style='width: 400px;' class='form-control' name='mtrPostil'>\
		        </div></td>" 
		        +		"<td style='display:none;'><input  name='mtrIdArray' value='"+curMtrId[i]+"'/></td>" +
		        		"<td style='display:none;'><input  name='mtrStockNumArray' value='"+curMtrStockNum[i]+"'/></td></tr>";
			index++;
	}
	$("#selectedMtr").empty().append(selectedMtr);
	var mtrIds = document.getElementsByName("mtrIdArray");
}

function commit(){
	if (mtrCount == 0){
		$("#SysHint").empty().append("<font color='red'>请先选择您要申请的物资</font>");
		$("#selectedMtr").empty();
		$("#SysWindow").modal('show');
		return;
	}
	if (!window.confirm("您确定要提交申请表？")){
		return;
	}
	var recordId = 0;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/recordController/applyRecord.do',
		async : false,
		data : {
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				recordId = msg.detailId;
			}
		},
		error : function(msg) {
			alert("网络超时!");
		}
	});
	
	var mtrNum = document.getElementsByName("mtrNum");
	var mtrPostil = document.getElementsByName("mtrPostil");
	var mtrIds = document.getElementsByName("mtrIdArray");
	var flag = false;//标记多条物资申请是否成功
	for (var i = 0;i < mtrNum.length;i++){
		$.ajax({
			type : "post",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			url : '/StuMtrManageSys/detailController/applyDetail.do',
			async : false,
			data : {
				detailRecordid:recordId,
				detailMtrid:mtrIds[i].value,
				detailMtrnum:mtrNum[i].value,
				MtrPostil:mtrPostil[i].value
			},
			dataType : 'json',
			success : function(msg) {
				if (msg.result == true) {
					flag = true;
				
				}else{
					flag = false;
				}
			},
			error : function(msg) {
				alert("网络超时!");
			}
		});
	}
	if (flag == true){
		var str = "<font color='red'>提交申请成功</font>";
	}else{
		var str = "<font color='red'>提交申请失败</font>";
	}
	$("#SysHint").empty().append(str);
	$("#selectedMtr").empty();
	$("#SysWindow").modal('show');
}

/*验证申请数量是否符合要求*/
function testApplyNum(index){
	var mtrIds = document.getElementsByName("mtrNum");
	
	var reg = /^\+?[1-9][0-9]*$/;
	if (!reg.test(mtrIds[index].value)) {
		var str = "<font color='red'>请输入一个正整数</font>";
		$("#SysHint").empty().append(str);
		$("#SysWindow").modal('show');
		return;
	}
	if (parseInt(mtrIds[index].value) > parseInt(curMtrStockNum[index]) ){
		var str = "<font color='red'>第"+(index+1)+"个物资申请数量超过库存</font>";
		$("#SysHint").empty().append(str);
		$("#SysWindow").modal('show');
	}
}

//初始化搜索条件
function InitOptions(){
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/materialtypeController/showAllMaterialtype.do',
		async : false,
		data : {
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var str = "<option>全部</option>";
				$.each(msg.materialtypes,function(key,val){
					if (val.typeName != "其它"){
						str +=  "<option>"+val.typeName+"</option>";
					}
				});
				str += "<option>其它</option>";
				$("#mtrType").empty().append(str);
			}
		},
		error : function(msg) {
			alert("网络超时!");
		}
	});
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/StuMtrManageSys/departmentController/showAllDepartment.do',
		async : false,
		data : {
		},
		dataType : 'json',
		success : function(msg) {
			if (msg.result == true) {
				var str = "<option>全部</option>";
				$.each(msg.departments, function(key,val){
					if (val.deptName != "其它"){
						str +=  "<option>"+val.deptName+"</option>";
					}
				});
				str += "<option>其它</option>";
				$("#department").empty().append(str);
			}
		},
		error : function(msg) {
			alert("网络超时!");
		}
	});
}

/*js验证*/
function testInteger(){
	var reg = new RegExp("^\+?[1-9][0-9]*$");
	var obj = document.getElementById("name");
	if (!reg.test(obj.value)) {
		alert("请输入数字!");
	}
}