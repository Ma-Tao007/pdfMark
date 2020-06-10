
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
        ,url: contextpath + '/sysuser/getList'
        ,toolbar: '#test-table-toolbar-toolbarDemo'
        ,height: 'full-100'
        ,cellMinWidth: 80
        ,page: true
        ,limit: 20
        ,cols: [[
            {type:'numbers'}
            ,{field:'username', title: '用户名', width:100}
            ,{field:'persname', title: '姓名', width:100}
            ,{field:'sex', title: '性别', width:100,templet:'#test-table-switchTpl', unresize: true}
            ,{field:'major', title: '所学专业', minWidth: 150}
            ,{field:'qualiy', title: '学历', minWidth: 150}
            ,{field:'skill', title: '技能', hide:true}
            ,{field:'birthday', title: '出生日期'}
            ,{field:'remark', title: '自我介绍', hide:true}
            ,{field:'phone', title: '电话', minWidth: 150}
            ,{field:'email', title: '邮箱', sort: true, align: 'right'}
            ,{
            field:'kind', title: '角色', sort: true,
                templet:function(row){
                return formatKind(row.kind)
                    },
                minWidth: 100, align: 'right'
                }
            ,{field:'status',title: '状态', sort: true, minWidth: 100,templet: '#test-table-checkboxTpl', align: 'right',unresize: true}
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

//监听锁定操作
    form.on('checkbox(test-table-lockDemo)', function(obj){
        var json = JSON.parse(decodeURIComponent($(this).data('json')));
        json = table.clearCacheKey(json);
        var msg = ''
        if(json.status==0){
            json.status = 1
            msg = "启用成功"
        }else{
            json.status = 0
            msg = "禁用成功"
        }
        $.ajax({
            url:contextpath+"/sysuser/update",
            type:"post",
            data:{"id":json.id,"status":json.status},
            success:function(data){
                layer.msg(msg, {icon: 1});
                $(".layui-laypage-btn")[0].click();
            }
        })

    });


    //监听行工具事件
    table.on('tool(test-table-toolbar)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){

                $.ajax({
                    url:contextpath+"/sysuser/delete",
                    type:"post",
                    data:data,
                    success:function(data){
                        layer.msg('删除成功', {icon: 1});
                        $(".layui-laypage-btn")[0].click();
                    }
                })

            });
        } else if(obj.event === 'edit'){
            if(top.layui.index){
                top.layui.index.openTabsPage("sysuser/show?id="+data.id,"用户查看")
            }else{
                window.open(url)
            }
        }
    });

});

function formatKind(kind){
    return kind==1?'管理员':'学生'
}
function formatStatus(status){
    return status==0?"禁用":'启用'
}

