<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
  <body bgcolor="#bbccbb">
    <%
      String act=(String)session.getAttribute("act1");
      if(act!="act1"){
    %>
      <jsp:forward page="/home.jsp"/>
    <%
      }    
    %>  
    <H1> CMMDC </H1>
    <%!
       long cmmdc(long m,long n){
       long c,r;
       do{
         c=n;
         r=m%n;
         m=n;
         n=r;
       }while(r!=0);
       return c;
       }
    %>
    <form method="post">
      <table> 
        <tr>
          <td><label> Primul numar </label></td>
          <td>    
             <input type="text" name="m" size="5" value="1"/>         
          </td>
        </tr>  
        <tr>
          <td><label> Al doilea numar </label></td>
          <td>
             <input type="text" name="n" size="5" value="1"/>
          </td>
        </tr>
        <tr>
          <td>          
             <p><input type="submit" value="Calculeaza">
          </td>
        </tr>
      </table>  
    </form>
    Rezultatul este 
    <% 
       String sm=request.getParameter("m");
       String sn=request.getParameter("n");
       System.out.println(sm+" : "+sn);          
       if(sm==null) sm="1";
       if(sn==null) sn="1";
       long m=Long.parseLong(sm.trim());
       long n=Long.parseLong(sn.trim());
       out.println(cmmdc(m,n));   
    %>
     <p><a href="<c:url value="/home.jsp"/>">Return to the home page.</a></p>

    <p><a href="<c:url value="/logout"/>">Log out.</a></p> 
  </body>
</html>
