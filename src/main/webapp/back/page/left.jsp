<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
 <script >
    $(function(){
        $.get('/cmfz_liuzz/menu/find',function(result){
            $.each(result, function(idex,menu) {
                var content="<div style='text-align:center;'>";
                $.each(menu.children, function(idex,child) {
                    var args=child.href+"*"+child.iconCls+"*"+child.title;
                    content += "<div class='easyui-linkbutton' onClick=\"addtabs('"+args+"'); \"  style='border-radius:5%;margin:7px 0px 7px 0px;width:90%;border:1px solid #95B8E7;'  data-options=\"iconCls:'"+child.iconCls+"' \" >"+child.title+"</div><br/>"
                });
                content +="</div>";
                $("#aa").accordion('add',{
                    title:menu.title,
                    iconCls:menu.iconCls,
                    selected:menu.selected,
                    content:content
                });
            });
        },"JSON");
    });
    function addtabs(args){
        var arg=args.split("*");
        var href=arg[0];
        var iconCls=arg[1];
        var title=arg[2];
        if(! $("#tt").tabs("exists",title)){
           $("#tt").tabs("add",{
               title:title,
               iconCls:iconCls,
               closable:true,
               href:href,
               tools:[{
                     iconCls:'icon-reload',
                     handler:refreshtabs,
               }]
           });
        }else{
           $("#tt").tabs('select',title);
        }
     }
    function refreshtabs(){
        var a=$("#tt").tabs("getSelected");
        a.panel('refresh');
     }
</script>
 <div id="aa" class="easyui-accordion" data-options="width:300,height:550,fit:true"></div>
