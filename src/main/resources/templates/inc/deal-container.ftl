<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">

            <div class="fly-panel" style="margin-bottom: 0;">


                <ul class="fly-list">
                    <ul class="fly-list">
                        <#list pageData.records as deal>
                            <li>
                                <a href="" class="fly-avatar">
                                    <img src="${deal.postPic}" >
                                </a>
                                <h2>
                                    <a href="">${deal.title}</a>
                                </h2>
                                <div class="fly-list-info">
                                    <span><span>购买日期：</span>${deal.created?string('yyyy-MM-dd')}</span>
                                    <span class="fly-list-money layui-hide-xs" title="money"> <span>购买价格：</span>${deal.price}</span>
                                    <span><span>购买数目：</span>${deal.postNum}</span>
                                    <span><span>总价：</span>${deal.sum}</span>
                                </div>
                            </li>
                        </#list>

                    </ul>
        </div>

    </div>
</div>