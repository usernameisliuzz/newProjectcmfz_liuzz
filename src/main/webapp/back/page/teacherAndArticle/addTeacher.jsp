<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <script type="text/javascript">
            $(function () {

            })
         </script>
        <form id="addTea" method="post" >
            <div style="text-align: center; ">
                <div style="margin: 70px 0px 10px 0px">
                    上师姓名:<input name="tea_name" class="easyui-textbox"   data-options="iconCls:'icon-heart_add'"/>
                </div>
                <div style="margin: 10px 0px 10px 0px">
                    选择状态:<select id="zt" class="easyui-combobox" name="state" style="width:200px;">
                                <option value="封禁" selected>封禁</option>
                                <option value="解封">解封</option>
                            </select>
                </div>
            </div>

        </form>
