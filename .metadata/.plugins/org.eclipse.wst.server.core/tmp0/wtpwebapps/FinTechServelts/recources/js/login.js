const msg = document.querySelector('#resultadoLogin').value


if (msg != '') {
	Swal.fire({
		icon: 'error',
		title: 'Oops...',
		text: msg,
		footer: '<a href="/login">Tente novamente!</a>'
	})
}


const abrirContainerDeCadastrarUsuario = () => {
	document.querySelector('#container-login').classList.add('desativar');
	document.querySelector('#container-login').classList.remove('ativar');

	document.querySelector('#container-cadastro-usuario').classList.remove('desativar');
	document.querySelector('#container-cadastro-usuario').classList.add('ativar');
}

const abrirContainerDeFazerLogin = () => {
	document.querySelector('#container-cadastro-usuario').classList.remove('ativar');
	document.querySelector('#container-cadastro-usuario').classList.add('desativar');
	document.querySelector('#container-login').classList.add('ativar');
}

document.querySelector('#cadastra-se')
	.addEventListener('click', () => { abrirContainerDeCadastrarUsuario() });

document.querySelector('#fazer-login')
	.addEventListener('click', () => { abrirContainerDeFazerLogin() });
