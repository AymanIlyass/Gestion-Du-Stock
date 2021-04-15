<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<c:choose>
		<c:when test="${ flag eq true }">
			<br><br>
			<div class="container" style="padding-top: 5%; padding-right: 10%; padding-left: 15%;">
				<div class="card" style="background-color: rgba(255,255,255,0.8); padding-right: 15%;">
						<br>
									<form method="get" action="accueil">
					                    <div class="form-groups">
											&nbsp;&nbsp;<input style="background-color: grey;" type="submit" value="<-"></input>
										</div>
									</form>
					<form method="post" class="form-compact" action="ajouter_produit">
			            <div>
			                <div>
			                    <div class="row" style="padding-left: 20%;">
			                        <h5 class="text-center col-12 mb-0">Ajout du produit</h5>
			                        <sub class="text-right text-muted col-12"><a href="#" tabindex="-1"><i class="far fa-edit"></i></a></sub>
			                    </div>
								<br><br><br>
			                    <div class="form-group row">
			                        <label for="nom" class="col-4 col-form-label-sm text-right">Nom:</label> 
			                        <div class="col-8">
			                            <div class="input-group"> 
			                                <input id="nom" name="nom" type="text" class="form-control form-control-sm" >
			                            </div>
			                        </div>
			                    </div> 
			                    <div class="form-group row align-items-center">
			                        <label for="quantite" class="col-4 col-form-label-sm text-right">Quantite:</label> 
			                        <div class="col-8">
			                          <div class="input-group"> 
			                            <input id="quantite" name="quantite" type="text" class="form-control form-control-sm" >
			                          </div>
			                        </div>
			                    </div>
			                    <div class="form-group row align-items-center">
			                        <label for="prix_unit" class="col-4 col-form-label-sm text-right">Prix unitaire (MAD):</label> 
			                        <div class="col-8">
			                          <div class="input-group"> 
			                            <input id="prix_unit" name="prix_unit" type="text" class="form-control form-control-sm extendable">
			                          </div>
			                        </div>
			                    </div>
			                    <div class="form-group row align-items-center">
			                        <label for="description" class="col-4 col-form-label-sm text-right">Description:</label> 
			                        <div class="col-8">
			                          <div class="input-group"> 
			                            <input id="description" name="description" type="text" class="form-control form-control-sm extendable">
			                          </div>
			                        </div>
			                    </div>
			                    <div class="form-group row align-items-center">
			                        <label for="achete_fois" class="col-4 col-form-label-sm text-right">Nbre de fois acheté:</label> 
			                        <div class="col-8">
			                          <div class="input-group">
			                            <input id="achete_fois" name="achete_fois" type="text" class="form-control form-control-sm" >
			                          </div>
			                        </div>
			                    </div>
			                    <br><br>
			                    <div class="form-group">
									<input style="background-color: #FFC312;" type="submit" value="Enregistrer" class="btn float-right login_btn">
								</div>
			                </div>
			               </div>
		       		 </form>
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