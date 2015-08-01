<%@ page import="java.util.List" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; UTF-8"/>
    <title>Ocare实时地图</title>
    <%--<script src="http://api.map.baidu.com/api?v=1.5&ak=ZFra3LYWoS5BRU11s8DFw1GG" type="text/javascript"></script>--%>
</head>
<body>
<%--<form action="/map/Refresh">--%>
    <%--<div style="width:1000px;height:650px;border:1px solid gray" id="container"></div>--%>
<%--</form>--%>
<div style="width:1000px;height:650px;border:1px solid gray" id="container"></div>
</body>
</html>


<script src="/OCare/Assets/JS/jquery-2.1.4.js"></script>
<script type="text/javascript">
    var map, point1;
    function loadScript() {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=1.2&ak=ZFra3LYWoS5BRU11s8DFw1GG&callback=init";
        document.head.appendChild(script);
    }
    function init() {
        map = new BMap.Map("container");
        point1 = new BMap.Point(116.404, 39.915);
        map.centerAndZoom(point1, 14);
        var option = {
            type: BMAP_NAVIGATION_CONTROL_LARGE,
            anchor: BMAP_ANCHOR_BOTTOM_RIGHT,
            offset: new BMap.Size(0, 5)
        };
        map.addControl(new BMap.NavigationControl(option));


        var points = [];
        var markers = [];
        var infoWindows = [];


        <c:forEach items="${Elders}" var="elder" varStatus="status">
        var point = new BMap.Point(${elder.getLatitude()}, ${elder.getLongtitude()});
        points.push(point);
        var marker = new BMap.Marker(points[${status.index}]);
        markers.push(marker);
        markers[0].setAnimation(BMAP_ANIMATION_BOUNCE);
        map.addOverlay(markers[${status.index}]);
        var infoWindow = new BMap.InfoWindow("<div style='width: 320px'><h4 style='margin:0 0 5px 0;padding:0.2em 0'>于子涵</h4>" +
                "<img style='float:right;margin:4px' id='imgDemo' src='./images/testIcon.jpg' width='90' height='100' title='老人头像'/>" +
                "<p style='margin:0;line-height:1.5;font-size:13px'>老人联系电话:<span>13500000000000</span></p>" +
                "<p style='margin:0;line-height:1.5;font-size:13px'>老人监护人联系电话:<span>13500000000000</span></p>" +
                "<p style='margin:0;line-height:1.5;font-size:13px'>老人状态:<span>" + "${status.index}" + "</span></p>" +
                "<p style='margin:0;line-height:1.5;font-size:13px'>老人当前地址:<span>上海XXX区XXX路XX号</span></p>" +
                "<p style='margin:0;line-height:1.5;font-size:13px'>老人外出原因:<span>看病</span></p>" +
                "<p style='margin:0;line-height:1.5;font-size:13px'><a href='#' style='text-decoration: none'>查看详情 >>></a> </p>" +
                "</div>");
        infoWindows.push(infoWindow);
        markers[${status.index}].addEventListener("mouseover", function () {
            this.openInfoWindow(infoWindows[${status.index}]);
        });
        </c:forEach>
        map.setViewport(points);

    }
    window.onload = loadScript;


    //    var myIcon =new BMap.Icon("http://dev.baidu.com/wiki/static/map/API/examples/images/Mario.png", new BMap.Size(32, 70), {    //小车图片
    //        offset: new BMap.Size(0, -5),    //相当于CSS精灵
    //        imageOffset: new BMap.Size(0, -20)    //图片的偏移量。为了是图片底部中心对准坐标点。
    //    });

    //添加标注部分
    // var points = [new BMap.Point(116.411776,39.942833)];
    // var markers =[new BMap.Marker(points[0])];
    //调整地图的最佳视野为显示标注数组point


    // var opts0 = {title : '<span style="font-size:14px;color:#0A8021">老人姓名</span>'};

    //    var infoWindow0 =new BMap.InfoWindow( "<div style='width: 320px'><h4 style='margin:0 0 5px 0;padding:0.2em 0'>于子涵</h4>" +
    //    "<img style='float:right;margin:4px' id='imgDemo' src='./images/testIcon.jpg' width='90' height='100' title='老人头像'/>" +
    //    "<p style='margin:0;line-height:1.5;font-size:13px'>老人联系电话:<span>13500000000000</span></p>" +
    //    "<p style='margin:0;line-height:1.5;font-size:13px'>老人监护人联系电话:<span>13500000000000</span></p>"+
    //    "<p style='margin:0;line-height:1.5;font-size:13px'>老人状态:<span>良好</span></p>"+
    //    "<p style='margin:0;line-height:1.5;font-size:13px'>老人当前地址:<span>上海XXX区XXX路XX号</span></p>"+
    //    "<p style='margin:0;line-height:1.5;font-size:13px'>老人外出原因:<span>看病</span></p>"+
    //    "<p style='margin:0;line-height:1.5;font-size:13px'><a href='#' style='text-decoration: none'>查看详情 >>></a> </p>"+
    //    "</div>");

    //markers[0].addEventListener("mouseover", function(){this.openInfoWindow(infoWindow0);});
    // markers[1].addEventListener("mouseover", function(){this.openInfoWindow(infoWindow0);});
    // setInterval("loadScript()", 10000);
    var new_points = [];
    var new_markers = [];
    var new_infoWindows = [];
    setInterval("RefreshCondition()", 3000);


    function RefreshCondition() {
        //alert('test');
        $.ajax({
            url: "/map/home",
            type: "GET",
            success: function (data) {
                //map.centerAndZoom(point1, 14);
                //刷新后
//                    var new_points = [];
//                    var new_markers = [];
//                    var new_infoWindows = [];
                new_points = [];
                new_markers = [];
                new_infoWindows = [];
                map.clearOverlays();

                <c:forEach items="${Elders}" var="elder" varStatus="status">

                <%--<c:forEach items="<%=request.getParameter('Elders')%>" var="elder" varStatus="status">--%>

                var p = new BMap.Point(${elder.getLatitude()}, ${elder.getLongtitude()});

                alert(${elder.getLatitude()}+"+" +${elder.getLongtitude()});

                new_points.push(p);
                var m = new BMap.Marker(new_points[${status.index}]);
                new_markers.push(m);
                map.addOverlay(new_markers[${status.index}]);
                var info = new BMap.InfoWindow("<div style='width: 320px'><h4 style='margin:0 0 5px 0;padding:0.2em 0'>于子涵</h4>" +
                        "<img style='float:right;margin:4px' id='imgDemo' src='/OCare/Assets/Images/testIcon.jpg' width='90' height='100' title='老人头像'/>" +
                        "<p style='margin:0;line-height:1.5;font-size:13px'>老人联系电话:<span>13500000000000</span></p>" +
                        "<p style='margin:0;line-height:1.5;font-size:13px'>老人监护人联系电话:<span>13500000000000</span></p>" +
                        "<p style='margin:0;line-height:1.5;font-size:13px'>老人状态:<span>" + "${status.index}" + "</span></p>" +
                        "<p style='margin:0;line-height:1.5;font-size:13px'>老人当前地址:<span>" + "${status.index}" + "</span></p>" +
                        "<p style='margin:0;line-height:1.5;font-size:13px'>老人外出原因:<span>看病</span></p>" +
                        "<p style='margin:0;line-height:1.5;font-size:13px'><a href='#' style='text-decoration: none'>查看详情 >>></a> </p>" +
                        "</div>");
                new_infoWindows.push(info);
                new_markers[${status.index}].addEventListener("mouseover", function () {
                    this.openInfoWindow(new_infoWindows[${status.index}]);
                });
                </c:forEach>

                // var markerClusterer = new BMapLib.MarkerClusterer(map, {markers:new_markers});
                //map.addOverlay(new_markers);

                map.setViewport(new_points);
                //window.location.reload();
                //alert("刷新完毕");

            }

        })
    }
</script>