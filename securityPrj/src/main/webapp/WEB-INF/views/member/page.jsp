<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/include/header.jspf"  %>
<title>Member Page</title>
</head>
<body>
      <br><br>
      <div class="container text-center">
          <h1>MEMBER PAGE</h1><br>
      </div>
      <br><br>
      <div class="container text-center">
          <h6 class="font-italic text-danger">MEMBER 전용 페이지입니다.<br>감사합니다. :)</h6>
      </div>
      <br><br>
      <div class="container text-center">
        <a href='<c:url value="/"/>' class="text-dark"><i class="fas fa-undo"></i></a>
      </div>
</body>
</html>