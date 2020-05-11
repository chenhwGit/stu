function initPage(page_record_url,queryName){
	var url="/common/page";
	$("#pageId").load(url,function(){
		getPageRecord(1,page_record_url,queryName);
	});
	$("#btn-search").click(function(){
		getPageRecord(1,page_record_url,queryName);
	});
}

//发送AJAX请求，获取日志列表数据
function getPageRecord(pageCurrent,page_record_url,queryName){
	var url=page_record_url;
	var searchValue=$("#searchNameId").val();// 默认值''
	var params={
		"pageCurrent":pageCurrent
	}
	// 在params中动态添加一个属性，
	// 属性名是queryName变量的值
	// eval() 先执行字符串的拼接 "params.name=tom"
	// 然后将拼接后的字符串作为js代码来执行
	eval("params."+queryName+"='"+searchValue+"'");
	
	$.getJSON(url,params,function(result){
		if(result.state==20){// 响应成功
			// 初始化表格中的数据
			createTableRows(result.data.pageRecord);
			// 初始化分页工具栏
			initPagination(result.data);
		}else{// 后台出现异常
			alert(result.message);
		}
	});
}

//将日志列表数据动态添加到页面中
function createTableRows(pageRecord){
	var tbody=$("#tbodyId");
	tbody.empty();// 清空tbody中的默认内容
	for(var index in pageRecord){ // 遍历数组
		var record=pageRecord[index]; //获取1个元素
		// 使用记录生成一行tr对应的字符串内容
		var row=createRow(record);
		tbody.append(row);
	}
}