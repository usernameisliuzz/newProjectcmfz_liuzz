<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $('#findTeacher').edatagrid({
            //数据表格容器属性
            url:'/cmfz_liuzz/teacher/findTeacher',
            remoteSort:false,
            fitColumns:true,
            fit:true,//自适应父容器
            singleSelect:"true",
            //数据表格列属性
            columns:[[
                {title:"cks",field:"cks",checkbox:true},
                {field:'id',title:'编号',width:70,align:'center',sortable:true},
                {field:'tea_name',title:'上师姓名',width:100,align:'center'},
                {field:'state',title:'状态',width:50,align:'center',
                    editor:{
                        type:'combobox',
                        options:{
                            valueField: 'label',
                            textField: 'value',
                            data: [{
                                label: '封禁',
                                value: '封禁'
                            },{
                                label: '解封',
                                value: '解封'
                            }]
                        }
                    }
                },

            ]],
            /* autoSave:true,*/
            toolbar:[{
                text: '添加',
                iconCls: 'icon-add',
                onClick: addBanner
            },
                {
                    text:'保存',
                    handler:save,
                    iconCls: 'icon-save',

                }
            ],
            pagination:true,
            updateUrl:"/cmfz_liuzz/teacher/update",
            onAfterEdit:function(index,row,changes){//结束编辑一行自动触发
                $.ajax({
                    url:"/cmfz_liuzz/teacher/update",
                    data:JSON.stringify(row),
                    type:"POST",
                    contentType:"application/json",//请求格式 为json
                    success:function(result){
                        //刷新datagrid
                        $("#findTeacher").edatagrid('reload','/cmfz_liuzz/teacher/findTeacher');
                    }
                });
            }
        });

    });

    //添加按钮事件
    function addBanner(){
        $("#addTeacher").dialog({
            title:'上师添加',
            width:500,
            height:300,
            border:'thin',
            href:'/cmfz_liuzz/back/page/teacherAndArticle/addTeacher.jsp',
            collapsible:true,
            iconCls:'icon-man',
            resizable:true,
            modal:true,
            buttons:[{
                text:'添加',
                iconCls:'icon-save',
                onClick:saveTeacher
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                onClick:Close
            }]
        });
    }
    //添加页面-添加按钮
    function saveTeacher(){
        $("#addTea").form('submit',{
            url:"/cmfz_liuzz/teacher/addTeacher",
            /*onSubmit:function(){
             var f = $("#ffBanner").form('validate');
             return f;
             },*/
            success:function(result){
                result = $.parseJSON(result);
                $("#addTeacher").dialog('close',true);//关闭对话框
                if(result.success){
                    $('#findTeacher').datagrid('reload');
                    $.messager.show({
                        title:"提示信息",
                        msg:result.message
                    });
                }else{
                    $.messager.show({
                        title:"提示信息",
                        msg:result.message
                    });
                }

            }
        });
    }
    //添加页面-关闭按钮
    function Close(){
        $("#addTeacher").dialog('close',true);//关闭对话框
    }

    function save() {
        $('#findTeacher').edatagrid('saveRow');
    }
</script>
<!-- 数据表格 -->
<table id="findTeacher"></table>

<!-- 轮播图添加对话框 -->
<div id="addTeacher"></div>


