
$(document).ready(function () {
    $.ajax({
        timeout: 3000,
        async: false,
        type: "POST",
        url: "getClassIdList",
        dataType: "json",
        data:{

        },
        success: function (data) {
            var idList = data["data"];
            if(!isload){
                for (var i = 0; i < idList.length; i++) {
                    if (idList[i]==0) {
                        $(".chooseBtn").append("<option selected="+"selected"+">" + idList[i] + "</option>");
                    }else {
                        $(".chooseBtn").append("<option>" + idList[i] + "</option>");
                    }
                }
                isload=true;
            }
        }
    });
});
