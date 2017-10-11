$(function () {
    $(".mask").bind('mozAnimationEnd MSAnimationEnd oanimationend webkitAnimationEnd', function () {
        var $p = $("#top > .middle > p.back_index");
        if ($p.is(":animated")) {
            $p.stop();
        }
        $p.animate({
            "opacity": "0.9",
            "letterSpacing": "30px"
        }, 500)
    })
    $("#top > .middle").mouseleave(function () {
        var $p = $("#top > .middle > p.back_index");
        if ($p.is(":animated")) {
            $p.stop();
        }
        $p.animate({
            "opacity": "0",
            "letterSpacing": "0px"
        }, 500)
    })
    //返回主页
    $("#top > .middle").click(function () {
        location.href = '/';
    })
})