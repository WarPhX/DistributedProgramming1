<html>
 <body bgcolor="#aaeeaa">
   <table>
       <%
         String act=(String)session.getAttribute("act1");
         if(act=="act1"){
       %>
       <tr>
         <td>
           <a href="cmmdc1pagina.jsp">Cmmdc</a>
         </td>
       </tr>  
       <%
         } 
         act=(String)session.getAttribute("act2");
         if(act=="act2"){
       %>    
         <tr>
           <td>
             <a href="hello1pagina.jsp">Hello</a>
           </td>
       </tr>  
       <%    
         }
       %>
    </table>
 </body
</html>   