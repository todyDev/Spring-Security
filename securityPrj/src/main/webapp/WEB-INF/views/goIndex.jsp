<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/resources/jquery-3.1.1.min.js"></script>
<title>goIndex</title>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	var msgg = '${msg}';
	var url= '${url}';
	alert(msgg);
	window.location.href= url;
});
</script>
</body>
</html>