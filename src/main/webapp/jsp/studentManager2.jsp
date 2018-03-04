<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>

  <title>...</title>
<link rel="stylesheet" type="text/css" href="../css/task.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
  <script type="text/javascript">
    var isload=false;
    $(document).ready(function () {
          $.ajax({
              timeout: 3000,
              async: false,
              type: "POST",
              url: "getClassIdList",
              dataType: "json",
              success: function (data) {
                  var idList = data["data"];
                  if(!isload){
                      for (var i = 0; i < idList.length; i++) {
                          $(".chooseBtn").append("<option>" + idList[i] + "</option>");
                      }
                      isload=true;
                  }
              }
          });



      });

     function chooseUp(){
        $.ajax({
            timeout: 3000,
            async: false,
            type: "POST",
            url: "getStudentByClass",
            dataType: "json",
            data: {
                classId: $("select option:selected").val(),
            },
            success: function (data) {
                var studentList = data["data"];
                console.log(studentList);
                $(".stuListPanel").empty();
                var row = "";
                row+="<tr>\n" +
                    "          <th>ID</th>\n" +
                    "          <th>NAME</th>\n" +
                    "          <th>BIRTH</th>\n" +
                    "          <th>ADDRESS</th>\n" +
                    "          <th>CLASSID</th>\n" +
                    "        </tr>";
                $.each(studentList,function (n,value) {
                    row +="<tr><td>"+value.id+"</td><td>"+value.name+"</td><td>"+value.birthdate+"</td><td>"+value.address+"</td><td>"+value.classid+"</td></tr>";
                })
                $(".stuListPanel").append(row);
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
    <select class="chooseBtn" name="classId" onchange="chooseUp()"></select>
    <div class="leftArea">
      <table border="1" class="stuListPanel">

      </table>
    </div>
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