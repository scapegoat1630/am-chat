/**
 * Created by zhangpeng12 on 2017/1/9.
 */
//毫秒级时间戳转换成前端需要的样式
function   formatDate(now)   {
    var   d;
    if(now == null || now <=0){
        d = new Date();
    }else{
       d  = new   Date(now);
    }
    var   year=d.getYear();
    var   month=d.getMonth()+1;
    var   date=d.getDate();
    var   hour=d.getHours();
    var   minute=d.getMinutes();
    var   second=d.getSeconds();
    var pm = hour > 12;
    //return   year+"-"+month+"-"+date+"   "+hour+":"+minute+":"+second;
    return   (pm ? hour - 12:hour) + ":" + ("000" + minute ).substr( -2 ) + (pm ? " pm":" am");
}
//格式化日期
Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
getRandomInt = function(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
};