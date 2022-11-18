package br.com.fin.tech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fin.tech.bean.Usuario;
import br.com.fin.tech.dao.UsuarioDAO;
import br.com.fin.tech.singleton.ConnectionManager;

public class OracleUsuarioDAO implements UsuarioDAO {
	private Connection conexao;

	@Override
	public Usuario validarUsuario(Usuario usuario) {
		Usuario resultUsuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_SCF_USUARIO WHERE EMAIL = ? AND SENHA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			rs = stmt.executeQuery();

			rs.next();
			
			int cdUsuario = rs.getInt("CD_USUARIO");
			String nome = rs.getString("NOME");
			String email = rs.getString("EMAIL");
			
		    Usuario usuarioDB = new Usuario(nome, email, cdUsuario);
		    resultUsuario = usuarioDB;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultUsuario;
	}

	@Override
	public boolean cadastrarUsuario(Usuario usuario) {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_SCF_USUARIO( CD_USUARIO, NOME,  EMAIL, SENHA ) VALUES (SQ_USUARIO.nextval, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			rs = stmt.executeQuery();

			if (rs.next()) {
			      return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;

	}


	

}
