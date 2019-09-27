<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>ListProduct</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body class="text-center" style="height: 780px">
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
				<strong style="color: white;"><a href="/Accueil">Bibliothèque</a></strong>
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
	<c:if test="${ !empty role and role == 'admin' }">
		<div class="row" style="height:100% ;">
			<div class="col-md-2" style="background-color: #3d444b!important">
				<div class="" >
					<form method="get" action="Accueil" class="form-signin">
						<button class="btn btn-lg btn-link btn-block" type="submit"
							style="text-decoration: none; color: white;">Accueil</button>
					</form>
					<form method="get" action="InsertUser" class="form-signin">
						<button class="btn btn-lg btn-link btn-block" type="submit"
							style="text-decoration: none; color: white;">Ajouter un utilisateur </button>
					</form>
					<form method="get" action="InsertLivre" class="form-signin">
						<button class="btn btn-lg btn-link btn-block" type="submit"
							style="text-decoration: none; color: white;">Ajouter un livre</button>
					</form>
					<form method="get" action="ListUser" class="form-signin">
						<button class="btn btn-lg btn-link btn-block" type="submit"
							style="text-decoration: none; color: white;">Liste des utilisateurs</button>
					</form>
				</div>	
			</div>
		<div class="col-md-10">
	</c:if>
	<div class="row">
		<div class="col-md-4 offset-md-4">
			<form method="post" action="InsertUser">
				<div class="form-group">
					<input type="text"
						class="form-control" id="login" name="login"
						aria-describedby="loginhelp" placeholder="Entrez le login">
				</div>
				<div class="form-group">
					<input type="text"
						class="form-control" id="nom" name="nom"
						aria-describedby="nomhelp" placeholder="Entrez le nom">
				</div>
				<div class="form-group">
					<input type="password"
						class="form-control" id="password" name="password"
						placeholder="Entrez le password">
				</div>
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</form>
		</div>
	</div>
	<c:if test="${ !empty role and role == 'admin' }">
			</div>
		</div>
	</c:if>
</body>
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