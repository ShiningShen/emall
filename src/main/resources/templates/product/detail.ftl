<#include "/inc/layout.ftl" />

<@layout "商品详情">

    <@shiro.hasRole name="seller">
        <!--表示为卖家-->
        <#include "/inc/header-panel.ftl" />
    </@shiro.hasRole>

    <div class="layui-container">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md8 content detail">
                <div class="fly-panel detail-box">
                    <h1>${product.title}</h1>
                    <div class="fly-detail-info">
                        <#if product.salesCount gt 0><span class="layui-badge layui-bg-black">已售出</span></#if>
                        <@shiro.hasRole name="seller">
                            <div class="fly-admin-box" data-id="${product.id}">
                                <#if product.sellerId == profile.id><span class="layui-btn layui-btn-xs jie-admin" type="del">删除</span></#if>
                            </div>
                        </@shiro.hasRole>
                    </div>
                    <div class="detail-about">
                        <a class="fly-avatar" href="">
                            <img src="${product.pic}" alt="${product.sellerName}">
                        </a>
                        <div class="fly-detail-user">
                            <span>${product.sellerName}</span>
                            <span>${product.created?string('yyyy-MM-dd')}</span>
                        </div>
                        <div class="detail-hits" id="LAY_jieAdmin" data-id="${product.id}">
                            <#if profile.id == product.sellerId>
                                <span class="layui-btn layui-btn-xs jie-admin" type="edit">
                                <a href="/product/edit?id=${product.id}">编辑商品</a></span>
                            </#if>
                        </div>
                    </div>
                    <div class="detail-body photos">
                        ${product.pabstract}
                    </div>
                    <@shiro.hasRole name="seller">
                        <#if profile.id == product.sellerId>
                            <div class="detail-body photos">
                                ${product.content}
                            </div>
                        </#if>
                    </@shiro.hasRole>

                    <@shiro.hasRole name="buyer">
                        <!--还未出售-->
                        <#if product.buyerId==null>
                            <div class="detail-body photos">
                                购买后可查看
                            </div>
                    <div class="layui-form layui-form-pane">
                            <form action="/cart/buy" method="post">
                                <div class="layui-form-item">
                                    <input type="hidden" name="id" value="${product.id}">
                                    <button class="layui-btn" lay-filter="*" lay-submit alert="true">购买商品</button>

                                </div>
                            </form>
                    </div>
                        <#elseif profile.id == product.buyerId>
                            <div class="detail-body photos">
                                ${product.content}
                            </div>
                        <#elseif profile.id != product.buyerId>
                            <div class="detail-body photos">
                                该内容已出售，不可购买和查看
                            </div>
                        </#if>

                    </@shiro.hasRole>

                </div>

            </div>
        </div>
    </div>

</@layout>
<script>
    layui.cache.page = 'jie';
</script>