<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=shift_jis"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/task.css" type="text/css"/>
  <script src="file:///C:\JAVATOOLS\jquery-3.3.1.min.js"></script>
  <title>学生情報管理システム</title>
  <script type="text/javascript">
      function choose() {
          $.ajax({
              timeout: 3000,
              async: false,
              type: "POST",
              url: "getClassIdList",
              dataType: "json",

              success: function (data) {
                  var idList = data.data;
                  for (var i = 0; i < idList.length; i++) {
                      $(".chooseBtn").append("<option>" + idList[i].value + "</option>");
                  }
              }
          });
      };
  </script>
</head>

<body>
<div style="font-weight:700;font-size:16px">
  	学生管理界面
  <span style="position:absolute;right:25px">
    <a href="<%=request.getContextPath()%>/menu">メニュー</a>
  </span>
  <hr size="1" style="border:thin dashed #008080"/>
</div>

<div class="Box">
  <div class="topArea">
  <h1 class="title">学生管理界面</h1>
  </div>

  <div class="clearfix centerArea">
    <select class="chooseBtn" onclick="choose()">

    </select>
    <div class="leftArea"></div>
    <div class="exchangeArea">
      <button class="rightBtn">&raquo;</button>
      <button class="leftBtn">&laquo;</button>
    </div>
    <div class="rightArea"></div>
  </div>

  <div class="bottomArea">
    <button class="sure">确定</button>
    <button class="cancle">取消</button>
  </div>

</div>

</body>
</html>