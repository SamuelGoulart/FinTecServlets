<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<link rel="stylesheet" href="./recources/css/styleDashboard.css">
<link rel="stylesheet" href="./recources/css/styleGlobal.css">

<title>DashBoard</title>
</head>
<body>
	<header id="header">
		<img src="./recources/image/foto_perfil.png" alt="Foto do perfil" />
	</header>
	<div id="container">
		<nav>
			<div>
				<img src="./recources/image/home.svg" alt="Icone de casa" />
			</div>
			<div id="entrada-receita" data-toggle="modal"
				data-target="#modal-receita">
				<img src="./recources/image/entrada_dinheiro.svg"
					alt="Icone de entrada dinheiro" />
			</div>
			<div id="entrada-despesa" data-toggle="modal"
				data-target="#modal-despesa">
				<img src="./recources/image/saida_dinheiro.svg"
					alt="Icone sa�da de dinheiro" />
			</div>
		</nav>
		<div>
			<section id="div-saldo-mes">
				<div id="div-info">
					<span class="text-align-center" id="mes">Abril 2022</span> <span
						class="text-align-center" id="text-saldo-mes">Saldo do m�s</span>
					<span id="saldo-mes">R$ 1.650,50</span>
					<div id="div-icone-olho">
						<img id="icone_olho" src="./recources/image/olho.svg"
							alt="Icone de olho" />
					</div>
				</div>
				<div id="div-despesas-orcamento">
					<div>
						<span>Despesas</span> <span>R$ 700,00</span>
					</div>
					<div>
						<span>Or�amento do m�s</span> <span>R$ 2.350,00</span>
					</div>
				</div>
				<div class="div-progress-bar">
					<div style="-progress: 25; width: 70%; height: 15px"></div>
				</div>
			</section>

			<section id="div-despesas-por-categoria">
				<span>Despesas por categoria</span>
				<div>
					<div id="div-grafico">
						<img src="./recources/image/grafico.svg" alt="Gr�fico" />
					</div>
					<div id="div-lista-grafico">
						<ul>
							<li>Alimenta��o</li>
							<li>Strimmer</li>
							<li>Transporte</li>
							<li>�gua e Luz</li>
							<li>Outros</li>
						</ul>
					</div>
				</div>
			</section>

			<section id="div-transacoes-recentes">
				<span>Suas Receitas</span>
				<div>
					<c:forEach items="${receitas }" var="receita">

						<div class="transacoes" id="entrada-receita"\>
							<div>
								<img src="./recources/image/entrada_dinheiro.svg"
									alt="Entrada de dinheiro" />
							</div>
							<div class="div-info-transacoes">
								<span class="descricao_transacoes">${receita.descricao }</span>
								<fmt:formatDate value="${receita.data.time }"
									pattern="dd/MM/yyyy" />
							</div>
							<div>
								<span class="dinheiro-transacao"> <fmt:formatNumber
										type="currency" maxFractionDigits="2" value="${receita.valor}" />
								</span>
							</div>

							<div>
								<form action="dashboard" method="post">
									<input type="hidden" name="acao" value="excluirReceita">
									<input type="hidden" name="codigoReceita"
										value="${receita.cdReceita }">
									<button class="btn-lixeira" type="submit">
										<img class="lixeira" src="./recources/image/lixeira.svg"
											alt="�cone de lixeira">
									</button>
								</form>
							</div>
							<div>
								<button class="btn-lixeira" type="submit" data-toggle="modal"
									data-target="#modal-editar-receita"
									onclick="codigoDeEditarReceita.value = ${receita.cdReceita}">

									<img class="editar" src="./recources/image/editar.svg"
										alt="�cone de editar">
								</button>

							</div>
						</div>
					</c:forEach>

				</div>
				<div>
					<button type="button" id="btn-adicionar-transacao"
						data-toggle="modal" data-target="#modal-receita"
						class="btn btn-primary">Adicionar receita</button>
				</div>
			</section>
			<div id="div-planejamento-do-mes">
				<span>Planejamento do m�s</span>

				<div class="infos-planejamento-do-mes">
					<div class="imagens-planejamento-do-mes">
						<img src="./recources/image/carrinho_supermercado.svg"
							alt="Carrinho de supermercado" />
					</div>
					<div>
						<div class="div-infos-gastos">
							<span>Supermercado</span> <span>R$ 550</span>
						</div>
						<div class="div-progress-bar">
							<div id="progress-carrinho" style="progress: 45"></div>
						</div>
						<div class="qtd-restou">
							<span>Restou R$ 170</span>
						</div>
					</div>
				</div>

				<div class="infos-planejamento-do-mes">
					<div class="imagens-planejamento-do-mes" id="div-trem">
						<img src="./recources/image/trem.svg" alt="Icone de um trem" />
					</div>
					<div>
						<div class="div-infos-gastos">
							<span>Transporte</span> <span>R$ 250</span>
						</div>
						<div class="div-progress-bar">
							<div id="progress-transporte" style="-progress: 30"></div>
						</div>
						<div class="qtd-restou">
							<span>Restou R$ 100</span>
						</div>
					</div>
				</div>

				<div class="infos-planejamento-do-mes">
					<div class="imagens-planejamento-do-mes" id="div-lampada">
						<img src="./recources/image/lampada.svg"
							alt="Icone de uma l�mpada" />
					</div>
					<div>
						<div class="div-infos-gastos">
							<span>Luz</span> <span>R$ 150</span>
						</div>
						<div class="div-progress-bar">
							<div id="progress-luz" style="-progress: 100"></div>
						</div>
						<div class="qtd-restou">
							<span>Restou R$ 0</span>
						</div>
					</div>
				</div>

				<div class="infos-planejamento-do-mes">
					<div class="imagens-planejamento-do-mes" id="div-cinema">
						<img src="./recources/image/cinema.svg" alt="Icone de cinema" />
					</div>
					<div>
						<div class="div-infos-gastos">
							<span>Strimmer</span> <span>R$ 80</span>
						</div>
						<div class="div-progress-bar">
							<div id="progress-strimmer" style="-progress: 100"></div>
						</div>
						<div class="qtd-restou">
							<span>Restou R$ 100</span>
						</div>
					</div>
				</div>

				<div id="div-definir-novo-orcamento">
					<button type="button" id="btn-definir-novo-orcamento"
						class="btn btn-primary">Definir novo or�amento</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="modal-receita" tabindex="-1" role="dialog"
		aria-labelledby="modal-receita" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal-receita">Adicionar Receita</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="dashboard" method="POST">

					<div class="modal-body">
						<input type="hidden" name="acao" value="cadastrarReceita" />

						<div class="mb-3">
							<label for="descricao-receita" class="form-label">
								Descri��o</label> <input type="text" name="descricao"
								class="form-control" id="descricao-receita"
								placeholder="Ex. Sal�rio" />
						</div>

						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Data</label>
							<input type="date" name="data" class="form-control"
								id="exampleFormControlInput1" placeholder="name@example.com" />
						</div>

						<div class="mb-3">
							<label for="valor" class="form-label">Valor</label> <input
								type="text" name="valor" class="form-control" id="valor"
								placeholder="Ex. 1.200" />
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Fechar</button>
							<input type="hidden" id="msgCadastroReceita"
								value="${ msgCadastroReceita }" /> <input type="hidden"
								id="msgErroCadastroReceita" value="${ msgErroCadastroReceita }" />
							<button type="submit" class="btn btn-primary">Salvar</button>
						</div>

					</div>
				</form>
			</div>
		</div>
	</div>


	<div class="modal fade" id="modal-editar-receita" tabindex="-1" role="dialog"
		aria-labelledby="modal-editar-receita" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal-editar-receita">Editar Receita</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="dashboard" method="POST">

					<div class="modal-body">
						<input type="hidden" name="acao" value="editarReceita" /> 
						<input type="hidden" name="codigoDeEditarReceita" id="codigoDeEditarReceita">

						<div class="mb-3">
							<label for="descricao-receita" class="form-label">
								Descri��o</label> <input type="text" name="descricao"
								class="form-control" id="descricao-receita"
								placeholder="Ex. Sal�rio" />
						</div>

						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Data</label>
							<input type="date" name="data" class="form-control"
								id="exampleFormControlInput1" placeholder="name@example.com" />
						</div>

						<div class="mb-3">
							<label for="valor" class="form-label">Valor</label> <input
								type="text" name="valor" class="form-control" id="valor"
								placeholder="Ex. 1.200" />
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Fechar</button>
							<input type="hidden" id="msgCadastroReceita"
								value="${ msgCadastroReceita }" /> <input type="hidden"
								id="msgErroCadastroReceita" value="${ msgErroCadastroReceita }" />
							<button type="submit" class="btn btn-primary">Salvar</button>
						</div>

					</div>
				</form>
			</div>
		</div>
	</div>



	</div>
	<div class="modal fade" id="modal-despesa" tabindex="-2" role="dialog"
		aria-labelledby="modal-despesa" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal-despesa">Adicionar despesa</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="mb-3">
						<label for="descricao-receita" class="form-label">Descri��o</label>
						<input type="text" class="form-control" id="descricao-receita"
							placeholder="Ex. Transporte" />
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Data</label>
						<input type="date" class="form-control"
							id="exampleFormControlInput1" placeholder="name@example.com" />
					</div>
					<div class="mb-3">
						<label for="valor" class="form-label">Valor</label> <input
							type="number" class="form-control" id="valor" placeholder="1.200" />
					</div>
					<p>� uma despesa mensal</p>
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value=""
							id="flexCheckDefault" /> <label class="form-check-label"
							for="flexCheckDefault"> Sim </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value=""
							id="flexCheckChecked" checked /> <label class="form-check-label"
							for="flexCheckChecked"> N�o </label>
					</div>

					<div id="div-select">
						<span>Selecione a categoria da despesa</span> <select
							id="select-despesa" class="form-select"
							aria-label="Default select example">
							<option selected>Selecione</option>
							<option value="1">One</option>
							<option value="2">Two</option>
							<option value="3">Three</option>
						</select>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Fechar</button>
						<button type="button" class="btn btn-primary">Salvar</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="./recources/js/dashboard.js"></script>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>