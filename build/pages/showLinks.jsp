<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="utilisateur.UtilisateurDBHandler" %>

<!-- Header -->
<jsp:include page="/fragments/header.html"/>
<!-- Navegation Gauche -->
<jsp:include page="/fragments/menu.html"/>

<div class="col col-sm-9">
	<div class="panel">
	<h1 style="color:#ff3333;text-align:center">Vos annonces <span style="color:#3498db"> ${UserNameSession.user}</span></h1>

	<c:if test="${UserNameSession.user != null}">
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
</c:if>

<c:if test="${UserNameSession.user == null}">
	</br>
	<h5 class="Roboto-light">Il faut se logger sur l'application</h5>
</c:if>

		<hr>
	</div>
</div>

<!-- Footer -->
<jsp:include page="/fragments/footer.html"/>
