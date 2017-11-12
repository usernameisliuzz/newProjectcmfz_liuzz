<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $('#findArticle').edatagrid({
            //数据表格容器属性
            url:'/cmfz_liuzz/article/findArticle',
            remoteSort:false,
            fitColumns:true,
            fit:true,//自适应父容器
            singleSelect:"true",
            //数据表格列属性
            columns:[[
                {field:'id',title:'编号',width:70,align:'center',sortable:true},
                {field:'art_name',title:'书名',width:100,align:'center'},
                {field:'pubDate',title:'发布时间',width:100,align:'center'},
                {field:'teacher.tea_name',title:'作者',width:100,align:'center',
                    formatter:function(value,row,index){
                        return row.teacher.tea_name;
                    }
                },
               // {field:'content',title:'内容',width:100,align:'center'},
                {field:'state',title:'状态',width:50,align:'center',
                    editor:{
                        type:'combobox',
                        options:{
                            valueField: 'label',
                            textField: 'value',
                            data: [{
                                label: 'true',
                                value: '上架'
                            },{
                                label: 'false',
                                value: '下架'
                            }]
                        }
                    }
                },

            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td style="border:0" align="center">' +
                    '<p>' + rowData.art_name + '</p><br/>' +
                    '<p>' + rowData.content + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            /* autoSave:true,*/
            toolbar:[{
                text: '添加',
                iconCls: 'icon-add',
                onClick: addart,
            },
                {
                    text:'保存',
                    handler:saveArt,
                    iconCls: 'icon-save',

                }
            ],
            pagination:true,
            updateUrl:"/cmfz_liuzz/article/updateArticle",
            onAfterEdit:function(index,row,changes){//结束编辑一行自动触发
                console.log(index);//当前行索引
                console.log(row); //当前修改 之后的对象
                console.log(changes);//被修改的列的对象
                //将js中对象转为json格式字符串
                console.log(JSON.stringify(row));
                //发送异步请求
                $.ajax({
                    url:"/cmfz_liuzz/article/updateArticle",
                    data:JSON.stringify(row),
                    type:"POST",
                    contentType:"application/json",//请求格式 为json
                    success:function(result){
                        //刷新datagrid
                        $("#findArticle").edatagrid('reload','/cmfz_liuzz/article/findArticle');
                    }
                });
            }

        });

    });

    //添加按钮事件
    function addart(){
        $("#addArticle").dialog({
            title:'文章添加',
            width:800,
            height:500,
            border:'thin',
            href:'/cmfz_liuzz/back/page/teacherAndArticle/addArticle.jsp',
            collapsible:true,
            iconCls:'icon-man',
            resizable:true,
            modal:true,
            buttons:[{
                text:'添加',
                iconCls:'icon-save',
                onClick:addArt
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                onClick:Close
            }]
        });
    }
    //添加页面-添加按钮
    function addArt(){
        $("#saveArticle").form('submit',{
            url:"/cmfz_liuzz/article/addArticle",
            /*onSubmit:function(){
             var f = $("#ffBanner").form('validate');
             return f;
             },*/
            success:function(result){
                result = $.parseJSON(result);
                $("#addArticle").dialog('close',true);//关闭对话框
                if(result.success){
                    $('#findArticle').datagrid('reload');
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
        $("#addArticle").dialog('close',true);//关闭对话框
    }

    function saveArt() {
        $('#findArticle').edatagrid('saveRow');
    }
</script>
<!-- 数据表格 -->
<table id="findArticle"></table>

<!-- 轮播图添加对话框 -->
<div id="addArticle"></div>


