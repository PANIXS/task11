<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/task.css" type="text/css"/>
  <title>学生情報管理システム</title>
</head>

<body>
<div style="font-weight:700;font-size:16px">
  学生情報管理システム Struts2.0版 登録画面
  <span style="position:absolute;right:25px">
    <a href="<%=request.getContextPath()%>/menu">メニュー</a>
  </span>
</div>
<hr size="1" style="border:thin dashed #008080"/>


<form action="/registerNewStu" method="get">
  名字:<input type="text" name="name" placeholder="请输入名字"/>
  生日:<input type="text" name="birthdate" placeholder="请输入生日"/>
  地址:<input type="text" name="address" placeholder="地址"/>
  <input type="submit" value="確認   "/>
  <input type="reset" value="重置  "/>
 </form>
</body>
</html>
