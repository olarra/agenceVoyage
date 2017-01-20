<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="hebergement.HebergementDBHandler" %>

	<!-- Header -->
	<jsp:include page="fragments/header.html"/>
	<!-- Navegation Gauche -->
	<jsp:include page="fragments/menu.html"/>

	<div class="col col-sm-9">
			<div class="panel">
			<h1 style="color:#ff3333;text-align:center">Les Offres</h1>

				<c:forEach var="hebergement" items="${hebergements}">
				<hr>

				<h2>${hebergement.type}</h2>
				<h4>${hebergement.pays}</h4>
				<img src="${hebergement.image}" height="100" width="150" class="img-responsive pull-right">${hebergement.description}
				<br><br><br><br>
				<button class="btn btn-default">More</button>
				</c:forEach>

				<hr>
				<h4><a href="#"><i class="glyphicon glyphicon-user"><i class="glyphicon glyphicon-chevron-down"></i></i> Inscrivez-vous</a></h4>
				<hr>
			</div>
	</div>
	<!-- Footer -->
		<jsp:include page="fragments/footer.html"/>
