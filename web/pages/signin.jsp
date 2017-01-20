<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="agence.ClientDBStub" %>
<%@page import="agence.Client" %>

<jsp:useBean id="oneClient" class="agence.Client" scope="session" />
<%-- Initializing bean --%>
<c:if test="${!empty param['user']}">
  <jsp:setProperty name="oneClient" property="user" value="${param['user']}" />
</c:if>
<c:if test="${!empty param['pass']}">
  <jsp:setProperty name="oneClient" property="pass" value="${param['pass']}" />
</c:if>
<c:if test="${!empty param['mail']}">
  <jsp:setProperty name="oneClient" property="mail" value="${param['mail']}" />
</c:if>

<c:choose>
  <c:when test="${param['action']=='setNew'}">
    <%
      ClientDBStub db = new ClientDBStub ();
      Client cl = new Client(oneClient);
      db.addClient(cl);
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

      <%-- Displaying new count form --%>
      <c:choose>
        <c:when test="${param['action']=='setNew'}">
          <p>
            Identifiants : <c:out value="${oneClient}" />
            <br>
            Votre mail : <%= oneClient.getMail() %>
          </p>
        </c:when>
        <c:otherwise>
          <p>Remplissez le formulaire</p>
        </c:otherwise>
      </c:choose>


      <div class="login-block">

          <form method="post" action="signin?action=setNew" id="loggin">
          <input type="text" size="20" name="user" value="${cl.user}" placeholder="Username" id="username" />
          <input type="text" name="pass" value="${cl.pass}" placeholder="Password" id="password"/>
          <input type="text" name="mail" value="${cl.mail}" placeholder="Email" id="email" />
          </form>
          <button type="submit" form="loggin" value="Submit">Submit</button>
      </div>

	</div>
	<!-- Footer -->
		<jsp:include page="fragments/footer.html"/>
