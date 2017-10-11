$(document).ready(function () {
    $('#picture>img').imgAreaSelect({
        handles: true,
        aspectRatio: "4:4",
        onSelectChange: preview,
        onSelectEnd: function (img, selection) {
            $('#id_top').val(selection.y1);
            $('#id_left').val(selection.x1);
            $('#id_right').val(selection.x2);
            $('#id_bottom').val(selection.y2);
        }
    });

    function preview(img, selection) {
        //改变预览图片
        var $pic_div = $("#pic-view");
        var $img = $("#pic-view>img");
        //console.log(selection);
        var scaleX = $pic_div.width() / (selection.width || 1);
        var scaleY = $pic_div.height() / (selection.width || 1);
        $img.css({
            width: Math.round(scaleX * $("#picture>img").width()) + 'px',
            height: Math.round(scaleY * $("#picture>img").height()) + 'px',
            marginLeft: '-' + Math.round(scaleX * selection.x1) + 'px',
            marginTop: '-' + Math.round(scaleY * selection.y1) + 'px'
        });
    }

    //关闭窗口
    function close() {
        $(".imgareaselect-selection").hide();
        $(".imgareaselect-selection").parent().hide();
        $(".imgareaselect-outer").hide();
    }

    $('#editIcon').on('hide.bs.modal', function () {
        close();
    })

    $("#upload").click(function () {
        $("#file").click();
    })

    $("#file").change(function () {
        $(this).fileupload({
            type: "post",
            dataType: "json",
            url: "/uploadIcon",
            maxFileSize: 20971520,
            success: function (data) {
                if (data == true) {
                    //上传成功
                    $("#picture>img").attr("src", "/getUserTempIcon?t=" + new Date().getTime());
                    $("#pic-view>img").attr("src", "/getUserTempIcon?t=" + new Date().getTime());
                } else {
                    //上传失败
                    alert("上传图片失败");
                }
            }
        });
    })
    $("#save").click(function () {
        $.ajax({
            url: "/saveUserIcon",
            type: "put",
            data: {
                _method: "PUT",
                x1: $("#id_left").val(),
                y1: $("#id_top").val(),
                x2: $("#id_right").val(),
                y2: $("#id_bottom").val()
            },
            success: function (data) {
                if (data == "true") {
                    alert("保存成功");
                    $(".icon>img").attr("src", "/getUserIcon?t=" + new Date().getTime());
                } else {
                    alert("保存失败");
                }
            }

        })
    })
});