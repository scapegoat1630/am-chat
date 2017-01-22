
  var NYLM, claerResizeScroll, conf, getRandomInt, insertI, lol;

  conf = {
    cursorcolor: "#696c75",
    cursorwidth: "4px",
    cursorborder: "none"
  };

  lol = {
    cursorcolor: "#cdd2d6",
    cursorwidth: "4px",
    cursorborder: "none"
  };

  NYLM = ["小豆豆"];

  claerResizeScroll = function() {
    $("#text").val("");
    $(".messages").getNiceScroll(0).resize();
    return $(".messages").getNiceScroll(0).doScrollTop(999999, 999);
  };

  insertI = function(data,id,path) {
    //2种推送的消息
    //1.用户聊天信息：发送消息触发
    //2.系统消息：登录和退出触发
    //===系统消息
    var messageDiv ;
      var randomHead = getRandomInt(1,290);
    if(data.from==undefined||data.from==null||data.from==""){
     //刷新联系人列表
        console.log(data);
        $(".list-friends").empty();
        $.each(data.users, function (index, user) {
            if( $(".list-friends li[id='" +user.id + "']").length <=0){
                var random = getRandomInt(1,290);
                userDiv =
                    "<li id=\""
                    + user.id
                    + "\">"
                    + "<img width=\"50\" height=\"50\" src=\""
                    + path + "/resources/userhead/" + random + ".jpg\">"
                    + "<div class=\"info\"><div class=\"user\">"
                    + user.nickname
                    + "</div><div class=\""
                    + "status on"
                    + "\">"
                    + "online"
                    + "</div></div></li>";
                $(".list-friends").prepend(
                    userDiv
                );
            };
        });

      messageDiv =
          "<li class=\""
          + "friend-with-a-SVAGina"
          + "\"><div class=\"head\"><img width=\"50\" height=\"50\" src=\""
          + path + "/resources/userhead/" +randomHead +  ".jpg"
          + "\"><span class=\"name\">"
          + "系统消息"
          + "</span><span class=\"time\">"
          + formatDate(data.date)
          + "</span></div><div class=\"message\">"
          + data.text
          +"</div></li>";
    }else if(data.from == id){
      messageDiv =
          "<li class=\""
          + "i"
          + "\"><div class=\"head\"><span class=\"time\">"
          + formatDate(data.date)
          + "</span><span class=\"name\">"
          + data.fromName
          + "</span><img width=\"50\" height=\"50\" src=\""
          + path + "/resources/userhead/" +randomHead +  ".jpg"
          + "\"></div><div class=\"message\">"
          + data.text
          +"</div></li>";
    }else{
      messageDiv =
          "<li class=\""
          + "friend-with-a-SVAGina"
          + "\"><div class=\"head\"><img width=\"50\" height=\"50\" src=\""
          + path + "/resources/userhead/" +randomHead +  ".jpg"
          + "\"><span class=\"name\">"
          + data.fromName
          + "</span><span class=\"time\">"
          + formatDate(data.date)
          + "</span></div><div class=\"message\">"
          + data.text
          +"</div></li>";
    };

      //判断消息类型
      $(".messages").append(
          messageDiv
      );
      claerResizeScroll();
      $('.message').last().parseEmotion();
  };