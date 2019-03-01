<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>抢红包啦</title>
<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		// 模拟500个异步请求
		var max = 800;
		for (var i = 1; i <= max; i++) {
			$.ajax({
				url : "getredpacket.do",
				type : 'post',
				dataType : 'json',
				data : {redPacketId : "1", userId : i},
				success : function(result) {
					
				}
			});
		}
	});
</script>
</head>
<body>
	此页面自动发送POST
</body>
</html>