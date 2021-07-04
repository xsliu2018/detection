const $btn = $('#updateButton')
$(function () {
    //修改个人信息,包含密码
    $btn.click(function () {
        $btn.attr("disabled",true);
        let nickname = $('#nickname').val();
        let password = $('#password').val();
        let email = $('#email').val()
        let phone = $('#phone').val()
        if (validUserNameForUpdate(email, nickname, phone, password)) {
            //ajax提交数据
            let params = $("#settingForm").serialize();
            $.ajax({
                type: "POST",
                url: "/admin/setting",
                data: params,
                success: function (result) {
                    if (result.success) {
                        alert('修改成功');
                    } else {
                        alert('修改失败:\n' + result.message);
                        $btn.prop("disabled",false);
                    }
                }
            });
        } else {
            $btn.prop("disabled",false);
        }
    });
     //修改密码
     $('#updatePasswordButton').click(function () {
         $btn.attr("disabled",true);
         let originalPassword = $('#originalPassword').val();
         let newPassword = $('#newPassword').val();
         if (originalPassword !== newPassword) {
             let params = $("#userPasswordForm").serialize();
             $.ajax({
                 type: "POST",
                 url: "/admin/profile/password",
                 data: params,
                 success: function (result) {
                     console.log(result);
                     if (result.success) {
                         alert('修改成功');
                         <!-- 修改成功 重新登录-->
                         window.location.href = '/admin/login';
                     } else {
                         alert('修改失败' + result.message);
                         $("#updatePasswordButton").attr("disabled",false);
                     }
                 }
             });
         } else {
             alert("请输入和旧密码不同的新密码")
             $("#updatePasswordButton").attr("disabled",false);
        }
     });
})

/**
 * 名称验证
 */
function validUserNameForUpdate(email, nickName, phone, password) {
    const $info = $('#setting-alert-info')
    if (isNull(email) || email.trim().length < 1) {
        $info.css("display", "block");
        $info.html("请输入邮箱！");
        return false;
    }
    if (isNull(nickName) || nickName.trim().length < 1) {
        $info.css("display", "block");
        $info.html("昵称不能为空！");
        return false;
    }
    if (!validUserName(nickName)) {
        $info.css("display", "block");
        $info.html("请输入符合规范的昵称！");
        return false;
    }
    if (!validEmail(email)) {
        $info.css("display", "block");
        $info.html("请输入符合规范的邮箱！");
        return false;
    }
    if (!validPhone(phone)) {
        $info.css("display", "block");
        $info.html("请输入符合规范的手机号码！");
        return false;
    }
    // 最少6位，最多20位
    if (!validPassword(password)) {
        $info.css("display", "block");
        $info.html("请输入符合规范的密码！");
        return false;
    }


    return true;
}

/**
 * 更换用户头像
 */
function changeHeads(){
    console.log("换头像了")

}

