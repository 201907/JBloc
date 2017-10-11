$(function () {
    $("[name='auto-login']").bootstrapSwitch();
    $("#changeVeriCode").click(function () {
        $("#codeImg").attr("src", "veriCode?t=" + new Date().getTime());
    })
    $("#loginForm").validate({
            rules: {
                loginName: {
                    required: true
                },
                password: {
                    required: true
                },
                verificaCode: {
                    required: true,
                    remote: {
                        type: "GET",
                        url: "/checkVeriCode",
                        data: {
                            verificationCode: function () {
                                return $("#verificaCode").val();
                            }
                        }
                    }
                }
            }, messages: {
                loginName: {
                    required: "请输入用户名！"
                },
                password: {
                    required: "请输入密码！"
                },
                verificaCode: {
                    required: "请填写验证码！",
                    remote: "验证码有误！"
                }
            }
        }
    )
})