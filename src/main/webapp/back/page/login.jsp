<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>管理中心</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="icon" href="/cmfz_liuzz/back/img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/cmfz_liuzz/back/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="/cmfz_liuzz/back/css/login.css" type="text/css"></link>
    <script type="text/javascript" src="/cmfz_liuzz/back/script/jquery.js"></script>
    <script type="text/javascript" src="/cmfz_liuzz/back/script/common.js"></script>
    <script type="text/javascript" src="/cmfz_liuzz/back/validate/jquery.validate.js"></script>
    <script type="text/javascript" src="/cmfz_liuzz/back/validate/messages_zh.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //点击更换验证码：
            $("#captchaImage").click(function(){//点击更换验证码
                $(this).attr({"src":"/cmfz_liuzz/user/getImage?"+Math.random()});
            });
            //  form 表单提交
            $("#loginForm").validate({
                rules:{
                    name:"required",
                    password:{
                        required:true,
                        minlength:6,
                    },
                    enCode:"required",
                },
                messages:{
                    name:"<font color='red'>必填！</font>",
                    password:{
                        required:"<font color='red'>必填！</font>",
                        minlength:"<font color='red'>不少于6位！</font>",
                    },
                    enCode:"<font color='red'>必填！</font>",
                }
            });
        });
    </script>
</head>
<body>

<div class="login">
    <form id="loginForm" action="/cmfz_liuzz/user/landing" method="post" >

        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="/cmfz_liuzz/back/img/header_logo.gif" alt="购物"/>
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input type="text"  name="name" class="text" value="" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input type="password" name="password" class="text" value="" maxlength="20" autocomplete="off"/>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" class="captchaImage" src="/cmfz_liuzz/user/getImage" title="点击更换验证码"/>
                </td>
            </tr>
            <tr>
                <c:if test="${message} !=null">
                    <font color="red">${message}</font>
                </c:if>
                <c:remove var="message" scope="session"/>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value="" onclick=""><input type="submit" class="loginButton" value="登录">
                </td>
            </tr>
            </tbody></table>
        <div class="powered">COPYRIGHT © 2005-2013.</div>
        <div class="link">
            <a href="">前台首页</a> |
            <a href="">官方网站</a> |
            <a href="">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>
