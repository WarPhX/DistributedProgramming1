<!doctype html>
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="mycss.css">
</head>  
<body>
  <%
    String act=(String)session.getAttribute("act1");
    if(act!="act1"){
  %>
    <jsp:forward page="/home.jsp"/>
  <%
    }    
  %>  
  <center>
  <h1> Pagina de apelare CmmdcServlet </h1>
  <form method="get"
      action="cmmdc">  
      <table> 
        <tr>
          <td><label> Primul numar </label></td>
          <td>    
             <input type="number" name="m" size="5" 
             required  min="1">
          </td>
        </tr>  
        <tr>
          <td><label> Al doilea numar </label></td>
          <td>
             <input type="number" name="n" size="5" 
             required  min="1">
          </td>
        </tr>
        <tr>
          <td>          
             <p><input type="submit" value="Calculeaza">
          </td>
        </tr>
      </table>  
      <input type="hidden" name="tip" value="text/html" >
  </form>
  <center>
</body>
</html>

