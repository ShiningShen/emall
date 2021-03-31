<#include "/inc/common.ftl" />

<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="layui-tab">
                <ul class="layui-tab-title">
                    <li class="layui-this">全部</li>
                    <@shiro.hasRole name="buyer">
                    <li>未购买</li>
                    </@shiro.hasRole>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <ul class="fly-list">
                            <#list pageData.records as product>
                                <@plisting product></@plisting>
                            </#list>
                        </ul>
                        <@paging pageData></@paging>
                    </div>
                    <div class="layui-tab-item">
                        <ul class="fly-list">
                            <#list pageData.records as product>
                                <#if product.salesCount==0>
                                    <@plisting product></@plisting>
                                </#if>
                            </#list>
                        </ul>
                        <div id="laypage-main"></div>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>
<script src="/res/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        //触发事件
        var active = {
            tabAdd: function(){
                //新增一个Tab项
                element.tabAdd('demo', {
                    title: '新选项'+ (Math.random()*1000|0) //用于演示
                    ,content: '内容'+ (Math.random()*1000|0)
                    ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
                })
            }
            ,tabDelete: function(othis){
                //删除指定Tab项
                element.tabDelete('demo', '44'); //删除：“商品管理”


                othis.addClass('layui-btn-disabled');
            }
            ,tabChange: function(){
                //切换到指定Tab项
                element.tabChange('demo', '22'); //切换到：用户管理
            }
        };

        $('.site-demo-active').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });

        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);

        element.on('tab(test)', function(elem){
            location.hash = 'test='+ $(this).attr('lay-id');
        });
    });
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