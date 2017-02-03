<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="utilisateur.UtilisateurDBHandler" %>


		<!-- Header -->
		<jsp:include page="/fragments/header.html"/>
		<!-- Navegation Gauche -->
		<jsp:include page="/fragments/menu.html"/>

		<div class="col col-sm-9">
				<div class="panel">
				<h1 style="color:#ff3333;text-align:center">Utilisateurs</h1>

     <c:forEach var="utilisateur" items="${utilisateur}">
					<hr>
					<h2>${utilisateur.idUtilisateur}</h2>
					<h2>${utilisateur.user}</h2>
					<h4>${utilisateur.pass}</h4>
					<p>${utilisateur.mail}</p>
					<br><br><br><br>
					<button class="btn btn-default">More</button>
				</c:forEach>

				</div>
		</div>
		<!-- Footer -->
		<jsp:include page="/fragments/footer.html"/>
