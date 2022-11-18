package br.com.fin.tech.factory;

import br.com.fin.tech.dao.ReceitaDAO;
import br.com.fin.tech.dao.UsuarioDAO;
import br.com.fin.tech.dao.impl.OracleReceitaDAO;
import br.com.fin.tech.dao.impl.OracleUsuarioDAO;

public class DAOFactory {
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	
	public static ReceitaDAO getReceitaDAO() {
		return new OracleReceitaDAO();
	}
}
