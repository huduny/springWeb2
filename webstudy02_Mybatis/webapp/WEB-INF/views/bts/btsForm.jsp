<%@page import="kr.or.ddit.utils.CookieUtils"%>
<%@page import="kr.or.ddit.vo.BtsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
</head>
<body>
확인
<form method="post"> 
   <select name="member">
      <option value>멤버 선택</option>
      <%
            String selectedMember = new CookieUtils(request).getCookieValue("btsCookie");
            List<BtsVO> btsList = (List) request.getAttribute("btsList");
            for(BtsVO tmp : btsList){
               String selected = tmp.getId().equals(selectedMember) ? "selected" : "";
               %>
               <option <%=selected %> value="<%=tmp.getId() %>"><%=tmp.getName() %></option>
               <%
            }
         %>
   </select>
   <input type="submit" value="전송" />
</form>
<script type="text/javascript">
   $("form:first").on("submit",function(event){
      event.preventDefault();
      let url = this.action;
      let method = this.method;
      let data = $(this).serialize();
      let form = this; //closure가 발생 이게 뭔지 검색..
      $.ajax({
         url : url,
         method : method,
         data : data,
         dataType : "html", //Accept, Content-Type
         success : function(resp) {
            $(form).after(resp);
         },
         error : function(xhr, status, error) {
            console.log(xhr);
            console.log(status);
            console.log(error);
         }
      });
      return false;
   });
</script>
</body>
</html>







