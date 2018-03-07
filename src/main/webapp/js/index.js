
function deleteJ() {
    var checkList = $("#showList tr").find("input[type=checkbox]");
    var deleteList = [];
    for(k in checkList){
        if(checkList[k].checked)
            deleteList.push(checkList[k].value);
    };
    $.ajax({
        timeout: 3000,
        async: false,
        type: "POST",
        url: "deleteJapanese",
        dataType: "json",
        data:{
            deleteList:deleteList.toString(),
        },
        success: function () {
            location.assign('http://localhost:8080')
        }
    });
};
