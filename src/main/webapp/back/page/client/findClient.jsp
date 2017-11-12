<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $('#showClient').edatagrid({
            //数据表格容器属性
            url:'/cmfz_liuzz/client/findClient',
            remoteSort:false,
            fitColumns:true,
            fit:true,//自适应父容器
            singleSelect:"true",
            //数据表格列属性
            columns:[[
                {title:"cks",field:"cks",checkbox:true},
                {field:'id',title:'编号',width:100,align:'center',sortable:true},
                {field:'alias',title:'法号',width:60,align:'center'},
                {field:'name',title:'姓名',width:60,align:'center'},
                {field:'sex',title:'性别',width:60,align:'center',},
                {field:'signature',title:'签名',width:150,align:'center'},
                {field:'phone',title:'电话',width:100,align:'center'},
                {field:'address',title:'所在地区',width:100,align:'center'},
                {field:'registerDate',title:'注册时间',width:100,align:'center'},
                {field:'teacher.tea_name',title:'所拜上师',width:60,align:'center',
                        formatter:function(value,row,index) {
                            return row.teacher.tea_name
                        }
                },
                {field:'state',title:'状态',width:50,align:'center',
                    editor:{
                        type:'combobox',
                        options:{
                            valueField: 'label',
                            textField: 'value',
                            data: [{
                                label: '锁定',
                                value: '锁定'
                            },{
                                label: '解锁',
                                value: '解锁'
                            }]
                        }
                    }
                },
            ]],
            /* autoSave:true,*/
            toolbar:"#Clientdatagridtb",
            loadMsg:"数据加载中.....",
            pagination:true,
            pageSize:5,
            pageList:[5,10,15,20,25],
            updateUrl:"/cmfz_liuzz/client/updateClient",
            onAfterEdit:function(index,row,changes){//结束编辑一行自动触发
                $.ajax({
                    url:"/cmfz_liuzz/client/updateClient",
                    data:JSON.stringify(row),
                    type:"POST",
                    contentType:"application/json",//请求格式 为json
                    success:function(result){
                        //刷新datagrid
                        $("#showClient").edatagrid('reload','/cmfz_liuzz/client/findClient');
                    }
                });
            }
        });
    });
    function save() {
        $('#showClient').edatagrid('saveRow');
    }

</script>
<!-- 数据表格 -->
<table id="showClient"></table>

<div id="Clientdatagridtb">
    <a class="easyui-linkbutton" href="/cmfz_liuzz/client/downClientMsg"  data-options="iconCls:'icon-add',plain:false">导出</a>

</div>
<!-- dialog对话框 -->
<%--<div id="clientdialog"></div>--%>

