<div class="fly-header layui-bg-black">
    <div class="layui-container">

        <ul class="layui-nav fly-nav-user">
            <li class="layui-nav-item">
                <a href="/">首页</a>
            </li>

            <li class="layui-nav-item">
                <a class="iconfont icon-touxiang layui-hide-xs" href=""></a>
            </li>
            <@shiro.guest>
            <!-- 未登入的状态 -->
            <li class="layui-nav-item">
                <a href="/login">登录</a>
            </li>
            </@shiro.guest>

            <@shiro.user>

                <li class="layui-nav-item">
                    <a href=""><@shiro.principal property="username" /></a>
                </li>

                <@shiro.hasRole name="buyer">
                <!--表示为买家-->
            <li class="layui-nav-item">
                <a href="/order">财务</a>
            </li>
<#--            <li class="layui-nav-item">-->
<#--                <a class="iconfont icon-cart layui-hide-xs" href="user/cart.html"></a>-->
<#--            </li>-->
            <li class="layui-nav-item">
                <a href="/cart">购物车</a>
            </li>
            </@shiro.hasRole>
                <li class="layui-nav-item">
                    <a href="user/logout">退出</a>
                </li>
            </@shiro.user>

        </ul>
    </div>
</div>