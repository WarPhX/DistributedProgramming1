<!doctype html>
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="mycss.css">
  <script type="text/javascript" src="keyboard.js" charset="UTF-8"></script>
  <link rel="stylesheet" type="text/css" href="keyboard.css">
</head>  
<body>
  <%
    String act=(String)session.getAttribute("act2");
    if(act!="act2"){
  %>
    <jsp:forward page="/home.jsp"/>
  <%
    }    
  %>  
  <center>
  <h1> Pagina de apelare a servletului HelloServlet </h1>
  <form method="post"
        action="hello"> 
    <table>
       <tr>
          <td><label>Introduceti numele </label></td>
          <td>
            <input type="text" name="name" size="20" class="keyboardInput">
          </td>
       </tr>
       <tr>    
         <td>       
           <input type="submit" value="Transmite">
         </td>
       </tr>
    </table>       
    <input type="hidden" name="tip" value="text/html" >
  </form>
  </center>
</body>
</html>
