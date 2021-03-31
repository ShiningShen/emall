<#include "/inc/layout.ftl" />

<@layout "商品发布">
  <div class="layui-container fly-marginTop">
    <div class="fly-panel" pad20 style="padding-top: 5px;">
      <div class="layui-form layui-form-pane">
        <div class="layui-tab layui-tab-brief" lay-filter="user">
          <ul class="layui-tab-title">
            <li class="layui-this"><#if !product??>发表商品<#else>编辑商品</#if></li>
          </ul>
          <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
            <div class="layui-tab-item layui-show">
              <form action="/product/submit" method="post">
                <div class="layui-row layui-col-space15 layui-form-item">
                  <div class="layui-col-md9">
                    <label for="L_title" class="layui-form-label" >标题</label>
                    <div class="layui-input-block">
                      <input type="text" id="L_title" name="title" value="${product.title}" class="layui-input">
                      <input type="hidden" name="id" value="${product.id}">
                    </div>
                  </div>
                </div>
<#--                <#list uploadTypy as t>-->
                <div class="layui-form-item">
                  <label class="layui-form-label">产品图片</label>
<#--                  <div class="layui-input-block" id="uploadPic">-->
<#--                    <input type="radio" name="pic" value="upload" title="上传图片" checked="">-->
<#--                    <input type="radio" name="pic" value="url" title="url输入">-->
<#--                  </div>-->

                  <div class="layui-col-md9" id="urlUpload">
                       <input type="text" id="L_title"  name="pic"  value="${product.pic}" class="layui-input" />
                  </div>

                  <div class="layui-col-md9" id="picUpload">
                    <button type="button" class="layui-btn layui-btn-danger" id="test7"><i class="layui-icon"></i>上传图片</button>
                    <img class="layui-upload-img" id="demo1" src="${product.pic}">
                    <div class="layui-inline layui-word-aux">
                    </div>
                    </div>
                  </div>

                <div class="layui-form-item layui-form-text">
                  <div class="layui-input-block">
                    <textarea id="L_content" name="pabstract"  placeholder="摘要长度在2-140个字符内" class="layui-textarea fly-editor" style="height: 260px;">${product.pabatract}</textarea>
                  </div>
                </div>
                <div class="layui-form-item layui-form-text">
                  <div class="layui-input-block">
                    <textarea id="L_content" name="content"  placeholder="正文长度在2-1000个字符内" class="layui-textarea fly-editor" style="height: 260px;">${product.content}</textarea>
                  </div>
                </div>
                <div class="layui-row layui-col-space15 layui-form-item">
                  <div class="layui-col-md3">
                    <label placeholder="¥" for="L_title" class="layui-form-label">价格</label>
                    <div class="layui-input-block">
                      <input type="text" id="L_title" name="price" value="${product.price}" required lay-verify="required" autocomplete="off" class="layui-input">
                      <input type="hidden" name="id" value="${product.id}">
                    </div>
                  </div>
                </div>
                <div class="layui-form-item">
                  <button class="layui-btn" lay-filter="*" lay-submit alert="true">立即发布</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
  <script>
    layui.use('upload', function(){
      var $ = layui.jquery
              ,upload = layui.upload;

      //设定文件大小限制
      upload.render({
        elem: '#test7'
        ,url: '/pic/upload' //改成您自己的上传接口
        ,size: 1024 //限制文件大小，单位 KB
        ,before: function(obj){
          //预读本地文件示例，不支持ie8
          obj.preview(function(index, file, result){
            $('#demo1').attr('src', result); //图片链接（base64）
          });
        }
        ,done: function(res){
          layer.msg('上传成功');
          console.log(res)
        }

      });
    });
  </script>
</@layout>
