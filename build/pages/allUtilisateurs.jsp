<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="utilisateur.UtilisateurDBHandler" %>

		<!-- Header -->
		<jsp:include page="/fragments/header.html"/>
		<!-- Navegation Gauche -->
		<jsp:include page="/fragments/menu.html"/>

		<div class="col col-sm-9">
			<div class="panel">
					<div class="w3-container">
					  <h2>Liste des utilisateurs</h2>
						<hr>
					  <ul class="w3-ul w3-card-4">
							<c:forEach var="utilisateur" items="${utilisateur}">
						    <li class="w3-padding-16">
						      <span onclick="this.parentElement.style.display='none'"
						      class="w3-closebtn w3-padding w3-margin-right w3-medium">&times;</span>
						      <img src="http://tinygraphs.com/labs/isogrids/hexa16/${utilisateur}?theme=berrypie&numcolors=4&size=60&fmt=svg" class="w3-left w3-circle w3-margin-right" style="width:60px">
						      <span class="w3-xlarge">user : ${utilisateur.user}</span><br>
						      <span>e-mail : ${utilisateur.mail}</span>
						    </li>
							</c:forEach>
					  </ul>
				</div>
				</br>
				</br>
			</div>
	</div>
		<!-- Footer -->
		<jsp:include page="/fragments/footer.html"/>
