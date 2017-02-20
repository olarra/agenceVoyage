<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="utilisateur.UtilisateurDBHandler" %>
<%@page import="utilisateur.IUtilisateurDB" %>
<%@page import="utilisateur.Utilisateur" %>

  <!-- Header -->
  <jsp:include page="fragments/header.html"/>
  <!-- Navegation Gauche -->
  <jsp:include page="fragments/menu.html"/>

  <div class="col col-sm-9">
      <div class="panel">
      <h1 style="color:#3498db;text-align:center">Login</h1>
      <hr>

      <div class="login-block">

          <form method="post" action="loginServlet" id="loggin">
            <input type="text" size="20" name="user" value="${cl.user}" placeholder="Username" id="username" />
            <input type="password" name="pass" value="${cl.pass}" placeholder="Password" id="password"/>
          </form>
          <button style="background:#3498db; border:1px solid #2ecc71;" type="submit" form="loggin" value="Submit">Submit</button>
      </div>

   </div>
  <!-- Footer -->
    <jsp:include page="fragments/footer.html"/>
