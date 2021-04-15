<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
	
	
			<div class="container" style="padding-top: 10%; padding-left: 15%; padding-right: 15%;">
				<div>
					<div class="card" style="background-color: rgba(255,255,255,0.8);">
						<div class="card-header">
							<h3>Sign In</h3>
						</div>
						<div class="card-body">
							<form method="post" action="accueil">
								<div class="input-group form-group">
									<div class="input-group-prepend">
										<span style="background-color: #FFC312;" class="input-group-text"><i class="fas fa-user"></i></span>
									</div>
									<input name="email" id="email" type="text" class="form-control" placeholder="email">
									
								</div>
								<div class="input-group form-group">
									<div class="input-group-prepend">
										<span style="background-color: #FFC312;" class="input-group-text"><i class="fas fa-key"></i></span>
									</div>
									<input name="password" id="password" type="password" class="form-control" placeholder="password">
								</div>
								<div class="row align-items-center remember" style="padding-left: 20px;">
									<input type="checkbox">&nbsp;Se souvenir de moi
								</div>
								<br>
								<c:if test="${ check eq 'false' }">
									<p style="color: red;">* Email ou Mot de passe erronés</p>
								</c:if>
								<div class="form-group">
									<input style="background-color: #FFC312;" type="submit" value="Login" class="btn float-right login_btn">
								</div>
							</form>
						</div>
						<div class="card-footer">
							<div class="d-flex justify-content-center links">
								Vous n'avez pas de compte?&nbsp;&nbsp;&nbsp;<a href="/GestStock/register">S'enregistrer</a>
							</div>
							<div class="d-flex justify-content-center">
								<a href="http://localhost:8080/GestStock/mailer">Oubliez-vous le mot de passe?</a>
							</div>
						</div>
					</div>
				</div>
			</div>
	</body>
	
</html>