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
	    <legend>Produits</legend>
	    	<ul>
		    <c:forEach items="${products}" var="pro">
		    	<li><a href="http://localhost:8080/CommerceTP/showProduct?id=${pro.id}">${pro.nom}</a> - <a href="http://localhost:8080/CommerceTP/removeProduct?id=${pro.id}">Supprimer</a></li>
		    </c:forEach>
		    </ul>
	    </fieldset>
		    <div>
		    	<a href='http://localhost:8080/CommerceTP/insertSomeProduct'>Ajouter un produit</a><br>
				<a href='http://localhost:8080/CommerceTP/insertSomeProduct?ajout=plusieurs'>Ajouter plusieurs produits</a>
		    </div>
	</body>
</html>