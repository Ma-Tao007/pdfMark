//使用该方法在调用改js之前需要先加载layer.js
function setTips(status,msg,method,time){
    var icon = status?1:2;
    layer.msg(msg,{icon:icon},function(){
        method()
    })
    setTimeout(function(){
        layer.closeAll()
    },time)
}
