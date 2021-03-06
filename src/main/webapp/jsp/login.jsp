<%@ page contentType="text/html; charset=shift_jis"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=shift_jis"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/task.css" type="text/css"/>
  <title>学生情報管理システム</title>
</head>

<body>
<div style="font-weight:700;font-size:16px">
  学生情報管理システム SpringMVC+Spring+Mybatis版 ログイン画面
  <span style="position:absolute;right:25px">
    <a href="<%=request.getContextPath()%>/menu">トップ</a>
  </span>
</div>
<hr size="1" style="border:thin dashed #008080"/>
<div>
<form:form modelAttribute="user" action="login" method="POST">
<form:errors path="" element="div"></form:errors>
<table><tr>
    <td width="10"></td>
    <td>ユーザー ID: </td>
    <td><form:input path="userid"/><form:errors path="userid"/></td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>パスワード: </td>
    <td><form:password path="password" /><form:errors path="password"/></td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>
      <input type="submit" value="   確認   "/>
    <input type="reset" value="  クリア  "/>
    </td> 
</tr></table>
</form:form>
</div>
</body>
</html>