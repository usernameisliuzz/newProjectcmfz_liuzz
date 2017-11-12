<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="/cmfz_liuzz/back/themes/gray/easyui.css">
    <link rel="stylesheet" type="text/css" href="/cmfz_liuzz/back/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/cmfz_liuzz/back/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="/cmfz_liuzz/back/editor/themes/default/default.css">
    <script type="text/javascript" src="/cmfz_liuzz/back/easyUi/jquery.js"></script>
    <script type="text/javascript" src="/cmfz_liuzz/back/easyUi/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/cmfz_liuzz/back/easyUi/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="/cmfz_liuzz/back/easyUi/datagrid-detailview.js"></script>
    <script type="text/javascript" src="/cmfz_liuzz/back/echarts/echarts.js"></script>
    <script type="text/javascript" src="/cmfz_liuzz/back/echarts/china.js"></script>
    <script type="text/javascript" src="/cmfz_liuzz/back/editor/kindeditor.js"></script>
    <script type="text/javascript" src="/cmfz_liuzz/back/editor/lang/zh_CN.js"></script>
    <script type="text/javascript">
        function updatepw(){
            $("#update").dialog({
                title: '密码修改',
                iconCls:'icon-man',
                width: 400,
                height: 200,
                closed: false,
                cache: false,
                modal: true,
                draggable:false,
                href:'/cmfz_liuzz/back/page/updatePw.jsp',
                buttons:[{
                    text:'确认',
                    width:100,
                    height:40,
                    iconCls:'icon-ok',
                    handler:update,
                },{
                    text:'关闭',
                    width:100,
                    height:40,
                    iconCls:'icon-back',
                    handler:back,
                }],
            });
        }
        function update(){
            $("#updatepw").form('submit',{
                url:'/cmfz_liuzz/user/updatepw',
                success:function(result){
                    result = $.parseJSON(result);
                    $("#update").dialog('close',true);
                    if(result.success){
                        $.messager.show({
                            title:"提示",
                            msg:result.message,
                        });
                    }else{
                        $.messager.show({
                            title:"提示",
                            msg:result.message,
                        });
                    }
                }
            });
        }
        function back(){
            $("#update").dialog('close',true);
        }
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${user.name} &nbsp;<a onclick="updatepw()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="/cmfz_liuzz/user/logout" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育</div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true,href:'/cmfz_liuzz/back/page/left.jsp'" style="width:220px;"></div>

<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood'"  style="background-image:url(/cmfz_liuzz/back/img/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
<div id="update"></div>
</body>
</html>
