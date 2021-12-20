<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01/gugudanForm.html</title>
<script type="text/javascript" src="../resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<form action="../gugudan.do" id="gugudanForm" method="get">
<input type="number" name="minDan" min="2" max="9"/>
<select name="maxDan">
   <option value>맥스단</option>
   <%
      for(int dan=2; dan<=9; dan++){
   %>
         <option value="<%=dan %>"><%=dan +"단"%></option>
   <%
      }
   %>
</select>
<button type="submit">전송</button>
<button type="button">걍버튼</button>
<button type="reset">취소</button>
</form>
<div id="resultArea"></div>
<script type="text/javascript">
   $("#gugudanForm").on("submit", function(event){
      event.preventDefault();
      
      let url = this.action;
      let method = this.method;
      let data = $(this).serialize();
      console.log(data);
      
      $.ajax({
         url : url,
         data : data,
         method : method,
         dataType : "html",
         success : function(resp){
            $("#resultArea").html(resp);
         },
         error : function(){
            
         }
      });
      
      return false;
   });
</script>
</body>
</html>









