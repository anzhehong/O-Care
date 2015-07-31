<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="OCare">
    <meta name="author" content="">
    <meta name="keywords" content="OCare">

    <title>OCare</title>
    <link rel="stylesheet" href="/OCare/Assets/CSS/header.css">
    <link rel="stylesheet" href="/OCare/Assets/CSS/sidebar.css">
    <link rel="stylesheet" href="/OCare/Assets/CSS/semantic.css" media="screen">
    <link rel="stylesheet" href="/OCare/Assets/CSS/icon.css" media="screen">
</head>

<body>
<div class="header">

    <div class="container">
        <img src="/OCare/Assets/Images/Ocare-logo.png">
        <div class="greeting">
            您好! <strong>admin</strong><a>注销</a><a>切换</a>
        </div>
        <div class="nav" >
            <ul>
                <li>
                    <a class="active item"><i class="home icon"></i> 首页</a>
                </li>
                <li>
                    <a class="item"><i class="gift icon"></i> 关于我们</a>
                </li>
                <li>
                    <a class="item"><i class="photo icon"></i> 幸福相册</a>
                </li>
                <li>
                    <a class="item"><i class="sitemap icon"></i> 合作伙伴</a>
                </li>
                <li>
                    <a class="item"><i class="phone icon"></i> 联系我们</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="sidebar">
    <div class="ui vertical menu">
        <a class="item">
            &nbsp;&nbsp;&nbsp;&nbsp;实时地图
            <i class="map icon"></i>
        </a>
        <div class="header item">
            <i class="male icon"></i>
            职员管理
        </div>
        <a class="item">
            &nbsp;&nbsp;&nbsp;&nbsp;职员列表
        </a>
        <a class="item">
            &nbsp;&nbsp;&nbsp;&nbsp;新增职员
        </a>
        <a class="item">
            &nbsp;&nbsp;&nbsp;&nbsp;职员管理
        </a>
        <div class="header item">
            <i class="legal icon"></i>
            合同管理
        </div>
        <a class="item">
            &nbsp;&nbsp;&nbsp;&nbsp;合同列表
        </a>
        <a class="item">
            &nbsp;&nbsp;&nbsp;&nbsp;上传合同
        </a>

        <div class="header item">
            <i class="book icon "></i>
            机构信息管理
        </div>
        <a class="item">
            &nbsp;&nbsp;&nbsp;&nbsp;已注册机构
        </a>
        <a class="item">
            &nbsp;&nbsp;&nbsp;&nbsp;添加新机构
        </a>
        <a class="item">
            &nbsp;&nbsp;&nbsp;&nbsp;申请审核
        </a>
    </div>
</div>

<script src="/OCare/Assets/JS/semantic.min.js"></script>
</body>
</html>
