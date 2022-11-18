<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Controle financeiro pessoal">
<meta name="keywords" content="Fintech,finan�as">
<meta name="author" content="Samuel Almeida Goulart">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link rel="stylesheet" href="./recources/css/styleLogin.css">
<link rel="stylesheet" href="./recources/css/styleGlobal.css">

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<title>Cadastra-se & Login</title>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col" id="div-form-login">
				<div id="container-login">
					<h1 id="titulo-bem-vindo">Bem vindo!</h1>
					<form action="login" method="post">
						<div class="mb-3">
							<label for="email" class="form-label">Email</label> <input
								type="email" class="form-control" name="email" id="email"
								placeholder="name@example.com" />
						</div>
						<div class="mb-3">
							<label for="senha" class="col-sm-2 col-form-label">Password</label>
							<input type="password" class="form-control" name="senha"
								id="senha" />
						</div>
						<div id="div-lembre-de-min">
							<div class="form-check form-switch">
								<input class="form-check-input" type="checkbox" role="switch"
									id="checkbox-lembre-de-mim" /> <label class="form-check-label"
									id="lembre-de-mim" for="checkbox-lembre-de-mim">lembre
									de mim</label>
							</div>
							<div>
								<p>
									<a id="esqueci-minha-senha" href="/"> Esqueci minha senha </a>
								</p>
								<p>
									<a id="cadastra-se"> Cadastra-se </a>
								</p>
							</div>
						</div>
						<div id="div-form-btn">
							<button type="submit" id="btn-form-login" class="btn btn-primary">Ingressar</button>
						</div>
						<input type="hidden" id="msgCadastroReceita"
							value="${ msgCadastroReceita }" />
					</form>
					<p id="divisor">
						<span>Ou</span>
					</p>
					<div id="redes-socias">
						<div>
							<img src="./recources/image/gmail.svg" alt="Logo do Gmail" />
							<p>Fazer login com o Gmail</p>
						</div>
						<div>
							<img src="./recources/image/facebook.svg" alt="Logo do facebook" />
							<p>Entrar com o Facebook</p>
						</div>
					</div>
				</div>
				<div id="container-cadastro-usuario" class="desativar">
					<h1 id="titulo-bem-vindo">Bem vindo!</h1>
					<h2>Cadastra-se</h2>
					<form action="cadastra-se" method="post">
						<div class="mb-3">
							<label for="nome" class="form-label">Nome</label> <input
								type="text" class="form-control" id="nome" name="nome" />
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">Email</label> <input
								type="email" class="form-control" id="email" name="email"
								placeholder="name@example.com" />
						</div>
						<div class="mb-3">
							<label for="senha" class="col-sm-2 col-form-label">Password</label>
							<input type="password" class="form-control" id="senha"
								name="senha" />
						</div>

						<div id="div-fazer-login">
							<div>
								<p>
									<a id="fazer-login"> Fazer login </a>
								</p>
							</div>
						</div>
						<div id="div-form-btn">
							<button type="submit" id="btn-form-login" class="btn btn-primary">
								Cadastra-se</button>
						</div>
					</form>
					<p id="divisor">
						<span>Ou</span>
					</p>
					<div id="redes-socias">
						<div>
							<img src="./recources/image/gmail.svg" alt="Logo do Gmail" />
							<p>Cadastra-se com o Gmail</p>
						</div>
						<div>
							<img src="./recources/image/facebook.svg" alt="Logo do facebook" />
							<p>Cadastra-se com o Facebook</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col imagem">
				<div>
					<img id="imagem-circulo" src="./recources/image/circulo_azul.svg"
						alt="" /> <img id="imagem-autenticacao"
						src="./recources/image/authentication.svg"
						alt="Imagem de uma pessoa se autenticando no sistema" />
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="./recources/js/login.js"></script>


</body>
</html>