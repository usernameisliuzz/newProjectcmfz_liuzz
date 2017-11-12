<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<meta charset="UTF-8">
<script>
    var $ts;
    $(function(){
        $ts=$("#ts");
        $ts.datagrid({
            url:'/cmfz_liuzz/slideshow/findSlideShow',
            remoteSort:false,   //关闭远程排序
            fitColumns:true,    //自适应datagrid容器
            fit:true,           //自适应父容器
            columns:[[
                {title:"编号",field:"sli_id",width:100,align:'center',halign:'left',sortable:true,checkbox:true},
                {title:"图片描述",field:"sli_discription",width:120,align:'center',resizable:false,fixed:true,
                    editor:{
                        type:'textbox',
                        options:{
                            required:true,
                            validType:'CHS',
                        }
                    }
                },
                {title:"状态",field:"state",width:180,align:'center',
                    editor:{
                        type:'textbox',
                        options:{
                            required:true,
                        }
                    }
                },
                {title:"操作",field:"options",width:300,
                    formatter:function(value,row,index){
                        return "<a href='javascript:;' onClick=\"editRow('"+index+"',this);\" class='upd' class='easyui-linkbutton'>修改</a>" +
                            "<a href='javascript:;' onClick=\"saveRow('"+index+"');\" class='save' style='display:none' class='easyui-linkbutton'>保存</a>";
                    }
                }
            ]],
            onLoadSuccess:function(){
                //数据加载完成渲染修改按钮
                $(".upd").linkbutton({plain:true,iconCls:'icon-edit'});
                $(".save").linkbutton({plain:true,iconCls:'icon-save'});
            },
            toolbar:"#studentdatagridtb",
            loadMsg:"数据加载中.....",
            pagination:true,
            onAfterEdit:function(index,row,changes){//结束编辑一行自动触发
                $.ajax({
                    url:"/ui_mvc/stu/update",
                    data:JSON.stringify(row),
                    type:"POST",
                    contentType:"application/json",//请求格式 为json
                    success:function(result){
                        console.log(reslut)
                        $("#ts").datagrid('reload');
                        result = $.parseJSON(result);
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
        });
    });
    //编辑一条记录
    function editRow(index,current){
        $ts.datagrid('beginEdit',index);
        $(current).css("display","none");
        $(current).next().css("display","inline");

    }
    //结束编辑
    function saveRow(index){
        $ts.datagrid('endEdit',index);
        //数据加载完成渲染删除 和  修改按钮
        $(".upd").linkbutton({plain:true,iconCls:'icon-edit'});
        $(".save").linkbutton({plain:true,iconCls:'icon-save'});
    }
    //点击搜索根据条件查询用户
    function serachStu(value,column){
        console.log(value);
        console.log(column);
        //  根据指定的条件 查询数据库  最终将响应的数据在当前的datagrid中展示  user/findLike   json
        //datagrid 能不能发起一个新的请求  并传递参数
        //$dg.datagrid('load');  //刷新datagrid之后回到第一页
        //$dg.datagrid('reload');  //刷新datagrid 保持在当前页
        $ts.datagrid('load','/ui_mvc/stu/selectBy?column='+column+'&value='+value);
    }
    function addPicture(){
        $("#addDialog").dialog({
            title: '添加',
            iconCls:'icon-man',
            width: 500,
            height: 350,
            closed: false,
            cache: false,
            modal: true,
            draggable:false,
            href:'/cmfz_liuzz/back/page/addSlideShow.jsp',
            buttons:[{
                text:'添加',
                width:100,
                height:40,
                iconCls:'icon-ok',
                handler:add,
            },{
                text:'关闭',
                width:100,
                height:40,
                iconCls:'icon-back',
                handler:back,
            }],
        });
    }
    function add(){
        $("#saveSlideShow").form('submit',{
            url:'/cmfz_liuzz/slideshow/upSlideShow',
            success:function(result){
                $("#ts").datagrid('reload');

                result = $.parseJSON(result);
                $("#addDialog").dialog('close',true);
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
        $("#addDialog").dialog('close',true);
    }
</script>

<table id="ts"></table>
<!-- 工具栏 -->
<div id="studentdatagridtb">
    <a class="easyui-linkbutton" onclick="addPicture()"  data-options="iconCls:'icon-add',plain:false">上传图片</a>
    <input id="ss" class="easyui-searchbox" style="width:300px" data-options="searcher:serachStu,prompt:'请输入搜索条件....',menu:'#mm'"></input>
    <div id="mm" style="width:120px">
        <div data-options="name:'sli_discription',iconCls:'icon-star'" class="items" >图片描述</div>
        <div data-options="name:'state',iconCls:'icon-star_silver'" class="items">状态</div>
    </div>
</div>
<div id="addDialog"></div>


