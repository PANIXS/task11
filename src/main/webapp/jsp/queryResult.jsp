<%@ page contentType="text/html; charset=shift_jis"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=shift_jis"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/task.css" type="text/css"/>
  <title>�w�����Ǘ��V�X�e��</title>
</head>

<body>
<div style="font-weight:700;font-size:16px">
  �w�����Ǘ��V�X�e�� Struts2.0�� �������ʉ��
  <span style="position:absolute;right:25px">
    <a href="<%=request.getContextPath()%>/menu">���j���[</a>
  </span>
</div>
<hr size="1" style="border:thin dashed #008080"/><br />

<form:form action="query" >
<div style="position:absolute;left:10;height:442;width:981; overflow:auto;">
<table border="0" cellspacing="1" cellpadding="3" bgcolor="#000000">
  <tr align="left">
    <th bgcolor="#A9A9A9">ID</th>
    <th bgcolor="#A9A9A9">���O</th>
    <th bgcolor="#A9A9A9">���N����</th>
    <th bgcolor="#A9A9A9">�Z��</th>
  </tr>
  <s:iterator value="screenBean.studentList">
  <tr>
    <td bgcolor="#ffffff"><s:property value="id"/>&nbsp;</td>
    <td bgcolor="#ffffff"><s:property value="name"/>&nbsp;</td>
    <td bgcolor="#ffffff"><s:property value="birthDate"/>&nbsp;</td>
    <td bgcolor="#ffffff"><s:property value="address"/>&nbsp;</td>
  </tr>
  </s:iterator>
</table>
</div>
</form:form>
</body>
</html>