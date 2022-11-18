package br.com.fin.tech.dao;

import br.com.fin.tech.bean.Usuario;

public interface UsuarioDAO {
	Usuario validarUsuario(Usuario usuario);
	
	boolean cadastrarUsuario(Usuario usuario);

}
