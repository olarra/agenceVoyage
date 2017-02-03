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
    			<h1 style="color:#ff3333;text-align:center">Inscrivez-vous</h1>
          <hr>

          <div class="login-block">

              <form method="post" action="addUtilisateurServlet?action=setNew" id="loggin">
              <input type="text" size="20" name="user" value="${cl.user}" placeholder="Username" id="username" />
              <input type="text" name="pass" value="${cl.pass}" placeholder="Password" id="password"/>
              <input type="text" name="mail" value="${cl.mail}" placeholder="Email" id="email" />
              </form>
              <button type="submit" form="loggin" value="Submit">Submit</button>
          </div>

    	</div>
    	<!-- Footer -->
    		<jsp:include page="fragments/footer.html"/>
