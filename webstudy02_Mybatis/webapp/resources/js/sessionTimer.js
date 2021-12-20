/**
 * 
 */
//<div id="msgArea">
//   세션 연장할래?
//   <input type="button" value="예" id="yesBtn" class="controlBtn">
//   <input type="button" value="아니오" id="noBtn" class="controlBtn">
//</div>

$.fn.sessionTimer = function(timeout){
   const TIMEOUT = timeout;
   const SPEED = 100;
   let time = TIMEOUT;
   let timeArea = this;
   //속성을 만들때도 prop나 attr
   //<> 만든다 , 없으면 찾는다
   let msgArea = $("<div>").prop("id", "msgArea")
           .append(
            $("<span>").html("세션 연장 ㄱㄱ?")
            ,$("<input>").attr({
               type:"button"
               , value:"예"
               , id:"yesBtn"
            }).addClass("controlBtn")
            ,$("<button>").attr({
               type:"button"
               , id:"noBtn"
            }).addClass("controlBtn")
              .text("아니오")
           );
   
   timeArea.after(msgArea);
   
   msgArea.hide().on("click", ".controlBtn" ,function(){
      if(this.id == "yesBtn") {
         init();
      }
      msgArea.hide();
//       console.log($(this).prop("id"));
//       console.log($(this).attr("id"));
//       console.log($(this).prop("disabled"));
//       console.log($(this).attr("disabled"));
   }); //controlBtn에 대해 동작하는 핸들러 msgArea 아님

   
   function init(){
      time = TIMEOUT;
      setTimeout(function(){
         msgArea.show();
      }, (TIMEOUT - 60) * SPEED);
      $.ajax({
         method : "head"
      });
   }
   
   const TIMEPTRN = "%D:%S";
   let timeFormat = function(time){
      let min = Math.trunc(time / 60);
      let sec = time % 60;
      return TIMEPTRN.replace("%D", min).replace("%S", sec);
   }
   
   let timerJob = setInterval(() => {
      if(time>0){
         let text = timeFormat(--time);
         timeArea.html(text);
      } else {
         clearInterval(timerJob);
//          location.reload();
      }
   }, 1*SPEED);
   
   setTimeout(function(){
      msgArea.show();
   }, (TIMEOUT - 60) * SPEED);
}

