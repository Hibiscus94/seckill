<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>秒杀详情</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default text-center">
        <div class="panel-heading">
            ${seckill.name}
        </div>
        <div class="panel-body">
            <div id="count-box" class="text-center"></div>
        </div>
    </div>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="phone" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">手机号码</h4>
            </div>
            <div class="modal-body">
                <form role="form">
                    <div class="form-group">
                        <input type="text" name="phoneNum" id="phoneNum" class="form-control" placeholder="手机号码">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <span id="phoneMessage"></span>
                <button type="button" class="btn btn-info" id="phoneBtn">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="https://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js"></script>
<script>
    $(document).ready(function () {
        var seckill = {
            // 秒杀相关url
            url: {
                now:'/seckill/time/now',
                exposer:function (seckillId) {
                    return '/seckill/'+seckillId+'/exposer';
                },
                execution:function (seckillId,md5) {
                    return '/seckill/'+seckillId+'/'+md5+'/execution';
                }
            },
            // 验证手机号
            validatePhone: function (phone) {
                if (phone && phone.length == 11 && !isNaN(phone)) {
                    return true;
                }
                return false;
            },
            // 获取秒杀地址，执行秒杀
            handleKill:function (seckillId,node) {
                node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
                $.post(seckill.url.exposer(seckillId),{},function (res) {
                    // 交互
                    if (res && res.success){
                        var exposer = res.data;
                        if (exposer.exposed){
                            // 开启秒杀
                            var md5 = exposer.md5;
                            $('#killBtn').one('click',function () {
                                $(this).addClass('disabled');
                                $.post(seckill.url.execution(seckillId,md5),{},function (res) {
                                    var result = res.data;
                                    var state = result.state;
                                    var stateInfo = result.stateInfo;
                                    if(res && res.success){
                                        node.html('<button class="btn btn-success">'+ stateInfo+'</button>');
                                    }else{
                                        node.html('<button class="btn btn-warning">'+ stateInfo+'</button>');
                                    }
                                },'json');
                            });
                            node.show();
                        }else{
                            // 未开启秒杀
                            var now = exposer.now;
                            var start = exposer.start;
                            var end = exposer.end;
                            seckill.countDown(seckillId,now,start,end);
                        }
                    }else{
                        console.log(res);
                    }
                },'json');
            },
            countDown:function (seckillId, nowTime,startTime,endTime) {
                var countBox = $('#count-box');
                if (nowTime>endTime){
                    // 秒杀结束
                    countBox.html('<button class="btn btn-warning">秒杀结束~</button>');
                }else if (nowTime<startTime){
                    // 秒杀未开始
                    var killTime = new Date(startTime + 1000);
                    console.log(killTime);
                    countBox.countdown(killTime, function(event) {
                        $(this).html(
                            event.strftime('秒杀倒计时：%D 天 %H时:%M分:%S秒')
                        );
                        /* 倒计时结束后回调 */
                    }).on('finish.countdown',function () {
                        seckill.handleKill(seckillId,countBox);
                    });
                }else{
                    seckill.handleKill(seckillId,countBox);
                }
            },
            detail: {
                init: function (obj) {
                    // cookie 中查找手机
                    var phone = $.cookie('phone');
                    var startTime = obj.startTime;
                    var endTime = obj.endTime;
                    var seckillId = obj.seckillId;
                    // 验证手机号
                    if (!seckill.validatePhone(phone)) {
                        var phoneModal = $('#phone');
                        // 显示弹出层
                        phoneModal.modal({
                            show: true,
                            backdrop: 'static',
                            keyboard: false});
                        $('#phoneBtn').on('click',function () {
                            var phoneNum = $('#phoneNum').val();
                            if (seckill.validatePhone(phoneNum)){
                                // 更新cookie
                                $.cookie('phone',phoneNum,{expires:7,path:'/seckill'});
                                window.location.reload();
                            }else{
                                $('#phoneMessage').hide().html('<label class="label label-danger">手机号错误</label>').show(300);
                            }
                        });
                    }
                    $.get(seckill.url.now,{},function (res) {
                        if (res.success){
                            var nowTime = res.data;
                            seckill.countDown(seckillId,nowTime,startTime,endTime);
                        }
                    },'json');
                }
            }
        };
        seckill.detail.init({
            seckillId: ${seckill.seckillId},
            startTime: ${seckill.startTime.time}, // 毫秒
            endTime: ${seckill.endTime.time}
        });
    });
</script>
</body>
</html>