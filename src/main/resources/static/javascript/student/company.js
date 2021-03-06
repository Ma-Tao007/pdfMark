
var contextpath = $("#contextpath").val()
layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'table','form'], function(){
    var admin = layui.admin
        ,table = layui.table
        ,form = layui.form
        ,$ = layui.$;
    table.render({
        elem: '#test-table-height'
        ,url: contextpath + '/company/getList'
        // ,toolbar: '#test-table-toolbar-toolbarDemo'
        ,height: 'full-100'
        ,cellMinWidth: 80
        ,page: true
        ,limit: 20
        ,cols: [[
            {type:'numbers'}
            // ,{field:'companyno', title: '企业编码', width:100}
            ,{field:'companyname', title: '企业名称', width:100}
            ,{field:'post', title: '招聘职位', width:100}
            // ,{field:'location', title: '企业地址', minWidth: 150}
            // ,{field:'people', title: '负责人'}
            // ,{field:'peoplephone', title: '负责人手机'}
            ,{field:'date', title: '发布时间'}
            ,{field:'type', title: '面试方式'}
            ,{field:'qualiy', title: '学历要求', sort: true }
            ,{field:'money', title: '薪资待遇', sort: true}
            ,{fixed: 'right', title:'操作', toolbar: '#test-table-toolbar-barDemo', width:150}
        ]]
    });

//监听性别操作
    form.on('switch(test-table-sexDemo)', function(obj){
        var json = JSON.parse(decodeURIComponent($(this).data('json')));
        layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);

        json = table.clearCacheKey(json);
        console.log(json); //当前行数据
    });
    var $ = layui.$, active = {
        reload: function(){
            var companyname = $('#companyname');
            var post = $('#post');
            var qualiy = $('#qualiy');

            //执行重载
            table.reload('test-table-height', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {

                        companyname: companyname.val(),
                        post: post.val(),
                        qualiy: qualiy.val()

                }
            });
        }
    };

    $('.test-table-reload-btn .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //监听行工具事件
    table.on('tool(test-table-toolbar)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            data.isdel = 1
            layer.confirm('真的删除行么', function(index){

                $.ajax({
                    url:contextpath+"/company/updata",
                    type:"post",
                    data:data,
                    success:function(data){
                        layer.msg('删除成功', {icon: 1});
                        $(".layui-laypage-btn")[0].click();
                    }
                })

            });
        } else if(obj.event === 'show'){
            $.ajax({
                url:contextpath+"/company/getUser",
                type:"post",
                data:data,
                success:function(data){
                    if(data.data.persname){
                        layer.msg('简历投递成功', {icon: 1});
                    }else{
                        layer.msg('请完善个人简历后投递', {icon: 2});
                    }
                }
            })

        }else if(obj.event === 'edit'){
            if(top.layui.index){
                top.layui.index.openTabsPage("company/show?id="+data.id+"&type=0","企业查看")
            }else{
                window.open(url)
            }
        }
    });

});

function formatKind(kind){
    return kind==0?'管理员':'学生'
}
function formatStatus(status){
    return status==0?"禁用":'启用'
}

