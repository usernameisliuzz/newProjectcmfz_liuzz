<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<meta charset="UTF-8">
<script>
    var $ts;
    $(function(){
        $ts=$("#ts");
        $ts.datagrid({
            url:'/cmfz_liuzz/log/findLog',
            remoteSort:false,   //关闭远程排序
            fitColumns:true,    //自适应datagrid容器
            fit:true,           //自适应父容器
            columns:[[
                {title:"编号",field:"id",width:100,align:'center',halign:'left',sortable:true,checkbox:true},
                {title:"操作姓名",field:"username",width:120,align:'center',resizable:false,fixed:true},
                {title:"操作时间",field:"doDate",width:180,align:'center'},
                {title:"操作事物",field:"doThing",width:300,align:'center'},
                {title:"状态",field:"state",width:300,align:'center'}
            ]],
            toolbar:"#studentdatagridtb",
            loadMsg:"数据加载中.....",
            pagination:true,
        });
    });
</script>

<table id="ts"></table>



