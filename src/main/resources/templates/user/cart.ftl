

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>购物车</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="emall">
    <meta name="description" content="内容售卖商城">
    <link rel="stylesheet" href="/res/layui/css/layui.css">
    <link rel="stylesheet" href="/res/css/global.css">
    <link rel="stylesheet" href="/res/css/base.css">
    <link rel="stylesheet" href="/res/css/style.css">

</head>
<body>
<#include "/inc/header.ftl" />
<@shiro.hasRole name="seller">
    <!--表示为卖家-->
    <#include "/inc/header-panel.ftl" />
</@shiro.hasRole>


<#include "/inc/cart-container.ftl" />
</body>
</html>
