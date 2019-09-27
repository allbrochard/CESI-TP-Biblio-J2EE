<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Login</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
    <c:choose>
	    <c:when test="${ !empty login }">
			<c:out value="Bonjour ${ login }" />
			<br>
			<a href="http://localhost:8080/CommerceTP/listLivre">Liste des Livres</a>
	    </c:when>    
    	<c:otherwise>
	        <form method="post" action="login">
	            <fieldset>
	                <legend>LOGIN</legend>
	
	                <label for="login">Nom d'utilisateur <span class="requis">*</span></label>
	                <input type="text" id="login" name="login" value="" size="20" maxlength="60" />
	                <br />
	
	                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
	                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
	                <br />
	
	                <input type="submit" value="login" class="sansLabel" />
	                <br />
	            </fieldset>
	        </form>
	    </c:otherwise>
	</c:choose>
    </body>
</html>