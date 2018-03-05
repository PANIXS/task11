<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/task.css" type="text/css"/>
  <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  <script type="text/javascript">
      $(document).ready(function () {
          $(".deleteBtn").click(function(e){
              console.log($(e.target).attr("name"));
              var stuIdStr = $(e.target).attr("name");
              var stuId = stuIdStr.substring(4);
              console.log(stuId);
              $.ajax({
                  timeout:3000,
                  async:false,
                  type:"POST",
                  url:"deleteStudent",
                  dataType:"json",
                  data:{
                      stuId: stuId,
                  },
                  success:function () {
                      alert("删除成功");
                      location.reload(true);
                  }
              });
          });


          $(".updateBtn").click(function (e) {
                  $("#updateDialog").toggle();
          });
      });


  </script>
  <title>学生情報管理システム</title>
</head>

<body>

<div style="font-weight:700;font-size:16px">
  学生情報管理システム Struts2.0版 学生情報展示
  <span style="position:absolute;right:25px">
    <a href="<%=request.getContextPath()%>/menu">メニュー</a>
  </span>
</div>
<hr size="1" style="border:thin dashed #008080"/>
<div style="position:absolute;left:10px;height:442px;width:400px; overflow:auto;">
  <c:if test="${not empty studentList}">
    <table border="0" cellspacing="1" cellpadding="3" bgcolor="#000000">
      <tr align="left">
        <th bgcolor="#A9A9A9">ID</th>
        <th bgcolor="#A9A9A9">名前</th>
        <th bgcolor="#A9A9A9">生年月日</th>
        <th bgcolor="#A9A9A9">住所</th>
        <th bgcolor="#A9A9A9">班级</th>
        <th bgcolor="#A9A9A9">更新</th>
        <th bgcolor="#A9A9A9">删除</th>
      </tr>

      <c:forEach items="${studentList}" var="student">
        <tr>
          <td  bgcolor="#ffffff">${student.id}&nbsp;</td>
          <td bgcolor="#ffffff">${student.name}&nbsp;</td>
          <td bgcolor="#ffffff">${student.birthdate}&nbsp;</td>
          <td bgcolor="#ffffff">${student.address}&nbsp;</td>
          <td bgcolor="#ffffff">${student.classid}&nbsp;</td>
          <td bgcolor="#ffffff"><button class="updateBtn">更新</button> &nbsp;</td>
          <td bgcolor="#ffffff"><button name="stu_${student.id}" class="deleteBtn">删除</button>&nbsp;</td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
</div>
<div id="updateDialog" title="基本的对话框">
  <form action="updateStudent" method="post">
    <h4 style="margin: 0 0 0 80px;">更新学生</h4>
    输入ID&nbsp;&nbsp;&nbsp;:<input  name="id" type="text"><br>
  输入名字:<input  name="name" type="text"><br>
  输入日期:<input name="birthdate" type="text"><br>
  输入住所:<input name="address" type="text"><br>
  <input class="stuInput" type="submit">&nbsp;&nbsp;
  <input type="reset">
  </form>
</div>

</body>
</html>
