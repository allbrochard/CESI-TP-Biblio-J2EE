<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>ListProduct</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>  
	    <fieldset>
	    <legend>Produit</legend>
		    	<b>${ product.id }</b> ${product.nom} -- ${product.prix} -- ${product.contenu}
	    </fieldset>
		    <div>
		    	<a href='http://localhost:8080/CommerceTP/listProduct'>Retour</a>
		    </div>
	</body>
</html>