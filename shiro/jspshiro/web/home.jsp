<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>
<body>

  <h1>Autentificare (Apache Shiro) </h1>

  <p>Salut  
      <shiro:guest>Guest</shiro:guest>
      <shiro:user><shiro:principal/></shiro:user>!
      
      <shiro:user>
        <table>
          <tr>          
            <td>
              <a href="<c:url value="/accesAutorizat/alegeActiune.jsp"/>">Ac&#355;iuni</a>
            </td>
          </tr>
          <tr>
            <td>
              <a href="<c:url value="/logout"/>">Log out</a>
            </td>
          </tr>         
        </table>  
      </shiro:user>
      <shiro:guest>
        <a href="<c:url value="/login.jsp"/>">Log in</a> 
      </shiro:guest> 
  </p>

  <h3>Rolurile d-voastr&#259;</h3>

  <p>
      <shiro:hasRole name="admin">admin<br/></shiro:hasRole>
      <shiro:hasRole name="rol1">rol1<br/>
        <%
          session.setAttribute("rol","rol1");
        %>
      </shiro:hasRole>
      <shiro:hasRole name="rol2">rol2<br/>
        <%
          session.setAttribute("rol","rol2");
        %>
      </shiro:hasRole>
  </p>

  <h3>Roluri pe care nu le ave&#355;i</h3>

  <p>
      <shiro:lacksRole name="admin">admin<br/></shiro:lacksRole>
      <shiro:lacksRole name="rol1">rol1<br/></shiro:lacksRole>
      <shiro:lacksRole name="rol2">rol2<br/></shiro:lacksRole>
  </p>
  
  <h3>Activit&#259;&#355;ile d-voastr&#259;</h3>

  <p>
      <shiro:hasPermission name="act1">act1<br/>
         <%
          session.setAttribute("act1","act1");
        %>
      </shiro:hasPermission>
      <shiro:hasPermission name="act2">act2<br/>
        <%
          session.setAttribute("act2","act2");
        %>
      </shiro:hasPermission>
  </p>

  <h3>Activit&#259;&#355;i de care nu dispune&#355;i</h3>

  <p>
      <shiro:lacksPermission name="act1">act1<br/></shiro:lacksPermission>
      <shiro:lacksPermission name="act2">act2<br/></shiro:lacksPermission>
  </p>
</body>
</html>
