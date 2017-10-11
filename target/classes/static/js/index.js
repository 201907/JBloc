// 等待所有加载
$(window).bind("load", function () {
    $('body').addClass('loaded');
    $('#loader-wrapper .load_title').remove();
    $('#code').qrcode({
        width: 200,
        height: 200,
        text: $("#encode").val()
    });
})
