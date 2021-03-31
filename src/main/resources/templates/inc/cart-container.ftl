

<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>购物车</legend>
            </fieldset>
            <div class="fly-panel" style="margin-bottom: 0;">

                <div class="layui-form">
                    <table class="layui-table">
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col width="200">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>商品标题</th>
                            <th>商品价格</th>
                            <th>商品数量</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list pageData.records as cart>
                        <tr>
                            <td>${cart.title}</td>
                            <td>${cart.price}</td>
                            <td>${cart.postNum}</td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="layui-form layui-form-pane">

                    <form action="/deal/buy" method="post">
                        <div class="layui-form-item">
                            <button class="layui-btn" id="back" >退出</button>
                            <input type="hidden" name="buyerId" value="${profile.id}">
                            <button class="layui-btn" lay-filter="*" lay-submit alert="true">购买</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<script>


</script>