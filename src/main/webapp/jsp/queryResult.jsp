<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<web-app id="WebApp_ID" version="2.4"
         xmlns="http://java.sun.com/xml/ns/j2ee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">



<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<html>
<head>

  <meta http-equiv="Content-Type" content="text/html; charset=shift_jis"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/task.css" type="text/css"/>
  <title>学生情報管理システム</title>
</head>

<body>
<div style="font-weight:700;font-size:16px">
  学生情報管理システム Struts2.0版 検索結果画面
  <span style="position:absolute;right:25px">
    <a href="<%=request.getContextPath()%>/menu">メニュー</a>
  </span>
</div>
<hr size="1" style="border:thin dashed #008080"/><br />




<form:form action="queryResult" >
  <div style="position:absolute;left:10px;height:442px;width:981px; overflow:auto;">
    <c:if test="${not empty studentList}">
      <table border="0" cellspacing="1" cellpadding="3" bgcolor="#000000">
        <tr align="left">
          <th bgcolor="#A9A9A9">ID</th>
          <th bgcolor="#A9A9A9">名前</th>
          <th bgcolor="#A9A9A9">生年月日</th>
          <th bgcolor="#A9A9A9">住所</th>
        </tr>

        <c:forEach items="${studentList}" var="student">
          <tr>
            <td bgcolor="#ffffff">${student.id}&nbsp;</td>
            <td bgcolor="#ffffff">${student.name}&nbsp;</td>
            <td bgcolor="#ffffff">${student.birthdate}&nbsp;</td>
            <td bgcolor="#ffffff">${student.address}&nbsp;</td>
          </tr>
        </c:forEach>
      </table>
    </c:if>
  </div>
</form:form>

</body>
</html>
</web-app>