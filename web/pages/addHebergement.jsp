<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="hebergement.HebergementDBHandler" %>
<%@page import="hebergement.Hebergement" %>
<%@page import="hebergement.IHebergementDB" %>

<jsp:useBean id="oneHebergement" class="hebergement.Hebergement" scope="session" />
<%-- Initializing bean --%>
<c:if test="${!empty param['type']}">
  <jsp:setProperty name="oneHebergement" property="type" value="${param['type']}" />
</c:if>
<c:if test="${!empty param['pays']}">
  <jsp:setProperty name="oneHebergement" property="pays" value="${param['pays']}" />
</c:if>
<c:if test="${!empty param['surface']}">
  <jsp:setProperty name="oneHebergement" property="surface" value="${param['surface']}" />
</c:if>
<c:if test="${!empty param['npieces']}">
  <jsp:setProperty name="oneHebergement" property="npieces" value="${param['npieces']}" />
</c:if>
<c:if test="${!empty param['addresse']}">
  <jsp:setProperty name="oneHebergement" property="addresse" value="${param['addresse']}" />
</c:if>
<c:if test="${!empty param['terrain_exterieur']}">
  <jsp:setProperty name="oneHebergement" property="terrain_exterieur" value="${param['terrain_exterieur']}" />
</c:if>
<c:if test="${!empty param['description']}">
  <jsp:setProperty name="oneHebergement" property="description" value="${param['description']}" />
</c:if>
<c:if test="${!empty param['image']}">
  <jsp:setProperty name="oneHebergement" property="image" value="${param['image']}" />
</c:if>



<c:choose>
  <c:when test="${param['action']=='setNew'}">
    <%
      Hebergement hb = new Hebergement(oneHebergement);
      IHebergementDB db = HebergementDBHandler.getDb();
      db.addHebergement(hb);
    %>
  </c:when>
</c:choose>

	<!-- Header -->
	<jsp:include page="fragments/header.html"/>
	<!-- Navegation Gauche -->
	<jsp:include page="fragments/menu.html"/>

	<div class="col col-sm-9">
			<div class="panel">
			<h1 style="color:#ff3333;text-align:center">Inscrivez-vous</h1>
      <hr>



      <div class="login-block">

          <form method="post" action="addHebergementServlet?action=setNew" id="loggin">
          <input type="text" size="20" name="type" value="${hb.type}" placeholder="type"/>
          <input type="text" size="20" name="pays" value="${hb.pays}" placeholder="pays"/>
          <input type="text" size="20" name="surface" value="${hb.surface}" placeholder="surface"/>
          <input type="text" size="20" name="npieces" value="${hb.npieces}" placeholder="npieces"/>
          <input type="text" size="20" name="addresse" value="${hb.addresse}" placeholder="addresse"/>
          <input type="text" size="20" name="terrain_exterieur" value="${hb.terrain_exterieur}" placeholder="terrain_exterieur"/>
          <input type="text" size="20" name="description" value="${hb.description}" placeholder="description"/>
          <input type="text" size="20" name="image" value="${hb.image}" placeholder="image"/>
          </form>
          <button type="submit" form="loggin" value="Submit">Submit</button>
      </div>

	</div>
	<!-- Footer -->
		<jsp:include page="fragments/footer.html"/>
