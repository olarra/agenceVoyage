<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="utilisateur.UtilisateurDBHandler" %>


		<!-- Header -->
		<jsp:include page="/fragments/header.html"/>
		<!-- Navegation Gauche -->
		<jsp:include page="/fragments/menu.html"/>

		<div class="col col-sm-9">
				<div class="panel">
				<h1 style="color:#ff3333;text-align:center">Les links</h1>

				<h2>bienvenu : ${UserNameSession.user} </h2>
				<p>idUser : ${UserNameSession.idUtilisateur}</p>

				<c:forEach var="hebergement" items="${hebergements}">

					<c:if test="${hebergement.idHebergement != null}">
						<hr>
						<p>type : ${hebergement.idHebergement}</p>
						<p>type : ${hebergement.type}</p>
						<p>pays : ${hebergement.pays}</p>
						<p>surface : ${hebergement.surface}</p>
						<a href="showLinks?hbToDelete=${hebergement.idHebergement}" class="btn btn-danger btn-sm">
		        <i class="glyphicon glyphicon-remove"></i> Delete
		    		</a>
					</c:if>
				</c:forEach>


					<hr>
					<h4><a href="#"><i class="glyphicon glyphicon-user"><i class="glyphicon glyphicon-chevron-down"></i></i>Inscrivez-vous</a></h4>
					<hr>
				</div>
		</div>
		<!-- Footer -->
		<jsp:include page="/fragments/footer.html"/>
