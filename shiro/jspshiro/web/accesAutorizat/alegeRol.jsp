<html>
 <body bgcolor="#aaeeaa">
   <%
     String rol=(String)session.getAttribute("rol");
     out.println(rol);
     if(rol=="rol1"){
   %>
       <jsp:forward page="alegeActiune.jsp"/>
   <%
     } 
     if(rol=="rol2"){
   %>    
       <jsp:forward page="alegeActiune.jsp"/>
   <%    
     }
   %>
   
 </body
</html>   