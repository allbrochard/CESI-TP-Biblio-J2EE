<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>  
    	<c:if test="${ !empty nom and !empty motdepasse }"><p><c:out value="Bonjour, vous vous appelez ${ nom } et votre mot de passe est : ${ motdepasse }" /></p></c:if>
    	
        <form method="post" action="insertSomeProduct">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <label for="nom">Nom du produit <span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="60" />
                <br />

                <label for="contenue">Contenu du produit <span class="requis">*</span></label>
                <input type="text" id="contenue" name="contenue" value="" size="100" maxlength="100" />
                <br />

                <label for="prix">Prix du produit  <span class="requis">*</span></label>
                <input type="text" id="prix" name="prix" value="" size="20" maxlength="20" />
                <br />

                <label for="id">ID du produit </label>
                <input type="text" id="id" name="id" value="" size="20" maxlength="20" />
                <br />

                <input type="submit" value="Ajouter" class="sansLabel" />
                <br />
            </fieldset>
        </form>
        <a href="http://localhost:8080/CommerceTP/listProduct">Retour</a>
    </body>
</html>