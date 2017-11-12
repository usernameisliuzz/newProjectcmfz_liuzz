<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <script type="text/javascript">
           $(function () {
               $('#tg').treegrid({
                   url:'/cmfz_liuzz/chapter/findchapter',
                   sortOrder:"asc",
                   idField:'id',
                   treeField:'name',
                   fitColumns:true,    //自适应datagrid容器
                   fit:true,
                   toolbar:"#albumdatagridtb",
                   columns:[[{title:'专辑名',field:'name',width:90 },
                               {field:'id',title:'编号',width:50,align:"center"},
                               {field:'ch_url',title:'音频路径',width:50,align:"center"},
                               {field:'ch_newName',title:'新名字',width:60,align:"center"},
                               {field:'ch_size',title:'音频大小',width:30,align:"center"},
                               {field:'ch_state',title:'状态',width:20,align:"center",
                                   editor:{
                                       type:'textbox',
                                       options:{
                                           required:true,
                                           validType:'CHS',
                                       }
                                   }
                               },
                                {field:'options',title:'操作',width:150,
                                    formatter:function(value,row,index){
                                        return "<audio src=\" /cmfz_liuzz/chapter/downMusic?fileName="+row.ch_newName+" \" controls= \" controls \" />" +
                                        "<a href='javascript:;' onClick=\"editRow('"+index+"',this);\" class='upd' class='easyui-linkbutton'>修改</a>" +
                                        "<a href='javascript:;' onClick=\"saveRow('"+index+"');\" class='save' style='display:none' class='easyui-linkbutton'>保存</a>";
                                    }
                                },
                   ]],
                   onLoadSuccess:function(){
                       //数据加载完成渲染修改按钮
                       $(".dow").linkbutton({plain:true,iconCls:'icon-edit'});
                       $(".upd").linkbutton({plain:true,iconCls:'icon-edit'});
                       $(".save").linkbutton({plain:true,iconCls:'icon-save'});
                   },
                  /* onDblClickCell:function (field,row) {
                       $("#tg").treegrid('beginEdit',row.id);
                       $(current).css("display","none");
                       $(current).next().css("display","inline");
                   },*/
                   onAfterEdit:function(row,changes){
                       $.ajax({
                           url:"/cmfz_liuzz/chapter/updateChapter",
                           data:JSON.stringify(row),
                           type:"POST",
                           contentType:"application/json",//请求格式 为json
                           success:function(result){
                               $("#tg").treegrid('reload');
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
               console.log(current);
               $("#tg").treegrid('beginEdit',index);
               $(current).css("display","none");
               $(current).next().css("display","inline");
           }
           //结束编辑
           function saveRow(index){
               $("#tg").treegrid('endEdit',index);
               //数据加载完成渲染删除 和  修改按钮
               $(".upd").linkbutton({plain:true,iconCls:'icon-edit'});
               $(".save").linkbutton({plain:true,iconCls:'icon-save'});
           }
           //下载音频
           function down(row){
               console.log(row);
               $.ajax({
                   url:"/cmfz_liuzz/chapter/downMusic",
                   data:JSON.stringify(row),
                   type:"POST",
                   contentType:"application/json",//请求格式 为json
                   success:function(result){}
               });
           }
           //上传音频
           function addAlbum(){
               $("#addDialog").dialog({
                   title: '添加',
                   iconCls:'icon-man',
                   width: 500,
                   height: 350,
                   closed: false,
                   cache: false,
                   modal: true,
                   draggable:false,
                   href:'/cmfz_liuzz/back/page/addchapter.jsp',
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
               $("#saveChapter").form('submit',{
                   url:"/cmfz_liuzz/chapter/addchapter",
                   success:function(result){
                       $("#tg").treegrid('reload');
                       console.log(result);
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
 <table id="tg" style="width:600px;height:400px"></table>
<div id="albumdatagridtb">
    <a class="easyui-linkbutton" onclick="addAlbum();"  data-options="iconCls:'icon-add',plain:false">添加</a>
</div>
<div id="addDialog"></div>
