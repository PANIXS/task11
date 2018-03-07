function query() {
    $.ajax({
        timeout: 3000,
        async: false,
        type: "POST",
        url: "getByNameAndSex",
        dataType: "json",
        data:{
            name:$("#username").val(),
            sex: $(".form-control option:selected").val(),
        },
        success: function () {

        }
    });
};