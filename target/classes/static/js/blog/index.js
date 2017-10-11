$(function () {
    //<code class="prettyprint linenums"
    $("#implant-code").click(function () {
        var value = $("#codearea").val();
        if (value == "") {
            return;
        }
        var $content = $("#post-content div.edui-container");
        var $codeElement = $("<input type='text' class='code-element'readonly='true'/>");
        // $codeElement.val($("#codearea").val());
        $codeElement.val("code");
        $codeElement.attr("code", value);
        // $codeElement.addClass("prettyprint linenums");
        $content.append($codeElement);
        $codeElement.popover({
            trigger: 'manual',
            placement: 'right', //top, bottom, left or right
            title: "code",
            html: 'true',
            content: value
        }).on("mouseenter", function () {
            var _this = this;
            // alert($(this).attr("code"));
            $(this).popover("show");
            $(this).siblings(".popover").on("mouseleave", function () {
                $(_this).popover('hide');
            });
        }).on("mouseleave", function () {
            var _this = this;
            setTimeout(function () {
                if (!$(".popover:hover").length) {
                    $(_this).popover("hide")
                }
            }, 100);
        });
        $("#codearea").val("");
    })
    //提交博客
    $("#post-commit").click(function () {
        var title = $("#title").val();
        var content = $("#post-content div.edui-container").html();
        if (title == "") {
            alert("请输入标题");
            return;
        }
        if (content == "") {
            alert("请输入内容");
            return;
        }
        // var code = new Array();
        // $(".code-element").each(function (index) {
        //     code[index] = $(this).attr("code");
        // })
        $.ajax({
            url: "/blog/",
            type: "post",
            data: {
                _method: "PUT",
                title:title,
                content: content,
                // code: code
            },
            success:function(data){
                if(data=="true"){
                    alert("发布成功")
                }else{
                    alert("发布失败")
                }
            }
        })
    })

})