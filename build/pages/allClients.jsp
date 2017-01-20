<%@page import="agence.IClientDB" %>
<%@page import="agence.ClientDBStub" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


		<!-- Header -->
		<jsp:include page="fragments/header.html"/>
		<!-- Navegation Gauche -->
		<jsp:include page="fragments/menu.html"/>

		<div class="col col-sm-9">
				<div class="panel">
				<h1 style="color:#ff3333;text-align:center">Les Offres</h1>

					<c:set var="db" value="<%= new ClientDBStub() %>" />
        	<c:forEach var="client" items="${db.getAll()}">
					<hr>
					<h2>${client.user}</h2>
					<h4>${client.pass}</h4>
					${client.mail}
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