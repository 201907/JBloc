$(function(){
    $("#form-block").submit(function(){
        confirm("确认要注册吗？");
    })
    $("#changeVeriCode").click(function () {
        $("#codeImg").attr("src", "veriCode?t=" + new Date().getTime());
    })
    $.validator.addMethod("checkPass",function(value,element,params){
        var checkName = /^[a-zA-z\d]{5,20}$/;
        return this.optional(element)||(checkName.test(value));
    },"请输入5~20位数字或字母！");
    $.validator.addMethod("checkMail",function(value,element,params){
        var checkName = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        return this.optional(element)||(checkName.test(value));
    },"邮箱格式错误！");
    $("#form-block").validate({
        rules:{
            loginName:{
                required:true,
                rangelength:[5,20],
                remote:{
                    type:"GET",
                    url:"/checkUserIfExists",
                    data:{
                        loginName:function(){
                            return $("#loginName").val();
                        }
                    }
                },
            },
            password:{
                required:true,
                rangelength:[5,20],
                checkPass:true
            },
            commitPass:{
                equalTo:password
            },
            email:{
                checkMail:true,
            },
            verificaCode: {
                required:true,
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

        },
        messages:{
            loginName:{
                required:"请输入用户名！",
                rangelength:"请输入5~20个字符！",
                remote:"该用户已注册！"
            },
            password:{
                required:"请输入密码！",
                rangelength:"请输入5~20位数字或字母！"
            },
            commitPass:"两次密码不一致！",
            email:"邮件格式错误！",
            verificaCode:{
                required:"请输入验证码！",
                remote:"验证码不正确！"
            }
        }
    });
})