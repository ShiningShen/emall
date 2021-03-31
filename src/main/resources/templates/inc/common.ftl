<#--分页-->
<#macro paging pageData>

<div style="text-align: center">
    <div id="laypage-main"></div>
    <script>
        layui.use('laypage', function(){
            var laypage = layui.laypage;

            //执行一个laypage实例
            laypage.render({
                elem: 'laypage-main'
                ,count: ${pageData.total}
                ,curr: ${pageData.current}
                ,limit: ${pageData.size}
                ,jump: function(obj, first){
                    //首次不执行
                    if(!first){
                        location.href = "?pn=" + obj.curr;
                    }
                }
            });
        });
    </script>
</div>
</#macro>

<#macro plisting product>

    <li>
        <a href="" class="fly-avatar">
            <img src="${product.pic}" >
        </a>
        <h2>
            <a href="/product/${product.id}">${product.title}</a>
        </h2>
        <div class="fly-list-info">
            <a href="" link>
                <cite>${product.sellerName}</cite>
            </a>
            <span>${product.created?string('yyyy-MM-dd')}</span>

            <span class="fly-list-money layui-hide-xs" title="money"> <span>销售价格：</span>${product.price}</span>
            <#if (product.salesCount gt 0)>
                <span class="layui-badge fly-badge-accept layui-hide-xs">已售出</span>
            </#if>
            <@shiro.hasRole name="seller">
                <span class="fly-list-nums"><span>销售量：</span>${product.salesCount} </span>
            </@shiro.hasRole>
        </div>
    </li>
</#macro>

<#--用户中心的左侧-->
<#macro centerLeft level>

<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
    <li class="layui-nav-item <#if level == 0> layui-this</#if>">
        <a href="/user/home">
            <i class="layui-icon">&#xe609;</i>
            我的主页
        </a>
    </li>
    <li class="layui-nav-item <#if level == 1> layui-this</#if>">
        <a href="/user/index">
            <i class="layui-icon">&#xe612;</i>
            用户中心
        </a>
    </li>
    <li class="layui-nav-item <#if level == 2> layui-this</#if>">
        <a href="/user/set">
            <i class="layui-icon">&#xe620;</i>
            基本设置
        </a>
    </li>
    <li class="layui-nav-item <#if level == 3> layui-this</#if>">
        <a href="/user/mess">
            <i class="layui-icon">&#xe611;</i>
            我的消息
        </a>
    </li>
</ul>
</#macro>