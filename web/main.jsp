<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="hebergement.HebergementDBHandler" %>

	<!-- Header -->
	<jsp:include page="fragments/header.html"/>
	<!-- Navegation Gauche -->
	<jsp:include page="fragments/menu.html"/>

	<div class="col col-sm-9">
			<div class="panel">
			<h1 style="color:#ff3333 !important; text-align:center">Annonces Maisons / Appartements</h1>

<div class="contenu">
				<c:forEach var="hebergement" items="${hebergements}">
					<div class="div row" data-eventtype="${hebergement.type}">
						   <span class="col-sm-4">
									<p class="Roboto-medium" style="font-size:17px; text-transform: capitalize; color:#e74c3c;"><i class="glyphicon glyphicon-home"></i> Type : ${hebergement.type}</p>
					 				<p class="Roboto-light"  style="font-size:17px; text-transform: capitalize; color:#2c3e50;"><i class="glyphicon glyphicon-globe"></i> Pays : ${hebergement.pays}</p>
					 				<p class="Roboto-light"  style="font-size:17px; text-transform: capitalize; color:#2c3e50;"><i class="glyphicon glyphicon-tag"></i> Nombre de pi&egrave;ces : ${hebergement.npieces}</p>
									<p><a class="md-trigger" data-modal="myModal${hebergement.idHebergement}" class="Roboto-regular" style="cursor: pointer; cursor: hand; font-size:17px; color:#3498db;"><i class="glyphicon glyphicon-eye-open"></i> Voir plus</a></p>
							</span>
						  <span class="col-sm-8">
									<img src="${hebergement.image}" height="100" width="150" class="img-responsive pull-right">
						</span>
					</div>
					<div class="md-modal md-effect-12" id="myModal${hebergement.idHebergement}">
						<div class="md-content">
							<h3>D&eacute;tails du longement</h3>
							<div>
								<p>Pour faire une demande contacter l'administrateur du site.</p>
								<ul>
									<li><strong>Type:</strong> ${hebergement.type}</li>
									<li><strong>Pays:</strong> ${hebergement.pays}</li>
									<li><strong>Surface:</strong> ${hebergement.surface} m2</li>
									<li><strong>Nombre de pi&egrave;ces:</strong> ${hebergement.npieces}</li>
									<li><strong>Address:</strong> ${hebergement.addresse}</li>
									<li><strong>Terrain_exterieur:</strong> ${hebergement.terrain_exterieur} m2</li>
									<li><strong>Description:</strong> ${hebergement.description}</li>
								</ul>
								<button class="md-close">Fermer!</button>
							</div>
						</div>
					</div>

				</c:forEach>

				<div class="md-overlay"></div><!-- the overlay element -->
</div>

<hr>
<h4><a href="#"><i class="glyphicon glyphicon-user"><i class="glyphicon glyphicon-chevron-down"></i></i> Inscrivez-vous</a></h4>



			</div>
	</div>
	<!-- Footer -->
		<jsp:include page="fragments/footer.html"/>
