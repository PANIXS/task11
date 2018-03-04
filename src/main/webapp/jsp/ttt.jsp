<%@ page import="jp.co.realsys.model.Student" %>
<%@ page import="java.util.List" %>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">--%>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         id="WebApp_ID" version="3.0">

<html>
<head>

    <title>JSP Page</title>
</head>
<body>

<h1>JSP Page</h1>
<div style="font-weight:700;font-size:16px">
    学生情報管理システム Struts2.0版 登録結果画面
    <span style="position:absolute;right:25px">
    <a href="<%=request.getContextPath()%>/menu">メニュー</a>
  </span>
</div>
<%--
This example uses JSTL, uncomment the taglib directive above.
To test, display the page like this: index.jsp?sayHello=true&name=Murphy
--%>
<% Student user=    (Student) request.getAttribute("studentList");

%>
${user}

<c:forEach  items="${studentList}" var="w" varStatus="status">

    <tr>
        <td><input name="studentList[${status.index}].name" value="${w.name}"></td>
        <td><input name="studentList[${status.index}].name" value="${w.id}"></td>
        <td><input name="studentList[${status.index}].name" value="${w.name}"></td>
        <td><input name="studentList[${status.index}].name" value="${w.name}"></td>
        <td><input name="studentList[${status.index}].name" value="${w.name}"></td>
    </tr>
</c:forEach>



</body>
</html>
</web-app>