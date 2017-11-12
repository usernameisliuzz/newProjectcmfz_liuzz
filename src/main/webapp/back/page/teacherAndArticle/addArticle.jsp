<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <script type="text/javascript">
            $(function () {
                $.ajax({
                    type:"GET",
                    url:"/cmfz_liuzz/teacher/findTeacher",
                    dataType:"JSON",
                    success:function(result){
                        $.each(result,function(index,prov){
                            var option=$("<option/>").text(prov.tea_name).val(prov.id);
                            $("#au").append(option);
                        });
                    }
                });
                    });
            KindEditor.create('#content', {
                afterBlur: function () { this.sync(); },
                basePath:'/cmfz_liuzz/back/editor/',
                uploadJson:'/cmfz_liuzz/article/upPicture',
                filePostName:'image'
            });
            KindEditor.ready("#content",{

            });
        </script>
        <form id="saveArticle" method="post" >
            <div style="text-align: center; ">
                <div style="margin: 70px 0px 10px 0px">
                    选择作者:<select id="au" style="width:200px" name="tea_id"></select>
                </div>
                <div style="margin: 10px 0px 10px 0px">
                    填写标题:<input name="art_name" class="easyui-textbox"   data-options="iconCls:'icon-heart_add'"/>
                </div>
                <div style="margin: 10px 0px 10px 0px">
                    选择状态:<select id="zt" class="easyui-combobox" name="state" style="width:200px;">
                    <option value="上架" selected>上架</option>
                    <option value="下架">下架</option>
                </select>
                </div>
                <div style="margin: 10px 0px 10px 0px">
                    <textarea id="content" name="content" style="width:500px;height:200px;visibility:hidden;" ></textarea>
                </div>

            </div>

        </form>
