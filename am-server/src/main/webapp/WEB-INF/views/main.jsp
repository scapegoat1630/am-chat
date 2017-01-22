<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getServerName() + ":" + request.getServerPort() + path + "/";
String baseUrlPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>阿姆娱乐聊天室</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.sinaEmotion.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/sockjs.min.js"></script>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/nicescroll/3.5.4/jquery.nicescroll.js'></script>
	<script src='${pageContext.request.contextPath}/resources/js/jquery.sinaEmotion.js'></script>
	<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
	<script type="text/javascript">
		  var path = '<%=basePath%>';
		  //当前用户id
		  var uid='${sessionScope.loginUser.id}';
		  //当前用户id
		  var from='${sessionScope.loginUser.id}';
		  //当前用户名称
		  var fromName='${sessionScope.loginUser.nickname}';
		  //接收人编号
		  var to="-1";
		 function getNewWEbsocket() {
			 if ('WebSocket' in window) {
				 return new WebSocket("ws://" + path + "ws");
				 //火狐
			 } else if ('MozWebSocket' in window) {
				 return new MozWebSocket("ws://" + path + "ws");
			 } else {
				 return new SockJS("http://" + path + "ws/sockjs");
			 };
		 };
		  /**创建一个Socket实例
		   *参数为URL，ws表示WebSocket协议。
		   * onopen、onclose和onmessage方法把事件连接到Socket实例上。
		   * 每个方法都提供了一个事件，以表示Socket的状态。
		   */
		  var websocket = getNewWEbsocket();
		  //不同浏览器的WebSocket对象类型不同

		  //打开Socket,
		  websocket.onopen = function(event) {
			  console.log("WebSocket:已连接");
		  }
		  // 监听WebSocket的关闭
		  websocket.onclose = function(event) {
			  //todo 系统消息，监听WebSocket的关闭
			  console.log("WebSocket:已关闭：Client notified socket has closed",event);
			  websocket = getNewWEbsocket();
		  };
		  //监听异常
		  websocket.onerror = function(event) {
			  //todo 系统消息，监听WebSocket异常
			  console.log("WebSocket:发生错误 ",event);
			  websocket = getNewWEbsocket();
		  };
		  // 监听消息
		  /**
		   *onmessage事件提供了一个data属性，它可以包含消息的Body部分。
		   * 消息的Body部分必须是一个字符串，可以进行序列化/反序列化操作，以便传递更多的数据。
		   */
		  websocket.onmessage = function(event) {
			  console.log('Client received a message',event);
			  var data=$.parseJSON(event.data);
			  console.log("WebSocket:收到一条消息",data);
			 insertI(data,uid,'${pageContext.request.contextPath}');
		  }
		  //使用ctrl+回车快捷键发送消息
		  function keySend(e) {
			  var theEvent = window.event || e;
			  var code = theEvent.keyCode || theEvent.which;
			  if (code == 13) {
				  var msg=$("#text");
				  if (msg.innerHTML == "") {
					  msg.focus();
					  return false;
				  }
				  sendMsg();
			  }
		  }
		  //发送消息
		  function sendMsg(){
			  //对象为空了
			  if(websocket==undefined||websocket==null){
				  //alert('WebSocket connection not established, please connect.');
				  alert('您的连接已经丢失，请退出聊天重新进入');
				  return;
			  }
			  //获取用户要发送的消息内容
			  var msg=$("#text").val();
			  if(msg==""){
				  return;
			  }else{
				  var data={};
				  data["from"]=from;
				  data["fromName"]=fromName;
				  data["to"]=to;
				  data["text"]=msg;
				  //发送消息
				  websocket.send(JSON.stringify(data));
				  //发送完消息，清空输入框
				  $("#text").val("");
			  }
		  }
		  //关闭Websocket连接
		  function closeWebsocket(){
			  if (websocket != null) {
				  websocket.close();
				  websocket = null;
			  }
		  }
		  //onload初始化
		  $(function(){
			  $(".list-friends").niceScroll(conf);
			  $(".messages").niceScroll(lol);
			  //发送消息
			  $("#sendBtn").on("click",function(){
				  sendMsg();
			  });
			  //给退出聊天绑定事件
			  $("#exitBtn").on("click",function(){
				  closeWebsocket();
				  location.href="${pageContext.request.contextPath}/index.jsp";
			  });
			  //给输入框绑定事件
			  $("#text").on("keydown",function(event){
				  keySend(event);
			  });
			  //获取历史聊天记录
			  $.get(
					  '${pageContext.request.contextPath }/chat/chatHistory',
					  function(data){
						  var response = eval(data);
						  console.log(response);
						  for(var i = 0; i < response.length;i++){
							  console.log(response[i]);
							  insertI($.parseJSON(response[i]),uid,'${pageContext.request.contextPath}');
						  }
					  }
			  );
			  //初始化时如果有消息，则滚动条到最下面
			  claerResizeScroll();
			  var textDiv =   $("#text");
			  $('.fa-picture-o').bind({
				  click: function(event){
					  if(! $('#sinaEmotion').is(':visible')){
						  $(this).sinaEmotion(textDiv);
						  event.stopPropagation();
					  }
				  }
			  });

		  });
	  </script>
  </head>

  <body>

    	<div class="ui">
		<div class="left-menu">
				<menu class="list-friends">
				</menu>
		</div>
		<div class="chat">

			<div class="top">
				<div class="avatar">
					<img width="50" height="50" src="${pageContext.request.contextPath}/resources/userhead/44.jpg">
				</div>
				<div class="info">
					<div class="name">阿姆娱乐聊天室</div>
					<div class="count"> 1902 消息</div>
				</div>
			</div>


			<ul class="messages">

			</ul>

			<div class="write-form">
				<textarea placeholder="Type your message" name="e" id="text"  rows="2"></textarea>
				<i class="fa fa-picture-o"></i>
				<i class="fa fa-file-o"></i>
				<span class="send" id = "sendBtn">发送</span>
			</div>
		</div>
	</div>


  </body>
</html>
