<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
	<c:choose>
		<c:when test="${ flag eq true }">
			<form method="get" action="accueil">
				<div class="wrap">
				   <div class="search">
				      <input name="nom" type="text" class="searchTerm" placeholder="Recherchez un produit?">
				      <button type="submit" class="searchButton">
				        <i class="fa fa-search"></i>
				     </button>
				   </div>
				</div>
			</form>
		
			<div class="containerr" style="padding-top: 10%; padding-left: 80%; padding-right: 2%;">
				<div class="card" style="background-color: rgba(255,255,255,0.8); padding-right: 15%;">
					<div class="row" style="padding-left: 10%;">
						<h5 class="text-center col-12 mb-0" style="font-family: 'Brush Script MT'; font-size: 36px;">Profil</h5>
						<br><br><br>
						<h5>&nbsp;&nbsp;<c:out value="${ prenom } ${ nom }"></c:out></h5><br><br>
						<ul>
							<li>Email: <c:out value="${ email }"></c:out></li>
							<li>Tele: <c:out value="${ tele }"></c:out></li>
							<li>Adresse: <c:out value="${ adresse }"></c:out></li>
							<li>Pays: <c:out value="${ pays }"></c:out></li>
							<li>Sexe: <c:out value="${ sexe }"></c:out></li>
						</ul>
						<form method="get" action="index">
							<input type="submit" value="Se Déconnecter" style="position: fixed; right: 5%;" />
						</form>
					</div>
						<br>
				</div>
			</div>
			<c:if test="${ Searched eq true }">
				<div class="containerr" style="position: fixed; top: 20%; left: 30%; width: 35%;">
					<div class="card" style="background-color: rgba(255,255,255,0.8);">
						<div class="rrow" style="padding-left: 20%;">
							<c:choose>
								<c:when test="${ Found eq false }"><p style="color: red;">Ce produit n'existe pas.<br> <span style="font-style: italic;">(Rééssayer d'entrer le nom exact du produit)</span></p></c:when>
								<c:otherwise>
								<br>
									<h5 style="text-decoration: underline;">Caractéristiques:</h5>
									<p>
										Nom: <c:out value="${ nomP }"></c:out><br>
										Quantité: <c:out value="${ quantite }"></c:out><br>
										Prix Unitaire: <c:out value="${ prix_unit } Dhs"></c:out><br>
										Description: <c:out value="${ description }"></c:out><br>
										Nombre de fois acheté: <c:out value="${ achete_fois }"></c:out><br><br>
										<span style="color: green; font-style: italic; text-decoration: underline;">Ce produit existe</span>
									</p>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				<c:set var="Searched" value="${ false }" scope="request"></c:set>
			</c:if>
				<div class="containerr" style="position: fixed; top: 20%; left: 2%; width: 15%;">
					<div class="card" style="background-color: rgba(255,255,255,0.8);">
						<div class="row" style="padding-left: 10%;">
							<ul>
								<li><a href="http://localhost:8080/GestStock/accueil" style="text-decoration: none; color: black;">Accueil</a></li>
								<li><a href="http://localhost:8080/GestStock/ajouter_produit" style="text-decoration: none; color: black;">Ajouter Produit</a></li>
								<li><a href="http://localhost:8080/GestStock/accueil" style="text-decoration: none; color: black;">FAQ</a></li>
								<li><a href="http://localhost:8080/GestStock/accueil" style="text-decoration: none; color: black;">Qui sommes-nous?</a></li>
							</ul>
						</div>
					</div>
				</div>
		</c:when>
		<c:otherwise>
			<div class="container" style="padding-top: 5%; padding-right: 10%; padding-left: 15%;">
				<div class="card" style="background-color: rgba(255,255,255,0.8); padding-right: 15%;">
					<div class="row" style="padding-left: 20%;">
						<h6 class="text-center col-12 mb-0" style="color: #c31111; font-style: italic;">Impossible d'accéder a cette section<br>(Il te faut que tu sois connecté)</h6><br>
						<ul>
							<li><a href="http://localhost:8080/GestStock/">Se connecter</a></li>
						</ul>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>

	</body>
	
</html>