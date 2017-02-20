<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="hebergement.HebergementDBHandler" %>
<%@page import="hebergement.Hebergement" %>
<%@page import="hebergement.IHebergementDB" %>

<jsp:useBean id="oneHebergement" class="hebergement.Hebergement" scope="session" />
<!-- Header -->
	<jsp:include page="fragments/header.html"/>
	<!-- Navegation Gauche -->
	<jsp:include page="fragments/menu.html"/>

	<div class="col col-sm-9">
			<div class="panel">
			<h1 style="color:#ff3333;text-align:center">Proposez un longement</h1>

  <c:if test="${UserNameSession.user != null}">
    <div class="login-block">
        <form method="post" action="addHebergementServlet?action=setNew" id="loggin">

        <div class="inner-addon left-addon">
          <i class="glyphicon glyphicon-home"></i>
          <input type="text" size="20" name="type" value="${hb.type}" placeholder="Type"/>
        </div>

        <div class="inner-addon left-addon">
          <i class="glyphicon glyphicon-globe"></i>
          <input type="text" size="20" name="pays" value="${hb.pays}" placeholder="Pays"/>
        </div>

        <div class="inner-addon left-addon">
          <i class="glyphicon glyphicon-tag"></i>
          <input type="text" size="20" name="surface" value="${hb.surface}" placeholder="Surface"/>
        </div>

        <div class="inner-addon left-addon">
          <i class="glyphicon glyphicon-home"></i>
          <input type="text" size="20" name="npieces" value="${hb.npieces}" placeholder="Nombre pi&egrave;ces"/>
        </div>

        <div class="inner-addon left-addon">
          <i class="glyphicon glyphicon-map-marker"></i>
          <input type="text" size="20" name="addresse" value="${hb.addresse}" placeholder="Addresse"/>
        </div>

        <div class="inner-addon left-addon">
          <i class="glyphicon glyphicon-tree-deciduous"></i>
          <input type="text" size="20" name="terrain_exterieur" value="${hb.terrain_exterieur}" placeholder="Terrain ext&eacute;rieur"/>
        </div>

        <div class="inner-addon left-addon">
          <i class="glyphicon glyphicon-comment"></i>
          <input type="text" size="20" name="description" value="${hb.description}" placeholder="Description"/>
        </div>

        <div class="inner-addon left-addon">
          <i class="glyphicon glyphicon-picture"></i>
          <input type="text" size="20" name="image" value="${hb.image}" placeholder="Link de l'image"/>
        </div>

        </form>
            <button type="submit" form="loggin" value="Submit">Submit</button>
        </div>
  </c:if>

  <c:if test="${UserNameSession.user == null}">
  </br>
  <h5 class="Roboto-light">Il faut se logger sur l'application</h5>
  </c:if>
  <hr>
	</div>
	<!-- Footer -->
		<jsp:include page="fragments/footer.html"/>
