<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<div id="dis" style="width: 600px;height: 400px"></div>
<script type="text/javascript">
    var myeChart = echarts.init(document.getElementById('dis'));
    $.ajax({
        url:'/cmfz_liuzz/count/clientDistribution',
        dataType:'json',
        success:function (data) {
            var option = {
                title : {
                    text: 'app用户地区分布',
                    subtext: '纯属虚构',
                    left: 'center'
                },
                tooltip : {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data:['用户分布']
                },
                visualMap: {
                    min: 0,
                    max: 35000,
                    left: 'left',
                    top: 'bottom',
                    text:['高','低'],           // 文本，默认为数值文本
                    calculable : true
                },
                toolbox: {
                    show: true,
                    orient : 'vertical',
                    left: 'right',
                    top: 'center',
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                series : [
                    {
                        name: '用户分布',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data:data
                    },
                ]
            };
            myeChart.setOption(option);
        }
    })
</script>

