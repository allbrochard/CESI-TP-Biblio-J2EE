<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>ListProduct</title>
<link type="text/css" rel="stylesheet" href="form.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body class="text-center">
	<header>
		<div class="collapse bg-dark" id="navbarHeader">
			<div class="container">
				<div class="row">
					<div
						class="col-md-5 offset-md-7 navbar navbar-dark bg-dark shadow-sm">
						<form method="post" action="LoginAdmin" class="form-signin">
							<h4 class="text-white">Connexion Admin</h4>
							<label for="login" class="sr-only">Login</label> <input
								type="text" id="login" name="login" class="form-control"
								placeholder="Pseudo" required autofocus> <label
								for="password" class="sr-only">Password</label> <input
								type="password" id="password" name="password"
								class="form-control" placeholder="Password" required> <input
								type="hidden" value="0" name="deco">
							<button class="btn btn-lg btn-primary btn-block"
								style="margin-top: 5px;" type="submit">Connexion</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="navbar navbar-dark bg-dark shadow-sm">
			<div class="container d-flex justify-content-between">
				<strong style="color: white;">Bibliothèque</strong>
				<c:choose>
					<c:when test="${ !empty role and role == 'admin' }">
						<strong style="color: white;"><c:out
								value="Bonjour ${ nom }" /></strong>
						<form method="get" action="LoginAdmin" class="form-signin">
							<input type="hidden" value="1" name="deco">
							<button class="btn btn-lg btn-link btn-block" type="submit"
								style="text-decoration: none; color: white;">Deconnexion</button>
						</form>
					</c:when>
					<c:when test="${ !empty role and role == 'user' }">
						<strong style="color: white;"><c:out
								value="Bonjour ${ nom }" /></strong>
						<form method="get" action="LoginUser" class="form-signin">
							<input type="hidden" value="1" name="deco">
							<button class="btn btn-lg btn-link btn-block" type="submit"
								style="text-decoration: none; color: white;">Deconnexion</button>
						</form>
					</c:when>
					<c:otherwise>
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarHeader"
							aria-controls="navbarHeader" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</header>
	<div class="row">
			<c:choose>
				<c:when test="${ !empty role}">
					<div class="col-md-8 offset-md-2">
						<table class="table">
							<c:forEach items="${livres}" var="li">
								<tr>
									<td <c:if test="${role == 'user' and ( !empty(li.idUser) and li.idUser != id )}">
										style="text-decoration: line-through;"
									</c:if> >${li.id}</td>
									<td <c:if test="${role == 'user' and ( !empty(li.idUser) and li.idUser != id )}">
										style="text-decoration: line-through;"
									</c:if>>${li.titre}</td>
									<td <c:if test="${role == 'user' and ( !empty(li.idUser) and li.idUser != id )}">
										style="text-decoration: line-through;"
									</c:if>>${li.auteur}</td>
									<td <c:if test="${role == 'user' and ( !empty(li.idUser) and li.idUser != id )}">
										style="text-decoration: line-through;"
									</c:if>>${li.edition}</td>
									<c:choose>
										<c:when test="${role == 'user' and ( empty(li.idUser) )}">
											<td><a href="http://localhost:8080/Projet_J2EE_CESI/reserver?id=${li.id}&idUser=${id}&nom=${nom}"  class="btn btn-primary">Reserver</a></td>
										</c:when>
										<c:when test="${role == 'user' and ( li.idUser == id )}">
											<td><a href="http://localhost:8080/Projet_J2EE_CESI/reserver?idUnReserve=${li.id}"  class="btn btn-success">Liberer</a></td>
										</c:when>
										<c:when test="${role == 'user' and ( !empty(li.idUser) and li.idUser != id )}">
											<td style="color:red;"><b>Ce livre est reservé par ${li.nomUser}</b></td>
										</c:when>
										<c:when test="${ role == 'admin'}">
											<td><a href="http://localhost:8080/Projet_J2EE_CESI/RemoveLivre?id=${li.id}" class="btn btn-danger">Supprimer</a></td>
										</c:when>
									</c:choose>
			
								</tr>
							</c:forEach>
						</table>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-md-4 offset-md-4">
						<form method="post" action="LoginUser">
							<h1 class="h3 mb-3 font-weight-normal">Connexion Utilisateur</h1>
							<label for="login" class="sr-only">login</label> 
							<input type="text" id="login" name="login" class="form-control"
								placeholder="Email address" required autofocus> 
							<label
							for="password" class="sr-only">Password</label> 
							<input type="password" id="password" name="password" class="form-control"
								placeholder="Password" required>
							<button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
						</form>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
<script>
	
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous">
	
</script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous">
	</script>
</html>