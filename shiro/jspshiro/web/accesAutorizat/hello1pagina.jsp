<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
  <body bgcolor="#bbccbb">
    <%
      String act=(String)session.getAttribute("act2");
      if(act!="act2"){
    %>
      <jsp:forward page="/home.jsp"/>
    <%
      }    
    %>  
    <center>
      <form method="post">
        <p> Numele: 
        <input type="text" name="name" size=20>
        <p>
        <input type="submit">
      </form>
      <% 
        out.println("Hi "+request.getParameter("name")+" !"); 
      %>
      <p><a href="<c:url value="/home.jsp"/>">Return to the home page.</a></p>

      <p><a href="<c:url value="/logout"/>">Log out.</a></p> 
    </center>
  </body>
</html>
