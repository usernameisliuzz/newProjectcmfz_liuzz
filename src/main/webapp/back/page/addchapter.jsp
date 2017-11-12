<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <script type="text/javascript">
            $(function () {
                $.ajax({
                    type:"GET",
                    url:"/cmfz_liuzz/chapter/findchapter",
                    dataType:"JSON",
                    success:function(result){
                        $.each(result,function(index,prov){
                            var option=$("<option/>").text(prov.name).val(prov.id);
                            $("#zj").append(option);
                        });
                    }
                });
            })
         </script>
        <form id="saveChapter" method="post" enctype="multipart/form-data">
            <div style="text-align: center; ">
                <div style="margin: 70px 0px 10px 0px">
                    选择文件：<input type="file" name="music">
                </div>
                <div style="margin: 10px 0px 10px 0px">
                    选择专辑:<select id="zj" name="fal_id" style="width:200px;"></select>
                </div>
                <div style="margin: 10px 0px 10px 0px">
                    选择状态:<select id="zt" class="easyui-combobox" name="sta" style="width:200px;">
                                <option value="上架" selected>上架</option>
                                <option value="下架">下架</option>
                            </select>
                </div>
            </div>

        </form>
