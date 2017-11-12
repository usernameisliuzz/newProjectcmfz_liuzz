<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<meta charset="UTF-8">
<div id="main" style="width: 600px;height: 400px"></div>
            <script type="text/javascript">
                var myeChart = echarts.init(document.getElementById('main'));
                $.ajax({
                    url:'/cmfz_liuzz/count/activeclient',
                    dataType:'json',
                    success:function(data){
                        var option={
                                title:{
                                    text:'用户活跃度'
                                },
                                legend:{
                                    data:['折线','柱状']
                                },
                                xAxis:{
                                data:data.name
                            },
                            yAxis:{},
                        series:[{
                            name:'折线',
                            type:'line',
                            data:data.num
                        },{
                            name:'柱状',
                            type:'bar',
                            data:data.num
                        }]
                    }
                        myeChart.setOption(option);
                    }
                })
            </script>
    </body>
</html>
