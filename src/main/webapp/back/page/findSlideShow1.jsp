<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $('#dgBanner').edatagrid({
            //数据表格容器属性
            url:'/cmfz_liuzz/slideshow/findSlideShow',
            remoteSort:false,
            fitColumns:true,
            fit:true,//自适应父容器
            singleSelect:"true",
            //数据表格列属性
            columns:[[
                {title:"cks",field:"cks",checkbox:true},
                {field:'sli_id',title:'编号',width:70,align:'center',sortable:true},
                {field:'sli_discription',title:'图片描述',width:100,align:'center'},
                {field:'sli_name',title:'新名',width:100,align:'center'},
                //{field:'sli_oldname',title:'旧名',width:100,align:'center',},
                {field:'sli_url',title:'路径',width:150,align:'center'},
                {field:'sli_size',title:'图片大小',width:100,align:'center'},
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
                    '<td rowspan=2 style="border:0"><img src="/cmfz_liuzz/upload/'+rowData.sli_oldname+'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>图片描述: ' + rowData.sli_discription + '</p>' +
                    '<p>状态: ' + rowData.state + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            /* autoSave:true,*/
            toolbar:[{
                text: '添加',
                iconCls: 'icon-add',
                onClick: addBanner
            },
                {
                    text:'保存',
                    handler:jj,
                    iconCls: 'icon-save',

                }
            ],
            pagination:true,
            updateUrl:"/cmfz_liuzz/slideshow/update",
            onError:function (index,row) {-+
                alert(row.msg)
            },
            onAfterEdit:function(index,row,changes){//结束编辑一行自动触发
                $.ajax({
                    url:"/cmfz_liuzz/slideshow/update",
                    data:JSON.stringify(row),
                    type:"POST",
                    contentType:"application/json",//请求格式 为json
                    success:function(result){
                        //刷新datagrid
                        $("#dgBanner").edatagrid('reload','/cmfz_liuzz/slideshow/findSlideShow');
                    }
                });
            }

        });

    });

    //添加按钮事件
    function addBanner(){
        $("#ddBanner").dialog({
            title:'轮播图添加',
            width:500,
            height:300,
            border:'thin',
            href:'/cmfz_liuzz/back/page/addSlideShow.jsp',
            collapsible:true,
            iconCls:'icon-man',
            resizable:true,
            modal:true,
            buttons:[{
                text:'添加',
                iconCls:'icon-save',
                onClick:saveBanner
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                onClick:userClose
            }]
        });
    }
    //添加页面-添加按钮
    function saveBanner(){
        $("#saveSlideShow").form('submit',{
            url:"/cmfz_liuzz/slideshow/upSlideShow",
            /*onSubmit:function(){
                var f = $("#ffBanner").form('validate');
                return f;
            },*/
            success:function(result){
                result = $.parseJSON(result);
                $("#ddBanner").dialog('close',true);//关闭对话框
                if(result.success){
                    $('#dgBanner').datagrid('reload');
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
    function userClose(){
        $("#ddBanner").dialog('close',true);//关闭对话框
    }

    function jj() {
        $('#dgBanner').edatagrid('saveRow');
    }
</script>
<!-- 数据表格 -->
<table id="dgBanner"></table>

<!-- 轮播图添加对话框 -->
<div id="ddBanner"></div>

