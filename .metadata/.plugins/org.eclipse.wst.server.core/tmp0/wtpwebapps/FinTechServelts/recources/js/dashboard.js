const msgCadastroReceita = document.querySelector('#msgCadastroReceita').value
const msgErroCadastroReceita = document.querySelector('#msgErroCadastroReceita').value

if (msgCadastroReceita != '') {
	const msg = document.querySelector('#msgCadastroReceita')

	Swal.fire({
		position: 'top-end',
		icon: 'success',
		title: msg.value,
		showConfirmButton: false,
		timer: 1500
	})

	msg.value = '';
}


if (msgErroCadastroReceita != '') {
	const msg = document.querySelector('#msgErroCadastroReceita')

	Swal.fire({
		icon: 'error',
		title: 'Oops...',
		text: msg.value,
	})

	msg.value = '';
}


const deleteReceita = (id) => {
	
}


const actionButttons = (event) => {
	const element = event.target
	if (element.type === 'button') {
		
		const action = element.dataset.action.split('-')
		
		if (action[0] === 'deletarReceita') {
			deleteReceita(action[1])
		}
		
		if (action[0] == 'editarReceita') {
			editReceita(action[1])
		} 
		
	}
}